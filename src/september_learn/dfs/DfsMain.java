package september_learn.dfs;

import java.util.*;
import java.util.stream.Collectors;

public class DfsMain {
    public static void main(String[] args) {
        FormDfs f1 = new FormDfs("A","B");
        FormDfs f2 = new FormDfs("B","E");
        FormDfs f3 = new FormDfs("E","D");
        FormDfs f4 = new FormDfs("A","D");
        FormDfs f5 = new FormDfs("D","B");
        FormDfs f6 = new FormDfs("C","E");
        FormDfs f7 = new FormDfs("C","F");
        FormDfs f8 = new FormDfs("F","F");
        List<FormDfs> formDfsList = new ArrayList<>(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8));
        System.out.println(formDfsList);
        calDfs(formDfsList);
    }

    private static void calDfs(List<FormDfs> formDfsList) {
        Map<String,List<String>> dfsAdj = formDfsList.stream()
                .collect(Collectors.groupingBy(FormDfs::getSource,
                        Collectors.mapping(FormDfs::getDestination, Collectors.toList())));
        System.out.println(dfsAdj);
        String source = "A";
        System.out.println(dfsAdj.size());
        List<String> choose = new ArrayList<>();
        calDfs1(choose, dfsAdj, source);
        System.out.println(choose);

    }

    private static void calDfs1(List<String> choose, Map<String, List<String>> dfsAdj, String source) {
        for(String s: dfsAdj.keySet()){
            if(!choose.contains(s)){
                choose.add(s);
                calDfsHelper(choose,dfsAdj,s);
            }
        }
    }


    private static void calDfsHelper(List<String> choose, Map<String, List<String>> dfsAdj, String source) {
        if(dfsAdj.get(source) == null) return;
        for(String v: dfsAdj.get(source)){
            if(!choose.contains(v)){
                choose.add(v);
                calDfsHelper(choose,dfsAdj,v);
            }
        }
    }
}
