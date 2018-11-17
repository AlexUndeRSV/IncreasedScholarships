package com.lynx.increasedscholarshipsapp.presentation.enter;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lynx.increasedscholarshipsapp.R;
import com.lynx.increasedscholarshipsapp.other.event.HideLoaderEvent;
import com.lynx.increasedscholarshipsapp.other.event.SetTitleEvent;
import com.lynx.increasedscholarshipsapp.other.event.ShowLoaderEvent;
import com.lynx.increasedscholarshipsapp.presentation.registration.RegistrationFragment;

import org.greenrobot.eventbus.EventBus;

public class EnterFragment extends MvpAppCompatFragment implements EnterView {
    public static final String TAG = "EnterFragment";
    @InjectPresenter
    EnterPresenter presenter;

    private FirebaseAuth mAuth;
    private DatabaseReference dbReference;

    private TextInputLayout txtInputEmail, txtInputPassword;
    private Button btnEnter, btnGoToReg;


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

        EventBus.getDefault().post(new SetTitleEvent("Вход"));

        mAuth = FirebaseAuth.getInstance();
        dbReference = FirebaseDatabase.getInstance().getReference().child("users");

        txtInputEmail = view.findViewById(R.id.edtEnterEmail);
        txtInputPassword = view.findViewById(R.id.edtEnterPassword);

        btnEnter = view.findViewById(R.id.btnEnter);
        btnGoToReg = view.findViewById(R.id.btnGoToRegistration);

        btnEnter.setOnClickListener((v) -> checkFirebase((txtInputEmail.getEditText().getText().toString().trim()), txtInputPassword.getEditText().getText().toString().trim()));
        btnGoToReg.setOnClickListener((v) -> goToRegistration());
    }

    private void goToRegistration() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, RegistrationFragment.newInstance(null))
                .commit();
    }

    private void checkFirebase(String email, String password) {

        if (email.isEmpty() || password.isEmpty()) {
            Snackbar.make(btnEnter, "Все поля должны быть заполнены", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", (v) -> {
                    })
                    .show();
            return;
        }

        EventBus.getDefault().post(new ShowLoaderEvent());

        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    if(data.child("email").getValue().equals(email)){
                        if(data.child("pass").getValue().equals(password)){
                            Snackbar.make(btnEnter, "Все хорошо)", Snackbar.LENGTH_INDEFINITE)
                                    .setAction("OK", v -> {

                                    }).show();
                            EventBus.getDefault().post(new HideLoaderEvent());
                        }
                    }
                }
                EventBus.getDefault().post(new HideLoaderEvent());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Snackbar.make(btnEnter, "Все хорошо)", Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", v -> {

                                }).show();
                        EventBus.getDefault().post(new HideLoaderEvent());
                    } else {
                        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
                        ab.setTitle("Ошибка")
                                .setMessage("Введен неверный логин или пароль")
                                .setNeutralButton("OK", (dialog, which) -> dialog.dismiss());
                        ab.create().show();
                        EventBus.getDefault().post(new HideLoaderEvent());
                    }
                });*/
    }
}
