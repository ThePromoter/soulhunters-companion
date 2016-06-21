package com.dpince.soulhunterscompanion.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.dpince.soulhunterscompanion.CompanionApplication;
import com.dpince.soulhunterscompanion.R;
import com.dpince.soulhunterscompanion.base.view.activity.BaseRxMvpActivity;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class HomeActivity
    extends BaseRxMvpActivity<Object, HomeView, HomePresenter>
    implements HomeView {

    @Inject HomePresenter presenter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.left_pane) FrameLayout leftPane;
    @Nullable @Bind(R.id.right_pane) FrameLayout rightPane;
    // contains leftPane + rightPane, tablet only
    @Nullable @Bind(R.id.pane_container) ViewGroup paneContainer;

    @Bind(R.id.menu_pane) FrameLayout menuPane;

    private ActionBarDrawerToggle drawerToggle;

    @Override protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override public HomePresenter createPresenter() {
        return presenter;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Toolbar
        setSupportActionBar(toolbar);

        // Navigation Drawer
        drawerToggle = new CustomActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
    }

    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    private class CustomActionBarDrawerToggle extends ActionBarDrawerToggle {

        private CustomActionBarDrawerToggle(Activity activity,
                                           DrawerLayout drawerLayout,
                                           Toolbar toolbar,
                                           @StringRes int openDrawerContentDescRes,
                                           @StringRes int closeDrawerContentDescRes) {
            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override public void onDrawerStateChanged(int newState) {
            super.onDrawerStateChanged(newState);
        }
    }

    @Override protected void injectDependencies() {
        CompanionApplication.get(this)
                            .getAppComponent()
                            .inject(this);
    }
}
