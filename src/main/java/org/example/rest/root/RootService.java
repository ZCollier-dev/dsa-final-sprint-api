package org.example.rest.root;

import org.example.rest.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootService {

    @Autowired
    private RootRepo rootRepo;

    // Get all trees in database
    public List<Root> getAllTrees(){
        return rootRepo.findAll();
    }

    // Creates a new tree from a list of numbers - Basic BST
    public Root createTreeFromList(List<Double> numberList){
        if (numberList.isEmpty()){
            return null;
        }
        int listLength = numberList.size();
        int listMiddle = listLength / 2;
        int maxHeight = 0;
        int newHeight;
        Node rootNode = new Node();
        rootNode.setValue(numberList.get(listMiddle - 1));

        for (int i = 0; i < listMiddle; i++) {
            newHeight = rootNode.addNode(numberList.get(i));
            if (maxHeight < newHeight){
                maxHeight = newHeight;
            }
        }

        return rootRepo.save(new Root(rootNode, maxHeight));
    }

    // Creates a new tree from a list of numbers - Balanced Tree, AVL
    public Root createBalancedTreeFromList(List<Double> numberList){
        if (numberList.isEmpty()){
            return null;
        }
        int listLength = numberList.size();
        int listMiddle = listLength / 2;
        int maxHeight = 0;
        int newHeight;
        Node rootNode = new Node();
        rootNode.setValue(numberList.get(listMiddle - 1));

        for (int i = 0; i < listMiddle; i++) {
            newHeight = rootNode.addNodeBalance(numberList.get(i));
            if (maxHeight < newHeight){
                maxHeight = newHeight;
            }
        }

        return rootRepo.save(new Root(rootNode, maxHeight));
    }
}
