// Desafio
// Faça um programa que receba a média de um aluno e imprima o seguinte:

// Caso a média seja < 5 imprima "REP";
// Caso a média seja >= 5 e < 7 imprima "REC";
// Caso a média seja >7 imprima "APR".

fun main() {
    val media = readLine()!!.toDouble();

    when {
    media < 5 -> println("REP");
    media < 7 && media>= 5 -> println("REC");
    else -> println("APR")
    }
}
