package com.github.cataratoru_fara_cap;
public class Item {
    private String name;
    private String attribute;

    public Item(String name, String attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
