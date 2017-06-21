package pl.lborowy.supercv.View;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by RENT on 2017-06-21.
 */

public class CvRow extends LinearLayout {

    private String text;
    private int imageId;

    public CvRow(Context context, String text, int imageId) {
        super(context);
        this.text = text;
        this.imageId = imageId;


        setupMainLayout(context);
        ImageView imageView = setupImageView(context, imageId);
        TextView textView = setupTextView(context, text);

        addViews(imageView, textView);

    }

    private void addViews(ImageView imageView, TextView textView) {
        this.addView(imageView);
        this.addView(textView);
    }

    @NonNull
    private TextView setupTextView(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(textParams);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(dpToPx(context,32),0,0,0);
        return textView;
    }

    @NonNull
    private ImageView setupImageView(Context context, int imageId) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        LayoutParams imageParams = new LayoutParams(dpToPx(context,24), dpToPx(context,24));
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(imageParams);
        return imageView;
    }

    private void setupMainLayout(Context context) {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(context,48));
        this.setLayoutParams(params);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setPadding(dpToPx(context,16), 0, dpToPx(context,16), 0);
    }

    private int dpToPx(Context context, int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

}
