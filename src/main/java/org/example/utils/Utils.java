package org.example.utils;

import org.example.common.SolutionInputData;
import org.example.common.TaskTree;
import org.example.common.TaskTreeNode;
import org.example.common.Vertex;
import org.example.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    
    public static String generateDegenerateData(int n) {
        
        Random random = new Random();
        
        // int n = 200000;
        int tpower = 9;
        int target = 0;//random.nextInt((int) Math.pow(10, tpower)) - random.nextInt((int) Math.pow(10, tpower)) + 1;
        int index = 0;
        
        StringBuilder res = new StringBuilder();
        
        res.append(n + " " + target + "\n");
        
        res.append(-1 + " " + genWeight() + "\n");
        
        for (int i = 2; i < n + 1; i++) {
            index = i - 2;
            res.append(index + " " + genWeight() + "\n");
        }
        
        res.deleteCharAt(res.length() - 1);
        
        return res.toString();
    }
    
    public static void generateDataFile() {
        String data = generateDegenerateData(Settings.dataFileListLength);
        try {
            Files.write(Path.of(Settings.filename), data.getBytes());
        } catch (IOException e) {
            System.out.println("ОШИБКА ФАЙЛА");
            throw new RuntimeException(e);
        }
    }
    
    static List <Vertex> generateVertices(int n, int target) {
        List<Vertex> res = new ArrayList <>();
        res.add(new Vertex(genWeight(), - 1));
        for (int i = 0; i < n - 1; i++) {
            res.add(new Vertex(genWeight(), i));
        }
        return  res;
    }
    
    public static List<Vertex> parseIntoVertices(String data) {
        List<Vertex> res = new ArrayList <>();
        
        
        String[] lines = data.split("\n");
        String[] firstLine = lines[0].split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int target = Integer.parseInt(firstLine[1]);
        for (int i = 1; i < lines.length; i++) {
            // if (i % 1000 == 0) { System.out.println("i: " + i); }
            String[] split = lines[i].split("\\s+");
            res.add(
                    new Vertex(Integer.parseInt(split[1]),
                            Integer.parseInt(split[0]))
            );
        }
        return res;
    }
    
    public static SolutionInputData generateSolutionInputData() {
        int n = 10;
        int target = 3;
        List<Vertex> vertices = generateVertices(n, target);
        return new SolutionInputData(vertices, n, target);
    }
    
    public static SolutionInputData readSolutionInputData() {
        String filename = Settings.filename;
        
        String readData = readFile(filename);
        
        var lines = readData.split("\n");
        var n = Integer.parseInt(lines[0].split("\\s+")[0]);
        var target = Integer.parseInt(lines[0].split("\\s+")[1]);
        
        List<Vertex> vertices = parseIntoVertices(readData);
        return new SolutionInputData(vertices, n, target);
    }
    
    public static String readFile(String filename) {
        try {
            byte[] data = Files.readAllBytes(Path.of(filename));
            return new String(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static TaskTree parseForTaskTree(List<Vertex> data, int target) {
        var tree = new TaskTree(target);
        for(var i : data) {
            tree.add(new TaskTreeNode(i.p, i.w));
        }
        return tree;
    }
    
    public static TaskTree parseForTaskTree(String data) {
        String[] lines = data.split("\n");
        String[] firstLine = lines[0].split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int target = Integer.parseInt(firstLine[1]);
        var tree = new TaskTree(target);
        for (int i = 1; i < lines.length; i++) {
            // if (i % 1000 == 0) { System.out.println("i: " + i); }
            String[] split = lines[i].split("\\s+");
            tree.add(
                    new TaskTreeNode(Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]))
            );
        }
        return tree;
    }
    
    public static TaskTree parseFileForTaskTree() {
        String filename = Settings.filename;
        return parseForTaskTree(readFile(filename));
    }
    
    public static String generateData() {
        
        Random random = new Random();
        
        int n = 200000;
        int tpower = 9;
        int target = random.nextInt((int) Math.pow(10, tpower)) - random.nextInt((int) Math.pow(10, tpower)) + 1;
        int index = 0;
        
        StringBuilder res = new StringBuilder();
        
        res.append(n + " " + target + "\n");
        
        res.append(-1 + " " + genWeight() + "\n");
        
        for (int i = 2; i < n + 1; i++) {
            index = random.nextInt(i - 1);
            res.append(index + " " + genWeight() + "\n");
        }
        
        res.deleteCharAt(res.length() - 1);
        
        return res.toString();
    }
    
    static int genWeight() {
        int power = 4;
        Random random = new Random();
        return 0;//random.nextInt((int) Math.pow(10, power)) - random.nextInt((int) Math.pow(10, power)) + 1;
        // return random.nextInt((int) Math.pow(10, 1));
    }
    
    
    public static void timeit (Runnable action, long times) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < times; i++) {
            action.run();
        }
        long end = System.currentTimeMillis();
        // System.out.println("start " +  start);
        // System.out.println("end " +  end);
        System.out.printf("Выполнено за %20.16f мс\n", (end - start) * 1.00 / times);
    }
    
    public static double timeitret (Runnable action, long times) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < times; i++) {
            action.run();
        }
        long end = System.currentTimeMillis();
        // System.out.println("start " +  start);
        // System.out.println("end " +  end);
        double res = (end - start) * 1.00 / times;
        // System.out.printf("Выполнено за %.2f мс\n", (end - start) * 1.00 / times);
        return res;
    }
}
