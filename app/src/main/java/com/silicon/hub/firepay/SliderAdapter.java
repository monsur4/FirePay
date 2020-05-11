package com.silicon.hub.firepay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    // Array of Slides
    //public int[] slideImages = {R.drawable.profile_data, R.drawable.bitcoin_boarding, R.drawable.wallet_boarding};
    public int[] slideImages = {R.drawable.im_social_girl, R.drawable.im_social_girl, R.drawable.im_social_girl};

    public String[] slideHeadings = {"PAY", "TRADE", "RELAX"};


    public String[] slideDescriptions = {
            "kfsjkdfedfskeuifefeilskfskjfks ofusfksiosifsiosfsFocuses on analytical skills and " +
                    "expert knowledgeFocuses on analytical skills and expert knowledge",
            "kljgkirjgeariggdklkgdgkldkgruepjrgpdgdgjdlgkdFocuses on analytical skills and expert" +
                    " knowledgeFocuses on analytical skills and expert knowledge",
            "fiowjeisoxvkxkand then we sstil like to seeFocuses on analytical skills and expert " +
                    "knowledgeFocuses on analytical skills and expert knowledge"
    };

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView sliderImageView = view.findViewById(R.id.imageView);
        TextView sliderHeading = view.findViewById(R.id.textView_heading);
        TextView sliderDesc = view.findViewById(R.id.textView_desc);

        //Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem().slideImages[position], position).
        //BitmapDrawable drawable = slideImages[position];
        /*Bitmap imageBitmap = BitmapFactory.decodeResource(context.getResources(), slideImages[position]);

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), slideImages[position]);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), imageBitmap);
        roundedBitmapDrawable.setCircular(true);*/
        //sliderImageView.setImageDrawable(roundedBitmapDrawable); // undo this later
        sliderImageView.setImageResource(slideImages[position]);
        sliderHeading.setText(slideHeadings[position]);
        sliderDesc.setText(slideDescriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
