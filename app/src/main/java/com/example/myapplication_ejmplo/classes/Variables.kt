package com.example.myapplication_ejmplo.classes

class Variables {

    fun main(){

        //Numbers variable
        val age:Int = 20
        val long_number:Long = 582927640777777
        val temperature:Float = 27.123f
        val weight:Double = 60.4

        //String
        val gender:Char = 'M'
        val name:String = "Ricardo Reyes"

        //Boolean
        val isGreater:Boolean = false

        //Array
        val names = arrayOf("Erik", "Silvia", "Hector", "Gabriela")

        println(age)
        println("WELCOME $name, to your first Kotlin project")

        println(add())

        println(product(10, 92))

    }

    fun add():Int{
        val x:Int = 5
        val y:Int = 10
        return (x+y)
    }

    fun product(x:Int, y:Int):Int{
        return(x+y)
    }
}