println "this is a refresher for groovy"

3.times {println it }

def myString = "12345"
println myString.toList().class.name
println myString.toList()
println myString.toList().collect{it.toInteger()}.sum()

println myString.findAll {it.toInteger() % 2 == 0}