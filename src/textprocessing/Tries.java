package textprocessing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Node{
    Map<Character, Node> children;
    boolean isWord;
    Node(){
        isWord = false;
        children = new HashMap<Character,Node>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "children=" + children.entrySet().stream().map((k)-> k.getKey()).collect(Collectors.toList()) +
                '}';
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insertWord(String word){
        Node newNode = root;
        for(int i=0;i<word.length();i++){
            if(!newNode.children.containsKey(word.charAt(i))){
                newNode.children.put(word.charAt(i), new Node());
            }

            newNode = newNode.children.get(word.charAt(i));
        }

        newNode.isWord = true;
    }

    boolean search(String word){
        Node searchNode = root;
        for(int i = 0; i<word.length();i++){
            if(!searchNode.children.containsKey(word.charAt(i))){
                return false;
            }
            searchNode = searchNode.children.get(word.charAt(i));
        }

        return searchNode.isWord;
    }

    void print(){
        Node print = root;
        while(print != null){
            for(int i = 0; i< print.children.size(); i++){
              List<Node> test = print.children.values().stream().collect(Collectors.toList());
                System.out.println(test);
            }
        }
    }


}
public class Tries {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insertWord("books");
        trie.insertWord("bound");
        trie.insertWord("around");
        System.out.println( trie.search("book"));
        System.out.println( trie.search("books"));
        System.out.println( trie.search("bound"));
       trie.print();

    }
}
