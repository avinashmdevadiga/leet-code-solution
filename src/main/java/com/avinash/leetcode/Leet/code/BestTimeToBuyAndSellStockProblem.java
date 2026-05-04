package com.avinash.leetcode.Leet.code;

public class BestTimeToBuyAndSellStockProblem {
    /*
    * you are given a Array prices where prices[i] is the price of a given stock on the ith day.
    * you want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    * return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    * Example1:
    * input prices=[7,1,5,3,6,4]
    * output: 5;
    * explanation: buy on day 2 when price =1 and sell on a day 5 when price = 6. total profit 6-1=5
    * Note: buying on day 2 and selling on day 1 is not allowed.always buy day is less than sell day.
    * */
    private static int maximumProfitByAvi(int[] inputArray){
        int maxProfit = 0;
        if(inputArray.length>0) {
            int minPrice = inputArray[0];
            if (inputArray.length < 2) {
                return 0;
            }
            for (int i = 1; i < inputArray.length; i++) {
                if (inputArray[i] <= minPrice) {
                    minPrice = inputArray[i];

                } else {
                    if (maxProfit < inputArray[i] - minPrice)
                        maxProfit = inputArray[i] - minPrice;
                }

            }
        }
        return maxProfit;

    }

    private static int maximumProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }

    static void main() {
        System.out.println("maxProfit :: "+maximumProfit(new int[]{7,1,5,3,6,8}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{7,6,4,3,1}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{1,2,3,4,5}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{5,5,5,5}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{2,1,2,1,0,1,2}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{3,8,1,10}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{2,4,1}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{1,1,2,2,0,0,3,3}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{9}));
        System.out.println("maxProfit :: "+maximumProfit(new int[]{}));
    }
}
