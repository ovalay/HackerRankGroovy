package algorithms.warmup
/**
 * Created by Tim Sloan on 21/09/15.
 */

/*
Problem Statement

You are given an integer N. Print the factorial of this number.

N!=N×(N−1)×(N−2)×⋯×3×2×1
Note: Factorials of N>20 can't be stored even in a 64−bit long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers but we need to write additional code in C/C++ to handle such large values.

We recommend solving this challenge using BigIntegers.

Input Format
Input consists of a single integer N.

Constraints
1≤N≤100

Output Format
Output the factorial of N.

Sample Input

25
Sample Output

15511210043330985984000000

 */

System.in.withReader { br ->
    def start = br.readLine().toBigInteger()
    if (start != 1) {
        (start - 1).downto(1) {  //begin with start-1, otherwise we end up multiplying by seed value an extra time
            start *= it
        }
    }
    println start
}