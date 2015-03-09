package com.example.ahmadlap.expandablelist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    ArrayList<String> headers;
    HashMap<String,List<String>> children;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headers = new ArrayList<String>();
        headers.add("names");
        headers.add("families");
//        headers.add("category");
//        headers.add("settings");

        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahmad");
        names.add("Mohammed");
        names.add("Momen");
        ArrayList<String> families = new ArrayList<String>();
        families.add("Otol");
        families.add("fananah");
        families.add("Rashed");
        children = new HashMap<String, List<String>>();
        children.put(headers.get(0), names);
        children.put(headers.get(1), families);

        ExpandableListView EListView = (ExpandableListView) this.findViewById(R.id.expandableListView);

        ExpandableAdapter adapter = new ExpandableAdapter(this, headers, children, R.layout.group_layout, R.layout.chiled_layout);
        EListView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
