package stack.queue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Long count = 0l;
        try (Stream<String> lines = Files.lines(Paths.get("src/stack/queue/fileTest.txt"),
                Charset.defaultCharset())) {
            count = lines
                    .flatMap(l -> Arrays.stream(l.split(" ")))
                    .collect(Collectors.toSet()).stream().count();
        }

        List data = new ArrayList();

        System.out.println("uniquewords ? " + count);
        System.out.println(processFile());
        //using Lambda functions.
        System.out.println(processFile2(br -> br.readLine() + br.readLine()));
        //Using Anonymous functions.
        System.out.println("using anonymous functions ? " + processFile2(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine();
            }
        }));
    }

    public static String processFile() throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/stack/queue/fileTest.txt"))){
            return  br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String processFile2(BufferedReaderProcessor brp) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/stack/queue/fileTest.txt"))){
            return brp.process(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
