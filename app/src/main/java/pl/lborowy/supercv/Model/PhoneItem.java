package pl.lborowy.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.lborowy.supercv.Constants;
import pl.lborowy.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class PhoneItem extends CVItem {

//    private static String TAG_PHONE_NUMBER = "(+48) 692 449 800";
    private String number;

    public PhoneItem() {
        super(R.drawable.icc_local_phone_black_24dp, "Moj numer: " + Constants.PHONE_NUMBER);
        number = Constants.PHONE_NUMBER;
    }

    public PhoneItem(String number) {
        super(R.drawable.icc_local_phone_black_24dp, number);
//        TAG_PHONE_NUMBER = number;
        this.number = number;
    }

    public PhoneItem(int imgId, String number) {
        super(imgId, number);
    }


    public void makeCall(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }

    @Override
    public void makeAction(Context context) {
        makeCall(context);
    }
}
