package com.example.judyshuai.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.judyshuai.torontoguide.R;

/**
 * Created by JudyShuai on 16-05-11.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private String [] names;
    private int [] imageIds;
    private static LayoutInflater inflater = null;

    public GridViewAdapter(Context mContext,String [] textList, int[] imgId) {
        this.mContext = mContext;
        names = textList;
        imageIds = imgId;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();

        convertView = inflater.inflate(R.layout.row_gridview, null);
        holder.textView=(TextView) convertView.findViewById(R.id.grid_textView);
        holder.imageView=(ImageView) convertView.findViewById(R.id.grid_imageView);

        holder.textView.setText(names[position]);
        holder.imageView.setImageResource(imageIds[position]);


        return convertView;
    }
}
