package com.example.cw8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView item_name, item_price, item_nutrition;
    ImageView item_image;
    Animation animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        Items items = (Items) bundle.getSerializable("item");

        item_name = findViewById(R.id.item_name_txt);
        item_price = findViewById(R.id.item_price_txt);
        item_nutrition = findViewById(R.id.item_nutrition);
        item_image = findViewById(R.id.item_image);
        animation = AnimationUtils.loadAnimation(this,R.anim.animation1);

        item_name.setText(items.getItemName());
        item_price.setText("$" + String.valueOf(items.getItemPrice()) + "0");
        item_image.setImageResource(items.getItemImg());


    }
}