// Descrição
// As Extension Functions, ou Funções de Extensão, são recursos poderosos disponíveis em linguagens de 
// programação que permitem adicionar métodos a classes existentes sem a necessidade de modificar o 
// código-fonte original dessas classes. Isso facilita a criação de novas funcionalidades ou comportamentos 
// para tipos de dados já existentes, mesmo quando você não tem acesso ao código fonte original desses tipos.

// Neste desafio, com foco em um sistema de gerenciamento de livros para uma biblioteca digital, você deve 
// implementar uma solução que permita gerar um "slug" único para representar os dados de um livro. 
// Um "slug" é uma versão simplificada e amigável para URLs de um texto, com espaços substituídos 
// por traços (-) e caracteres especiais removidos. A solução requer que você crie uma função de extensão 
// generateSlug() para a classe String que fará essa transformação.

// Funcionalidade a ser implementada:

// generateSlug(): Crie uma função de extensão chamada generateSlug() para a classe String. 
// A função deve gerar um "slug" para a string fornecida, removendo espaços e caracteres especiais, 
// substituindo-os por traços.

fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")

    println("$slugTitulo"+"_"+"$slugAutor")
}

fun String.generateSlug(): String {
    return this.replace(" ", "-").replace(".", "").toLowerCase()
}
