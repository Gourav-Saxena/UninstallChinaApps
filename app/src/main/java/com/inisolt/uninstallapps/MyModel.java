package com.inisolt.uninstallapps;

public class MyModel {
    String packageName;
    Boolean isChinese;

    public MyModel(String packageName, Boolean isChinese) {
        this.packageName = packageName;
        this.isChinese = isChinese;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Boolean getChinese() {
        return isChinese;
    }

    public void setChinese(Boolean chinese) {
        isChinese = chinese;
    }
}
