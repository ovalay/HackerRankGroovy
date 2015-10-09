package algorithms.graphs

/**
 * Created by Tim Sloan on 06/10/15.
 */

/*Problem Statement

You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

        To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

Input Format
The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

Output Format
Print the answer, a single integer.

Constraints
2 <= N <= 100.

        Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

        Sample Input

10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Sample Output

2
Explanation
On removing edges (1, 3) and (1, 6), we can get the desired result.

See https://www.hackerrank.com/challenges/even-tree for diagram of tree in this example
*/

System.in.withReader { br ->
    def input = br.readLine().tokenize()*.toInteger()
    int vertices = input.get(0)
    int edges = input.get(1)

    //set up graph as map of lists, each key representing a node with value of list of connected nodes
    Map theGraph = new HashMap()
    vertices.times {
        theGraph.put((it+1), [it+1])
    }

    edges.times {
        input = br.readLine().tokenize()*.toInteger()
        theGraph[input.get(1)] << input.get(0)
    }

    int result = 0
    //DFS algorithm
    (2..vertices).each {
        //println "size of tree at $it is ${getSizeOfTreeAtNode(it, theGraph)}"
        //could be improved here using memoisation
        if (getSizeOfTreeAtNode(it, theGraph) % 2 == 0)
            result ++
    }
    println result
}

int getSizeOfTreeAtNode(int root, Map vertices) {
    List currentEdges = []
    Set discovered = currentEdges as Set
    vertices.get(root).each { currentEdges << it} // 1 based index
    while (currentEdges) {
        int v = currentEdges.pop()
        if (!discovered.contains(v)) {
            discovered << v
            vertices.get(v).each {currentEdges << it}
        }
    }
    discovered.size()
}