package com.vladborisov.demorecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElementItemViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView, subtitleTextView;

    public ElementItemViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.titleTextView);
        subtitleTextView = itemView.findViewById(R.id.subTitleTextView);
    }

    public void bind(ElementItem item){
        titleTextView.setText(item.title);
        subtitleTextView.setText(item.subtitle);
    }
}
