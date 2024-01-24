// Descrição
// No mundo da programação, frequentemente enfrentamos situações onde múltiplas tarefas precisam 
// ser executadas simultaneamente para otimizar o tempo de resposta ou processamento. 
// Um exemplo comum é o download de múltiplos arquivos da internet.
//  
// Para este desafio, suponha que você tenha uma lista de URLs que deseja "baixar". 
// Seu objetivo é simular o download desses arquivos de forma paralela e imprimir o 
// tamanho de cada URL após seu "download" ter sido disparado. Para simplificar, 
// cada URL leva exatamente 1 segundo para ser "baixado".
//  
// Requisitos:
//  
// Defina uma lista de URLs que você deseja "baixar".
// Crie uma função para simular o "download" de uma URL. Essa função deve aceitar uma URL como 
// entrada e retornar o tamanho da URL.
// Implemente uma lógica que permita iniciar o "download" de várias URLs em paralelo.
// Imprima o tamanho de cada URL na ordem em que foram inseridas.


fun main() {
    val urls = mutableListOf<String>()

    while (true) {
    val input = readLine() ?: break
    if (input.isBlank()) break
    urls.add(input)
    }

    println("Iniciando downloads...")

    // Cria uma lista de Pair (indice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    // Em Kotlin, Coroutines são uma opção mais idiomática e simples para operações assíncronas
    // e paralelas em comparação com Threads. No entanto, nosso editor de código atual
    // ainda não suporta Coroutines. Para mais detalhes, veja a documentação oficial:
    // https://kotlinlang.org/docs/coroutines-overview.html

    val threads = urls.mapIndexed { index, url ->
    Thread {
        val length = openLink(url)
        synchronized(results) {
        results.add(Pair(index, length))
        }
    }
    }

    // Inicia cada Thread para começar o processo de 'download' paralelamente
    threads.forEach { it.start() }
    
    // Aguarda até que todas as Threads terminem suas respectivas execuções
    threads.forEach { it.join() }

    // Ordena os resultados por índice para imprimir na ordem correta
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
    println("Arq${idx + 1}: ${result.second}")
    }
    println("Tempo total: ${urls.size}")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
    return url.length
}
