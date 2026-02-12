package org.example.com.rockthejvm

object FPinKotlin {

    // ability to use functions as values

    fun multiply10(arg: Int): Int = arg * 10
    // fun -> methods of class

    val tenXFun : (Int) -> Int = fun(x: Int): Int { return x * 10 }    // Saves steps
    val tenXFun_V2 = { x: Int -> x * 10} //Lambda Expression

    // multi arg Lambda

    val adderFun = {a: Int, b: Int -> a + b }

    // Collections

    val numberList = listOf<Int>(1,2,3,4,5,6,7,8,9,10)

    val tenXNumbersList = numberList.map(tenXFun)    // Passed a Lambda
    val tenXNumbersList_V2 = numberList.map({ x: Int -> x * 10 })  //Equivalent
    val tenXNumbersList_V3 = numberList.map { x: Int -> x * 10 }   //Can remove () if last argument is Lambda -> Preferred
    val tenXNumbersList_V4 = numberList.map { x -> x * 10 } //Shorthand, compiler type inference
    val tenXNumbersList_V5 = numberList.map { it * 10 } // Same

    // functional API
    // filtering
    val evenNumbers = numberList.filter { x -> x % 2 == 0 }

    //reducing
    val numbersSum = numberList.reduce{ partialSum, elem -> partialSum + elem}  //accumulator

    //processing with predicates
    val firstEven = numberList.find { x -> x % 2 == 0 }     //Nullable i.e. may not return anything
    val oddPrefix = numberList.takeWhile { x -> x % 2 != 0 }    //[1]
    val evenNumbersCount = numberList.count {it % 2 == 0}       //All elements
    val stringRep = numberList.joinToString ( " | ", "{", "}" ) { x: Int -> x.toString()}


    @JvmStatic
    fun main(args: Array<String>) {

        println(tenXFun(17))
        println(adderFun(10, 75))
        println(numbersSum)
        println(firstEven)
        println(oddPrefix)
        println(evenNumbersCount)
        println(stringRep)

    }
}