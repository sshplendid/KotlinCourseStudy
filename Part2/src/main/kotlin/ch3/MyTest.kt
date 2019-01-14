// 가상 패키지 선언 가능
package ch3.one

import ch3.MyFile
import ch3.data
// import할 때 이름 바꾸어 사용 가능
import ch3.printData as someFun

fun main(args: Array<String>) {
    val obj = MyFile()

    // 문자열 템플릿 개념
    println("data: $data. obj data: ${obj.data}")
    someFun()

   // top level에서 선언된 변수, 함수는 파일명+kt.class로 묶인다.
    // 그런데 코틀린 코드에서 그 파일을 직접 이용할 수는 없다.

    // `:w
    // MyFileKt.data // error
}
