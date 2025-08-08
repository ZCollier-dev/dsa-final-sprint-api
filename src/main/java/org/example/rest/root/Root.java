package org.example.rest.root;

import org.example.rest.node.Node;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Root {
    @Id
    Long id;

    double value;
    Node left;
    Node right;
}
