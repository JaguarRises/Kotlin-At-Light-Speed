package org.example.com.rockthejvm

object CollectionsInKotlin {

    // lists, arrays, sets, maps
    val aList: List<Int> = listOf(1, 2, 3, 4)       //immutable
    // If I create a new list with same name -> This will be a different list
    // main API: Index of an element + size fo that list

    val  thirdElement: Int = aList.get(2)
    val thirdElementV2: Int = aList[2]  // equivalent
    val lengthOfList = aList.size

    //other API

    val find3 = aList.indexOf(3) //2    -1 if not present
    val has3 = aList.contains(3) // true - boolean

    val subList = aList.subList(1, 2) //(inclusive, exclusive)  //only element at index 1
    val with5 = aList.plus(5)   // add element at the end

    // Functional Programming - Later

    val mutableList = mutableListOf<Int>(1, 2, 3, 4, 5, 6)

    // arrays - very fast - map to JVM arrays -> map to OS arrays

    //much faster than mutable lists
    val anArray = arrayOf(1, 2, 3, 4, 5, 6, 7)

    //sets - cannot contain duplicates -  order cannot be guaranteed

    val aSet = setOf(1, 2, 3, 4, 2, 3, 1)   //immutable
    //API - contains

    val constains1 = aSet.contains(1)
    val constains1_V2 = 1 in aSet       // Equivalent

    //other API
    val add7 = aSet.plus(7) // an new set
    val without3 = aSet.minus(3)

    //mutable set
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 3, 2, 4)


    // Maps - Key Value Associations
    val phoneBook: Map<String, Int> = mapOf(
        Pair("Prerit", 1234),
        "Seeta" to 9876 //syntactic sugar equivalent
    )

    // main API : contains a key

    val hasPrerit = phoneBook.contains("Prerit")
    val hasPreit_V2 = "Preirt" in phoneBook

    val preritNumber = phoneBook.get("Prerit")
    val preritNumber_V2 = phoneBook["Prerit"]




    @JvmStatic
    fun main(args: Array<String>) {

        mutableList[2] = 99
        mutableList.set(2, 99) // equivalent

        println(aSet)
        println(mutableSet)

        println(phoneBook)
    }
}