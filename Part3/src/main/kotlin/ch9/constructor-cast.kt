package ch9

open class Super(no: Int) {
    constructor(no: Int, name: String) : this(no) {
        println("super constructor....")
    }

    init {
        println("super init...")
    }
}

class Sub(no: Int): Super(no, "Shawn") {
    constructor(no: Int, name: String) : this(no) {
        println("sub constructor")
    }

    init {
        println("sub init....")
    }
}

// Singleton: 클래스의 인스턴스가 하나만 생성
class Singleton private constructor() {
    var data: Int = 0;

    fun foo() {
        println("Singleton foo.. ${data}")
    }

    companion object { // inner class
        // 이 안에 정의된 멤버는 outter 클래스 명으로 마치 static 멤버처럼 이용 가능
        val instance: Singleton by lazy { Singleton() }
    }
}

// Builder 패턴
// AlertDialog.Builder builder = new AlertDialog.Builder()

class AlertDialog private constructor(val message: String) {
    var data: Int = 0

    companion object Builder {
       fun build(msg: String): AlertDialog {
           return AlertDialog(msg)
       }
    }
}


fun main(args: Array<String>) {
    Sub(10, "Kim")

    val child: Super = Sub(10) // 하위 -> 상위: smart casting
    val obj2: Sub = child as Sub   // 상위 -> 하위: `as` 연산자로

    // nullable casting
    val obj3: Super? = null
    val obj4: Sub? = obj3 as? Sub // `as` 사용하면 TypeCastException 발생

    // singleton
    val singleton1 = Singleton.instance
    val singleton2 = Singleton.instance
    println("singleton diff 1: ${singleton1.data}, 2: ${singleton2.data}")
    singleton1.data = 10
    println("singleton diff 1: ${singleton1.data}, 2: ${singleton2.data}")
    singleton2.data = 20
    println("singleton diff 1: ${singleton1.data}, 2: ${singleton2.data}")

    println("${singleton1 == singleton2}, ${singleton1 === singleton2}")


    // builder
    val builder = AlertDialog.Builder
    val dialog1 = builder.build("hello")
    val dialog2 = builder.build("world")
    println("${dialog1.message}, ${dialog2.message}")
}