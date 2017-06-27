package pl.lborowy.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.lborowy.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class WebItem extends CVItem {

    public static final String WEB_ADDRESS = "google.com";

    public WebItem(String name) {
        super(R.drawable.ic_public_black_24dp, name);

    }

    public void openWebsite(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://" + WEB_ADDRESS));
        context.startActivity(intent);
    }

    @Override
    public void makeAction(Context context) {
        openWebsite(context);
    }
}
