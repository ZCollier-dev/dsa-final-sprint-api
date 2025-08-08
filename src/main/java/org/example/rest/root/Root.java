package org.example.rest.root;

import org.example.rest.node.Node;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Root {
    @Id
    private Long id;
    private int treeHeight;

    private Node rootNode;

    public Root(Node rootNode, int treeHeight){
        this.rootNode = rootNode;
        this.treeHeight = treeHeight;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public int getTreeHeight(){
        return treeHeight;
    }
    public void setHeight(int treeHeight){
        this.treeHeight = treeHeight;
    }

    public Node getRootNode(){
        return rootNode;
    }
    public void setRootNode(Node rootNode){
        this.rootNode = rootNode;
    }
}
