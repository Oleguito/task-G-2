package org.example;

import org.example.common.TaskTree;
import org.example.common.TaskTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySolutionTree {
    public static void main(String[] args) {
        int target = 3;
        TaskTree tree = new TaskTree(target);
        tree.traverseSolution();
    }
}



