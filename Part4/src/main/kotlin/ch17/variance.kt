package ch17

open class Super

class Sub: Super()

class Foo<out T> // 하위타입으로 선언된 객체를 상위 타입에 대입

fun testVariance() {
    val obj: Super = Sub() // OK, variance
}

fun testInvariance() {
    val obj = Foo<Sub>()
    val obj1 = Foo<Super>()

    val obj2: Foo<Super> = obj // OK
    // val obj3: Foo<Sub> = obj1 // error
}

fun main(args: Array<String>) {
    testVariance()
    testInvariance()
    val n: Nothing? = null
}
