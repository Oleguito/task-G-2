package org.example.common;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;

public class TaskTree {
    public TaskTreeNode root;
    int numNodes = 0;
    int result = 0;
    char[][] screen;
    HashMap <Integer, List <TaskTreeNode>> map;
    HashMap <Integer, TaskTreeNode> toFindNodesMap;
    HashMap<Node, Integer> resultMap;
    public int solutionResult;
    int solutionTarget;
    // int sum;
    
    public TaskTree(int target) {
        // this.screen = new char[10][178];
        // map = new HashMap <Integer, List<TaskTreeNode>>(20);
        toFindNodesMap = new HashMap <>();
        resultMap = new HashMap <>();
        solutionResult = 0;
        solutionTarget = target;
        // sum = 0;
    }
    
    public void add(TaskTreeNode taskTreeNode) {
        if(taskTreeNode.parentIndex == -1) {
            root = taskTreeNode;
            root.index = numNodes++;
            toFindNodesMap.put(root.index, taskTreeNode);
            return;
        }
        
        taskTreeNode.index = numNodes++;
        TaskTreeNode padre = toFindNodesMap.get(taskTreeNode.parentIndex);
        taskTreeNode.parentIndex = padre.index;
        taskTreeNode.parent = padre;
        padre.children.add(taskTreeNode);
        toFindNodesMap.put(taskTreeNode.index, taskTreeNode);
    }

    public void printRecursiveTree() {
        _printRecursiveTree(root, 0);
    }
    
    private void _printRecursiveTree(TaskTreeNode taskTreeNode, int tabs) {
        if(taskTreeNode == null) return;
        
        if(tabs == 0) {
            System.out.printf("%d[%d]\n", taskTreeNode.index, taskTreeNode.weight);
        } else {
            System.out.printf("%s%d[%d]\n", toStr(tabs), taskTreeNode.index, taskTreeNode.weight);
        }
        
        for(var i : taskTreeNode.children) {
            _printRecursiveTree(i, tabs + 1);
        }
    }
    
    private String toStr(int tabSize) {
        final int width = 10;
        StringBuilder sb = new StringBuilder();
        // sb.append("│");
        if(tabSize == 1) {
            sb.append("├");
            for (int i = 1; i < tabSize * width; i++) {
                sb.append("─");
            }
            return sb.toString();
        } else {
            int pos = 0;
            while(pos < (tabSize - 1) * width + 1) { sb.append(" "); ++pos; }
            sb.append("└");
            while(pos < tabSize * width) { sb.append("─"); ++pos; }
            return sb.toString();
        }
    }
    
    public void traverseSolution() {
        _traverseSolution(root);
    }
    
    private void _traverseSolution2(TaskTreeNode node, int sum) {
        if(node == null) return;
        
        var val = node.weight;
        
        for(var i : node.children) {
            _traverseSolution2(i, sum + node.weight);
        }
        
        
        
    }
    
    public void emptyTraverse(TaskTreeNode node) {
        if(node == null) return;
        
        
        
        for(var i : node.children) {
            emptyTraverse(i);
        }
    }
    
    private void _traverseSolution(TaskTreeNode taskTreeNode) {
        if(taskTreeNode == null) return;
        
        calcPathWeight(taskTreeNode);
        
        for(var i : taskTreeNode.children) {
            _traverseSolution(i);
        }
    }
    
    private void calcPathWeight(TaskTreeNode taskTreeNode) {
        if(taskTreeNode.visited) return;
 
        int res = 0;
        
        TaskTreeNode cur = taskTreeNode;
        while(cur != null) {
            res += cur.weight;
            if(res == solutionTarget) {
                solutionResult++;
                // System.out.printf("%d\n", taskTreeNode.index);
                // taskTreeNode.visited = true;
            }
            cur = cur.parent;
        }

        
    }
}
