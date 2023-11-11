package mcsinos.entity;

import mcsinos.enumerator.MenuItem;

import java.util.List;
import java.util.Random;

public class Order  {
    int id;
    List<MenuItem> items;

    public Order(int id, MenuItem... items) {
        this.id = id;
        this.items = List.of(items);
    }

    public Order(MenuItem... items) {
        this.id = new Random().nextInt(100);
        this.items = List.of(items);
    }

    @Override
    public String toString() {
        return "Order\n{id=" + id + ", items=" + items + "}";
    }

}
