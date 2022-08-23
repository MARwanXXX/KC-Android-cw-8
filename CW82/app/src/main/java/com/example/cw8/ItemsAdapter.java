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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter {

    List<Items> itemList;
    Animation animation;


    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);
        animation = android.view.animation.AnimationUtils.loadAnimation(getContext(),R. anim.animation1);




        Items currentItem = itemList.get(position);
        ImageView delete = view.findViewById(R.id.delete);
        TextView itemNameTxt = view.findViewById(R.id.itemNameTxt);
        TextView itemPriceTxt = view.findViewById(R.id.itemPriceTxt);
        TextView price = view.findViewById(R.id.price);
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


        itemNameTxt.setAnimation(animation);
        view.setAnimation(animation);
        itemImage.setAnimation(animation);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(getContext());
                dialog.setCancelable(false);
                dialog.setTitle("");
                dialog.setMessage("Are you sure???????????");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                itemList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                final AlertDialog alert = dialog.create();
                alert.show();
            }
        });

        return view;
    }
}
