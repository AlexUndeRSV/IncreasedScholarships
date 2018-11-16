package com.lynx.increasedscholarshipsapp.presentation.regestration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lynx.increasedscholarshipsapp.presentation.regestration.RegestrationView;
import com.lynx.increasedscholarshipsapp.presentation.regestration.RegestrationPresenter;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.lynx.increasedscholarshipsapp.R;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class RegestrationFragment extends MvpAppCompatFragment implements RegestrationView {
    public static final String TAG = "RegestrationFragment";
    @InjectPresenter
    RegestrationPresenter presenter;


    public static RegestrationFragment newInstance(Bundle args) {
        RegestrationFragment fragment = new RegestrationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_regestration, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
