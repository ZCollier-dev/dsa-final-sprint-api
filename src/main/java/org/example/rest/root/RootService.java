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
        if (numberList.isEmpty() || numberList == null){
            return null;
        }
        int maxHeight = -1;
        int newHeight;
        Node rootNode = new Node();

        for (Double number : numberList) {
            newHeight = rootNode.addNode(number);
            if (maxHeight < newHeight){
                maxHeight = newHeight;
            }
        }

        return rootRepo.save(new Root(rootNode, maxHeight, numberList));
    }

    // Creates a new tree from a list of numbers - Balanced Tree, AVL
    public Root createBalancedTreeFromList(List<Double> numberList){
        if (numberList.isEmpty() || numberList == null){
            return null;
        }
        int maxHeight = -1;
        Node rootNode = new Node();

        for (Double number : numberList) {
            rootNode = rootNode.addNodeBalance(number);
            if (maxHeight < rootNode.getHeight()){
                maxHeight = rootNode.getHeight();
            }
        }

        return rootRepo.save(new Root(rootNode, maxHeight, numberList));
    }
}
