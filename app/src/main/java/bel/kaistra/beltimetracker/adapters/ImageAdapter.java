package bel.kaistra.beltimetracker.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import bel.kaistra.beltimetracker.R;
import bel.kaistra.beltimetracker.util.ImageResizer;

public class ImageAdapter extends BaseAdapter{
    private Context context;

    public Integer[] iconIDs = {
            R.drawable.big_smile,R.drawable.cereal_guy,
            R.drawable.epic_win, R.drawable.fap,
            R.drawable.kitteh_smile,R.drawable.lol_crazy
    };

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return iconIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return iconIDs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 170));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else {
            imageView = (ImageView) convertView;
        }
        Bitmap sampleBitmap = ImageResizer.decodeBitmapFromResourse(context.getResources(),iconIDs[position],150,170);
        imageView.setImageBitmap(sampleBitmap);
        return imageView;
    }
}
