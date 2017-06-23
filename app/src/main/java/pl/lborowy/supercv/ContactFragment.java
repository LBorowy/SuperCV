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


public class ContactFragment extends Fragment {


    @BindView(R.id.contactFragmentContainer)
    LinearLayout container;

    // #11
//    private OnFragmentInteractionListener mListener;

    public ContactFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    // wywalamy, bo program i tak odwoła sie do fragmentów z nad klasy -> public class ContactFragment extends Fragment
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {                         też wywalić
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this,view);

//        LinearLayout container2 = view.findViewById(R.id.contactFragmentContainer);

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

    // #11 zakomentowac, bo sie wywali
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
