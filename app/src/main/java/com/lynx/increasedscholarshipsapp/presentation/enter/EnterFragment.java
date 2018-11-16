package com.lynx.increasedscholarshipsapp.presentation.enter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import com.lynx.increasedscholarshipsapp.R;

import com.arellomobile.mvp.presenter.InjectPresenter;

public class EnterFragment extends MvpAppCompatFragment implements EnterView {
    public static final String TAG = "EnterFragment";
    @InjectPresenter
    EnterPresenter presenter;


    public static EnterFragment newInstance(Bundle args) {
        EnterFragment fragment = new EnterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
