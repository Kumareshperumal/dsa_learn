package java8features.streamsconcepts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Trader> traderList = new ArrayList<>();
        traderList.add(new Trader("California", "90A"));
        traderList.add(new Trader("Chicago", "80B"));
        traderList.add(new Trader("Maldives", "90D"));
        traderList.add(new Trader("Guava", "91H"));
        traderList.add(new Trader("Temple", "91A"));
        traderList.add(new Trader("Brazil", "92G"));
        traderList.add(new Trader("Chile", "80HA"));
        traderList.add(new Trader("Rwanda", "81A"));

       Map<String,String> data =  traderList.stream().collect(Collectors.groupingBy(d-> d.getCity().substring(0,2),
                LinkedHashMap::new,
                Collectors.mapping(Trader::getName, Collectors.joining("-"))));
        System.out.println("data ? " + data);
    }
}
