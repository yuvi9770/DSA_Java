package Greedy;

import java.util.ArrayList;
import java.util.Collections;

class Job2{
    int id, profit, deadline;

    public Job2(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class jobSch{
    public void schedule(int jobsInfo[][]){
        ArrayList<Job2> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job2(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a,b) -> b.profit-a.profit);

        int maxDeadline = 0;
        for (Job2 job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline];
        ArrayList<Integer> seq = new ArrayList<>();

        for (Job2 job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (slot[j] == false) {
                    slot[j] = true;
                    seq.add(job.id);
                    break;
                }
            }
        }

        System.out.println(seq.size());
        for (Integer i : seq) {
            System.out.print(i + " ");
        }
    }
}

public class JobScheduler2 {
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,200},{1,10},{1,40},{1,30}};

        jobSch jb = new jobSch();
        jb.schedule(jobsInfo);
    }
}