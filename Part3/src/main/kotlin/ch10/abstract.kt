package ch10

abstract class Super {
    // Java에서 추상 변수 선언 불가
    // 코틀린의 변수는 property -> Java 메서드로 변환?
    abstract val foo: String

    open fun bar() {
        println("Super bar...")
    }
    abstract fun baz()
    open fun bah() {
        println("Super bah...")
    }
}

interface Walkable {
    val foo: String // 기본은 추상형

    // 컴파일 할때 field를 만들지 않기 때문에
    // val numberOfLegs: Int = 4
    val numberOfLegs: Int
        get() = 4

    fun bar() { println("Walkable bar...")}
    fun baz()
    fun bah()
}

interface MyInterface

class Sub: MyInterface, Super(), Walkable {
    override val foo: String
        get() = "Sub foo"

    override fun baz() {
        println("Sub baz")
    }

    override fun bar() {
        super<Walkable>.bar()
        super<Super>.bar()
    }

    override fun bah() {
        super.bah()
    }
}

fun main(args: Array<String>) {
    val obj = Sub()
    obj.bar()
    obj.baz()
    obj.bah()
}
