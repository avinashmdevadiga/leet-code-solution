package com.avinash.leetcode.Leet.code;

public class SpaceComplexityExample {
    private static long fib(int n){
        if(n == 1 || n==2) return 1;
        return fib(n-1) + fib(n-2);
    }

    /*
    * Space complexity calculation for factorial:
    * - Each call to factorial(n) creates a new stack frame.
    * - The maximum depth of the call stack is O(n) (when n is large).
    * - Therefore, the space complexity is O(n).
    * */
    private static double factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    /*
    * Space complexity calculation for doubleInputArray:
    * recurssive -  0
    * data Structure - 0
    * variables - 4 byte foe n,4 byte for i,4 byte for result
    * total space complexity = 4 + 4 + 4 = 12 bytes (O(1))
    * Note: The space complexity is O(1) because the amount of memory used does not grow with the size of the input array. The function uses a constant amount of space for its variables, regardless of the input size.
    *
    * */
    private static void doubleInputArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <n; i++) {
            int result = arr[i] * 2;
            System.out.println("doubleInputArray:"+result);
        }
    }

    /*
    * Space complexity: growth in memory usage as the input size increases
    * Example 1: Fibonacci Sequence (Recursive)
    * - Each call to fib(n) creates a new stack frame.
    * - The maximum depth of the call stack is O(n) (when n is large).
    * - Therefore, the space complexity is O(n).
    * Example 2: Factorial (Recursive)
    * - Each call to factorial(n) creates a new stack frame.
    * - The maximum depth of the call stack is O(n) (when n is large).
    * - Therefore, the space complexity is O(n).
    * Note: Both examples have exponential time complexity (O(2^n) for Fibonacci and O(n) for factorial), but their space complexity is linear (O(n)) due to the depth of the recursive calls.
    *
    * */
    public static void main() {
       /* for (int i = 1; i <= 100; i++) {
            //System.out.println("fibonacci:"+i+" : "+fib(i));
//            System.out.println("factorial:"+i+" : "+factorial(i));

        }*/
        doubleInputArray(new int[]{1, 2, 3, 4, 5});


    }
}
