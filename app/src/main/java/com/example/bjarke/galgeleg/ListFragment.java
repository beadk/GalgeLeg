package com.example.bjarke.galgeleg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import logik.GalgeLogik;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_list, container, false);
        GalgeLogik logik = MainScreen.logik;
        ListView lv = new ListView(this.getActivity());
        lv.setOnItemClickListener((AdapterView.OnItemClickListener) this.getActivity());
        lv.setAdapter(new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1 ,logik.getMuligeOrd()){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent){
                View view = super.getView(position,cachedView,parent);
                TextView listDescription = (TextView) view.findViewById(R.id.listDescription);
                listDescription.setText(position);
                return view;
            }
        });


        return inf;
    }

}
