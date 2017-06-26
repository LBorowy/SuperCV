package pl.lborowy.supercv.View;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.lborowy.supercv.Model.CVItem;
import pl.lborowy.supercv.Model.MailItem;
import pl.lborowy.supercv.Model.PhoneItem;
import pl.lborowy.supercv.Model.WebItem;

/**
 * Created by RENT on 2017-06-21.
 */

public class CvRow extends LinearLayout {
    private final Context context;
    private final DisplayMetrics metrics;
    private final CVItem cvItem;

    public CvRow(final Context context, final CVItem cvItem) {
        super(context);
        this.context = context;
        this.cvItem = cvItem;


        Resources resources = context.getResources();
        metrics = resources.getDisplayMetrics();

        setupMainLayout();
        ImageView imageView = createImageView();
        TextView textView = createTextView();

        addViews(imageView, textView);


        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (cvItem instanceof PhoneItem)
//                    ((PhoneItem) cvItem).makeCall(context);
//                else if (cvItem instanceof MailItem)
//                    ((MailItem) cvItem).sendMail(context);
//                else if (cvItem instanceof WebItem)
//                    ((WebItem) cvItem).openWebsite(context);
                cvItem.makeAction(context);
            }
        });
    }

    private void addViews(ImageView imageView, TextView textView) {
        this.addView(imageView);
        this.addView(textView);
    }

    @NonNull
    private TextView createTextView() {
        TextView textView = new TextView(context);
        textView.setText(cvItem.getName()); // getText
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
        imageView.setImageResource(cvItem.getImageId());
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
