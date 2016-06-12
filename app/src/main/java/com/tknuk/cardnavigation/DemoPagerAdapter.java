package com.tknuk.cardnavigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DemoPagerAdapter extends PagerAdapter {

    private final Random random = new Random();
    private final SparseArray<TextView> mHolderArray = new SparseArray<>();
    private int mSize;
    Context mContext;

    private ImageView pageIV;
    private TextView titleTV;

    LayoutInflater mLayoutInflater;
    public DemoPagerAdapter(Context context) {
        mContext = context;
        mSize = 5;
    }

    public DemoPagerAdapter(int count) {
        mSize = count;
    }

    @Override public int getCount() {
        return mSize;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView(mHolderArray.get(position));
    }

    @Override public Object instantiateItem(ViewGroup view, int position) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.view_pager_view, view, false);
        pageIV = (ImageView) itemView.findViewById(R.id.image);
        titleTV = (TextView) itemView.findViewById(R.id.tittle);
        setTheView(position);
        view.addView(itemView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return itemView;
    }

    public void setTheView(int position) {
        Bitmap bitmap = null;
        switch (position) {
            case 0:
                titleTV.setText("Welcome to incredible India");
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.india);
                pageIV.setImageBitmap(bitmap);
                break;
            case 1:
                titleTV.setText("Welcome to USA");
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.usa);
                pageIV.setImageBitmap(bitmap);
                break;
            case 2:
                titleTV.setText("Welcome to JAPAN");
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.japan);
                pageIV.setImageBitmap(bitmap);
                break;
            case 3:
                titleTV.setText("Welcome to United Kingdom");
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.uk);
                pageIV.setImageBitmap(bitmap);
                break;
            case 4:
                titleTV.setText("Welcome to Germany");
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.germany);
                pageIV.setImageBitmap(bitmap);
                break;
            default:
                break;
        }
    }

    @Override public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
}