# 📚 Data Structures & Algorithms Guide

> A comprehensive guide to understanding data structures, algorithms, and complexity analysis with practical examples in
> Java.

## 📖 Table of Contents

- [Introduction](#introduction)
- [Time and Space Complexity Analysis](#time-and-space-complexity-analysis)
- [Big O Notation](#big-o-notation)
- [Common Complexity Classes](#common-complexity-classes)
- [Practical Complexity Guidelines](#practical-complexity-guidelines)
- [Common Myths About Complexity](#common-myths-about-complexity)
- [Brute Force Approach](#brute-force-approach)
- [Best, Average, and Worst Case Analysis](#best-average-and-worst-case-analysis)
- [Data Structures](#data-structures)
    - [Arrays](#arrays)
        - [Array Basics](#array-basics)
        - [Array Characteristics](#array-characteristics)
        - [Array Operations & Complexity](#array-operations--complexity)
        - [Common Array Patterns](#common-array-patterns)
        - [Advantages of Arrays](#advantages-of-arrays)
        - [Disadvantages of Arrays](#disadvantages-of-arrays)
        - [When to Use Arrays](#when-to-use-arrays)

---

## Introduction

This guide covers fundamental concepts in data structures and algorithms that every programmer should know. Whether
you're preparing for coding interviews or want to write more efficient code, understanding these concepts is crucial for
building scalable applications.

**What You'll Learn:**

- How to analyze algorithm efficiency
- Understanding Big O notation and complexity analysis
- Core data structures and their use cases
- Practical tips for choosing the right algorithm

---

## Time and Space Complexity Analysis

### 🤔 What is Time and Space Complexity?

**Time Complexity** measures how the runtime of an algorithm grows as the input size increases. It helps us answer: *"
How fast is this algorithm?"*

**Space Complexity** measures how the memory usage of an algorithm grows as the input size increases. It helps us
answer: *"How much memory does this algorithm need?"*

#### Why Are They Important?

- **Performance**: Understanding complexity helps us write efficient code that scales well
- **Resource Management**: Helps optimize memory usage, especially for large datasets
- **Algorithm Selection**: Allows us to choose the best algorithm for a given problem
- **Scalability**: Ensures our solutions work efficiently as data grows

#### Example:

```java
// Time: O(n) - loops through array once
// Space: O(1) - uses only a few variables
public int findMax(int[] arr) {
    int max = arr[0];  // Space: 1 variable
    for (int i = 1; i < arr.length; i++) {  // Time: n iterations
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```

---

## 🔨 Brute Force Approach

**Brute Force** is a straightforward problem-solving method that tries all possible solutions until finding the correct
one.

#### Characteristics:

- ✅ **Simple to implement** - Easy to understand and code
- ✅ **Guaranteed correctness** - Will find the solution if one exists
- ❌ **Often inefficient** - High time and space complexity
- ❌ **Not scalable** - Becomes impractical for large inputs

#### Common Complexity Patterns:

| Pattern          | Complexity     | Example                     |
|------------------|----------------|-----------------------------|
| All Combinations | O(2^n)         | Subsets, Power Set          |
| All Permutations | O(n!)          | Arranging n items           |
| Nested Loops     | O(n²) or O(n³) | Checking all pairs/triplets |

#### Example: Finding a Pair with Target Sum (Brute Force)

```java
// Time: O(n²) - nested loops
// Space: O(1) - no extra space
public boolean hasPairWithSum(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                return true;
            }
        }
    }
    return false;
}

// Optimized with HashSet: O(n) time, O(n) space
public boolean hasPairWithSumOptimized(int[] arr, int target) {
    Set<Integer> seen = new HashSet<>();
    for (int num : arr) {
        if (seen.contains(target - num)) return true;
        seen.add(num);
    }
    return false;
}
```

---

## ⏱️ Time Complexity Deep Dive

Time complexity measures the **growth rate** of an algorithm's runtime relative to input size.

#### Key Points:

- Expressed using **Big O notation**: O(n), O(log n), O(n²), etc.
- Focuses on **scalability**, not exact runtime
- Helps predict performance as data grows
- Considers **worst-case** scenario by default

#### Example:

```java
// O(1) - Constant time
public int getFirst(int[] arr) {
    return arr[0];  // Always 1 operation
}

// O(n) - Linear time
public int sum(int[] arr) {
    int total = 0;
    for (int num : arr) {  // n operations
        total += num;
    }
    return total;
}

// O(n²) - Quadratic time
public void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {       // n iterations
        for (int j = 0; j < arr.length; j++) {   // n iterations each
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```

---

## 💾 Space Complexity Deep Dive

Space complexity measures the **growth rate** of an algorithm's memory usage relative to input size.

#### What Counts Toward Space Complexity?

1. **Variables**: Local variables, parameters
2. **Data Structures**: Arrays, lists, maps, sets
3. **Recursive Call Stack**: Space used by function calls
4. **Auxiliary Space**: Extra space used (excluding input)

#### Memory Types:

- **RAM** (Primary focus)
- **Disk Storage** (Databases, files)
- **Cache Memory**

#### Example:

```java
// O(1) Space - Constant space
public int findMax(int[] arr) {
    int max = arr[0];  // Only 1 variable
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}

// O(n) Space - Linear space
public int[] doubleArray(int[] arr) {
    int[] result = new int[arr.length];  // New array of size n
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i] * 2;
    }
    return result;
}

// O(n) Space - Recursive stack
public int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);  // n recursive calls on stack
}
```

---

## 📊 Big O Notation

Big O notation describes the **upper bound** of an algorithm's growth rate, focusing on worst-case performance.

#### Key Principles:

- **Ignores constants**: O(2n) → O(n)
- **Ignores lower terms**: O(n² + n) → O(n²)
- **Focuses on dominant term**: The fastest-growing term matters
- **Describes scalability**: How algorithm behaves as input grows

#### Why Simplify?

```java
// This code has 3n + 5 operations
public void example(int[] arr) {
    int x = 5;              // 1 operation
    int y = 10;             // 1 operation
    int z = x + y;          // 1 operation

    for (int i = 0; i < n; i++) {    // n operations
        System.out.println(arr[i]);
    }

    for (int i = 0; i < n; i++) {    // n operations
        arr[i] = arr[i] * 2;
    }

    for (int i = 0; i < n; i++) {    // n operations
        arr[i] = arr[i] + 1;
    }
}
// Total: 3n + 3 operations
// Big O: O(n) - constants and lower terms ignored
```

---

## 🚀 Common Complexity Classes

Understanding different complexity classes helps choose the right algorithm:

| Complexity     | Name         | Description                     | Example Operations                |
|----------------|--------------|---------------------------------|-----------------------------------|
| **O(1)**       | Constant     | Same time regardless of input   | Array access, HashMap get/put     |
| **O(log n)**   | Logarithmic  | Halves the problem each step    | Binary search, balanced tree ops  |
| **O(n)**       | Linear       | Grows proportionally with input | Simple loop, linear search        |
| **O(n log n)** | Linearithmic | Efficient sorting algorithms    | Merge sort, quick sort, heap sort |
| **O(n²)**      | Quadratic    | Nested loops                    | Bubble sort, selection sort       |
| **O(n³)**      | Cubic        | Triple nested loops             | Matrix multiplication (naive)     |
| **O(2ⁿ)**      | Exponential  | Doubles with each input         | Recursive fibonacci, subsets      |
| **O(n!)**      | Factorial    | All permutations                | Traveling salesman (brute force)  |

#### Growth Comparison:

```
For n = 10:
O(1)      = 1
O(log n)  = 3
O(n)      = 10
O(n log n)= 30
O(n²)     = 100
O(2ⁿ)     = 1,024
O(n!)     = 3,628,800

For n = 20:
O(1)      = 1
O(log n)  = 4
O(n)      = 20
O(n log n)= 86
O(n²)     = 400
O(2ⁿ)     = 1,048,576
O(n!)     = 2.4 × 10¹⁸  (impractical!)
```

#### Visual Representation:

```
Performance (lower is better):
═══════════════════════════════════
Excellent:  O(1), O(log n)
Good:       O(n), O(n log n)
Fair:       O(n²)
Poor:       O(n³)
Bad:        O(2ⁿ)
Terrible:   O(n!)
```

#### Detailed Examples:

**O(1) - Constant Time:**

```java
public int getElement(int[] arr, int index) {
    return arr[index];  // Always 1 operation
}
```

**O(log n) - Logarithmic Time:**

```java
// Binary search: halves search space each iteration
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

**O(n) - Linear Time:**

```java
public int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {  // n operations
        if (arr[i] > max) max = arr[i];
    }
    return max;
}
```

**O(n log n) - Linearithmic Time:**

```java
// Merge sort: divides array and merges
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);      // Divide: log n levels
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);   // Merge: n operations per level
    }
}
```

**O(n²) - Quadratic Time:**

```java
// Bubble sort: nested loops
public void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

**O(2ⁿ) - Exponential Time:**

```java
// Naive fibonacci: each call makes 2 more calls
public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### How do you decide a big o notation is expected or not?

- for any problem if the solution the number of oper is between 10 power 7 to 10 power 8 then we can say that the
  solution is expected to pass the time limit. if the number of oper is more than 10 power 8 then we can say that the
  solution is not expected to pass the time limit. if the number of oper is less than 10 power 7 then we can say that
  the solution is always expected to pass the time limit.
- for example, i have problem with arrays and after my analysis the algotithm takes o(n^2) time complexity and the input
  size is 10^5 then the number of oper will be 10^10 which is more than 10 power 8 so we can say that the solution is
  not expected to pass the time limit. if the input size is 10^4 then the number of oper will be 10^8 which is equal to
  10 power 8 so we can say that the solution is expected to pass the time limit. if the input size is 10^3 then the
  number of oper will be 10^6 which is less than 10 power 7 so we can say that the solution is always expected to pass
  the time limit.in this situation of input size is 10^5 we need to look for more efficient algorithm with better time
  complexity such as O(n log n) or O(n) to solve the problem in a reasonable amount of time and with less memory usage.
- we can decide based on the input limit. for example if 0<n<10^12 here input limit itsellf exceed the the time limit.
  it indirectly suggest that this problem solution using time complexity of o(nlogn).which suggest solution includes
  binary search or some devide and concure approach.

### myth about time complexity

example 1

```java
for(int i = 0;
i<n;i++){
        // this loop runs n times
        }
```

example 2

```java
for(int i = 0;
i<n;i+=2){

        }
```

here both the loops have time complexity of O(n) because in the first loop it runs n times and in the second loop it
runs n/2 times which is also O(n) because we ignore constant factors in big O notation. so both the loops have the same
time complexity of O(n).
here secons loop takes half time compare to first loop for same n value. here we are calculation relative time
complexity not absolute time complexity. so we can say that both the loops have the same time complexity of O(n) because
we are interested in the growth rate of the algorithm as the input size increases, rather than the exact number of
operations performed.

### Space complexity

- space complexity is a measure of the amount of memory an algorithm uses as a function of the input size.
- it is expressed using Big O notation (e.g., O(1), O(n)).
- space complexity helps us understand how much additional memory the algorithm will require as the input size
  increases.
- for example, if an algorithm has a space complexity of O(1), it means that the algorithm uses a constant amount of
  memory regardless of the input size. This means that the algorithm will not require any additional memory as the input
  size increases, making it efficient in terms of space usage.
- Space complexity depends on local variable used, data Structure used, recursive stack space used, and auxiliary space
  used.
- for example, if an algorithm uses a local variable to store a value, it will require O(1) space complexity because the
  amount of memory used does not depend on the input size.
- if an algorithm uses a data structure such as an array or a list to store values, it will require O(n) space
  complexity because the amount of memory used depends on the input size.
- if an algorithm uses recursion, it will require O(n) space complexity because the recursive stack space used depends
  on the depth of the recursion, which can be proportional to the input size.
- if an algorithm uses auxiliary space, it will require O(n) space complexity because the amount of memory used depends
  on the input size.

### Arrays

- an array is a data structure that stores a fixed number of values of the same type in contiguous memory locations.
- suppose i have created a int array of size 10. it allocate 4 byte memory for each element of the array because int
  data type takes 4 byte memory. so total memory allocated for the array will be 4*10 = 40 byte.
- i want to store value into 2nd index of the array using arr[2] =20. it calulate the memory address of the 2nd index by
  using the formula: memory address of arr[0] + (index * size of each element). so it will calculate as memory address
  of arr[0] + (2 * 4) = memory address of arr[0] + 8. so it will store the value 20 at the memory address calculated for
  arr[2].
- time complexity of accessing an element in an array is O(1) because we can directly access any element in the array
  using its index, regardless of the size of the array. this is because arrays are stored in contiguous memory
  locations, which allows for efficient access to elements using an index.
- space complexity of an array is O(n) because the amount of memory used by an array depends on the size of the array.
  for example, if we create an array of size 10, it will require O(10) space complexity because it will use a fixed
  amount of memory to store 10 elements. if we create an array of size n, it will require O(n) space complexity because
  it will use a variable amount of memory that depends on the input size n.
- array are linear data structure because the elements in an array are stored in a linear sequence, and each element can
  be accessed using its index. for example, if we have an array of integers, we can access the elements of the array
  using an index, such as array[0] to access the first element, array[1] to access the second element, and so on. this
  allows us to traverse the array in a linear manner, making it a linear data structure.
- array are ordered data structure because the elements in an array are stored in a specific order, and each element has
  a specific index that corresponds to its position in the array. for example, if we have an array of integers, the
  first element will be at index 0, the second element will be at index 1, and so on. this allows us to maintain the
  order of the elements in the array, making it an ordered data structure.
- Array are homogeneous data structure because they store values of the same type. for example, if we have an array of
  integers, all the elements in the array must be of type int. if we try to store a value of a different type, such as a
  string or a float, it will result in a compile-time error.
- Array are static data structure because the size of the array is fixed at the time of creation and cannot be changed
  during runtime. for example, if we create an array of size 10, we cannot add or remove elements from the array after
  it has been created. if we try to add an element to the array that exceeds its size, it will result in an
  ArrayIndexOutOfBoundsException.
- Array are stored in contiguous memory locations, which allows for efficient access to elements using an index. for
  example, if we have an array of integers, we can access the elements of the array using an index, such as array[0] to
  access the first element, array[1] to access the second element, and so on. this allows for constant time access to
  elements in the array, making it an efficient data structure for storing and accessing data.
- Array are mutable data structure because we can change the values of the elements in the array after it has been
  created. for example, if we have an array of integers, we can change the value of an element in the array by assigning
  a new value to it, such as array[0] = 5 to change the value of the first element to 5. this allows us to modify the
  contents of the array without having to create a new array, making it a flexible data structure for storing and
  manipulating data.
- Array are zero indexed data structure because the index of the first element in the array is 0. for example, if we
  have an array of integers with 10 elements, the index of the first element will be 0, the index of the second element
  will be 1, and so on, up to the index of the last element which will be 9. this allows us to access elements in the
  array using a simple and consistent indexing scheme, making it easier to work with arrays in programming languages.
- Array are used in many applications such as storing and manipulating data, implementing algorithms, and creating data
  structures such as lists, stacks, and queues. they are a fundamental data structure in computer science and are widely
  used in programming languages for various purposes.

### drawback of array

- fixed size: once an array is created, its size cannot be changed. this can lead to wasted memory if the array is not
  fully utilized, or it can lead to errors if we try to add more elements than the array can hold.
- inefficient insertion and deletion: inserting or deleting elements in an array can be inefficient because it may
  require shifting elements to maintain the order of the array. for example, if we want to insert an element at the
  beginning of the array, we would need to shift all existing elements one position to the right, which can be
  time-consuming for large arrays.
- lack of flexibility: arrays are homogeneous data structures, meaning they can only store values of the same type. this
  can limit their flexibility in certain applications where we may want to store different types of data together.
- inefficient searching: searching for an element in an unsorted array can be inefficient because it may require
  checking each element until a match is found. for example, if we have an unsorted array of integers and we want to
  find a specific value, we may need to check each element in the array until we find a match, which can be
  time-consuming for large arrays. in contrast, other data structures such as hash tables or binary search trees can
  provide more efficient searching capabilities.
    - memory fragmentation: if we create multiple arrays of different sizes, it can lead to memory fragmentation, where
      there are small gaps of unused memory between the arrays. this can lead to inefficient use of memory and can make
      it difficult to allocate larger arrays in the future.
    - lack of built-in functionality: arrays may not have built-in functionality for certain operations, such as
      resizing or dynamic allocation. this can require additional code to implement these features, which can increase
      the complexity of the program and make it more difficult to maintain. in contrast, other data structures such as
      lists or vectors may provide built-in functionality for resizing and dynamic allocation, making them more
      convenient to use in certain applications.
    - limited data manipulation: arrays may not provide efficient methods for manipulating data, such as sorting or
      filtering. for example, if we want to sort an array of integers, we may need to implement a sorting algorithm such
      as bubble sort or quicksort, which can be time-consuming for large arrays. in contrast, other data structures such
      as lists or sets may provide built-in methods for sorting and filtering, making them more convenient to use in
      certain applications.
    - lack of support for complex data structures: arrays may not be suitable for representing complex data structures
      such as trees or graphs, which require more flexible and dynamic data structures. for example, if we want to
      represent a binary tree, we may need to use a different data structure such as a linked list or a hash table,
      which can provide more efficient ways to store and manipulate the data. in contrast, arrays may not be able to
      efficiently represent these types of data structures, making them less suitable for certain applications.
    - limited functionality for multi-dimensional data: while arrays can be used to represent multi-dimensional data,
      they may not provide efficient methods for manipulating this data. for example, if we want to perform operations
      such as matrix multiplication or convolution on a multi-dimensional array, we may need to implement complex
      algorithms that can be time-consuming and difficult to optimize. in contrast, other data structures such as
      tensors or sparse matrices may provide more efficient methods for manipulating multi-dimensional data, making them
      more suitable for certain applications.
    - lack of support for dynamic data: arrays may not be suitable for representing dynamic data that can change in size
      or structure over time. for example, if we want to represent a list of items that can be added or removed
      dynamically, we may need to use a different data structure such as a linked list or a hash table, which can
      provide more efficient ways to store and manipulate the data. in contrast, arrays may not be able to efficiently
      represent dynamic data, making them less suitable for certain applications.\
    - limited support for concurrent access: arrays may not be suitable for applications that require concurrent access
      to data, as they may not provide efficient methods for synchronizing access to the data. for example, if we have
      multiple threads accessing an array simultaneously, we may need to implement complex synchronization mechanisms to
      prevent
    - data corruption or race conditions. in contrast, other data structures such as concurrent queues or hash tables
      may provide built-in support for concurrent access, making them more suitable for certain applications.
    - lack of support for sparse data: arrays may not be suitable for representing sparse data, where most of the
      elements are empty or zero. for example, if we want to represent a large matrix with mostly zero values, using an
      array may lead to inefficient use of memory. in contrast, other data structures such as sparse matrices or hash
      tables may provide more efficient ways to represent sparse data, making them more suitable for certain
      applications.
    - limited support for non-primitive data types: arrays may not be suitable for representing non-primitive data types
      such as objects or structures, which require more complex data structures. for example, if we want to represent a
      collection of objects with different properties and methods, using an array may not provide the necessary
      functionality to manipulate the data effectively. in contrast, other data structures such as lists or hash tables
      may provide more efficient ways to represent non-primitive data types, making them more suitable for certain
      applications.
    - lack of support for dynamic resizing: arrays may not be suitable for applications that require dynamic resizing,
      as they may not provide efficient methods for resizing the array. for example, if we want to add more elements to
      an array that has already reached its maximum size, we may need to create a new array with a larger size and copy
      the existing elements to the new array, which can be time-consuming and inefficient. in contrast, other data
      structures such as lists or vectors may provide built-in support for dynamic resizing, making them more convenient
      to use in certain applications.
    - limited support for complex operations: arrays may not provide efficient methods for performing complex operations
      such as searching, sorting, or filtering. for example, if we want to search for a specific value in an unsorted
      array, we may need to check each element until we find a match, which can be time-consuming for large arrays. in
      contrast, other data structures such as hash tables or binary search trees may provide more efficient searching
      capabilities, making them more suitable for certain applications.
    - lack of support for advanced data manipulation: arrays may not provide efficient methods for performing advanced
      data manipulation tasks such as grouping, aggregation, or transformation. for example, if we want to group
      elements in an array based on certain criteria, we may need to implement complex algorithms that can be
      time-consuming and difficult to optimize. in contrast, other data structures such as data frames or databases may
      provide more efficient methods for performing advanced data manipulation tasks, making them more suitable for
      certain applications.
    - limited support for distributed computing: arrays may not be suitable for applications that require distributed
      computing, as they may not provide efficient methods for distributing data across multiple nodes or machines. for
      example, if we want to process a large dataset that exceeds the memory capacity of a single machine, using an
      array may not be feasible. in contrast, other data structures such as distributed arrays or distributed hash
      tables may provide more efficient ways to distribute data across multiple nodes, making them more suitable for
      certain applications.
    - lack of support for data persistence: arrays may not be suitable for applications that require data persistence,
      as they may not provide efficient methods for storing and retrieving data from disk or other storage media. for
      example, if we want to store a large dataset that exceeds the memory capacity of a single machine, using an array
      may not be feasible. in contrast, other data structures such as databases or file systems may provide more
      efficient methods for storing and retrieving data, making them more suitable for certain applications.
    - limited support for data integrity: arrays may not provide efficient methods for ensuring data integrity, such as
      validation or error checking. for example, if we want to ensure that the values stored in an array meet certain
      criteria, we may need to implement complex validation algorithms that can be time-consuming and difficult to
      optimize. in contrast, other data structures such as databases or data frames may provide built-in support for
      data integrity, making them more suitable for certain applications.
    - lack of support for data security: arrays may not provide efficient methods for ensuring data security, such as
      encryption or access control. for example, if we want to protect sensitive data stored in an array, we may need to
      implement complex encryption algorithms that can be time-consuming and difficult to optimize. in contrast, other
      data structures such as databases or secure storage systems may provide built-in support for data security, making
      them more suitable for certain applications.
    - limited support for data visualization: arrays may not provide efficient methods for visualizing data, such as
      charts or graphs. for example, if we want to create a visual representation of the data stored in an array, we may
      need to implement complex algorithms that can be time-consuming and difficult to optimize. in contrast, other data
      structures such as data frames or visualization libraries may provide more efficient methods for visualizing data,
      making them more suitable for certain applications.
    - lack of support for data analysis: arrays may not provide efficient methods for performing data analysis tasks
      such as statistical analysis or machine learning. for example, if we want to perform a regression analysis on a
      dataset stored in an array, we may need to implement complex algorithms that can be time-consuming and difficult
      to optimize. in contrast, other data structures such as data frames or machine learning libraries may provide more
      efficient methods for performing data analysis tasks, making them more suitable for certain applications.

### Resizable Arrays

- resizable arrays, also known as dynamic arrays, are a type of array that can grow or shrink in size as needed. they
  are implemented using a fixed-size array that is resized when the number of elements exceeds the current capacity.
  when the array needs to be resized, a new array with a larger capacity is created, and the existing elements are
  copied to the new array. this allows for efficient memory usage while still providing the benefits of an array data
  structure. resizable arrays are commonly used in programming languages such as Java (ArrayList) and Python (list) to
  provide a flexible and dynamic way to store and manipulate data. they offer the advantages of arrays, such as constant
  time access to elements, while also allowing for dynamic resizing to accommodate changing data needs. however, it is
  important to be aware of the potential performance implications of resizing, as it can involve copying elements and
  may lead to increased time complexity in certain scenarios. overall, resizable arrays provide a convenient and
  efficient way to manage dynamic data while still leveraging the benefits of an array data structure.
- ArrayList and vector
- when we create array list it creates an array with an initial capacity of 10. when we add elements to the array list
  and it exceeds the initial
  capacity, it creates a new array with a larger capacity (usually double the current capacity) and copies the existing
  elements to the new array. this process is known as resizing. for example, if we add 11 elements to the array list, it
  will create a new array with a capacity of 20 and copy the existing 10 elements to the new array before adding the
  11th element. this allows the array list to dynamically grow in size as needed while still providing efficient access
  to
  elements. however, it is important to note that resizing can be a costly operation in terms of time complexity, as it
  involves copying elements from one array to another. therefore, it is recommended to set an appropriate initial
  capacity
  for the array list if we know that we will be adding a large number of elements to avoid frequent resizing and improve
  performance.
- time complexity of adding an element to an array list is O(1) on average, but it can be O(n) in the worst case when
  the array needs to be resized. this is because when the array reaches its capacity, a new array with a larger capacity
  is created, and all existing elements are copied to the new array before adding the new element. however, since
  resizing happens infrequently (usually when the number of elements exceeds the current capacity), the average time
  complexity for adding an element to an array list is O(1). it is important to note that if we know that we will be
  adding a large number of elements to the array list, it is recommended to set an appropriate initial capacity to avoid
  frequent resizing and improve performance.
- space complexity of an array list is O(n) because the amount of memory used by an array list depends on the number of
  elements it contains. as we add elements to the array list, it may need to resize the underlying array to accommodate
  the new elements, which can lead to increased memory usage. however, the space complexity is still O(n) because it
  grows linearly with the number of elements in the array list. it is important to note that if we know that we will be
  adding a large number of elements to the array list, it is recommended to set an appropriate initial capacity to avoid
  frequent resizing and improve performance, as this can help reduce memory usage and improve efficiency. overall, array
  lists provide a convenient and efficient way to manage dynamic data while still leveraging the benefits of an array
  data structure, but it is important to be aware of the potential performance implications of resizing and memory usage
  when working with large datasets.
- advantages of array list:
    - dynamic resizing: array lists can grow or shrink in size as needed, allowing for efficient memory usage while
      still
      providing the benefits of an array data structure.
    - constant time access: array lists provide constant time access to elements, allowing for efficient retrieval and
      manipulation of data.
    - built-in methods: array lists often come with built-in methods for common operations such as adding, removing, and
      searching for elements, making them convenient to use in programming languages.
    - flexibility: array lists can store elements of different types (if using a generic implementation), providing
      flexibility in managing diverse data.
    - efficient iteration: array lists allow for efficient iteration over elements using loops or iterators, making it
      easy
      to process and manipulate data stored in the list.
- disadvantages of array list:
    - resizing overhead: when the array list needs to resize, it can lead to increased time complexity due to copying
      elements to a new array, which can impact performance, especially when adding a large number of elements.
    - memory usage: array lists may use more memory than necessary if the initial capacity is set too high, leading to
      inefficient memory usage.
    - not suitable for large datasets: if we need to store a large number of elements, an array list may not be the most
      efficient data structure, as it may require frequent resizing and lead to increased time complexity.
    - lack of thread safety: array lists are not thread-safe, meaning that if multiple threads access and modify the
      list concurrently, it can lead to data corruption or unexpected behavior. synchronization mechanisms may be needed
      to ensure thread safety when using array lists in multi-threaded environments.
        - limited functionality: while array lists provide built-in methods for common operations, they may not offer
          the same level of functionality as other data structures such as linked lists or hash tables, which may be
          more suitable for certain applications that require specific operations or performance characteristics.
    