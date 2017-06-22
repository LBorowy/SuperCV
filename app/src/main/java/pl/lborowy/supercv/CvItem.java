package pl.lborowy.supercv;

/**
 * Created by RENT on 2017-06-21.
 */

public class CvItem {

    private final int imageId;
    private final String text;

    public CvItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
