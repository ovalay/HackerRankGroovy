package warmup
/**
 * Created by tim sloan on 21/09/15.
 */

/*
Problem Statement

The Head Librarian at a library wants you to make a program that calculates the fine for returning the book after the return date. You are given the actual and the expected return dates. Calculate the fine as follows:

If the book is returned on or before the expected return date, no fine will be charged, in other words fine is 0.
If the book is returned in the same month as the expected return date, Fine = 15 Hackos × Number of late days
If the book is not returned in the same month but in the same year as the expected return date, Fine = 500 Hackos × Number of late months
If the book is not returned in the same year, the fine is fixed at 10000 Hackos.
Input Format

You are given the actual and the expected return dates in D M Y format respectively. There are two lines of input. The first line contains the D M Y values for the actual return date and the next line contains the D M Y values for the expected return date.

Constraints
1≤D≤31
1≤M≤12
1≤Y≤3000
Output Format

Output a single value equal to the fine.

Sample Input

9 6 2015
6 6 2015
Sample Output

45
 */
System.in.withReader { br ->
    Date actualReturn = Date.parse('dd MM yyyy', br.readLine())
    Date expectedReturn = Date.parse('dd MM yyyy', br.readLine())

    if (actualReturn.before(expectedReturn)) {
        println 0
        return
    }
    if (actualReturn.getAt(Calendar.YEAR) > expectedReturn.getAt(Calendar.YEAR)) {
        println 10000
    } else {
        if (actualReturn.getAt(Calendar.MONTH) > expectedReturn.getAt(Calendar.MONTH)) {
            println  (500 * (actualReturn.getAt(Calendar.MONTH) - expectedReturn.getAt(Calendar.MONTH)))
        } else {
            println (15 * (actualReturn.getAt(Calendar.DAY_OF_MONTH) - expectedReturn.getAt(Calendar.DAY_OF_MONTH)))
        }
    }
}