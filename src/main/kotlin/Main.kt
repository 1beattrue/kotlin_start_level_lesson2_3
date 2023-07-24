import java.lang.Exception

private val name: String? = null // создание переменной, которая может быть null

fun main() {
    // println(name.length) не сработает, ибо переменная может быть null

    try {
        println(name!!.length) // 1 способ, для любителей NPE
    } catch (e: Exception) {
        println(e)
    }

    println(name?.length) // 2 способ
    // эта запись фактически означает следующее
    if (name != null) println(name.length) else println(null)

    // заметим, что переменная, со значением name?.length будет типа Int?, то есть нулабельный инт
    val nameLength = name?.length

    // можно привести это значение к другому нулабельному типу, например
    val nameLengthString = nameLength?.toString()

    // если мы не хотим хранить в переменной нулабельный тип, то стоит сделать следующее
    val nameLengthInt = name?.length?:0 // теперь в переменной будет храниться либо длина строки, либо 0

    // домашнее задание: есть три null строки, нужно сложить их длины
    val a: String? = null
    val b: String? = "null"
    val c: String? = null

    val lenA = a?.length?:0
    val lenB = b?.length?:0
    val lenC = c?.length?:0

    println(lenA + lenB + lenC)

    // правильный ответ
    val res = (a?.length?:0) + (b?.length?:0) + (c?.length?:0)
    println(res)
}