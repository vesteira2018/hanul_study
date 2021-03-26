package com.example.my10_intentresult;

import java.io.Serializable;

public class Person implements Serializable {
    String id;
    int pw;

    public Person(String id, int pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

}//class
