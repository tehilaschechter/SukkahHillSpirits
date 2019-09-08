package com.example.fried.sukkahhillspirits;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] list = {"Products", "Prices", "Meet Us/Book A Tour", "Our Site"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.list, list));
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){
            case 0:
                startActivity(new Intent(MainActivity.this, Products.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Prices.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Meet.class));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sukkahhill.com/")));
                break;
        }
    }
}
