package com.dpince.soulhunterscompanion.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.FragmentArgs;

import butterknife.ButterKnife;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class BaseFragment extends Fragment {

    private static final String LOG_TAG = BaseFragment.class.getSimpleName();

    @LayoutRes protected abstract int getLayoutRes();

    @MenuRes protected int getMenuRes() {
        return 0;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
        injectDependencies();
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (getMenuRes() > 0) {
            setHasOptionsMenu(true);
        }

        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (getMenuRes() > 0) {
            inflater.inflate(getMenuRes(), menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected abstract void injectDependencies();
}
