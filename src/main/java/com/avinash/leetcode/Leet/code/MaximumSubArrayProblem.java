package com.avinash.leetcode.Leet.code;

public class MaximumSubArrayProblem {
    /*
    * find the sub array with largest sum
    * example:
    * input: [-2,1,-3,4,-1,2,1,-5,4]
    * output: 6
    * subArray = [4,-1,2,1]
    *
    * */

    //my implimentation
    private static int findMaxSubArraySumByAvi(int[] inputArray){
        int largestSum = inputArray[0];
        int currentSum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            currentSum = currentSum + inputArray[i];
            if(currentSum<0){
                currentSum = 0;
            }
            if(currentSum>largestSum){
                largestSum = currentSum;
            }
        }

        return largestSum;
    }

    private static int findMaxSubArraySumByCopilot(int[] inputArray){
        int maxSoFar = inputArray[0];
        int currentMax = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {

            currentMax = Math.max(inputArray[i], currentMax + inputArray[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }


    private static void findMaxSubArraySumWithSubarrayByCopilot(int[] inputArray) {
        int maxSoFar = inputArray[0];
        int currentMax = inputArray[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < inputArray.length; i++) {
            // If starting fresh gives better sum, restart from here
            if (inputArray[i] > currentMax + inputArray[i]) {
                currentMax = inputArray[i];
                tempStart = i;  // Mark new potential start
            } else {
                currentMax = currentMax + inputArray[i];
            }

            // If current sum is better, update max and record the range
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        // Print results
        System.out.println("Max Sum: " + maxSoFar + ", Range: [" + start + ", " + end + "]");
        System.out.print("SubArray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(inputArray[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("]");
    }


    static void main() {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};// expected sum: 6, subarray: [4, -1, 2, 1]
        int[] ints1 = {1, 2, 3, 4};// expected sum: 10, subarray: [1, 2, 3, 4]
        int[] ints2 = {-1, -2, -3, -4};// expected sum: -1, subarray: [-1]
        int[] ints3 = {5};// expected sum: 5, subarray: [5]
        int[] ints4 = {-5};// expected sum: -5, subarray: [-5]
        int[] ints5 = {0, 0, 0, 0};// expected sum: 0, subarray: [0] (or any single 0)
        int[] ints6 = {4, -1, 2, 1};// expected sum: 6, subarray: [4, -1, 2, 1]
        int[] ints7 = {-2, -1, 0, -3};// expected sum: 0, subarray: [0]
        int[] ints8 = {8, -19, 5, -4, 20};// expected sum: 21, subarray: [5, -4, 20]
        int[] ints9 = {2, -1, 2, 3, 4, -5};// expected sum: 10, subarray: [2, -1, 2, 3, 4]

        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints1)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints1));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints2)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints2));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints3)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints3));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints4)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints4));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints5)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints5));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints6)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints6));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints7)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints7));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints8)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints8));
        System.out.println("findMaxSubArraySumByAvi:"+findMaxSubArraySumByAvi(ints9)+" findMaxSubArraySumByCopilot:"+findMaxSubArraySumByCopilot(ints9));

        int[] ints10 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] ints11 = {1, 2, 3, 4};
        int[] ints12 = {-1, -2, -3, -4};

        findMaxSubArraySumWithSubarrayByCopilot(ints10);   // Max Sum: 6, Range: [3, 6], SubArray: [4, -1, 2, 1]
        findMaxSubArraySumWithSubarrayByCopilot(ints11);  // Max Sum: 10, Range: [0, 3], SubArray: [1, 2, 3, 4]
        findMaxSubArraySumWithSubarrayByCopilot(ints12);  // Max Sum: -1, Ra

    }
}
