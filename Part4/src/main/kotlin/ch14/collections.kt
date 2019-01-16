package ch14

import com.google.gson.Gson
import java.io.File

data class Data(val id: Int, val name: String, val addr: String, val age: String)

fun main(args: Array<String>) {
    val file: File = File("Part4/out/production/resources/test.json")
    val inputStream = file.inputStream()
    val input = inputStream.bufferedReader().use { it.readText() }

    println(input)

    var gson = Gson()

    // Array<Data>::class.java  // 데이터를 담기 위한 reflection 정보를 지정
    // Gson이 코틀린 라이브러리였으면 // Array<Data>::class
    var list: List<Data> = gson.fromJson(input, Array<Data>::class.java).toList()


    list.filter { it.addr.equals("seoul") }
        .groupBy { it.age }
        .forEach {
            println("${it.key} - ${it.value.count() }")
            it.value.forEach {
                it.run {
                    println("  ${name} - ${addr} - ${age}")
                }
            }
        }

}
