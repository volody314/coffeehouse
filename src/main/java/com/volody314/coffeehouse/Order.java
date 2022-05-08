package com.volody314.coffeehouse;

import java.util.ArrayList;

/**
 * Заказ
 */
public class Order {
    private Integer id; // Идентификатор заказа
    //private Float overralSum = 0.0;  // Сумма чека
    private Integer posCounter = 0; // Счётчик позиций
    private ArrayList<Item> items = new ArrayList<>();  // Позиции заказа


    public Order(Integer id_) {
        this.id = id_;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Возвращает список позиций в заказе
     * @return Список позиций
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Добавляет позицию в заказ
     * @param item Описание позиции
     * @return Номер позиции в заказе
     */
    public Integer addItem(Item item) {
        //this.overralSum += item.prise * item.count;
        this.items.add(item);
        return posCounter++;
    }

    public ArrayList<Item> deleteItem(Integer toDel) {
        if (toDel < this.items.size()) {
            //overralSum -= this.items.get(toDel).prise * this.items.get(toDel).count;
            this.items.remove(toDel);
            posCounter--;
        }
        return this.items;
    }
}
