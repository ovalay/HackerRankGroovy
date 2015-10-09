package algorithms.search

/**
 * Created by Tim Sloan on 08/10/15.
 */

/*
Problem Statement

You are given a matrix with m rows and n columns of cells, each of which contains either 1 or 0. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected and filled (i.e. cells that contain a 1) cells form a region. There may be several regions in the matrix. Find the number of cells in the largest region in the matrix.

Input Format
There will be three parts of t input:
The first line will contain m, the number of rows in the matrix.
The second line will contain n, the number of columns in the matrix.
This will be followed by the matrix grid: the list of numbers that make up the matrix.

Output Format
Print the length of the largest region in the given matrix.

Constraints
0<m<10
0<n<10

Sample Input:

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output:

5
Task:
Write the complete program to find the number of cells in the largest region.


*/

System.in.withReader { br ->


    //note, if some reading of input seems bizarre, it is because of bad test input data from hackerrank.
    int num_rows = br.readLine().trim().toInteger()
    int num_cols
    line = br.readLine()
    while (line == "") {
        line = br.readLine()
    }
    num_cols = line.trim().toInteger()
    def array = []

    for (int i in 0..num_rows-1) {
        line = br.readLine()
        while (line == "") {
            line = br.readLine()
        }
        array[i] = line.trim().tokenize()*.toInteger().toArray()
    }

    int maxSize = 0

    for (int r in 0..num_rows-1) {
        for (int c in 0..num_cols-1) {
            def sizeTree = getSizeOfTreeAtNode(array, r, c, num_rows - 1, num_cols - 1)
//            println "Final size starting at $r$c is $sizeTree"
            if (sizeTree && sizeTree > maxSize)
                maxSize = sizeTree
        }
    }

    println maxSize
}

int getSizeOfTreeAtNode(List<List>array, int row, int col, int maxRow, int maxCol) {
    if (!array[row][col])
        return 0
    List currentEdges = []
    Set discovered = currentEdges as Set
    discovered << "$row$col".toString() //need to string, otherwise gstring will be added and wont be picked up by contains comparison with string below
    currentEdges.addAll(getConnected(row, col, maxRow, maxCol, array)) // 1 based index
    while (currentEdges) {
        String v = currentEdges.pop()
        if (!discovered.contains(v)) {
            discovered << v
            List rowCol = v.split('')
            def clean = rowCol.findAll { item -> !item.isEmpty() }
            row = clean[0].toInteger()
            col = clean[1].toInteger()
            currentEdges.addAll(getConnected(row, col, maxRow, maxCol, array))
            array[row][col] = 0
        }
    }
    discovered.size()
}

List getConnected(int row, int col, int maxRow, int maxCol, List<List>array) {
    results = []
    if (row > 0) {
        results.addAll(getEdgesForRow(array[row-1], col, maxCol).collect{"${row-1}" << it})
    }
    if (col > 0) {
        if (array[row][col-1] == 1)
            results << "$row${col-1}"
    }
    if (col < maxCol) {
        if (array[row][col+1] == 1)
            results << "$row${col+1}"
    }
    if (row < maxRow) {
        results.addAll(getEdgesForRow(array[row+1], col, maxCol).collect{"${row+1}" << it})
    }
    return results
}

List getEdgesForRow(theRow, int col, int maxCol) {
    rowResults = []
    if (col > 0) {
        if (theRow[col-1] == 1)
            rowResults << col-1
    }
    if (theRow[col] == 1)
        rowResults << col
    if (col < maxCol) {
        if (theRow[col+1] == 1)
            rowResults << col+1
    }
    return rowResults
}