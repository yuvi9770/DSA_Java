package SegmentTree;

public class CreationOfST {

    // Construction of ST
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int arr[], int i, int start, int end){
        if (start == end) {
            tree[i] = arr[start];
            return;
            // return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr, 2*i+1, start, mid); //left subtree - 2*i+1
        buildST(arr, 2*i+2, mid+1, end); //right subtree - 2*i+2

        tree[i] = tree[2*i+1] + tree[2*i+2];
        // return tree[i];
    }

    // Query on ST (find the sum of a range)
    public static int helper(int i, int si, int sj, int qi, int qj){
        if (qj < si || qi > sj) { //non overlapping
            return 0;

        }else if (si >= qi && sj <= qj) { //complete overlapping
            return tree[i];

        }else{ //partial overlapping
            int mid = (si+sj)/2;
            int left = helper(2*i+1, si, mid, qi, qj);
            int right = helper(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return helper(0, 0, n-1, qi, qj);
    }

    // Update on ST (only those node that include the idx)
    public static void helper2(int i, int si, int sj, int idx, int diff){
        if (idx > sj || idx < si) {
            return;
        }

        tree[i] += diff;
        if (si != sj) { // check for non-leaf
            int mid = (si+sj)/2;
            helper2(2*i+1, si, mid, idx, diff); // left
            helper2(2*i+2, mid+1, sj, idx, diff); // right
        }
    }

    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        helper2(0, 0, n-1, idx, diff);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n-1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }System.out.println();

        System.out.println(getSum(arr, 1, 5));

        update(arr, 2, 2);
        System.out.println(getSum(arr, 1, 5));
    }
}