package org.example.rest.root;

import org.example.rest.node.Node;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Root {
    @Id
    private Long id;

    private short height = 0;
    private Node rootNode = new Node();

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public short getHeight(){
        return height;
    }
    public void setHeight(short height){
        this.height = height;
    }

    public Node getRootNode(){
        return rootNode;
    }
    public void setRootNode(Node rootNode){
        this.rootNode = rootNode;
    }
}
