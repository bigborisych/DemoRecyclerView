package com.vladborisov.demorecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final List<ElementItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.addAll(ElementItemsGen.getInstance().getItems());
        RecyclerView recyclerView = findViewById(R.id.activity_main_recycler);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true); // как вариант
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ElementItemsAdapter(LayoutInflater.from(this), items));

        findViewById(R.id.activity_main_button_delete).setOnClickListener(v -> {
            items.remove(2);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemRemoved(2);
        });
        findViewById(R.id.activity_main_button_add).setOnClickListener(v -> {
            items.add(2, new ElementItem("Добавленный заголовок", "Добавленный подзаголовок", 0));
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemInserted(2);
        });
    }
}