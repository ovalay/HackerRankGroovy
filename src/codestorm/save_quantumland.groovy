package codestorm

/**
 * Created by Tim Sloan on 29/10/15.
 */

System.in.withReader { br ->
    int testcases = br.readLine().toInteger()

    testcases.times {
        int n = br.readLine().toInteger()
        def theCities = br.readLine().tokenize()*.toInteger()
        int guardsRequired = 0
        if (n == 1) {
            guardsRequired = 0
        }
        else {
            for (int i in 0..n - 1) {
                if (theCities[i] != 1 && theCities[i + 1] != 1 && i < n - 1) {
                    guardsRequired++
                    theCities[i+1] = 1
                }
            }
        }
        println guardsRequired
    }
}