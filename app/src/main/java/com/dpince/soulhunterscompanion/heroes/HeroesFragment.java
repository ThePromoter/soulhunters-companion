package com.dpince.soulhunterscompanion.heroes;

import com.dpince.soulhunterscompanion.base.view.fragment.BaseRxMvpFragment;
import com.dpince.soulhunterscompanion.model.Hero;

import java.util.List;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class HeroesFragment
    extends BaseRxMvpFragment<List<Hero>, HeroesView, HeroesPresenter>
    implements HeroesView {

    @Override public HeroesPresenter createPresenter() {
        return null;
    }

    @Override protected int getLayoutRes() {
        return 0;
    }

    @Override protected void injectDependencies() {

    }
}
