package org.example;

import org.example.common.Vertex;
import org.example.utils.Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // test();
        
        Utils.timeit(() -> {
            String data = Utils.generateDegenerateData(30000);
            List <Vertex> vertices = Utils.parseIntoVertices(data);
            int target = 0;
            MySolutionMap.getNumberOfUpgoingPaths(vertices, 0);
        }, 1);
        
        
        
        // Utils.generateDataFile();
        // var tree = Utils.parseFileForTaskTree();
        // tree.printRecursiveTree();
        // tree.traverseSolution();
        // Utils.timeit(() -> {tree.traverseSolution();}, 1);
        // Utils.timeit(() -> {tree.emptyTraverse(tree.root);}, 1);
        // int mySolutionTreeResult = tree.solutionResult;
        // System.out.println("mySolutionTreeResult: " + mySolutionTreeResult);
        
        // Utils.generateDataFile();
        
        // var sid = Utils.readSolutionInputData();
        
        // var mySolutionArrayResult = MySolutionArray.getNumberOfUpgoingPaths(sid.vertices, sid.target);
        // var mySolutionMapResult = MySolutionMap.getNumberOfUpgoingPaths(sid.vertices, sid.target);

        // var time1 = Utils.timeitret(() -> {MySolutionArray.getNumberOfUpgoingPaths(sid.vertices, sid.target);}, 200);
        // var time2 = Utils.timeitret(() -> {MySolutionMap.getNumberOfUpgoingPaths(sid.vertices, sid.target);}, 200);
        //
        // System.out.printf("%20.16f\n", time1);
        // System.out.printf("%20.16f\n", time2);
        
        // var dudesSolutionResult = DudesSolution.getNumberOfUpgoingPaths(sid.vertices, sid.target);
        
        // Utils.timeitret(() -> {DudesSolution.getNumberOfUpgoingPaths(sid.vertices, sid.target);}, 1);
        
        // System.out.println("n: " + sid.n);
        // System.out.println("target: " + sid.target);
        // System.out.println("mySolutionTreeResult: " + mySolutionTreeResult);
        // System.out.println("mySolutionMapResult: " + mySolutionMapResult);
        // System.out.println("dudesSolutionResult: " + dudesSolutionResult);
    }
    
    private static void test() {
        for (int i = 0; i < 1; i++) {
            
            if (i % 20 == 0 && i != 0) { System.out.println(""); }
            System.out.println(i + " ");
            
            // Utils.generateDataFile();
        
            var tree = Utils.parseFileForTaskTree();
            tree.traverseSolution();
            var time1 = Utils.timeitret(() -> {tree.traverseSolution();}, 1);
            int mySolutionTreeResult = tree.solutionResult;
    
            var sid = Utils.readSolutionInputData();
    
            var mySolutionMapResult = MySolutionMap.getNumberOfUpgoingPaths(sid.vertices, sid.target);
            var time2 = Utils.timeitret(() -> {MySolutionMap.getNumberOfUpgoingPaths(sid.vertices, sid.target);}, 1);
    
            var dudesSolutionResult = DudesSolution.getNumberOfUpgoingPaths(sid.vertices, sid.target);
            var time3 = Utils.timeitret(() -> {DudesSolution.getNumberOfUpgoingPaths(sid.vertices, sid.target);}, 1);
            
            System.out.println("");
            
            // if(mySolutionMapResult == dudesSolutionResult) {
            //     continue;
            // }
            
            
            System.out.println("mySolutionTreeResult: " + mySolutionTreeResult + "(" + time1 + " ms)");
            System.out.println("mySolutionMapResult: " + mySolutionMapResult + "(" + time2 + " ms)");
            System.out.println("dudesSolutionResult: " + dudesSolutionResult + "(" + time3 + " ms)");
            // throw new RuntimeException("Наконец-то!!!");
        }
    }
}