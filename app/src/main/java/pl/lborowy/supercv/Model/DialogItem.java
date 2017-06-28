package pl.lborowy.supercv.Model;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by RENT on 2017-06-28.
 */

public class DialogItem extends CVItem{

    private String text;

    public DialogItem(int imageId, String name, String text) {
        super(imageId, name);
        this.text = text;
    }

    @Override // protected w CVItem !
    public void makeAction(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(name)
                .setIcon(imageId)
                .setMessage(text);

//        builder.create().show();
        //lub
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
