package org.example.com.rockthejvm

object BasicsOfKotlin {
    @JvmStatic
    fun main(args: Array<String>) {

        val meaningOfLife: Int = 42 // final int meaningOfLife = 42

        val newInt = 42 // Auto Type Inference by Compiler
        // meaningOfLife = 43 // Error - Val are "Immutable"

        var objectiveInLife = 32
        objectiveInLife = 50

        //String

        val aString = "I Love Kotlin"
        val aTemplate = "The meaning of life is $meaningOfLife" // Similar to s"" of Scala

        println(aTemplate)

        //Expressions

        val anExpression = 2 + 3

        val aCondition = 1 > 2
        if(aCondition){
            println("If True")
        }else{
            println("If False")
        }

        val anIfExpression = if(aCondition) 42 else 999 //This is an expression
        println(anIfExpression)

        // "Switch on Steroids" = when expression

        when(meaningOfLife){    //Instruction
            42 -> println("Forty Two")      // case
            43 -> println("Forty Three")
            else -> println("Something Else")       //default
        }

        // when structure becomes a when expression

        val meaningOfLifeExpression = when (meaningOfLife){ //Expression
            42 -> "Forty Two"
            43 -> "Forty Three"
            else -> "Something Else"
        }

        println(meaningOfLifeExpression)

        //Looping
        println("Inclusive Range 1 - 10")
        for(i in 1..10){
            print(i)
            print(" ")
        }

        println()
        println("Range 1 - Excluding 10")
        for(i in 1..<10){
            print(i)
            print(" ")
        }

        println()
        println("Range 1 - Excluding 10 V2")
        for(i in 1 until 10){
            print(i)
            print(" ")
        }

        println()
        println("Inclusive Range 1 - 10 Step 2 - Odd Numbers")
        for(i in 1 .. 10 step 2){
            print(i)
            print(" ")
        }

        println()
        println("Inclusive Range 10 to 1")
        for(i in 10 downTo 1){
            print(i)
            print(" ")
        }

        println()
        println("Inclusive Range 10 - 1 step 3")
        for(i in 10 downTo 1 step 3){
            print(i)
            print(" ")
        }

        // Arrays and List
        println("Iterating over a Collection")

        val aList = listOf(1, 5, 4, 2, 3)
        for(element in aList){
            print(element)
        }

        // while loops
        println("While Loops")

        var i = 1
        while(i <= 10){
            print(i)
            print(" ")
            i += 1
        }

        println("Do - While")

        do{
            println(i)
            i-= 1
        }while( i > 0)

        //Functions
        println("Functions")
        fun concatenateString(aString: String, count: Int): String {
            var result = ""
            for(i in 1 .. count){
                result += aString
            }
            return result
        }

        // single-expressionn function

        fun combineString(strA: String, strB: String) = "$strA +++++ $strB"

//        fun combineString(strA: String, strB: String) : String {
//            return "$strA +++++ $strB"     // One Expression
//        }

        // Unit = void
        // void functionReturningVoid(String args)

        fun functionReturningVoid(arg: String): Unit{
            println("This is a String: $arg")
        }

    }
}