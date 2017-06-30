package pl.lborowy.supercv.Fragment;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.supercv.MainActivity;
import pl.lborowy.supercv.Model.CVItem;
import pl.lborowy.supercv.Model.MailItem;
import pl.lborowy.supercv.Model.MessengerItem;
import pl.lborowy.supercv.Model.PhoneItem;
import pl.lborowy.supercv.Model.WebItem;
import pl.lborowy.supercv.R;
import pl.lborowy.supercv.SnackBarShower;
import pl.lborowy.supercv.View.CvRow;


public class ContactFragment extends Fragment {

    //    private MainActivity mainActivity; // po interfejsie
    // nazwa interfejsu
    private SnackBarShower snackBarShower;


    public static final String TAG_WEB_ADSRESS = "google.com";

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
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof MainActivity) // w przypadku gdyby byly inne Activity
//            mainActivity = (MainActivity) context; // dzieki temu mozemy wywolac na mainActivity.showSnackBar();
        // po interfejsie
        // jesli kontekst jest instacja czegos co pokazuje snackbar, to moj adres do pokazywania snackbara bedzie kontekstem.
        if (context instanceof SnackBarShower)
            snackBarShower = (SnackBarShower) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

//        LinearLayout container2 = view.findViewById(R.id.contactFragmentContainer);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PhoneItem phoneItem = new PhoneItem();
        CvRow phoneRow = new CvRow(getActivity(), phoneItem);
//        phoneRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                phoneItem.makeCall(getActivity());
//            }
//        });
        container.addView(phoneRow);

        final MailItem mailItem = new MailItem();
        CvRow mailRow = new CvRow(getActivity(), mailItem);
//        mailRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mailItem.sendMail(getActivity());
//            }
//        });
        container.addView(mailRow);

        final WebItem webItem = new WebItem(TAG_WEB_ADSRESS);
        CvRow webRow = new CvRow(getActivity(), webItem);
//        webRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                webItem.openWebsite(getActivity());
//            }
//        });
        container.addView(webRow);


        MessengerItem messengerItem = new MessengerItem();
        CvRow messengerRow = new CvRow(getActivity(), messengerItem);
        container.addView(messengerRow);

        messengerRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pokaz messengera
                Uri uri = Uri.parse("fb-messenger://user/"); // wskazuje na aplikacje w kodzie
                uri = ContentUris.withAppendedId(uri, 121526247868537L); // numer ze stronki + L
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getActivity().startActivity(intent);
                }
                else {

                    // snackbar
                    // zeby wyjac MainActivity z FragmentActivity trzeba rzutować acti.cast
//                   ((MainActivity) getActivity()).showSnackbar("Brak aplikacji Messenger"); // onAttach

//                   mainActivity.showSnackBar("Brak aplikacji Messenger ;(");
                    snackBarShower.showSnackBar("Brak aplikacji Messenger ;(");
                }
            }
        }
        );
    }


//
//        final CvRow phoneRow = new CvRow(getActivity(), "(+48) 692 449 800", R.drawable.icc_local_phone_black_24dp);
//        phoneRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               makeCall();
//            }
//        });
//        container.addView(phoneRow);
//        CvRow mailRow = new CvRow(getActivity(), "lucas.borowy@gmail.com", R.drawable.icc_email_black_24dp);
//        mailRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendMail();
//            }
//        });
//        container.addView(mailRow);
//        CvRow webRow = new CvRow(getActivity(), "www.google.com", R.drawable.ic_public_black_24dp);
//        webRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openWebsite();
//            }
//        });
//        container.addView(webRow);
//    }

//    public void makeCall() {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:(+48)692449800"));
//        startActivity(intent);
//    }


//    public void sendMail() {
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        //nie zadziała, ponieważ String musi być tablicą (dokumanetacja)
////        intent.putExtra(Intent.EXTRA_EMAIL, "mail@mail.com");
//        //zadziała
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Mail z mojego CV");
//        startActivity(intent);
//    }

    public void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));
        startActivity(intent);
    }

    @Override // w momencie zamykania fragmentu (snackbara) garbageCollector usuwam go
    public void onDetach() {
        super.onDetach();
//        mainActivity = null;
        snackBarShower = null;
    }
}
