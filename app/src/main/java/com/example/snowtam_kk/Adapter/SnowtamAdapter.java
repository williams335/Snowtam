package com.example.snowtam_kk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.snowtam_kk.Model.Snowtam;
import com.example.snowtam_kk.R;
import com.example.snowtam_kk.View.ListSnowtams;
import com.example.snowtam_kk.View.MainActivity;
import com.example.snowtam_kk.View.Map;

import java.io.Serializable;
import java.util.List;

public class SnowtamAdapter extends BaseAdapter {
    private Context context;
    private List<Snowtam> snowtamList;

    private LayoutInflater inflater;


    public SnowtamAdapter(Context context, List<Snowtam> snowtamList){
        this.context = context;
        this.snowtamList = snowtamList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return snowtamList.size();
    }

    @Override
    public Snowtam getItem(int position) {
        return snowtamList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.item_adapter, null);

        Snowtam currentItem =  getItem(i);
        final String itemName = currentItem.getSnows();
        final double Lat = currentItem.getLat();
        final double Longis = currentItem.getLongis();

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        /*TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + "$");
        */

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), Map.class);
                intent.putExtra("Lat", Lat);
                intent.putExtra("Longis", Longis);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
