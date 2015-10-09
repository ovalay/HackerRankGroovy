package algorithms.warmup

/*
Problem Statement

Your teacher has given you the task to draw the structure of a algorithms.warmup.staircase. Being an expert programmer, you decided to make a program for the same. You are given the height of the algorithms.warmup.staircase. You need to print a algorithms.warmup.staircase as shown in the example.

Input Format

You are given an integer N depicting the height of the algorithms.warmup.staircase.

Constraints
1≤N≤100
Output Format

Draw a algorithms.warmup.staircase of height N in the format given below.

For example:

     #
    ##
   ###
  ####
 #####
######
Staircase of height 6, note that last line has 0 spaces before it.
 */

System.in.withReader { br ->
    int sizeStaircase = br.readLine().toInteger()

    sizeStaircase.times {
        def outputLeft =  " " * (sizeStaircase - it -1)
        def outputRight = "#" * (it + 1)
        println outputLeft << outputRight
    }
}