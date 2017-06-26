package pl.lborowy.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.lborowy.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class MailItem extends CVItem{


    private static final String TAG_EMAIL = "lucas.borowy@gmail.com";
    private static final String TAG_MAILTO = "mailto:";
    private static final String TAG_SUBJECT = "Mail z mojego CV";

    public MailItem() {
        super(R.drawable.icc_email_black_24dp, TAG_EMAIL);
    }

    public void sendMail(Context context) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(TAG_MAILTO));
        //nie zadziała, ponieważ String musi być tablicą (dokumanetacja)
//        intent.putExtra(Intent.EXTRA_EMAIL, "mail@mail.com");
        //zadziała
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, TAG_SUBJECT);
        context.startActivity(intent);
    }

    @Override
    public void makeAction(Context context) {
        sendMail(context);
    }
}
