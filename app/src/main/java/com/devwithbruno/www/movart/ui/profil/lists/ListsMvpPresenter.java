package com.devwithbruno.www.movart.ui.profil.lists;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 05/02/2018.
 */

@PerActivity
public interface ListsMvpPresenter<V extends ListsMvpView, I extends ListsMvpInteractor>
        extends MvpPresenter<V,I> {
}
