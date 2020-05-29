package com.example.firebasetutorial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArtistList extends ArrayAdapter<ArtistData> {
    private Activity context;
    private List<ArtistData> artistDataList;

    public ArtistList(Activity context,List<ArtistData> artistList)
    {
        super(context,R.layout.list_layout,artistList);
        this.context=context;
        this.artistDataList=artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName=(TextView) listViewItem.findViewById(R.id.text_view_name);

        ArtistData artistData=artistDataList.get(position);
        textViewName.setText(artistData.getName());

        return listViewItem;
    }
}
