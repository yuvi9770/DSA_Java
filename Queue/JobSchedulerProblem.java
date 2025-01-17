package Queue;

import java.util.Arrays;

class job{
    int id, profit, deadline;

    public job(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

class solve{
    public int[] jobSceduling(job arr[], int n){
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        boolean result[] = new boolean[maxDeadline+1];
        
        int countJob = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    countJob++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[] {countJob, jobProfit};
    }
}

public class JobSchedulerProblem {
    public static void main(String[] args) {
        job arr[] = new job[4];
        arr[0] = new job(1, 20, 4);
        arr[1] = new job(2, 10, 1);
        arr[2] = new job(3, 40, 2);
        arr[3] = new job(4, 30, 2);

        solve jb = new solve();
        int res[] = jb.jobSceduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);
    }
}