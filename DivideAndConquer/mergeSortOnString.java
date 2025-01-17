package DivideAndConquer;

public class mergeSortOnString {
    public static String[] sort(String str[], int low, int high){
        if (low == high) {
            String Arr[] = {str[low]};
            return Arr;
        }

        int mid = (low+high)/2;
        String arr1[] = sort(str, low, mid);
        String arr2[] = sort(str, mid+1, high);
        String arr3[] = merge(arr1, arr2);
        return arr3;
    }

    
    public static String[] merge(String arr1[], String arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        String res[] = new String[m+n];

        int idx = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (isAlphabetical(arr1[i], arr2[j])) {
                res[idx] = arr1[i];
                i++;
            } else {
                res[idx] = arr2[j];
                j++;
            }
            
            idx++;
        }

        while (i < m) {
            res[idx++] = arr1[i++];
        }

        while (j < n) {
            res[idx++] = arr2[j++];
        }

        return res;
    }


    public static boolean isAlphabetical(String arr1, String arr2){
        String s1 = arr1.toLowerCase();
        String s2 = arr2.toLowerCase();
        if (s1.compareTo(s2) < 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String str[] = {"sun", "earth", "mars", "mercury"};
        String str2[] = sort(str, 0, str.length-1);
        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]);
        }
    }
}