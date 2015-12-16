package algorithms.implementation

/**
 * Not a great problem to solve, so I didn't bother putting down the question asked. Don't bother figuring it out,
 * it isn't worth the time
 */
System.in.withReader { br ->
    int testCases = br.readLine().toInteger()
    testCases.times {
        def number = br.readLine()
        def currentTotal = 0
        def chars = number.toCharArray()
        chars.each{
            if (it.toString().toInteger() != 0 && (number.toBigInteger() % it.toString().toInteger()) == 0)
                currentTotal++
        }
        println currentTotal
    }
}