package algorithms.greedy

/**
 * Created by Tim Sloan on 20/10/15.
 */

/*


Problem Statement

Given a squared sized grid G of size N in which each cell has a lowercase letter. Denote the character in the ith row and in the jth column as G[i][j].

You can perform one operation as many times as you like: Swap two column adjacent characters in the same row G[i][j] and G[i][j+1] for all valid i,j.

Is it possible to rearrange the grid such that the following condition is true?

G[i][1]≤G[i][2]≤⋯≤G[i][N] for 1≤i≤N and
G[1][j]≤G[2][j]≤⋯≤G[N][j] for 1≤j≤N

In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?

Note: c1≤c2, if letter c1 is equal to c2 or is before c2 in the alphabet.

Input Format

The first line begins with T, the number of testcases. In each testcase you will be given N. The following N lines contain N lowercase english alphabet each, describing the grid.

Output Format

Print T lines. On the ith line print YES if it is possible to rearrange the grid in the ith testcase or NO otherwise.

Constraints
1≤T≤100
1≤N≤100
Gij will be a lower case letter

Sample Input

1
5
ebacd
fghij
olmkn
trpqs
xywuv

Sample Output

YES

Explanation

The grid in the first and only testcase can be reordered to

abcde
fghij
klmno
pqrst
uvwxy

This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.

 */

System.in.withReader { br ->
    int testCases = br.readLine().toInteger()

    testCases.times {
        int sizeLine = br.readLine().toInteger()
        def grid = []
        sizeLine.times {
            String line = br.readLine().split('').sort().join('')
            grid << line
        }
        boolean sorted = true

        for ( col in 0..sizeLine-1) {
            String column = ''
            for ( row in 0..sizeLine-1) {
                column += grid[row].toString().charAt(col)
            }
            if (column != column.split('').sort().join('')) {
                sorted = false
            }
        }
        if (sorted)
            println "YES"
        else
            println "NO"
    }
}