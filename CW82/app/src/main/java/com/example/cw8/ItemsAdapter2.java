package com.example.cw8;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemsAdapter2 extends ArrayAdapter {

    List<Items> itemList;
    Animation animation;


    public ItemsAdapter2(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row2, parent, false);
        animation = android.view.animation.AnimationUtils.loadAnimation(getContext(),R. anim.animation1);

        


        Items currentItem = itemList.get(position);
        ImageView good = view.findViewById(R.id.good);
        TextView itemNameTxt = view.findViewById(R.id.itemNameTxt);
        TextView itemPriceTxt = view.findViewById(R.id.itemPriceTxt);
        final ImageView itemImage = view.findViewById(R.id.itemImage);

        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
                .alpha(1f)
                .setDuration(800)
                .setListener(null);

        itemNameTxt.setText(currentItem.getItemName());
        itemPriceTxt.setText("$" + String.valueOf(currentItem.getItemPrice()) + "0");
        itemImage.setImageResource(currentItem.getItemImg());
        view.setAnimation(animation);


        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "It is NEW!😉", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
