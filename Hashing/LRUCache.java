package Hashing;

import java.util.HashMap;

public class LRUCache {

    private class Node{
        int data; int key;
        Node prev; Node next;
        public Node(int key, int data) {
            this.data = data;
            this.key = key;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> map;
    Node head; Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void RemoveHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void AddToHead(Node node){
        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev =head;
    }

    private void MoveToHead(Node node){
        RemoveHead(node);
        AddToHead(node);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node temp = map.get(key);
        MoveToHead(temp);
        return temp.data;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.data = value;
            MoveToHead(temp);
            // map.put(key, temp); // Auto update in map as it refers to Node

        }else{
            if (map.size() >= capacity) {
                Node lru = tail.prev;
                RemoveHead(lru);
                map.remove(lru.key);
            }
    
            Node newNode = new Node(key, value);
            AddToHead(newNode);
            map.put(key, newNode);
        }
    }


    public static void main(String[] args) {
        
    }
}