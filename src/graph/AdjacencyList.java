package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    static Map<Integer,List<Integer>> graph = new HashMap<>();
    public static void main(String[] args) {

        addEdge(1,2,true);
        addEdge(1,3, true);
        addEdge(2,4,true);
        System.out.println(graph);
    }
    static void addEdge(int a, int b, boolean undir){

        List<Integer> graphNodes = new LinkedList<>();
        graph.computeIfPresent(a,(k,v)-> {
            v.add(b);
            return v;
        });
//        graph.computeIfAbsent(a,(k,v) -> v.add(b));
    }


}
