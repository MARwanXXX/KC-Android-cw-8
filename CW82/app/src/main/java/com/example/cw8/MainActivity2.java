package com.example.cw8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private final ArrayList<Items> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ListView listView = findViewById(R.id.listview);




        Bundle bundle = getIntent().getExtras();


        Items item1 = new Items("Levi Armchair",99.9, R.drawable.chair );
        Items item2 = new Items("Walnut Z chair", 150, R.drawable.chair5 );
        Items item3 = new Items("Sofa Stool", 29.9, R.drawable.chair1 );
        Items item4 = new Items("Engage Chair", 250, R.drawable.chair3 );
        Items item5 = new Items("Cafe chair", 90, R.drawable.chair4 );
        Items item6 = new Items("Puffy Teal", 550, R.drawable.chair6 );
        Items item7 = new Items("Conroy Sofa", 270, R.drawable.chair2 );
        Items item8 = new Items("Shell chair", 200, R.drawable.chair7 );
        Items item9 = new Items("Wingback ", 175, R.drawable.chair8 );
        Items item10 = new Items("Grand Piano", 600, R.drawable.chair9 );

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);

        ItemsAdapter itemsAdapter = new ItemsAdapter(this, 0, items);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(MainActivity2.this, DetailsActivity.class);
                intent.putExtra("item", (Serializable) items.get(position));
                startActivity(intent);
            }
        });
    }
}