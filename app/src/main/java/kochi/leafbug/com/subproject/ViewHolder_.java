package kochi.leafbug.com.subproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vaisakh vij on 07-03-2018.
 */

public class ViewHolder_ extends RecyclerView.ViewHolder
{
    // A ViewHolder describes an item view and metadata about its place within the RecyclerView.
    protected ImageView thumbnail1;
    protected ImageView thumbnail2;
    protected TextView title;

    public ViewHolder_(View view) // constructor with one argument
    {   super(view);
         this.thumbnail1 = (ImageView) view.findViewById(R.id.thumbnail1);
          this.thumbnail2 = (ImageView) view.findViewById(R.id.thumbnail2);
        this.title = (TextView) view.findViewById(R.id.title);
    }

}