package org.example.com.rockthejvm

object OOPInKotlin {

    //Classes

    open class Pet{ //by default classes are not extendable without open
        //properties
        val age = 0

        //functions (methods) = pieces of behavior

        open fun eat(): Unit{       //open - method can be overridden in child classes
            println("I'm eating something!!")
        }

        companion object{
            // Properties and methods of Pet TYPE
            // static Boolean humanLoveGuaranteed = true
            //Everything is static
            val humanLoveGuaranteed = true
        }
    }

    val aPet = Pet()   // instantiation = construction
    // aPet = An instance of Pet

    // Inheritance

    class Dog(val name: String) : Pet(){
        //name is not a property, it is part of constructor
        // val/var name  is a property
        // Constructor arguments are NOT properties unlesss prefixed with val/var
        //Additional properties, methods, parameters etc

        override fun eat() {
            println("Don't disturb me while Eating!!")
        }


    }

    val aDog = Dog("Loki")
    val aDogName = aDog.name

    // SubType Polymorphism
    val myPet: Pet = Dog("Bruno")

    //Abstract Classes
    abstract class WalkingPet {
        val hasLegs = true
        abstract fun walk(): Unit // May not necessarily have an implementation
    }

    //interface
    interface Carnivore {
        fun eat(animal : Pet): Unit     //all methods are implicitly abstract in interface
    }

    interface ColdBlooded

    // inheritance model: a class can inherit from One class and > 0 interfaces

    class Snake: Pet(), Carnivore, ColdBlooded{
        override fun eat(animal: Pet): Unit {
            println("I will eat you, I'm a Carnivore")
            //additional properties, methods, overrides
        }
    }

    // Access Modifiers: protected, private
    // Method Overloading

    // objects and companions

    object MyObject{
        // singleton pattern in one line
        // Singleton = Type + the ONLY instance of that type
        //Can define properties and methods

        val aProperty = 100
        fun aMethod(arg: Int): Int {
            println("Hello from Singleton: $arg")
            return aProperty + arg
        }

    }

    // data classes (Java: records, Scala: case classes)

    data class Person(val name: String, val age: Int)
    // meant to be passed around and stored in eg Collections
    //equals, hashCode, toString
    //copy
    //destructuring -> eg: bob

    //Exceptions

    val maybeFailure = try{
        //code that can crash
        val aString = "Kotlin"
        aString.substring(10, 20) //Crash
    }catch (e: Exception){
        "Some Faulty Error Message"
    }finally {
        // Execute some code no matter what
    }

    // generics - Java, Scala, C#, TypeScript

    interface MyLinkedList<T>{      //<T> Type parameter
        // Can use the type T inside the definition of the methods/properties
        // In Scala we have [] instead of <>

        fun head(): T       // eg - first element of the LL
        fun tail(): MyLinkedList<T> //eg - rest of the LL except the head

    }

    // Real Collections
    val numberList : List<Int> = listOf(1, 2, 3, 4, 5)// , "Kotlin is cool") // Type should match
    val first = numberList[0]   //element at index 0

    val stringList = listOf("Kotlin", "Rocks")
    val firstString = stringList[0]



    @JvmStatic
    fun main(args: Array<String>) {

        aPet.eat()
        aDog.eat()
        println(aDogName)
        println(aDog.name)
        //println(myPet.name) It is not the instance of Dog
        myPet.eat()     //eat method from Dog will be called at runtime

        println("Using Singleton")
        println(MyObject.aProperty)
        println(MyObject.aMethod(50))
        println(Pet.humanLoveGuaranteed)

        val bob = Person("Bob", 32)
        val (name, age) = bob       // val bobName = bob.name; val bobAge = bob.age
    }
}