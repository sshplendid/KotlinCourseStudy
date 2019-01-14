package ch4

val data1: Int = 1
var data2: Int = 2

class MyClass {
    val data3: Int = 3
    var data4: Int = 4

    fun some() {
        // 지역변수만 선언과 동시에 초기화하지 않아도 됨
        val data5: Int

        data5 = 1

        val result = data5 + 10 // error, 지역변수 초기화가 선행되어야 사용 가능함

    }

    // Nullable vs Non-nullable
    var data6: Int? = null

    var myBool = false
    /*
    \val은 값 변경이 불가능, 하지만 상수는 아님
     항상 초기값을 리턴한다고 보장할 수 없음
    코틀린에서 변수는 property이고 일반 변수처럼 보이지만
    getter/setter 함수를 내장한 개념이어서 값 변경은 불가능하지만
    getter 함수를 어떻게 작성했는가에 따라 동일 값이 반환된다고 보장할 수 없다
    ==> 상수와는 다르다!!!
    */
    // val valData: Int = 10 // 일반적인 경우
    val valData: Int
    get() {
        if(myBool) return 100
        else return 0
    }
}

fun main(args: Array<String>) {
    val obj = MyClass()
    println("valData: ${obj.valData}")

    obj.myBool = true
    println("valData: ${obj.valData}")
}