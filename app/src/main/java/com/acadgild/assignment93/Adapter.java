package com.acadgild.assignment93;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Pri on 9/2/2017.
 */

public class Adapter extends BaseAdapter {
    //Declearing context title and description
    Activity context;
    String title[];
    String description[];
    //Making constructor
    public Adapter(Activity context, String title[], String description[]) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    // creating viewhOLDER CLASS it will be responsible for view
    private class ViewHolder {
        //Declaration of set of views
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    //This getView method matains how to create a view each time by inflating
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();//retreving layout of current context
        //Checking if view is null then assiging the view of customlist and holder holds the view
        if (view == null) {

            view = inflater.inflate(R.layout.customlist,null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) view.findViewById(R.id.textView);
            holder.txtViewDescription = (TextView) view.findViewById(R.id.textView2);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtViewTitle.setText(title[position]);//tile
        holder.txtViewDescription.setText(description[position]);// Desciption

        return view;//returning view

    }
}


