package pl.lborowy.supercv.View;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by RENT on 2017-06-21.
 */

public class CvRow extends LinearLayout {

    private String text; // TextView
    private int imageId; // ImageView - R.id.ic_email_black_24.dp.xml

    public CvRow(Context context, String text, int imageId) {
        super(context);
        this.text = text; // TextView
        this.imageId = imageId; // ImageView

        // prostokąt(layout) (szerokość na matchParent i wysokość na 48)
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 48);
        this.setLayoutParams(params);
        // orientacja w LinearLayout HORIZONTAL
        this.setOrientation(LinearLayout.HORIZONTAL);
        // padding layoutu
        this.setPadding(16, 0, 16, 0);

        ImageView imageView = new ImageView(context); // obiekt ImageView przyjmuje context
        imageView.setImageResource(imageId); //
        LayoutParams imageParams = new LayoutParams(24, 24); // *1 ustawienie rozmiarów Layoutu dla rys (24px/24px)
        imageParams.gravity = Gravity.CENTER_VERTICAL; // ustawienie gravity dla ImageView
        imageView.setLayoutParams(imageParams); // inicjacja *1

        // dodawanie widoku ImageView
        this.addView(imageView);

        TextView textView = new TextView(context);
        textView.setText(text);
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(textParams);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(32,0,0,0);

        this.addView(textView);

    }

}
