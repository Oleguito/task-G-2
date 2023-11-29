package org.example.common;

import java.util.ArrayList;
import java.util.List;

public class TaskTreeNode {
    TaskTreeNode parent;
    List <TaskTreeNode> children;
    int parentIndex;
    int index;
    int weight;
    int tier = -1;
    int pathWeight;
    boolean visited;
    int pathWeightToThisNode;
    
    public TaskTreeNode(int parentIndex, int weight) {
        this.weight = weight;
        this.parentIndex = parentIndex;
        children = new ArrayList <>();
        pathWeight = 0;
        visited = false;
        pathWeightToThisNode = 0;
    }
}
