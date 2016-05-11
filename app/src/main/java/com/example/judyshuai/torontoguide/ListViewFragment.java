package com.example.judyshuai.torontoguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JudyShuai on 16-05-11.
 */
public class ListViewFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        //****************      data     ********************************//

        String[] points = new String[] { "Ripley&apos;s Aquarium", "CN Tower", "Toronto Zoo",
                "Royal Ontario Museum", "Art Gallery of Ontario", "Yorkdale Mall", "Eaton Center",
                "City Hall", "Hockey Hall of Fame", "Air Canada Center" };

        int[] imgs= new int[]{R.drawable.aquarium, R.drawable.cntower,R.drawable.torontozoo,
                R.drawable.rom, R.drawable.cntower, R.drawable.yorkdalemall,
                R.drawable.torontoeatoncentre,R.drawable.torontocityhall,R.drawable.aquarium,
                R.drawable.yorkdalemall};

        final String[] urls = new String []{
                "http://www.ripleyaquariums.com/canada/",
                "http://www.cntower.ca/en-ca/home.html",
                "http://www.torontozoo.com/",
                "http://www.rom.on.ca/en",
                "http://www.ago.net/",
                "http://yorkdale.com/",
                "http://www.torontoeatoncentre.com/en/Pages/default.aspx",
                "http://www.toronto.ca/",
                "http://www.hhof.com/",
                "http://www.theaircanadacentre.com/"
        };

        //****************      data     ********************************//


        ArrayList list = new ArrayList();

        for (int i = 0; i < points.length; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("pointsName", points[i]);
            hashMap.put("icon", imgs[i]);
            list.add(hashMap);
        }

        String[] from = new String[]{"pointsName", "icon"};
        int[] to = new int[]{R.id.pointsName, R.id.imageView};
        //setAdapter for ListView
        this.setListAdapter(new SimpleAdapter(getActivity(), list, R.layout.item_listview, from, to));
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(intent);

            }
        });

    }
}

