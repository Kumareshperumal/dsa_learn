package java8features.graph;

import java.util.*;

public class BFSLearning {
    public static void main(String[] args) {
        String source = "A", destination = "F";
        boolean result = bfs1(source,destination);
        System.out.println("result ? " + result);
    }

    private static boolean bfs(String source, String destination) {
        List<Node> edges = new ArrayList<>();
        edges.add(new Node("A","B"));
        edges.add(new Node("A","D"));
        edges.add(new Node("B","E"));
        edges.add(new Node("B","C"));
        edges.add(new Node("D","E"));
        edges.add(new Node("E","C"));
        edges.add(new Node("E","F"));
        edges.add(new Node("C","F"));
        Map<String, List> graph = buildGraph(edges);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(source);
        while(!queue.isEmpty()){
            String node = queue.poll();
            System.out.println("node ? " + node);
            if(node.equalsIgnoreCase(destination)) return true;
            visited.add(node);
            List<String> neighbours = graph.get(node);
            if(neighbours != null){
                for(String n: neighbours){
                    if(!visited.contains(n))
                        queue.add(n);
                }
            }
        }
        return false;
    }



    private static Map buildGraph(List<Node> edges) {
        Map<String, List> graph = new HashMap<>();
        for(Node node : edges){
            if(!graph.containsKey(node.source)){
                graph.put(node.source, new ArrayList());
            }
            graph.get(node.source).add(node.destination);
        }
        System.out.println("Graph ? " + graph);
        return graph;
    }

    private static boolean bfs1(String source, String destination) {
        List<Node> edges = new ArrayList<>();
        edges.add(new Node("A","B"));
        edges.add(new Node("A","D"));
        edges.add(new Node("B","E"));
        edges.add(new Node("B","C"));
        edges.add(new Node("D","E"));
        edges.add(new Node("E","C"));
        edges.add(new Node("E","F"));
        edges.add(new Node("C","F"));
        Map<String, List> graph = buildGraph(edges);

        Queue<BFSpath> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        BFSpath bfSpath = new BFSpath();
        bfSpath.setKey(source);
        bfSpath.setValues(source);
        queue.add(bfSpath);
        while(!queue.isEmpty()){
            BFSpath node = queue.poll();
            System.out.println("node ? " + node);
            if(node.getKey().equalsIgnoreCase(destination)) {
                System.out.println("Path ? : " + node.values);
                return true;
            }
            visited.add(node.getKey());
            List<String> neighbours = graph.get(node.getKey());
            if(neighbours != null){
                for(String n: neighbours){
                    if(!visited.contains(n)) {
                        BFSpath newNode = new BFSpath();
                        newNode.setKey(n);
                        newNode.values = new ArrayList<>(node.values);
                        newNode.setValues(n);
                        queue.add(newNode);

                    }
                }
            }
        }
        return false;
    }
}
