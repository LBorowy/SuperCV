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
    private final Context context;
    private final DisplayMetrics metrics;
    private final String text;
    private final int imageId;

    public CvRow(Context context, String text, int imageId) {
        super(context);
        this.context = context;
        this.text = text;
        this.imageId = imageId;

        Resources resources = context.getResources();
        metrics = resources.getDisplayMetrics();

        setupMainLayout();
        ImageView imageView = createImageView();
        TextView textView = createTextView();

        addViews(imageView, textView);

    }

    private void addViews(ImageView imageView, TextView textView) {
        this.addView(imageView);
        this.addView(textView);
    }

    @NonNull
    private TextView createTextView() {
        TextView textView = new TextView(context);
        textView.setText(text);
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(textParams);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(dpToPx(32), 0, 0, 0);
        return textView;
    }

    @NonNull
    private ImageView createImageView() {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        LayoutParams imageParams = new LayoutParams(dpToPx(24), dpToPx(24));
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(imageParams);
        return imageView;
    }

    private void setupMainLayout() {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(48));
        this.setLayoutParams(params);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    }

    private int dpToPx(int dp) {
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

}
