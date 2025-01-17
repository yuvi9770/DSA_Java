package Trie;

class Node{
    Node children[] = new Node[26];
    boolean eow = false;
    int freq = 0;

    // Node(){
    //     for (int i = 0; i < 26; i++) { // no need as java automatically initalize to null
    //         children[i] = null;
    //     }

    //     freq = 0;
    // }
}