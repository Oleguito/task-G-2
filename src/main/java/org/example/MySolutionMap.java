package org.example;

import org.example.common.Vertex;

import java.util.List;

public class MySolutionMap {
    
    public static int getNumberOfUpgoingPaths(List <Vertex> vertices, int target) {
        
        int res = 0;
        
        for (int i = 0; i < vertices.size(); i++) {
            var cur = vertices.get(i);
            var sum = 0;
            do {
                sum += cur.w;
                if(sum == target) {
                    res++;
                }
                if(cur.p < 0) break;
                cur = vertices.get(cur.p);
            } while(true);
        }
        
        
        return res;
    }
}
