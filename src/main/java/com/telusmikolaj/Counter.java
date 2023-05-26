package com.telusmikolaj;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

public class Counter {


    private int currentGraphSize;

    private Map<Integer, InnerCounter> visitedMap;

    private int prevNumOfV;
    public Counter() {
        this.visitedMap = new HashMap<>();
        this.prevNumOfV = 0;
    }

    class InnerCounter {
        private int sumOfVisits = 1;
        private int N = 1;
        private int notFouned = 0;
        private void incrementSumOfVisits() {
            sumOfVisits ++;
        }

        private void incrementN() {
            N ++;
        }

        private void incrementNotFounded() {
            notFouned ++;
        }


    }

    public void incrementN(int numOfV) {
        if (prevNumOfV == numOfV) {
            this.visitedMap.get(numOfV).incrementN();
        }
        prevNumOfV = numOfV;
    }

    public void incrementVisitedCounter(int numOfV) {
        if (visitedMap.containsKey(numOfV)) {
            visitedMap.get(numOfV).incrementSumOfVisits();

        } else {
            visitedMap.put(numOfV, new InnerCounter());
        }
    }

    public void incrementNotFounded(int numOfV) {
        visitedMap.get(numOfV).incrementNotFounded();
    }

   public void resetCounter() {
       this.visitedMap = new HashMap<>();
       this.prevNumOfV = 0;
    }

    public void setCurrentGraphSize(int currentGraphSize) {
        this.currentGraphSize = currentGraphSize;
    }

    public int getCurrentGraphSize() {
        return currentGraphSize;
    }

    public void printCounterResult(String algorithmName) {
        System.out.println("Algorithm: " + algorithmName);
        this.visitedMap.forEach((key, value) -> {
            System.out.println("Number of verticies " + key + " N " + value.N);
            System.out.println("Sum of vistis " + value.sumOfVisits);
            System.out.println("Average visited " + value.sumOfVisits / value.N);
            System.out.println("Not founded " + value.notFouned);
        });

    }


}
