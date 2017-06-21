package pl.lborowy.supercv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.supercv.View.CvRow;

public class MainActivity extends AppCompatActivity {

//    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.container)
    LinearLayout container;

//    @BindView(R.id.textViewphoneNumber)
//    TextView phoneNumber;
    private String number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CvRow phoneRow = new CvRow(this, "(+48) 692 449 800", R.drawable.icc_local_phone_black_24dp);
        container.addView(phoneRow);

        CvRow mailRow = new CvRow(this, "lucas.borowy@gmail.com", R.drawable.icc_email_black_24dp);
        container.addView(mailRow);

        CvRow webRow = new CvRow(this, "www.google.com", R.drawable.ic_public_black_24dp);
        container.addView(webRow);

        phoneRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
                sendMail();
                openWebsite();

            }
        });
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
