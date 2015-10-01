package dynamicProgramming

/**
 * Created by Tim Sloan on 01/10/15.
 */

/*
Problem Statement

Given an array A={a1,a2,…,aN} of N elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Hint: Kadane algorithm

Input Format

First line of the input has an integer T. T cases follow.
Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

Constraints:

1≤T≤10
1≤N≤105
−104≤ai≤104
The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2
4
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case:
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case:
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 */

System.in.withReader { br ->
    br.readLine().toInteger().times {
        int sizeArray = br.readLine().toInteger()
        def theArray = br.readLine().tokenize()*.toInteger()

        println "${findMaxContiguousArray(theArray)} ${findMaxNonContiguousArray(theArray)}"
    }
}

def findMaxContiguousArray(List theArray) {
    def bestSum = 0
    def currentSum = 0

    for (int i in theArray) {
        if (currentSum + i <= 0) {
            currentSum = 0
        } else {
            currentSum = currentSum + i
            if (currentSum > bestSum) {
                bestSum = currentSum
            }
        }
    }
    if (bestSum == 0)
        return theArray.max()
    else return bestSum
}

def findMaxNonContiguousArray(List theArray) {
    List res = theArray.findAll { it >= 0 }
    if (res.isEmpty())
        return theArray.max()
    return res.sum()
}