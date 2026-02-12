package org.example.com.rockthejvm

object NicetiesInKotlin {
    //nullables

    data class Developer(val name: String, val favLanguage: String)

    //val maybeDeveloper: Developer = null        // Not Possible in Kotlin
    val maybeDeveloper : Developer? = null  // ?  Possible if the type is nullable
    // val devName = maybeDeveloper.name   // Not Possible because Developer is nullable
    // special protection of nullable

    data class Person(val name: String, val age: Int){

        infix fun likes(movie: String) = "$name says: I Love movie: $movie"

    }

    val prerit = Person("Prerit", 99)
    val preritStatement = prerit.likes("ZNMD")
    val preritStatement_V2 = prerit likes "ZNMD"    //Infix notation equivalent
    // Inflix notation if function only has one parameter

    class VectorClass(var x: Double, var y: Double) {
       operator fun plus(other: VectorClass) = VectorClass(x + other.x, y + other.y)

        operator fun get(index: Int): Double =
            when(index) {
                0 -> x
                1 -> y
                else -> throw IllegalArgumentException("Vectors only have 2 coordination")
            }

    }

    val a = VectorClass(1.0, 2.0)
    val b = VectorClass(5.0, 8.0)
    val aPb = a.plus(b)
    val aPb_V2 = a + b      // syntax sugar for a.plus(b)   //operator must be added to function
    // same rules for minus, times, div, rem(%)

    val aX = a.get(0)
    val aX_V2 = a[0]    // Equivalent

    //Extensions - new method to existing types after they have been defined - Outside

    operator fun Int.times(aString: String): String {
        var result = ""
        for(i in 1 .. this){
            result += aString
        }
        return result
    }

    val kotlinX3 = 3.times("Kotlin")
    // nicer APIs, Domain Specific Languages

    val kotlinX_V2 = 3 * "Kotlin"



    @JvmStatic
    fun main(args: Array<String>) {

        val devName = {
            if(maybeDeveloper == null) "Prerit Rathi"
            else maybeDeveloper.name       // Compiler knows that it is not null
        }

        val devName_V2 = maybeDeveloper?.name       //v2 is nullable
        //?. is a safe call operator

        val devName_definitive = devName_V2 ?: "Prerit Rathi" //?: Elvis Operator - or else

        val trueDevName = maybeDeveloper?.name ?: "Prerit Rathi"

        println(kotlinX3)
        println(kotlinX_V2)

    }
}