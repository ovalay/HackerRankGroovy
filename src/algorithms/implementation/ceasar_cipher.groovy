package algorithms.implementation

/**
 * Created by Tim on 15/10/2015.
 */

/*
Problem Statement

Julius Caesar protected his confidential information from his enemies by encrypting it. Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are given a string S and the number K. Encrypt the string and print the encrypted string.

For example:
If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched.
'm' becomes 'o' when letters are rotated twice,
'i' becomes 'k',
'-' remains the same because only letters are encoded,
'z' becomes 'b' when rotated twice.

Input Format

Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.

Constraints
1?N?100
0?K?100
S is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string.

Sample Input

11
middle-Outz
2

Sample Output

okffng-Qwvb

 */

System.in.withReader { br ->
    int size = br.readLine().toInteger()
    String input = br.readLine().trim()
    int shift = br.readLine().toInteger()


    for (char c in input) {
        if (c.isLetter()) {
            boolean isLower = c.isLowerCase()
            char c1 = c.toLowerCase()
            shift.times {
                if (c1 == 'z')
                    c1 = 'a'
                else
                    c1 = c1.next()
                }
            if (!isLower)
                c1 = c1.toUpperCase()
            print c1
        }
        else {
            print c
        }
    }
}