// Descrição
// O padrão de projeto Adapter é um padrão de projeto estrutural que permite que objetos com interfaces 
// incompatíveis trabalhem juntos. Ele atua como um intermediário, adaptando a interface de uma classe 
// para outra interface esperada pelo cliente.
//  
// Neste desafio, você deverá implementar um conversor de moedas que permitirá que valores monetários 
// sejam convertidos de dólares americanos (USD) para euros (EUR). Embora exista uma taxa de conversão 
// direta de 1 USD = 0.85 EUR, o nosso sistema inicialmente só suportava a conversão de USD para libras 
// esterlinas (GBP). Utilizando o padrão Adapter, você deve adaptar esse sistema antigo para fornecer a 
// nova funcionalidade de conversão direta para EUR, usando a conversão intermediária para GBP.

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    fun convertUSDtoGBP(amount: Double): Double {
        return amount * 0.80 // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR

class CurrencyAdapter(private val oldConverter: OldCurrencyConverter) {
    fun convertUSDtoEUR(amount: Double): Double {
        val gbpAmount = oldConverter.convertUSDtoGBP(amount)
        return gbpAmount * 1.0625
    }
}

fun main() {
    val input = readLine()?.toDoubleOrNull() ?: return
    val oldConverter = OldCurrencyConverter()
    val adapter = CurrencyAdapter(oldConverter)

    val amountInEUR = adapter.convertUSDtoEUR(input)

    println("USD: $input")
    println("EUR: $amountInEUR")
}
