package Tries;

import java.util.*;

public class Trie {

    public static int ALPHABET_SIZE = 26;

    private class Node {

        private char value;

        private HashMap<Character, Node> children;

        private boolean isEndOfAWord;

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
            this.isEndOfAWord = false;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(String value) {
        if(value == null)
            return;

        var current = root;

        for(var ch : value.toCharArray()) {
            if(current.children.get(ch)== null) {
                current.children.put(ch, new Node(ch));
            }
            current = current.children.get(ch);
        }

        current.isEndOfAWord = true;
    }

    public boolean contains(String word) {
        if(word == null)
            return  false;

        var current = root;
        for(var ch : word.toCharArray()) {
            if(!current.children.containsKey(ch))
                return false;

            current = current.children.get(ch);
        }
        return current.isEndOfAWord;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        System.out.println(node.value);

        for (Node n : node.children.values().toArray(new Node[0])) {
            preOrderTraversal(n);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        for (Node n : node.children.values().toArray(new Node[0])) {
            postOrderTraversal(n);
        }

        System.out.println(node.value);
    }

    public void remove(String word) {
        if(word == null) {
            return;
        }
        remove(root, word, 0);
    }

    private void remove(Node node, String word, int index) {
       if(index == word.length()) {
           node.isEndOfAWord = false;
           return;
       }

       var child = node.children.get(word.charAt(index));
       if(child == null)
           return;

       remove(child, word, index + 1);

       if(child.children.isEmpty() && !child.isEndOfAWord)
           node.children.remove(child.value);

    }



    public List<String> findWords(String prefix) {
        if(prefix == null) {
            return null;
        }
        List<String> words = new ArrayList<String>();
        findWords(findLastNodeOf(prefix), prefix, words);
        return words;
    }

    public void findWords(Node node, String prefix, List<String> words) {
        if(node.isEndOfAWord) {
            words.add(prefix);
        }
        for(Node child : node.children.values().toArray(new Node[0])) {
            findWords(child, prefix + child.value, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        var current = root;
        for(var ch : prefix.toCharArray()) {
            if(!current.children.containsKey(ch)) {
                return null;
            }
            current = current.children.get(ch);
        }
        return current;
    }




}
