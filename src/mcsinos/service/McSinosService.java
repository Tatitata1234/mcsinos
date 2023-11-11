package mcsinos.service;

import mcsinos.entity.Order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class McSinosService {

    private Queue<Order> orders = new ArrayDeque<>();
    
    public void order(Order order) {
        orders.add(order);
    }

    public String showOrderQueue() {
        return Arrays.toString(orders.toArray());
    }

    public Order delivery() {
        return orders.poll();
    }

    public int getNextId(){
        return orders.size() + 1;
    }

}
