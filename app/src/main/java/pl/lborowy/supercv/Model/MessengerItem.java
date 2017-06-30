package pl.lborowy.supercv.Model;

import android.content.Context;

import pl.lborowy.supercv.R;

/**
 * Created by RENT on 2017-06-30.
 */

public class MessengerItem extends CVItem {

    private static final String MESSENGER = "Messenger";

    public MessengerItem() {
        super(R.drawable.ic_facebook_messenger, MESSENGER);
    }


    @Override
    public void makeAction(Context context) {
        // Leave empty
    }
}
