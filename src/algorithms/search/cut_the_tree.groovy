package algorithms.search

/**
 * Created by Tim Sloan on 15/10/15.
 */

/*
Problem Statement

Atul is into graph theory, and he is learning about trees nowadays. He observed that the removal of an edge from a given tree T will result in the formation of two separate trees, T1 and T2.

Each vertex of the tree T is assigned a positive integer. Your task is to remove an edge, such that the Tree_diff of the resultant trees is minimized. Tree_diff is defined as the following:

 F(T) = Sum of numbers written on each vertex of a tree T
 Tree_diff(T) = abs(F(T1) - F(T2))
Input Format
The first line will contain an integer N, i.e. the number of vertices in the tree.
The next line will contain N integers separated by a single space, i.e. the values assigned to each of the vertices.
The next N−1 lines contain a pair of integers eah, separated by a single space, that denote the edges of the tree.
In the above input, the vertices are numbered from 1 to N.

Output Format
A single line containing the minimum value of Tree_diff.

Constraints
3≤N≤105
1≤ number written on each vertex ≤1001

Sample Input

6
100 200 100 500 100 600
1 2
2 3
2 5
4 5
5 6
Sample Output

400
Explanation

Originally, we can represent tree as

         1(100)
          \
           2(200)
          / \
    (100)5   3(100)
        / \
  (500)4   6(600)
Cutting the edge at 1 2 would result in Tree_diff = 1500-100 = 1400
Cutting the edge at 2 3 would result in Tree_diff = 1500-100 = 1400
Cutting the edge at 2 5 would result in Tree_diff = 1200-400 = 800
Cutting the edge at 4 5 would result in Tree_diff = 1100-500 = 600
Cutting the edge at 5 6 would result in Tree_diff = 1000-600 = 400

Hence, the answer is 400.
 */

System.in.withReader { br ->
    int verticies = br.readLine().toInteger()
    List values = br.readLine().tokenize()*.toInteger()
    def totalSum = values.sum()
    def lowest

    Map theTree = [:]
    Map<Integer,List> edges = new HashMap<Integer,List>()
    verticies.times {
        theTree.put((it+1), [(it+1)])
        edges.put((it+1), [])
    }

    (verticies-1).times {
        final input = br.readLine().tokenize()*.toInteger()
        theTree[input.get(0)] << input.get(1)
        theTree[input.get(1)] << input.get(0)
        edges[input.get(0)] << input.get(1)
    }

    edges.each { edgeskeyVal ->

        List edgeConnections = []
        edgeConnections.addAll(edgeskeyVal.value)

        for (value in edgeConnections) {
            def copiedTree = new HashMap()
            copiedTree.putAll(theTree)

            def connections = []
            connections.addAll(copiedTree[edgeskeyVal.key])
            connections.removeAll { val -> val == value }
            copiedTree[edgeskeyVal.key] = connections

            List connections2 = []
            connections2.addAll(copiedTree[value])
            connections2.removeAll { val -> val == edgeskeyVal.key }
            copiedTree[value] = connections2

            def discoveredNodes =  getSizeOfTreeAtNode(1, copiedTree)
            def mySum = 0
            for (int i in discoveredNodes) {
                mySum += values.get(i-1)
            }
            def sumTreeB = totalSum - mySum
            def diff = (mySum - sumTreeB).abs()

            if (lowest == null)
                lowest = diff
            else {
                if (diff < lowest)
                    lowest = diff
            }
        }
    }
    println lowest
}

Set getSizeOfTreeAtNode(int root, Map vertices) {
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
    discovered
}