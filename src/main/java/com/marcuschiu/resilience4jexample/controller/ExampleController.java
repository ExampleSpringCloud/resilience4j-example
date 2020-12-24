package com.marcuschiu.resilience4jexample.controller;

import com.marcuschiu.resilience4jexample.service.ExampleManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleManualService exampleManualService;

    @GetMapping("/albums")
    public String albums() {
        return exampleManualService.getAlbumList();
    }

}