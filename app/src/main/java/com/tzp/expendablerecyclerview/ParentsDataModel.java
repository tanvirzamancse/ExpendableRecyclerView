package com.tzp.expendablerecyclerview;

import java.util.List;

public class ParentsDataModel {
    private List<String> itemList;
    private String itemText;
    private boolean isExpendable;

    public ParentsDataModel(List<String> itemList, String itemText) {
        this.itemList = itemList;
        this.itemText = itemText;
        isExpendable = false;
    }



    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public boolean isExpendable() {
        return isExpendable;
    }

    public void setExpendable(boolean expendable) {
        isExpendable = expendable;
    }
}
