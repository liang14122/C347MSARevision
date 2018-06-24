package com.example.a16004118.c347msarevision.Object;

import java.io.Serializable;

public class SerializableItem implements Serializable {

    private String name;
    private int id;

    public SerializableItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
