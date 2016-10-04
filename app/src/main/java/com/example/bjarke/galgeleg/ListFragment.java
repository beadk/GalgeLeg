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
        final GalgeLogik logik = MainScreen.logik;
        ListView lv = (ListView) inf.findViewById(R.id.listView1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                logik.setOrdet(i);
                StartGame();
            }
        });
        lv.setAdapter(new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1 ,logik.getMuligeOrd()));

        return inf;
    }
    public void StartGame(){
        Fragment fragment = new StartFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
}
