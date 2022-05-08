package com.volody314.coffeehouse;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Реализация списка заказов
 */
@Service
public class OrdersImpl implements Orders {

    // Хранилище заказов
    private static final Map<Integer, Order> ORDER_REPOSITORY_MAP = new HashMap<>();

    // Генератор ID заказа
    private static final AtomicInteger ORDER_ID_HOLDER = new AtomicInteger();

    @Override
    public Integer create() {
        final int orderId = ORDER_ID_HOLDER.incrementAndGet();
        Order order = new Order(orderId);
        ORDER_REPOSITORY_MAP.put(orderId, order);
        return orderId;
    }

    @Override
    public List<Item> read(Integer orderId) {
        return ORDER_REPOSITORY_MAP.get(orderId).getItems();
    }

    @Override
    public Integer putItem(Integer orderId, Item item) {
        return ORDER_REPOSITORY_MAP.get(orderId).addItem(item);
    }

    @Override
    public List<Item> deleteItem(Integer orderId, Integer itemId) {
        return ORDER_REPOSITORY_MAP.get(orderId).deleteItem(itemId);
    }

    @Override
    public void produceOrder(Integer orderId) {

    }
}
