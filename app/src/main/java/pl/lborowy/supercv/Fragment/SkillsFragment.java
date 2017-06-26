package pl.lborowy.supercv.Fragment;

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
import pl.lborowy.supercv.Model.MailItem;
import pl.lborowy.supercv.Model.PhoneItem;
import pl.lborowy.supercv.Model.WebItem;
import pl.lborowy.supercv.R;
import pl.lborowy.supercv.View.CvRow;


public class SkillsFragment extends Fragment {

    @BindView(R.id.skillsFragmentContainer)
    LinearLayout container;

    // TODO: Rename and change types and number of parameters
    public static SkillsFragment newInstance() {
        SkillsFragment fragment = new SkillsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
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

        WebItem webItem = new WebItem();
        CvRow webRow = new CvRow(getActivity(),webItem);
        container.addView(webRow);
    }
}
