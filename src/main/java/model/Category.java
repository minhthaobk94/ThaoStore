package model;

import lombok.Data;

@Data
public class Category {
    private int id;
    private String title;

    public Category() {
    }

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
