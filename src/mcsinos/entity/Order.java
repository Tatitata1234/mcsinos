package mcsinos.entity;

import mcsinos.enumerator.MenuItem;

import java.util.List;

public class Order  {
    int id;
    List<MenuItem> items;

    public Order(int id, MenuItem... items) {
        this.id = id;
        this.items = List.of(items);
    }

    @Override
    public String toString() {
        return "Order\n{id=" + id + ", items=" + items + "}";
    }

}
