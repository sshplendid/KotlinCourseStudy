package ch5

import org.omg.CORBA.Object

fun foo(arg: Any) {
    // 코틀린에서는 자바의 switch-case가 없다.
    when(arg) {
        // 데이터 조건
        1 -> println("arg = 1")
        10, 20 -> println("arg is 10 or 20")
        30 -> {
            println("wow")
            println("arg 30")
        }
        "hello" -> println("arg hello")

        // 타입 조건
        is Int -> println("type Int")
        is Double -> println("type double")
    }
}

fun main(args: Array<String>) {
    foo(30)
    foo(11)
    foo("hello")


    // casting
    val data1: Int = 10
    // val data2: Double = data1 // error, 객체간 스마트 캐스팅 불가
    //val data2: Double = data1 as Double // runtime error, Double과 Int는 상속관계가 아님

    // 기초 타입 변형은 함수제공
    val data2: Double = data1.toDouble()
    val data4: String = data1.toString()
    val data5: Int = data4.toInt()

    // nullable은 non-nullable의 상위 타입
    val data6: Any = 10
    val data7: Any? = data6;
    //val data8: Any = data7 // error
    val data8: Any = data7 as Any

    // Java의 Object 클래스 사용 가능
    val data9: java.lang.Object = Object()
    // Any <- Object
    val data10: Any = data9
    val data11: java.lang.Object = data10 as java.lang.Object
}