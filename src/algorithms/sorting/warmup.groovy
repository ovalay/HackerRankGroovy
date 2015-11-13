package algorithms.sorting

/**
 * Created by Tim Sloan on 13/11/15.
 */

System.in.withReader { br ->
    int toFind = br.readLine().toInteger()
    br.readLine()
    println(br.readLine().tokenize()*.toInteger().indexOf(toFind))
}