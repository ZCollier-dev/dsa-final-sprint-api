package org.example.rest.root;

import org.bson.types.ObjectId;
import org.example.rest.node.Node;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Root {
    @Id
    private String id;

    @Field("treeHeight")
    private int treeHeight;

    @Field("inputNumbers")
    private List<Double> inputNumbers;

    @Field("rootNode")
    private Node rootNode;

    public Root(Node rootNode, int treeHeight, List<Double> inputNumbers){
        this.rootNode = rootNode;
        this.treeHeight = treeHeight;
        this.inputNumbers = inputNumbers;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getTreeHeight(){
        return treeHeight;
    }
    public void setTreeHeight(int treeHeight){
        this.treeHeight = treeHeight;
    }

    public List<Double> getInputNumbers(){
        return inputNumbers;
    }
    public void setInputNumbers(List<Double> inputNumbers){
        this.inputNumbers = inputNumbers;
    }

    public Node getRootNode(){
        return rootNode;
    }
    public void setRootNode(Node rootNode){
        this.rootNode = rootNode;
    }
}
