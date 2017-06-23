package pl.lborowy.supercv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.supercv.View.CvRow;


public class ExperienceFragment extends Fragment {

    @BindView(R.id.experienceFragmentContainer)
    LinearLayout container;

    // TODO: Rename and change types and number of parameters
    public static ExperienceFragment newInstance() {
        ExperienceFragment fragment = new ExperienceFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_experience, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CvRow phoneRow = new CvRow(getActivity(), "(+48) 692 449 800", R.drawable.icc_local_phone_black_24dp);
        phoneRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
        container.addView(phoneRow);
        CvRow mailRow = new CvRow(getActivity(), "lucas.borowy@gmail.com", R.drawable.icc_email_black_24dp);
        mailRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        container.addView(mailRow);
        CvRow webRow = new CvRow(getActivity(), "www.google.com", R.drawable.ic_public_black_24dp);
        webRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });
        container.addView(webRow);
    }

    public void makeCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:(+48)692449800"));
        startActivity(intent);
    }


    public void sendMail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        //nie zadziała, ponieważ String musi być tablicą (dokumanetacja)
//        intent.putExtra(Intent.EXTRA_EMAIL, "mail@mail.com");
        //zadziała
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Mail z mojego CV");
        startActivity(intent);
    }

    public void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));
        startActivity(intent);
    }




}
