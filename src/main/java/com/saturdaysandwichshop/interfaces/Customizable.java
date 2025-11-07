package com.saturdaysandwichshop.interfaces;

import java.util.List;

public interface Customizable {

    //get & display the options
    void addOption(String option);
    void removeOption(String option);

    List<String> getOption();
}



//menu/sandwich/receipt implement from the interface classes