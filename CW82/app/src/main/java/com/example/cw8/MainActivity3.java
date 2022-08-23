package com.example.cw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private final ArrayList<Items> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final ListView listView2 = findViewById(R.id.listview2);
        ImageView deals = findViewById(R.id.deal);
        listView2.setRotation(-90);

        Bundle bundle = getIntent().getExtras();

        Items item = new Items("Leatherette Sofa", 270, R.drawable.chair0);
        Items item1 = new Items("Levi Armchair", 99.9, R.drawable.chair);
        Items item2 = new Items("Walnut Z chair", 150, R.drawable.chair5 );
        Items item3 = new Items("Sofa Stool", 29.9, R.drawable.chair1 );
        Items item4 = new Items("Engage Armchair", 250, R.drawable.chair3 );
        Items item5 = new Items("Cafe chair", 90, R.drawable.chair4 );
        Items item6 = new Items("Puffy Teal", 550, R.drawable.chair6 );
        Items item7 = new Items("Conroy Sofa", 270, R.drawable.chair2 );
        Items item8 = new Items("Shell chair", 200, R.drawable.chair7 );
        Items item9 = new Items("Wingback chair", 175, R.drawable.chair8 );
        Items item10 = new Items("Grand Piano", 600, R.drawable.chair9 );

        items.add(item);
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

        ItemsAdapter2 itemsAdapter2 = new ItemsAdapter2(this, 0, items);

        listView2.setAdapter(itemsAdapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(MainActivity3.this, DetailsActivity.class);
                intent.putExtra("item", (Serializable) items.get(position));
                startActivity(intent);
            }
        });

        deals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}