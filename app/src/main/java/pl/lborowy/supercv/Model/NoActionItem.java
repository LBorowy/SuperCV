package pl.lborowy.supercv.Model;

import android.content.Context;

import pl.lborowy.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class NoActionItem extends CVItem{

    public static final String TAG_NO_ACTION = "No Action";

    public NoActionItem() {
        super(R.drawable.ic_visibility_off_black_24dp, TAG_NO_ACTION);
    }

    @Override
    public void makeAction(Context context) {
        // Leave empty
    }
}
