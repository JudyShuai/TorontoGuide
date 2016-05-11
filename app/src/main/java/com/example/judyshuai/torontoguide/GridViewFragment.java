package com.example.judyshuai.torontoguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.judyshuai.adapters.GridViewAdapter;

/**
 * Created by JudyShuai on 16-05-11.
 */
public class GridViewFragment extends Fragment implements AdapterView.OnItemClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gridview, container, false);


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


        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(rootView.getContext(),points,imgs));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


