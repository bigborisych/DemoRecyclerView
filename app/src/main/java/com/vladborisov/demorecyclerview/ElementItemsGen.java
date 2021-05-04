package com.vladborisov.demorecyclerview;

import java.util.ArrayList;
import java.util.List;

public class ElementItemsGen {
    private static final int ITEM_COUNT = 50;
    private static final List<ElementItem> items = new ArrayList<>();
    private static ElementItemsGen instance;

    private ElementItemsGen() {
        for (int i = 1; i < ITEM_COUNT; i++) {
            items.add(new ElementItem("Заголовок" + i, "Подзаголовок" + i, 0));
        }
    }

    public static ElementItemsGen getInstance() {
        if (instance == null) {
            instance = new ElementItemsGen();
        }
        return instance;
    }

    public List<ElementItem> getItems() {
        return items;
    }
}
