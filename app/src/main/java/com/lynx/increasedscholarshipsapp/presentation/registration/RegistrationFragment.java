package com.lynx.increasedscholarshipsapp.presentation.registration;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lynx.increasedscholarshipsapp.domain.dataclass.User;
import com.lynx.increasedscholarshipsapp.other.event.HideLoaderEvent;
import com.lynx.increasedscholarshipsapp.other.event.SetTitleEvent;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.lynx.increasedscholarshipsapp.R;


import com.arellomobile.mvp.presenter.InjectPresenter;
import com.lynx.increasedscholarshipsapp.other.event.ShowLoaderEvent;

import org.greenrobot.eventbus.EventBus;

public class RegistrationFragment extends MvpAppCompatFragment implements RegestrationView {
    public static final String TAG = "RegistrationFragment";
    @InjectPresenter
    RegestrationPresenter presenter;

    private DatabaseReference dbReference;

    private TextInputLayout txtInputFirstName, txtInputLastName, txtInputEmail, txtInputPassword;

    private Button btnReg;

    public static RegistrationFragment newInstance(Bundle args) {
        RegistrationFragment fragment = new RegistrationFragment();
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

        EventBus.getDefault().post(new SetTitleEvent("Регистрация"));

        dbReference = FirebaseDatabase.getInstance().getReference().child("users");

        txtInputFirstName = view.findViewById(R.id.edtRegFirstName);
        txtInputLastName = view.findViewById(R.id.edtRegLastName);
        txtInputEmail = view.findViewById(R.id.edtRegEmail);
        txtInputPassword = view.findViewById(R.id.edtRegPassword);

        btnReg = view.findViewById(R.id.btnRegistration);
        btnReg.setOnClickListener((v)->{
            onRegistration(txtInputFirstName.getEditText().getText().toString().trim(),
                    txtInputLastName.getEditText().getText().toString().trim(),
                    txtInputEmail.getEditText().getText().toString().trim(),
                    txtInputPassword.getEditText().getText().toString().trim());
        });
    }

    private void onRegistration(String fName, String lName, String email, String pass) {

        //TODO проверять на корректность все поля

        EventBus.getDefault().post(new ShowLoaderEvent());

        if(fName.isEmpty()){
            return;
        }else if(lName.isEmpty()){
            return;
        }else if(email.isEmpty()){
            return;
        }else if(pass.isEmpty()){
            return;
        }

        User user = new User();

        user.setfName(fName);
        user.setlName(lName);
        user.setEmail(email);
        user.setPassword(pass);

        dbReference.setValue(user);

        EventBus.getDefault().post(new HideLoaderEvent());
    }
}
