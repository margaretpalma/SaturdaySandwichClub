package com.saturdaysandwichshop.orders;

import com.saturdaysandwichshop.models.ProductMain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    //customer order

    //arrayList of products
    //sandwich, chips, drinks
    private final List<ProductMain> items = new ArrayList<>();


    //add products
    public void addItem(ProductMain item){
        items.add(item);
    }

    //receipt and ui display items
    public List<ProductMain> getItems(){
        return items;
    }
    //clear order
    public void clear(){
        items.clear();
    }

    //total cost
    //streams
    public double getTotal(){
        return items.stream().mapToDouble(ProductMain::getPrice).sum();
    }

    //formatting
    @Override
    public String toString() {
        String itemList = items.isEmpty() ? "No items!" : items.stream().map(items -> String.format(items.getProductName(),
                items.getPrice())).collect(Collectors.joining("\n"));

        return  itemList + "---\n$Your Total Is" + getTotal();
    }
}
