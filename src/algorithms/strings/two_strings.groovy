package algorithms.strings

/**
 * Created by Tim Sloan on 12/10/15.
 */

/*
Problem Statement

You are given two strings, A and B. Find if there is a substring that appears in both A and B.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

For the 1st test case, the letter o is common between both strings, hence the answer YES.
For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
 */

System.in.withReader { br ->
    int testCases = br.readLine().toInteger()

    Set inputSet = new HashSet(26) //assume max size 26 different letters

    testCases.times {
        inputSet.addAll(br.readLine().trim().toString().split(''))
        //still having probs with hackerrank test case input format. trim won't remove trailing blank created at end of string split
        //thus need to remove empty string below. If not done, solution fails on their env, although works perfectly locally either way
        inputSet.remove("")

        if (br.readLine().trim().split('').find{inputSet.contains(it.toString())})
            println "YES"
        else
            println "NO"
        inputSet.clear()
    }
}