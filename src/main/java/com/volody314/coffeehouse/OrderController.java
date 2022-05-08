package com.volody314.coffeehouse;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {
    private final Orders orders = new OrdersImpl();
}
