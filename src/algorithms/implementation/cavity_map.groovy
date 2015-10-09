package algorithms.implementation

/**
 * Created by Tim Sloan on 22/09/15.
 */

/*
Problem Statement

You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, n, denoting the size of the map. Each of the following n lines contains n positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints
1≤n≤100
Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
 */

System.in.withReader { br ->
    int numberLines = br.readLine().toInteger()

    if (numberLines < 3)
        numberLines.times {println br.readLine()}

    List firstLine = br.readLine().toList()*.toInteger()
    def secondLine = br.readLine()?.toList()*.toInteger()
    def thirdLine = br.readLine()?.toList()*.toInteger()

    def lineSize = firstLine.size()
    List results = []
    results << firstLine

    (numberLines-2).times {
        results << checkLines(firstLine, secondLine, thirdLine, lineSize)
        firstLine = secondLine
        secondLine = thirdLine
        if (it != numberLines -3)
            thirdLine = br.readLine().toList()*.toInteger()
    }
    results << thirdLine
    results.each{List vals -> println vals.join()}
}

def checkLines(List firstLine, List secondLine, List thirdLine, int lineSize) {
    List result = []
    result << secondLine.get(0)
    (1..lineSize-2).each {
        int currentVal = secondLine.get(it)
        int topVal =  firstLine.get(it)
        int bottomVal = thirdLine.get(it)
        int leftVal = secondLine.get(it-1)
        int rightVal = secondLine.get(it+1)

        if (currentVal > topVal && currentVal > bottomVal && currentVal > leftVal && currentVal > rightVal) {
            result << 'X'
        }
        else {
            result << currentVal
        }
    }
    result << secondLine.get(lineSize-1)
}