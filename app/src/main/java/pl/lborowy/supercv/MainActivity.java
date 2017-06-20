package pl.lborowy.supercv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.textViewphoneNumber)
    TextView phoneNumber;
    private String number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.firstElement)
    public void makeCall() {
        number = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:(+48)123456789"));
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    @OnClick(R.id.secondElement)
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

    @OnClick(R.id.thirdElement)
    public void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));
        startActivity(intent);
    }
}
