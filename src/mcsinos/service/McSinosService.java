package mcsinos.service;

import mcsinos.entity.Order;
import mcsinos.enumerator.MenuItem;

import java.util.StringJoiner;

import java.util.*;

public class McSinosService {

    private final Queue<Order> orders = new ArrayDeque<>();
    private int nextId = 0;

    public void order(Order order) {
        orders.add(order);
    }

    public void order(List<MenuItem> items) {
        orders.add(new Order(getNextId(), items));
    }

    public String showOrderQueue() {
        StringJoiner sj = new StringJoiner("\n");
        for (Order order : orders) {
            sj.add(order.toString());
        }
        return sj.toString();
    }

    public Order delivery() {
        return orders.poll();
    }

    public int getNextId(){
        this.nextId += 1;
        return nextId;
    }

}
