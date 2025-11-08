package com.saturdaysandwichshop.interfaces;

import com.saturdaysandwichshop.orders.Order;

public interface Saving {

    //saving receipts
    void saveReceiptFile(Order order);

}
