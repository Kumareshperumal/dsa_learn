package graph;

import java8features.graph.BFSpath;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    public static void main(String[] args) {
        List<FormGraph> formGraphs = new ArrayList<>();
        formGraphs.add(new FormGraph("A", "B"));
        formGraphs.add(new FormGraph("A", "D"));
        formGraphs.add(new FormGraph("B", "E"));
        formGraphs.add(new FormGraph("B", "C"));
        formGraphs.add(new FormGraph("C", "F"));
        formGraphs.add(new FormGraph("D", "E"));
        formGraphs.add(new FormGraph("E", "C"));
        formGraphs.add(new FormGraph("E", "F"));
        Map<String,List<String>> graph = new HashMap<>();
        graph = formGraph(formGraphs,graph);
        System.out.println(graph);
        bfsPattern(graph);
    }

    private static void bfsPattern(Map<String, List<String>> graph) {
        String source = "B", destination = "F";
        Queue<BFSpath> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        BFSpath bfSpath = new BFSpath();
        bfSpath.setKey(source);
        bfSpath.setValues(source);
        queue.add(bfSpath);

        while(!queue.isEmpty()){
            BFSpath data = queue.poll();
            if(data.getKey().equalsIgnoreCase(destination)){
                System.out.println(data);
                return;
            }
            isVisited.add(data.getKey());
            if(graph.containsKey(data.getKey())){
                for(String neighbour: graph.get(data.getKey())){
                   if(!isVisited.contains(neighbour)){
                       BFSpath newPath = new BFSpath();
                       newPath.setKey(neighbour);
                       newPath.values = new ArrayList<>(data.getValues());
                       newPath.setValues(neighbour);
                       queue.add(newPath);
                   }
                }
            }
        }
    }

        private static Map formGraph(List<FormGraph> formGraphs, Map<String,List<String>> graph) {
//        for(int i =0;i<formGraphs.size();i++){
//            if(!graph.containsKey(formGraphs.get(i).getSource())){
//                graph.put(formGraphs.get(i).getSource(), new ArrayList<>());
//            }
//            graph.get(formGraphs.get(i).getSource()).add(formGraphs.get(i).getDestination());
//        }

        return formGraphs.stream().collect(Collectors.groupingBy(FormGraph::getSource,
                Collectors.mapping(FormGraph::getDestination, Collectors.toList())));

//            System.out.println(graph);

    }
}
