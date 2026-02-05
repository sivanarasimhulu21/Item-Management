
package com.siva.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.siva.demo.model.Item;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @PostMapping("/items")
    public String addItem(@RequestBody Item item) {
        if (item.getName() == null || item.getName().isEmpty()) {
            return "Item name is required";
        }
        items.add(item);
        return "Item added successfully";
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
