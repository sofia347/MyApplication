package com.example.myapplication_ejmplo.classes

//class Variables {

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

        printArray(names)

        println(names.joinToString())
        
        val number = arrayOf(1,2,3,4,5,6,7,8,9)

        isEven(number)

        println(getDay(4))

        val person = Person("Andrea", 22)

        println(person.name)
        println(person.age)

        person.displayInformation()

    }

    fun add():Int{
        val x:Int = 5
        val y:Int = 10
        return (x+y)
    }

    fun product(x:Int, y:Int):Int{
        return x+y
    }

    fun printArray(names:Array<String>){
        for  (name in names){
            print("Hello $name")
        }
    }

    fun isEven(numbers:Array<Int>){
        for(number in numbers){
            if(number%2 == 0){
                println("The number $number is Even")
            }else{
                println("The number $number is Odd")
            }
        }
    }

    fun getDay(day:Int): String{
        var name = ""

        when(day){
            1 -> name = "Monday"
            2 -> name = "Tuesday"
            3 -> name = "Wednesday"
            4 -> name = "Thursday"
            5 -> name = "Friday"
            6 -> name = "Saturday"
            7 -> name = "Sunday"
            else -> name = "Incorrect value"
        }
        return name
    }

    class Person (val name: String, val age: Int){
        fun displayInformation(){
            println("Name: $name, Age: $age")
        }
    }

//}