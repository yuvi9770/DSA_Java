package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void choco(Integer CostVer[],Integer CostHor[]){
        Arrays.sort(CostVer, Collections.reverseOrder());
        Arrays.sort(CostHor, Collections.reverseOrder());

        int h = 0, v = 0; // cuts
        int hPiece = 1, vPiece = 1; // pieces
        int minCost = 0;

        while (h < CostHor.length && v < CostVer.length) {
            if (CostVer[v] <= CostHor[h]) { // horizontal cuts
                minCost += (CostHor[h] * vPiece);
                hPiece++;
                h++;

            }else{ // vertical cuts
                minCost += (CostVer[v] * hPiece);
                vPiece++;
                v++;
            }
        }

        while (h < CostHor.length) {
            minCost += (CostHor[h] * vPiece);
            hPiece++;
            h++;
        }

        while (v < CostVer.length) {
            minCost += (CostVer[v] * hPiece);
            vPiece++;
            v++;
        }

        System.out.println("Min minCost : " + minCost);
    }
    public static void main(String[] args) {
        // int row = 6, col = 4;
        Integer CostVer[] = {2,1,3,1,4};
        Integer CostHor[] = {4,1,2};
        choco(CostVer, CostHor);
    }
}