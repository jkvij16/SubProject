package kochi.leafbug.com.subproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vaisakh vij on 07-03-2018.
 */

public class Adapter_ extends RecyclerView.Adapter<ViewHolder_>
{
    // Adapters provide a binding from an app-specific data set (Here, the data set is, our Data Holding Class's data) to views that are displayed within a RecyclerView.

    private ArrayList<Data_Holding_Class> holdingClassArraylist;
    private Context mContext;

    public Adapter_(Context context, ArrayList<Data_Holding_Class> arrayListElements)
    {
        this.holdingClassArraylist = arrayListElements;
        this.mContext = context;
    }

    // onCreateViewHolder is called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.

    // This new ViewHolder should be constructed(on created) with a new View(list_row) that can represent the items of the type that have declared. (like imageview , textview).
    // A ViewGroup is a special view that can contain other views (called children.) Here our view in activity_main is the parent
    // parent : The ViewGroup into which the new View will be added after it is bound to an adapter position.
    // int viewType: is the view type of the new View.
    @Override
    public ViewHolder_ onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.e("In","onCreateViewHolder");
        Log.d("ViewGroup size",String.valueOf(parent.getScrollBarStyle()));
        Log.d("viewType",String.valueOf(viewType));
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null); // .from means, Obtains the LayoutInflater from the given context.

        return new ViewHolder_(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder_ holder, int position)
    {
        // onBindViewHolder is called by RecyclerView to display the data at the specified position.
        // int i : The position of the item within the adapter's data set.
        Log.e("In","onBindViewHolder");
        Log.d("ViewHolder_ holder",String.valueOf(holder));
        Log.d("position",String.valueOf(position));
        Data_Holding_Class Dataholdingclass = holdingClassArraylist.get(position);


       Picasso.with(mContext).load("http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/sign-check-icon.png")
                .error(R.drawable.googleplus)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.thumbnail1);


        holder.title.setText(Dataholdingclass.getTitle()+String.valueOf(position));
    }

    @Override
    public int getItemCount()
    {
        Log.e("In","getItemCount");
        Log.e("getItemCount is",String.valueOf((holdingClassArraylist != null ? holdingClassArraylist.size() : 0)));
        return (holdingClassArraylist != null ? holdingClassArraylist.size() : 0);
    }
}

