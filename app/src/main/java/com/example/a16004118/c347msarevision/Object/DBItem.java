package com.example.a16004118.c347msarevision.Object;

public class DBItem {

    private String name;
    private int id;
    private int star;

    public DBItem(int id, String name,  int star) {
        this.name = name;
        this.id = id;
        this.star = star;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
