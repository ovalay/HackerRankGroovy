package codestorm

/**
 * Created by Tim Sloan on 29/10/15.
 */


System.in.withReader { br ->
    int seconds = br.readLine().toInteger()
    BigInteger count = 1
    def total = 0
    for (int i in 1..seconds) {
        if (!(i % 2))
            count ++
        total += count
    }
    println total
}