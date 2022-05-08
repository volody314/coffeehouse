package com.volody314.coffeehouse;

import java.util.ArrayList;

/**
 * Заказ
 */
public class Order {
    private final Integer id; // Идентификатор заказа
    //private Float overralSum = 0.0;  // Сумма чека
    private Integer posCounter = 0; // Счётчик позиций
    private final ArrayList<Item> items = new ArrayList<>();  // Позиции заказа


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
        itemsRenumerate();
        return posCounter++;
    }

    public ArrayList<Item> deleteItem(int toDel) {
        if (toDel < this.items.size()) {
            //overralSum -= this.items.get(toDel).prise * this.items.get(toDel).count;
            //System.out.println("Deleting item "+toDel);
            this.items.remove(toDel);
            posCounter--;
            itemsRenumerate();
        }
        return this.items;
    }

    /**
     * Проставляет актуальные номера позиций в заказе, необходимые для выдачи клиенту,
     * чтоб указать номер удаляемой позиции
     */
    private void itemsRenumerate() {
        for (int i = 0; i < items.size(); ++i) {
            items.get(i).setId(i);
        }
    }
}
