package algorithms.search

/**
 * Created by Tim Sloan on 09/11/15.
 */

/*
Problem Statement

Given N integers, count the number of pairs of integers whose difference is K.

Input Format

The first line contains N and K.
The second line contains N numbers of the set. All the N numbers are unique.

Output Format

An integer that tells the number of pairs of integers whose difference is K.

Constraints:
N≤105
0<K<109
Each integer will be greater than 0 and at least K smaller than 231−1.

Sample Input

5 2
1 5 3 4 2
Sample Output

3
Explanation

There are 3 pairs of integers in the set with a difference of 2.
 */

System.in.withReader {br ->
    def cfg = br.readLine().tokenize()*.toInteger()
    def diff = cfg[1]
    def mapNumbers = [:]
    def total = 0

    def numbers = br.readLine().tokenize()*.toInteger()

    for (int i in numbers) {
        mapNumbers.put(i, 1)
    }

    for (int i in numbers) {
        if (mapNumbers[i+diff]) {
            total++
        }
    }

    println total
}