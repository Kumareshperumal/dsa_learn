package java8features.streamsconcepts;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PracticeStream {
    public static void main(String[] args) {
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactionsCalculate(transactions);
    }

    private static void transactionsCalculate(List<Transaction> transactions) {
        /*
           1. Find all transactions in the year 2011 and sort them by value (small to high).
         */
        List<Transaction> result = transactions
                .stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println("transactions in 2011 with sorted order ? " + result);
        /*
            2. What are all the unique cities where the traders work?
         */
        System.out.println("Unique cities trader work ? ");
        transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        //or use set.
        Set<String> output = transactions.stream().map(tr -> tr.getTrader().getCity()).collect(toSet());

        /*
         3. Find all traders from Cambridge and sort them by name
         */
        List<Trader> tradersCam = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(tr -> tr.getTrader())
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(toList());
        System.out.println("Trader from cambridge - names are sorted ? " + tradersCam);
        /*
        4. Return a string all traders name sorted alphabetically.
         */
        String tradersName = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining(", "));
        System.out.println("Traders Name sorted alphabetically ? " + tradersName);
        /*
        5. Any traders from Milan?
         */
        Boolean tradersFromMilan = transactions.stream()
                .anyMatch(tr -> tr.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println("Traders from Milan ? " + tradersFromMilan);


        /*
        6. Print all the transactions value from the traders living in Cambridge.
         */
        List<Integer> transactionValue = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());

       long transactionSum = transactions
               .stream()
               .filter(t->t.getTrader().getCity().equalsIgnoreCase("cambridge"))
               .collect(Collectors.summingInt(Transaction::getValue));

        System.out.println("transaction values from cambridge? " + transactionSum);
        /*
        7. What's the hightest value of all Transactions?
         */
        Optional<Integer> maxValueTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("Max value transaction? " + maxValueTransaction.get());

        transactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue))).ifPresent(System.out::println);
        /*
        8. Find the transaction with the smallest value?
         */
        Optional<Transaction> trans = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println("transaction ? " + trans.get());

        OptionalInt maxTransValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println("max transaction value ? " + maxTransValue.getAsInt());


    }


}
