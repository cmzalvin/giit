package com.giit.www.entity.custom;

/**
 * Created by c0de8ug on 16-1-6.
 */
public class SpecialityJSON {
    String text;
    String val;

    public SpecialityJSON(String text, String val) {
        this.text = text;
        this.val = val;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
