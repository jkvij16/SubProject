package kochi.leafbug.com.subproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;

/**
 * Created by vaisakh vij on 07-03-2018.
 */

public class ListView extends Activity {
    private ArrayList <Data_Holding_Class> DataHoldingClass_ArrayList = new ArrayList<Data_Holding_Class>();

    private RecyclerView recyclerViewObj;

    private Adapter_ adapterObj;

    private boolean loading = true;

    private RecyclerView.LayoutManager mLayoutManager;

    int pastVisiblesItems, visibleItemCount, totalItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("In", "Main_Activity    Oncreate");
        //A progress bar can also be made indeterminate.
        // In indeterminate mode, the progress bar shows a cyclic animation without an indication of progress.
        // This mode is used by applications when the length of the task is unknown.
        // The indeterminate progress bar can be either a spinning wheel or a horizontal bar.
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//  FEATURE_INDETERMINATE_PROGRESS is the Flag for indeterminate progress

        setContentView(R.layout.activitylrecylelist);
        recyclerViewObj = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerViewObj.setLayoutManager(mLayoutManager);



        Data_Holding_Class DataHoldingClassObj = new Data_Holding_Class();
        for(int h=0;h<40;h++)
        {
            DataHoldingClassObj.setTitle("title");
            DataHoldingClassObj.setThumbnail("thumbnail");
            DataHoldingClass_ArrayList.add(DataHoldingClassObj);
        }
        adapterObj = new Adapter_(ListView.this, DataHoldingClass_ArrayList);
        recyclerViewObj.setAdapter(adapterObj);


        recyclerViewObj.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = mLayoutManager.getChildCount();
                    Log.e("visibleItemCount",String.valueOf(visibleItemCount));
                    totalItemCount = mLayoutManager.getItemCount();
                     //pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.v("...", "Last Item Wow !");
                            //Do pagination.. i.e. fetch new data
                        }
                    }
                }
            }
        });
    }
}

