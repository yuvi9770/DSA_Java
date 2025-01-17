package BinarySearchTree;

import java.util.ArrayList;

public class CountPairsFromTwoBST {
    static int count = 0;

    public static void getInOrder(Node root, ArrayList<Integer> Arr){
        if (root == null) return;

        getInOrder(root.left, Arr);
        Arr.add(root.data);
        getInOrder(root.right, Arr);
    }

    public static void findPair(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int target){
        int i = 0;
        int j = arr2.size()-1;
        while (i < arr1.size() && j >= 0) {
            int currNum = arr1.get(i)+arr2.get(j);

            if (currNum == target) {
                count++; i++; j--;

            }else if (currNum > target) {
                j--;
            }else{
                i++;
            }
        }
    }

    public static int pairSum(Node root1, Node root2, int target){
        count = 0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        findPair(arr1, arr2, target);
        return count;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right = new Node(7);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right = new Node(15);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        System.out.println(pairSum(root1, root2, 16));
    }
}

// This is a better solution then above

// class Solution {
//     private int count;
    
//     public int countPairs(Node root1, Node root2, int x) {
//         Set<Integer> storedVal = new HashSet<>();
//         count = 0;

//         dfsGenVal(root1, storedVal);
//         dfsCountVal(root2, storedVal, x);

//         return count;
//     }

//     private void dfsGenVal(Node root, Set<Integer> storedVal) {
//         if (root == null) return;

//         dfsGenVal(root.left, storedVal);
//         storedVal.add(root.data);
//         dfsGenVal(root.right, storedVal);
//     }

//     private void dfsCountVal(Node root, Set<Integer> storedVal, int x) {
//         if (root == null) return;

//         dfsCountVal(root.left, storedVal, x);
//         if (storedVal.contains(x - root.data)) count++;
//         dfsCountVal(root.right, storedVal, x);
//     }
// }