
/*
Problem Statement

You're given an array containing integer values. You need to print the fraction of count of positive numbers, negative numbers and zeroes to the total numbers. Print the value of the fractions correct to 3 decimal places.

Input Format

First line contains N, which is the size of the array.
Next line contains N integers A1,A2,A3,⋯,AN, separated by space.

Constraints
1≤N≤100
−100≤Ai≤100
Output Format

Output three values on different lines equal to the fraction of count of positive numbers, negative numbers and zeroes to the total numbers respectively correct to 3 decimal places.

Sample Input

6
-4 3 -9 0 4 1
Sample Output

0.500
0.333
0.167

 */
import java.math.MathContext

System.in.withReader { br ->

    int sizeArray = br.readLine().toInteger()
    def inputs = br.readLine().split()*.toInteger()

    double d = (inputs.findAll{it > 0}.size() / sizeArray).round(new MathContext(3))
    println "$d".padRight(5, '0')
    double e = (inputs.findAll{it < 0}.size() / sizeArray).round(new MathContext(3))
    println "$e".padRight(5, '0')
    double f =  (inputs.findAll{it == 0}.size() / sizeArray).round(new MathContext(3))
    println "$f".padRight(5, '0')
}

