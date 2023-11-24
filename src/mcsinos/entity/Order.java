package mcsinos.entity;

import mcsinos.enumerator.MenuItem;

import java.util.List;
import java.util.StringJoiner;

public class Order  {
    int id;
    List<MenuItem> items;

    public Order(int id, MenuItem... items) {
        this.id = id;
        this.items = List.of(items);
    }

    public Order(int id, List<MenuItem> items) {
        this.id = id;
        this.items = items;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", this.id + " → ", "");
        for (MenuItem item : items) {
            sj.add(item.toString());
        }
        return sj.toString();
    }

}
