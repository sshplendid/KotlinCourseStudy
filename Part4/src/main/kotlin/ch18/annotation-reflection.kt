package ch18

import java.lang.reflect.Method

// Junit과 유사하게 동작하는 annotation을 만들고
// annotation이 추가된 test 클래스를 reflection 정보로 분석
// 특정 작업을 수행
annotation class TestBegin

annotation class TestEnd

annotation class TestEqualsInt(val expected: Int, val desc: String)

class Foo {
    fun bar(a: Int, b: Int): Int {
        return a + b
    }
}


class Test {
    val obj = Foo()

    @TestBegin
    fun begin() {
        println("begin...")
    }

    @TestEnd
    fun end() {
        println("end...")
    }

    @TestEqualsInt(expected = 10, desc="bar() equalsTest...")
    fun testBar(): Int {
        return obj.bar(5, 5)
    }

    @TestEqualsInt(expected = 10, desc="bar() want to fail...")
    fun testBarFailed(): Int {
        return obj.bar(4, 5)
    }
}


fun main(args: Array<String>) {
    sunit()
}

fun sunit() {
    val obj: Test = Test()
    val methods = Test::class.java!!.methods

    val beginMethods = mutableListOf<Method>()
    val endMethods = mutableListOf<Method>()
    val assertMethods = mutableListOf<Method>()

    for(method in methods) {
        if(method.isAnnotationPresent(TestBegin::class.java)) {
            beginMethods.add(method)
        } else if(method.isAnnotationPresent(TestEnd::class.java)) {
            endMethods.add(method)
        } else if(method.isAnnotationPresent(TestEqualsInt::class.java)) {
            assertMethods.add(method)
        }
    }

    for(m in beginMethods) {
        var args = arrayOfNulls<Any>(0)
        m.invoke(obj, *args) // 매개변수가 없어도 array를 넣어야 함
    }

    for(m in assertMethods) {
        val annotation = m.getAnnotation(TestEqualsInt::class.java)
        val expected = annotation.expected
        val desc = annotation.desc


        var args = arrayOfNulls<Any>(0)

        val actual = m.invoke(obj, *args) as Int

        if(expected == actual) {
            println("TEST success!")
        } else {
            println("TEST failed!")

        }
        println(" [${desc}] expected: ${expected}, actual: ${actual}")
    }

    for(m in endMethods) {
        var args = arrayOfNulls<Any>(0)
        m.invoke(obj, *args) // 매개변수가 없어도 array를 넣어야 함
    }
}
