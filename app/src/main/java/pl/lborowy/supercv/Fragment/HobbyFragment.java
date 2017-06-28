package pl.lborowy.supercv.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.supercv.Model.MailItem;
import pl.lborowy.supercv.Model.NoActionItem;
import pl.lborowy.supercv.Model.PhoneItem;
import pl.lborowy.supercv.Model.WebItem;
import pl.lborowy.supercv.R;
import pl.lborowy.supercv.View.CvRow;

/**
 * A simple {@link Fragment} subclass.
 */
public class HobbyFragment extends Fragment {

    public static final String TAG_WEB_ADDRESS = "google.com";

    @BindView(R.id.hobbyFragmentContainer)
    LinearLayout container;

    public static HobbyFragment newInstance() {
        HobbyFragment fragment = new HobbyFragment();
        return fragment;
    }

    public HobbyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hobby, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PhoneItem phoneItem = new PhoneItem();
        CvRow phoneRow = new CvRow(getActivity(),phoneItem);
        container.addView(phoneRow);

        MailItem mailItem = new MailItem();
        CvRow mailRow = new CvRow(getActivity(),mailItem);
        container.addView(mailRow);

        WebItem webItem = new WebItem(TAG_WEB_ADDRESS);
        CvRow webRow = new CvRow(getActivity(), webItem);
        container.addView(webRow);


        NoActionItem noActionItem = new NoActionItem("cooostam");
        CvRow noItemRow = new CvRow(getActivity(),noActionItem);
        container.addView(noItemRow);
    }
}
