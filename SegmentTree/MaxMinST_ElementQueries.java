package SegmentTree;

public class MaxMinST_ElementQueries {
    // Creation of ST with max element(in the range)
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildTree(int arr[], int i, int start, int end){
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        buildTree(arr, 2*i+1, start, mid);
        buildTree(arr, 2*i+2, mid+1, end);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    // getMax in ST
    public static int helper(int i, int si, int sj, int qi, int qj){
        if (qj < si || qi > sj) {//non overlapping
            return Integer.MIN_VALUE;

        }else if (si >= qi && sj <= qj) {//complete overlapping
            return tree[i];

        }else{ //partial overlapping
            int mid = (si+sj)/2;
            int left = helper(2*i+1, si, mid, qi, qj);
            int right = helper(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return helper(0, 0, n-1, qi, qj);
    }

    // Update in ST (only those node that include the idx)
    public static void helper2(int i, int si, int sj, int idx, int newVal){
        if (idx > sj || idx < si) {
            return;
        }

        //si == sj, then currVal = newVal
        if (si == sj) tree[i] = newVal;
        
        else if (si != sj) { // check for non-leaf
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si+sj)/2;
            helper2(2*i+1, si, mid, idx, newVal); // left
            helper2(2*i+2, mid+1, sj, idx, newVal); // right
        }
    }

    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;

        helper2(0, 0, n-1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        buildTree(arr, 0, 0, n-1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }System.out.println();

        System.out.println(getMax(arr, 2, 2));

        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 2));
    }
}