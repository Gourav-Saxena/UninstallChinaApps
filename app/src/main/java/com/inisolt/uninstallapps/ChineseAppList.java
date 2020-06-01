package com.inisolt.uninstallapps;

import java.util.ArrayList;

public class ChineseAppList {
    public ChineseAppList() {
        setChineseAppList();
    }

    private ArrayList<String> chineseAppList = new ArrayList<>();

    public ArrayList<String> getChineseAppList() {
        return chineseAppList;
    }

    private void setChineseAppList() {
        chineseAppList.add("org.mozilla.firefox");
    }
}
