package com.dpince.soulhunterscompanion.base.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes protected int getLayoutRes() {
        return 0;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        injectDependencies();
        super.onCreate(savedInstanceState);

        if (getLayoutRes() != 0) {
            setContentView(getLayoutRes());
        }
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    protected abstract void injectDependencies();
}
