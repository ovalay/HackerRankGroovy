package algorithms.greedy

/**
 * Created by Tim Sloan on 16/11/15.
 */

/*
Problem Statement

Mark and Jane are very happy after having their first kid. Their son is very fond of toys, so Mark wants to buy some. There are N different toys lying in front of him, tagged with their prices, but he has only $K. He wants to maximize the number of toys he buys with this money.

Now, you are Mark's best friend and have to help him buy as many toys as possible.

Input Format
The first line contains two integers, N and K, followed by a line containing N space separated integers indicating the products' prices.

Output Format
An integer that denotes maximum number of toys Mark can buy for his son.

Constraints
1<=N<=105
1<=K<=109
1<=price of any toy<=109
A toy can't be bought multiple times.

Sample Input

7 50
1 12 5 111 200 1000 10
Sample Output

4
Explanation

He can buy only 4 toys at most. These toys have the following prices: 1,12,5,10.
 */
System.in.withReader { br ->

    def inputs = br.readLine().tokenize()*.toInteger()
    int money = inputs[1]

    def sortedPrices = br.readLine().tokenize()*.toInteger().sort()
    def total = 0
    def toysBought = 0

    while ( total <= money) {
        total += sortedPrices.remove(0)
        if (total <= money)
            toysBought++
    }

    println toysBought

}