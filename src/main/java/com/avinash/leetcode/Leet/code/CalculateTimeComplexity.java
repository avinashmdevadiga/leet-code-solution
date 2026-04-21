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


        /*
        * i->1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
         *
         * Steps to calculate the time complexity of this loop:
         *
         * 1) Initialize i = 1
         *    - Executes once → 1 step
         *
         * 2) Check condition i < n
         *    - Executes (k + 1) times where k is the number of iterations until i >= n → (k + 1) steps
         *
         * 3) Update i (i = i * 2)
         *    - Executes k times → k steps
         *
         * 4) Print i
         *    - Executes k times → k steps
         *
         * Total steps = 1 + (k + 1) + k + k = 3k + 2
         *
         * To find k in terms of n:
         * - The loop runs while i < n.
         * - After k iterations: i = 2^k.
         * - The loop stops when i >= n → when 2^k >= n → k >= log₂(n).
         *
         * Therefore, k is approximately log₂(n).
         *
         * Substituting back:
         * Total steps ≈ 3log₂(n) + 2
         *
         * Big-O simplification rules:
         * - Ignore constant multipliers (e.g., 3log₂(n) → log₂(n))
         * - Ignore lower-order terms/constants (e.g., +2)
         *
         * Therefore, the time complexity is O(log n).
        * */
        int i =1;
        while(i < n){
            System.out.println(i);
            i = i * 2;
        }

        /*
        * nested loop
        * Steps to calculate the time complexity of this nested loop:
         *
         * 1) Outer loop (j):
         *    - Initializes j = 0 → 1 step
         *    - Checks condition j < n → Executes (n + 1) times → (n + 1) steps
         *    - Increments j (j++) → Executes n times → n steps
         *
         * 2) Inner loop (k):
         *    - For each iteration of the outer loop, it initializes k = 0 → 1 step
         *    - Checks condition k < m → Executes (m + 1) times → (m + 1) steps
         *    - Increments k (k++) → Executes m times → m steps
         *
         * Total steps for inner loop per iteration of outer loop = 1 + (m + 1) + m = 2m + 2
         *
         * Since the inner loop runs for each of the n iterations of the outer loop:
         * Total steps for inner loop across all iterations = n * (2m + 2)
         *
         * Adding the outer loop steps:
         * Total steps = Outer loop steps + Inner loop steps
         *              = [1 + (n + 1) + n] + [n * (2m + 2)]
         *              = (2n + 2) + (2mn + 2n)
         *              = 2n + 2mn + 4n
         *              = 6n + 2mn
         *
         * Big-O simplification rules:
         * - Ignore constant multipliers (e.g., 6n → n, and 2mn → mn)
         * - Ignore lower-order terms/constants (e.g., if m is considered a constant, then mn simplifies to n)
         *
         * If m is a constant, then the time complexity simplifies to O(n).
         *
         * If m is not a constant and grows with n, then the time complexity is O(mn).
        * */
        int m=20;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.println(j + ", " + k);
            }
        }
    }
}
