package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private String currentCounter;
    private Map<String, Integer> counters;

    public CounterController() {
        this.currentCounter = "default counter";
        this.counters = new HashMap<>();
        this.counters.put(currentCounter, 0);
    }

    @GetMapping("/custom/{name}")
    public String changeToCustomCounter(@PathVariable String counter) {
        return "";
    }

    @GetMapping("/increment")
    public String increment() {
        this.counters.put(currentCounter, this.counters.get(currentCounter) + 1);
        return String.valueOf(this.counters.get(currentCounter));
    }

    @GetMapping("/decrement")
    public String decrement() {
        this.counters.put(currentCounter, this.counters.get(currentCounter) - 1);
        return String.valueOf(this.counters.get(currentCounter));
    }

    @GetMapping
    public String getValue() {
        return String.valueOf(this.counters.get(currentCounter));
    }
}
