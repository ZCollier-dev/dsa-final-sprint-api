package org.example.rest.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/binary-search-tree")
public class RootController {

    @Autowired
    private RootService rootService;
}
