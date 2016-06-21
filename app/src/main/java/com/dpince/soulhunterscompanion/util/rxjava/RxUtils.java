package com.dpince.soulhunterscompanion.util.rxjava;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class RxUtils {

    private static final String LOG_TAG = RxUtils.class.getSimpleName();

    public static CompositeSubscription getNewCompositeSubIfUnsubscribed(CompositeSubscription subscriptions) {
        if (subscriptions == null || subscriptions.isUnsubscribed()) {
            subscriptions = new CompositeSubscription();
        }
        return subscriptions;
    }

    public static void unsubscribeIfNotNull(Subscriber subscriber) {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }

    public static void unsubscribeIfNotNull(CompositeSubscription subscriptions) {
        if (subscriptions != null && !subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }
    }

    public static void unsubscribeIfNotNull(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
