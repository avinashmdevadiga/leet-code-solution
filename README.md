# leet-code-solution

## Time and Space complexity analysis

### What is Time and Space Complexity?

- Time complexity and space complexity are measures of the efficiency of an algorithm.
- Time complexity refers to the amount of time an algorithm takes to complete as a function of the input size, while
  space complexity refers to the amount of memory an algorithm uses as a function of the input size.
- Both time and space complexity are important factors to consider when designing and analyzing algorithms, as they can
  impact the performance and scalability of a solution.
- understanding the time and space complexity of an algorithm can help us make informed decisions about which algorithm
  to use for a given problem, and can also help us optimize our code for better performance.

### Brute Force Approach

- a brute force approach is a straightforward method of solving a problem by trying all possible combinations or
  permutations of the input data.
- it is often used as a baseline or starting point for solving a problem, and can be useful for understanding the
  problem and testing the correctness of a solution.
- however, brute force approaches are often inefficient and can have high time and space complexity, especially for
  large input sizes.
    - for example, if we have a problem that requires us to check all possible combinations of n elements, a brute force
      approach would have a time complexity of O(2^n) because there are 2^n possible combinations. This means that as
      the input size increases, the runtime will grow exponentially, making it impractical for large input sizes. In
      such cases, it is often necessary to look for more efficient algorithms that can solve the problem in a reasonable
      amount of time and with less memory usage.
    - for example, if we have a problem that requires us to check all possible permutations of n elements, a brute force
      approach would have a time complexity of O(n!) because there are n! possible permutations. This means that as the
      input size increases, the runtime will grow factorially, making it impractical for large input sizes. In such
      cases, it is often necessary to look for more efficient algorithms that can solve the problem in a reasonable
      amount of time and with less memory usage.

### Time Complexity

- tells us growth in runtime of the algorithm with respect to the input size.
- expressed using Big O notation (e.g., O(n), O(log n), O(n^2)).
- helps us understand how the algorithm will perform as the input size increases.

### Space Complexity

- tells us growth in memory(it takes two type of memory such as RAM(mainly), other like db) usage of the algorithm with
  respect to the input size.
- also expressed using Big O notation (e.g., O(1), O(n)).
- helps us understand how much additional memory the algorithm will require as the input size increases.

### Big O Notation

- Big O notation is a mathematical notation used to describe the upper bound of an algorithm's growth
- it provides a way to express the worst-case scenario of an algorithm's performance.
- it focuses on the dominant term of the growth rate, ignoring constant factors and lower-order terms.
- for example, if an algorithm has a time complexity of O(n^2 + n), it can be simplified to O(n^2) because n^2 grows
  faster than n as the input size increases.
- Big O notation allows us to compare the efficiency of different algorithms and make informed decisions about which
  algorithm to use based on the expected input size and performance requirements.
- for example, if an algorithm has a time complexity of O(n^2), it means that the runtime will grow quadratically as the
  input size increases. If the input size doubles, the runtime will increase by a factor of four (2^2). If the input
  size triples, the runtime will increase by a factor of nine (3^2). This indicates that the algorithm may not be
  efficient for large input sizes, and alternative algorithms with better time complexity should be considered.
- there are couple of examples of time complexity such as O(1) (constant time), O(log n) (logarithmic time), O(n) (
  linear time), O(n log n)
  (linearithmic time), O(n^2) (quadratic time), O(2^n) (exponential time), and O(n!) (factorial time).
- we need to write a code with better time complexity and space complexity to solve the problem efficiently.
- for example, if we have a problem that requires us to check all possible combinations of n elements, a brute force approach would have a time complexity of O(2^n) because there are 2^n possible combinations. This means that as the input size increases, the runtime will grow exponentially, making it impractical for large input sizes. In such cases, it is often necessary to look for more efficient algorithms that can solve the problem in a reasonable amount of time and with less memory usage.
