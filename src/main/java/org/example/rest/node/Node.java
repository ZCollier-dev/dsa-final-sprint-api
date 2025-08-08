package org.example.rest.node;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Node {
    double value;
    Node left;
    Node right;
}
