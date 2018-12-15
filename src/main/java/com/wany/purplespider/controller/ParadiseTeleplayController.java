package com.wany.purplespider.controller;

import com.wany.purplespider.processor.ParadiseTeleplayProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ParadiseTeleplay")
public class ParadiseTeleplayController {

    @Autowired
    private ParadiseTeleplayProcessor processor;

    @GetMapping("/capture")
    public Object capture() {
        processor.capture();
        return "success";
    }

    @GetMapping("/capture/{path}")
    public Object capture(@PathVariable String path) {
        processor.capture(path);
        return "success";
    }
}
