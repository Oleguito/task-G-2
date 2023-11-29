package org.example;

import org.example.common.Vertex;
import org.example.utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DudesSolution {
    static int root = 0;

    static List<List<Long>> createReverseTree(List<Vertex> treeOrig) {
        int n = treeOrig.size();
        List<List<Long>> reverseTree = new ArrayList <>(n);
        
        for (int i = 0; i < n; i++) {
            reverseTree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            int parent = (int) treeOrig.get(i).p;

            if (parent < 0) {
                continue;
            }
            reverseTree.get(parent).add((long) i);
        }

        return reverseTree;
    }

    static long traverseTree(List<List <Long>> reverseTree, List<Vertex> treeOrig, long node, long k, long sumSoFar, Map <Long, Long> map) {
        Vertex curVertex = treeOrig.get((int) node);
        sumSoFar += curVertex.w;

        long count = map.getOrDefault(sumSoFar - k, 0L);
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0L) + 1);

        for (long child : reverseTree.get((int) node)) {
            var call = traverseTree(reverseTree, treeOrig, child, k, sumSoFar, map);
            count += call;
        }

        map.put(sumSoFar, map.get(sumSoFar) - 1);

        return count;
    }

    static long getNumberOfUpgoingPaths(List<Vertex> treeOrig, long x) {
        long resVal = 0;

        List<List<Long>> tree = createReverseTree(treeOrig);

        Map<Long, Long> map = new HashMap <>();
        map.put(0L, 1L);

        resVal = traverseTree(tree, treeOrig, root, x, 0, map);

        return resVal;
    }

    public static void main(String[] args) {
        var data = Utils.readFile("data!.txt");
        var target = Integer.parseInt(data.split("\n")[0].split("\\s+")[1]);
        var vertices = Utils.parseIntoVertices(data);
        
        System.out.println(getNumberOfUpgoingPaths(vertices, target));
    }
}
