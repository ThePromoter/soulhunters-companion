package com.dpince.soulhunterscompanion.base.presenter;

import android.util.Log;

import com.dpince.soulhunterscompanion.base.view.RxMvpView;

import javax.inject.Inject;
import javax.inject.Named;

import de.greenrobot.event.EventBus;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.dpince.soulhunterscompanion.util.rxjava.RxUtils.getNewCompositeSubIfUnsubscribed;
import static com.dpince.soulhunterscompanion.util.rxjava.RxUtils.unsubscribeIfNotNull;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class RxMvpPresenter<V extends RxMvpView, M> extends BaseMvpPresenter<V, M> {

    private static final String LOG_TAG = RxMvpPresenter.class.getSimpleName();

    @Inject public EventBus eventBus;
    @Inject @Named("UIScheduler") public Scheduler uiScheduler;
    @Inject @Named("IOScheduler") public Scheduler ioScheduler;
    protected CompositeSubscription subscriptions;
    protected Subscriber<M> mainSubscriber;

    public RxMvpPresenter() {
        super();
        subscriptions = getNewCompositeSubIfUnsubscribed(subscriptions);
    }

    /**
     * Unsubscribes the main mainSubscriber and sets it to null
     */
    protected void unsubscribeMain() {
        unsubscribeIfNotNull(mainSubscriber);
        mainSubscriber = null;
    }

    /**
     * Subscribes the presenter himself as mainSubscriber on the observable
     *
     * @param observable The observable to subscribe
     */
    protected void subscribe(final Observable<M> observable) {
        unsubscribeMain();

        mainSubscriber = new Subscriber<M>() {
            @Override public void onCompleted() {
                RxMvpPresenter.this.onCompleted();
            }

            @Override public void onError(Throwable e) {
                RxMvpPresenter.this.onError(e);
            }

            @Override public void onNext(M m) {
                RxMvpPresenter.this.onNext(m);
            }
        };

        subscriptions.add(
            observable.subscribeOn(ioScheduler)
                      .observeOn(uiScheduler)
                      .subscribe(mainSubscriber)
        );
    }

    /**
     * Adds the subscription to the composite so it can be cleaned up properly.  This method does NOT
     * start the mainSubscriber, you should do that before calling this method.
     *
     * @param subscription the subscription
     */
    protected void subscribe(Subscription subscription) {
        subscriptions.add(subscription);
    }

    protected void onCompleted() {
        unsubscribeMain();
    }

    private void onError(Throwable e) {
        unsubscribeMain();
        Log.e(LOG_TAG, "RxJava error", e);
    }

    protected void onNext(M data) {

    }

    /**
     * This method must be overridden if the extending presenter should subscribe
     * to eventBus so we can automatically register/unregister from the eventBus
     * when the view is attached/detached
     *
     * @return boolean whether or not the extending presenter utilizes eventBus
     */
    protected boolean subscribesToEventBus() {
        return false;
    }

    @Override public void attachView(V view) {
        super.attachView(view);
        subscriptions = getNewCompositeSubIfUnsubscribed(subscriptions);
        if (subscribesToEventBus() && !eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            unsubscribeIfNotNull(subscriptions);

            if (subscribesToEventBus() && eventBus.isRegistered(this)) {
                eventBus.unregister(this);
            }
        }
    }
}
