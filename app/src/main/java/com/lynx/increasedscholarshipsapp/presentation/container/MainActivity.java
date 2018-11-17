package com.lynx.increasedscholarshipsapp.presentation.container;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.lynx.increasedscholarshipsapp.R;
import com.lynx.increasedscholarshipsapp.other.event.SetTitleEvent;
import com.lynx.increasedscholarshipsapp.other.event.HideLoaderEvent;
import com.lynx.increasedscholarshipsapp.other.event.ShowLoaderEvent;
import com.lynx.increasedscholarshipsapp.presentation.enter.EnterFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private View loader;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, EnterFragment.newInstance(null))
                .commit();

        EventBus.getDefault().register(this);

        loader = findViewById(R.id.pre_loader);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onHideLoader(HideLoaderEvent event) {
        hideLoader();
    }

    @Subscribe
    public void onShowLoader(ShowLoaderEvent event) {
        showLoader();
    }

    @Subscribe
    public void onSetTitle(SetTitleEvent event){
        setToolbarTitle(event.title);
    }

    private void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    private void hideLoader() {
        loader.setVisibility(View.GONE);
    }

    private void showLoader() {
        loader.setVisibility(View.VISIBLE);
    }
}
