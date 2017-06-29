package pl.lborowy.supercv.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.supercv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordFragment extends DialogFragment {

    private static final String PASSWORD = "iksde";
    private static final int VIBRATION_TIME = 500;
    private Animation shake;
    private Vibrator vibrator;

    @BindView(R.id.password_editText)
    EditText passwordText;
    @BindView(R.id.password_button)
    Button passwordButton;

    public static PasswordFragment newInstance() {

        PasswordFragment fragment = new PasswordFragment();
        return fragment;
    }


    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override // do animacji
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
    }

    // zabezpieczenie przed "cofaniem", kiedy mamy opcje wpisania hasła
    @Override // ctrl+o
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);

        this.setCancelable(false);
    }

    // akcja przy kliknięciu CHECK
    @OnClick(R.id.password_button)
    public void checkPassword() {

        if (isPasswordValid()) {
            this.dismiss(); // znika nam PasswordFragment
        }
        else {
            notifyAuthenticationFailed();
        }
    }

    private boolean isPasswordValid() {
        String userInput = passwordText.getText().toString();
        return userInput.equals(PASSWORD);
    }

    private void notifyAuthenticationFailed() {
        passwordText.setText("");
        passwordText.startAnimation(shake);
        vibrate();
    }

    private void vibrate() {
        // wibracje przy zlym hasle
        vibrator.vibrate(VIBRATION_TIME); // do manifstu permission dac
    }
}
