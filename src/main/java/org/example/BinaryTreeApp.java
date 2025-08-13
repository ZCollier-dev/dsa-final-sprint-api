package org.example;

/* Develop a Spring Boot application that allows users to
create a binary search tree from a series of numbers,
visualize the resulting tree,
and view previous tree results.

UI:
Display HTML page using route /enter-numbers
This page should contain:
    ▪ An input field for users to enter a series of numbers.
    ▪ A 'Submit' button to send numbers for processing.
    ▪ A 'Show Previous' button to view earlier trees stored in the database.
Process numbers using route /process-numbers
This route should:
    ▪ Accept the list of numbers from the user input
    ▪ Construct a binary search tree by inserting the numbers sequentially
    ▪ Returns the tree as a JSON representation
    ▪ Stores both the input numbers and resulting tree structure in a database of your choice
Display previous trees using route /previous-trees
This route should:
    ▪ Retrieve and display the input numbers from the database
    ▪ Retrieve their corresponding tree structures from the database
Include at least three unit tests for your application.
Store all input numbers and their resulting tree structures in a database of your choice.
Return a balanced binary search tree to the user (optional)

DATABASE USED: MongoDB (because that seems easiest to store trees in)
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinaryTreeApp {
    public static void main(String[] args) {
        SpringApplication.run(BinaryTreeApp.class, args);
    }
}