package algorithms.search

/**
 * Created by Tim on 15/10/2015.
 */
System.in.withReader { br ->
    int aSize = br.readLine().toInteger()
    def aNums = br.readLine().tokenize()
    int bSize = br.readLine().toInteger()
    def bNums = br.readLine().tokenize()
    Map aMap = [:]
    Map bMap = [:]
    Set missingNums = []

    aNums.each {
        if (aMap[it])
            aMap[it] += 1
        else
            aMap[it] = 1
    }
    bNums.each {
        if (bMap[it])
            bMap[it] += 1
        else
            bMap[it] = 1
    }

    bMap.each {
        if (!aMap[it.key] || aMap[it.key] != bMap[it.key])
            missingNums.add(it.key)
    }
    println (missingNums.sort().join(' '))
}