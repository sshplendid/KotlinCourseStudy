package ch3

import java.text.SimpleDateFormat
import java.util.*

class MyFile {
    val data = 0
    fun some() {
        println("MyFile... some()")
    }
}

/*
  Top level에 변수, 함수 선언 가능
  java의 static member들은 top level에 작성한다.
  코틀린에서는 static 예약어가 없다.
  top level 변수, 함수는 동일 패키지에서 전역멤버가 된다.
*/

val data=20

fun printData() {
    // 객체 생성할 때 `new` 연산자를 사용하지 않는다.
    val date = Date()
    val sdformat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    println(sdformat.format(date))

    /*
    함수형 프로그래밍에선 함수가 First class citizen이 될 수 있어야 한다.
    함수 내에 함수 선언 가능
     */

    fun some() {
        println("printDatata... some()")
    }

    // 함수 내 클래스 선언 가능
    class MyClass {
        val data=0
        fun some() {
        println("printData... MyClass... some()... $data")
       }
    }

    some()
    val obj=MyClass()
    obj.some()
}

fun main(args: Array<String>) {
    val obj = MyFile()
    obj.some()
    printData()
}