package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

class Hash_Map<K,V>{ // generic
    private class Node{
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // Total Number of pairs
    private int N; // size of Array/buckets
    private LinkedList<Node> buckets[]; // N = buckets.length

    @SuppressWarnings("unchecked")
    public Hash_Map(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }


    private int hashFunction(K key){
        int hc = key.hashCode();
        return Math.abs(hc) % N; // % n will return a value in range 0 to (N-1)
    }

    private int SearchLL(K key, int bi){
        LinkedList<Node> ll = buckets[bi];

        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void reHash(){
        LinkedList<Node> oldBucket[] = buckets;
        N = N * 2;
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // oldBucket -> add in newBucket
        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            
            while (!ll.isEmpty()) {
                Node node = ll.remove();
                // put(node.key, node.value);
                int bi = Math.abs(node.key.hashCode()) % N; // improve as directly add into bucket 
                buckets[bi].add(node);
            }            
        }
    }

    public void put(K key, V value){
        int bi = hashFunction(key);
        int di = SearchLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;

        }else{
            buckets[bi].add(new Node(key, value));
            n++;
        }

        double lambda = (double) n/N;
        if (lambda > 2.0) {
            reHash();
        }
    }

    public boolean containsKey(K key){
        int bi = hashFunction(key);
        int di = SearchLL(key, bi);

        if (di != -1) return true;

        return false;
    }

    public V remove(K key){
        int bi = hashFunction(key);
        int di = SearchLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }

        return null; // if key not present then return null
    }

    public V get(K key){
        int bi = hashFunction(key);
        int di = SearchLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        }

        return null; // if key not present then return null
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> ll = buckets[i];
            for (Node n : ll) {
                keys.add(n.key);
            } 
        }
        return keys;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (LinkedList<Node> ll : buckets) {
            for (Node node : ll) {
                sb.append(node.key).append(" = ").append(node.value).append(", ");
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove last comma and space
        }
        sb.append("}");

        return sb.toString();
    }
}

public class Hash_Map_Implementation {
    public static void main(String[] args) {
        Hash_Map<String, Integer> hm = new Hash_Map<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);
 
        System.out.println(hm.toString());

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}