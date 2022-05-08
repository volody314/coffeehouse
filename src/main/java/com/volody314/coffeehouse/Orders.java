package com.volody314.coffeehouse;

import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;

/**
 * Список заказов
 */
public interface Orders {
    /**
     * Создаёт заказ
     * @return Номер заказа
     */
    Integer create();

    /**
     * Возвращает список позиций в заказе
     * @param orderId Номер заказа
     * @return Список позиций в заказе
     */
    List<Item> read(Integer orderId);

    /**
     * Добавляет позицию заказа
     * @param item Описание позиции
     * @return Номер позиции в заказе
     */
    Integer putItem(Integer orderId, Item item);

    /**
     * Удаляет позицию из заказа
     * @param orderId Номер заказа
     * @param itemId Позиция
     */
    List<Item> deleteItem(Integer orderId, Integer itemId);

    /**
     * Отправляет заказ в производство
     * @param orderId Номер заказа
     */
    void produceOrder(Integer orderId);
}
