package algorithms.strings

/**
 * Created by Tim Sloan on 18/02/16.
 */

/*
John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of NN rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, NN, the number of rocks.
Each of the next NN lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints
1≤N≤100
Each composition consists of only lower-case Latin letters ('a'-'z').
1≤1≤ length of each composition ≤100≤100

Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg

Sample Output

2

Explanation

Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
 */

System.in.withReader { br ->
    int stones = br.readLine().toInteger()
    def elementsMap = [:]
    stones.times {
        def stone = br.readLine().toCharArray()
        Set currentElementMap= []
        stone.each {
            currentElementMap << it
        }
        currentElementMap.each {

            if (elementsMap[it])
                elementsMap[it] += 1
            else
                elementsMap[it] = 1
        }
    }
    Map results = elementsMap.findAll{it.value == stones}
    //println results?.keySet().toArray().join(' ')
    println results.size()
}