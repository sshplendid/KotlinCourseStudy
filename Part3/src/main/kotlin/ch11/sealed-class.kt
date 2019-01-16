package ch11

// 객체 생성이 안되는건 추상 클래스와 동일
// 외부에서 상속 불가(동일 파일 내에서만 가능)
abstract class AbstractClass private constructor()
// class Sub: AbstractClass() // error


// sealed class는 생성자가 이미 private으로 선언된 클래스
// 그래서 외부에서 상속 불가
// 단 내부에서만 상속되게 특별하게 처리되는 추상 클래스

sealed class SealedClass {
    class sub2: SealedClass()
}
class Sub1: SealedClass()

fun main(args: Array<String>) {
    println("${1}")
    println("foo...${foo()}")
}

fun foo() {
    1
}

val foo = { println("hello")}