package com.volody314.coffeehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final Orders orders; // = new OrdersImpl();

    @Autowired
    public OrderController(Orders orders) {
        this.orders = orders;
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<Integer> create() {
        System.out.println(" *** Creating *** ");
        return new ResponseEntity<>(orders.create(), HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<List<Item>> read(@PathVariable(name = "id") Integer id) {
        System.out.println(" *** Get-ting *** " + id);
        final List<Item> items = orders.read(id);
        System.out.println(" *** Get-ting *** " + items.get(0).name + " " + items.get(0).prise + " " + items.get(0).count);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<Integer> putItem(@PathVariable(name = "id") Integer id, @RequestBody Item item) {
        System.out.println(" *** Put-ting *** " + item.name + " " + item.prise + " " + item.count);
        //orders.putItem(id, item);
        return new ResponseEntity<>(orders.putItem(id, item), HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/{ordId}/items/{itId}")
    public ResponseEntity<List<Item>> delete(@PathVariable(name = "ordId") Integer orderId,
                                                  @PathVariable(name = "itId") Integer itemId) {
        return new ResponseEntity<>(orders.deleteItem(orderId, itemId), HttpStatus.OK);
    }
    // void deleteItem(Integer orderId, String itemName);
}
