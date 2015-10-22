package algorithms.sorting

/**
 * Created by Tim Sloan on 22/10/15.
 */

/*
Problem Statement

Sorting is often useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses, as well.

Challenge
Given a list of unsorted integers, A={a1,a2,…,aN}, can you find the pair of elements that have the smallest absolute difference between them? If there are multiple pairs, find them all.

Input Format
The first line of input contains a single integer, N, representing the length of array A.
In the second line, there are N space-separated integers, a1,a2,…,aN, representing the elements of array A.

Output Format
Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line (consecutively) with just a single space between each pair of numbers. If there's a number which lies in two pair, print it two times (see the sample case #3 for explanation).

Constraints

2≤N≤200000
−107≤ai≤107
ai≠aj,where 1≤i<j≤N
Sample Input #1

10
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
Sample Output #1

-20 30
Explanation
(30) - (-20) = 50, which is the smallest difference.

Sample Input #2

12
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
Sample Output #2

-520 -470 -20 30
Explanation
(-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.

Sample Input #3

4
5 4 3 2
Sample Output #3

2 3 3 4 4 5
Explanation
Here, the minimum difference will be 1. So valid pairs are (2, 3), (3, 4), and (4, 5). So we have to print 2 once, 3 and 4 twice each, and 5 once.
 */

System.in.withReader { br ->
    int sizeArray = br.readLine().toInteger()
    def theArray = br.readLine().tokenize()*.toInteger().sort()
    def answers = []  //have to use a list here as the ordering of output is important, thus can't use the more logical choice of set for data structure
    int lowestDiff = Integer.MAX_VALUE

    for (num in 0..theArray.size()-2) {
        def diff = (theArray[num+1] - theArray[num]).abs()
        if (diff < lowestDiff) {
            answers.clear()
            answers.add("${theArray[num]} ${theArray[num+1]}")
            lowestDiff = diff
        }
        if (diff == lowestDiff) {
            if (!answers.contains("${theArray[num]} ${theArray[num+1]}"))
                answers.add("${theArray[num]} ${theArray[num+1]}")
        }

    }
    print answers.join(' ')
}