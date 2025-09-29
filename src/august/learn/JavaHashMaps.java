package august.learn;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class JavaHashMaps {
    public static void main(String[] args) {
//        hashmapp();
        shoppingMap();
//        complexScenario();
    }

    private static void complexScenario() {
        /* 1. You have a list of orders (with Customer ID, product ID, and date).
        Detect and count how many times each customer re-ordered the same product on different days.
        */

        List<Products> products = List.of(new Products("1","1", LocalDate.of(2025,01,10)),
                new Products("2","1", LocalDate.of(2025,06,10)),
                new Products("1","1", LocalDate.of(2025,02,10)),
                new Products("3","2", LocalDate.of(2025,03,10)),
                new Products("4","4", LocalDate.of(2025,04,10)),
                new Products("3","2", LocalDate.of(2025,05,10)));

        Map<String, Map<String,Set<LocalDate>>> countSameProductsDiffDate = new HashMap<>();

        products.forEach(p-> countSameProductsDiffDate.computeIfAbsent(p.getCustomerId(), pr -> new HashMap<>())
                .computeIfAbsent(p.getProductId(), or-> new HashSet<>())
                .add(p.getOrderDate()));


        countSameProductsDiffDate.entrySet().forEach((k)-> {
                 long count =   k.getValue()
                                .values()
                                .stream()
                                .filter(pr -> pr.size() > 1)
                                .count();
                 if(count > 0){
                     System.out.println("customer Id : "+ k.getKey() + " ---> count " + count);
                 }
                });
        System.out.println(countSameProductsDiffDate);


        /*
            2. You have two inventories (Map<ProductId, Quantity>). You want to:
                Merge the inventories
                If a product is in both, keep the max quantity
         */
        Map<String, Integer> warehouseA = Map.of("p1", 50, "p2", 40, "p3", 30);
        Map<String, Integer> warehouseB = Map.of("p2", 60, "p3", 25, "p4", 80);

        Map<String, Integer> mergeWarehouses = new HashMap<>(warehouseA);
        warehouseB.forEach((product, quantity) ->
            mergeWarehouses.merge(product, quantity, (o,n) -> o+n)
        );

        System.out.println(mergeWarehouses);

        /*
         3. You receive logs with user sessions (userId, timestamp, pageVisited). Build a structure to:
            Aggregate page visits per session ID
            Track order of visits (use LinkedHashSet for order preservation)
         */
        List<ClickEvent> clickEvents = new ArrayList<>();
        Map<String, List<ClickEvent>>  map= clickEvents.stream().collect(Collectors.groupingBy(ClickEvent::getSessionId));
        System.out.println(map);

        /*
            4. Transaction Fee Aggregator per Account with Dynamic Fee Rule
                Problem:
                You have a list of transactions. Each account has variable fees depending on transaction type:
                For each account, sum total fees by type
         */
        List<Transaction> transactions = Arrays.asList(
                new Transaction("acc1", "TRANSFER", 5.0),
                new Transaction("acc1", "WITHDRAWAL", 2.0),
                new Transaction("acc1", "TRANSFER", 3.0),
                new Transaction("acc2", "TRANSFER", 4.0),
                new Transaction("acc2", "WITHDRAWAL", 1.0),
                new Transaction("acc2", "TRANSFER", 2.5),
                new Transaction("acc3", "WITHDRAWAL", 7.0),
                new Transaction("acc3", "WITHDRAWAL", 3.0)
        );

        Map<String, Map<String, Double>> transactionByType = new HashMap<>();

        transactions.parallelStream().forEach( transaction -> transactionByType.computeIfAbsent(transaction.getAccountId(), type -> new HashMap<>())
                .merge(transaction.getType(), transaction.getFee(), Double::sum));
        System.out.println(transactionByType);


        Map<String, Map<String, Double>> transactionByTypes  = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getAccountId,
                        Collectors.groupingBy(Transaction::getType,
                                Collectors.summingDouble(Transaction::getFee))));
        System.out.println(transactionByTypes);


    }

    private static void shoppingMap() {
        List<Order> orders = List.of(
                new Order("Alice", "Laptop", 1200),
                new Order("Bob", "Phone", 600),
                new Order("Alice", "Mouse", 50),
                new Order("Charlie", "Phone", 500),
                new Order("Alice", "Laptop", 800),
                new Order("Bob", "Charger", 30),
                new Order("Charlie", "Mouse", 80),
                    new Order("Graham", "Charger", 90)
        );

        Map<String, Integer> map = new HashMap<>();
        map.merge("x", 1, (oldVal, newVal) -> oldVal + newVal);
        System.out.println(map.get("x"));

        //1. Total spending per customer
        /*
            No need to check if key exists.
            Automatically sums values if present.
         */

        Map<String, Integer> totalSpendingPerCustomer = new HashMap<>();
        orders.forEach(o -> totalSpendingPerCustomer
                .merge(o.getCustomer(), o.getAmount(), (oldValue,newValue)-> oldValue + newValue));
        System.out.println("totalSpendingPerCustomer  using normal map + merge? " +totalSpendingPerCustomer);

        //2. Product bought per customer.

        Map<String, Integer> totalSpendingPerCustomer1 = orders
                .stream()
                .collect(Collectors.toMap(o -> o.getCustomer(), o -> o.getAmount(), (ol,n) -> ol+n));
        System.out.println("totalSpendingPerCustomer using collect + toMap + merge? " + totalSpendingPerCustomer1);

        streamsFeatures(orders);


    }

    private static void streamsFeatures(List<Order> orders) {

        /*
           1. Group total sales (sum of amount) by product.
         */

        Map<String, Double>  totalSalesByproduct = orders.stream().collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getAmount)));
        System.out.println(totalSalesByproduct);

        /*
            2. From the same Product list above, find the most expensive product per category.
         */

        Map<String, Optional<Order>>  totalSalesByproducts =  orders
                .stream()
                .collect(
                        Collectors.groupingBy(Order::getProduct,
                                Collectors.maxBy(Comparator.comparing(Order::getAmount) )));
        totalSalesByproducts.entrySet().stream().forEach((k) -> System.out.println( k.getValue().get()) );
    }

    private static void hashmapp() {
        Map<String,String> map = new HashMap<>();
        map.put("a","apple");
        map.put("b", "banana");
        map.put("c", "cat");
        //returns the value if key is present, else returns the default.
        System.out.println(map.getOrDefault("c","canada"));
        //putIfAbsent(key, value)
        System.out.println(map.putIfAbsent("d","dog"));
        System.out.println(map.putIfAbsent("d","dragon"));

        //avoids manual null checks, merges insertion and updates logic.
        map.compute("c", (k,v) -> v.equals("cat")? v+" walks": v+ " is beautiful");

        //Avoids containsKey + put, and ensures atomicity in concurrent maps.'
        String newKey = "e";
        map.computeIfAbsent(newKey, v ->  "elephant" );

        //update values if the key is already present.
        map.computeIfPresent(newKey, (k,v) -> "majestic elephant");
        System.out.println(map);

    }
}

