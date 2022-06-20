package com.GeeksForGeeks.Array;

public class MaximumProfitByBuyingAndSellingAShareAtMostTwice {
    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        int size = arr.length;;
        int result = maxTwoBuySell(arr, size);
        System.out.println(result);
    }
    /*private static int maxProfit(int[] price, int n) {
        // Create profit array
        // and initialize it as 0
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = 0;
        }

        *//* Get the maximum profit
           with only one transaction
           allowed. After this loop,
           profit[i] contains
           maximum profit from
           price[i..n-1] using at most
           one trans. *//*
        int maxPrice = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // max_price has maximum
            // of price[i..n-1]
            if (price[i] > maxPrice)
                maxPrice = price[i];

            // we can get profit[i]
            // by taking maximum of:
            // a) previous maximum,
            // i.e., profit[i+1]
            // b) profit by buying
            // at price[i] and selling
            // at
            //    max_price
            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
        }

        *//* Get the maximum profit
           with two transactions allowed
           After this loop, profit[n-1]
           contains the result
         *//*
        int minPrice = price[0];
        for (int i = 1; i < n; i++) {
            // min_price is minimum
            // price in price[0..i]
            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice));
        }
        int result = profit[n - 1];
        return result;
    }*/

    private static int maxTwoBuySell(int[] arr, int size) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for(int i = 0; i < size; i++) {

            firstBuy = Math.max(firstBuy, -arr[i]);
            firstSell = Math.max(firstSell, firstBuy + arr[i]);
            secondBuy = Math.max(secondBuy, firstSell - arr[i]);
            secondSell = Math.max(secondSell, secondBuy + arr[i]);

        }
        return secondSell;
    }
}
