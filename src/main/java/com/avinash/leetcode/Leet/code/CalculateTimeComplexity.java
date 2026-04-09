package com.avinash.leetcode.Leet.code;

public class CalculateTimeComplexity {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int n = 10;
        /*
         * Example 1
         * ---------
         * Steps to calculate the time complexity of this loop:
         *
         * 1) Initialize i = 0
         *    - Executes once → 1 step
         *
         * 2) Check condition i < n
         *    - Executes (n + 1) times (the final check fails when i == n) → (n + 1) steps
         *
         * 3) Increment i (i++)
         *    - Executes n times → n steps
         *
         * 4) Print i
         *    - Executes n times → n steps
         *
         * Total steps = 1 + (n + 1) + n + n = 3n + 2
         *
         * Big-O simplification rules:
         * 1) Ignore constant multipliers (e.g., 3n → n)
         * 2) Ignore lower-order terms/constants (e.g., +2)
         *
         * Therefore, the time complexity is O(n).
         */
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        /*
         * Example 2
         * ---------
         * Loop: for (int i = 0; i % 2 == 0; i++)
         *
         * Key observation:
         * - The loop condition depends only on i.
         * - It’s true for i = 0, false for i = 1.
         * - So the body runs exactly once, regardless of any external input.
         *
         * Step count:
         * 1) Initialize i = 0
         *    - Executes once → 1 step
         *
         * 2) Check condition i % 2 == 0
         *    - Executes twice (for i = 0 and i = 1) → 2 steps
         *
         * 3) Increment i (i++)
         *    - Executes once → 1 step
         *
         * 4) Print i
         *    - Executes once → 1 step
         *
         * Total steps = 1 + 2 + 1 + 1 = 5 → constant
         *
         * Therefore, the time complexity is O(1) (constant time).
         *
         * Note:
         * - This is O(1) with respect to any external input (like n), because n is not used.
         */
        for (int i = 0; i % 2 == 0; i++) {
            System.out.println(i);
        }
    }
}
