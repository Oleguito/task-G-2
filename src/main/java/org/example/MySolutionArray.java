package org.example;

import org.example.common.Vertex;

import java.util.List;

public class MySolutionArray {
    public static int getNumberOfUpgoingPaths(List <Vertex> vertices, int target) {
        
        int n = vertices.size();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = vertices.get(i).p;
            array[i][1] = vertices.get(i).w;
        }
        
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int curIndex = i;
            int sum = 0;
            do {
                sum += array[curIndex][1];
                if(sum == target) {
                    res++;
                }
                if(array[curIndex][0] < 0) break;
                curIndex = array[curIndex][0];
            } while(true);
        }
       
        return res;
    }
}
