package pl.lborowy.supercv.Model;

import android.content.Context;

/**
 * Created by RENT on 2017-06-26.
 */

public abstract class CVItem {

    protected int imageId;
    protected String name;

    public CVItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public abstract void makeAction(Context context);
}
