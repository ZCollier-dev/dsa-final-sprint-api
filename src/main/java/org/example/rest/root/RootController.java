package org.example.rest.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/binary-search-tree")
public class RootController {

    @Autowired
    private RootService rootService;

    @GetMapping
    public List<Root> getAll(){
        return rootService.getAllTrees();
    }

    @PostMapping("/process-numbers")
    public Root processNumbers(@RequestBody List<Double> numbers){
        return rootService.createTreeFromList(numbers);
    }

    @PostMapping("/process-numbers/balance")
    public Root processNumbersBalance(@RequestBody List<Double> numbers){
        return rootService.createBalancedTreeFromList(numbers);
    }
}
