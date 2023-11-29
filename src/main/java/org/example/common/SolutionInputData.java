package org.example.common;

import java.util.List;

public class SolutionInputData {
    public List <Vertex> vertices;
    public int n;
    public int target;
    
    public SolutionInputData(List <Vertex> vertices, int n, int target) {
        this.vertices = vertices;
        this.n = n;
        this.target = target;
    }
}
