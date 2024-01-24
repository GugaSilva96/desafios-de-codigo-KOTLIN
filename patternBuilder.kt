// Descrição
// O Design Pattern "Builder" é uma técnica utilizada para criar objetos complexos passo a passo, 
// separando o processo de construção da representação final do objeto. Isso ajuda a melhorar a 
// legibilidade e a flexibilidade do código, especialmente quando você precisa criar objetos com muitos 
// parâmetros ou configurações diferentes.

// Neste desafio, buscando soluções para um problema de negócios em uma plataforma de e-commerce, 
// é necessário melhorar a forma como os pedidos personalizados são tratados. Você tem a opção de implementar 
// a solução utilizando o padrão Builder para criar pedidos de forma mais eficiente e organizada, 
// ou seguir uma abordagem alternativa sem a necessidade de utilizar o padrão Builder.

class Product(val name: String, val price: Double, val quantity: Int)

class CustomOrder private constructor(
    val customerName: String,
    val products: List<Product>,
    val total: Double,
    val deliveryAddress: String
) {
    /* Classe interna para "linkar" o Bulder com a classe CustomOrder */
    class Builder {
        private var customerName: String = ""
        private var products: MutableList<Product> = mutableListOf()
        private var deliveryAddress: String = ""

        fun setCustomerName(name: String) = apply { customerName = name }
        fun addProduct(product: Product) = apply { products.add(product) }
        fun setDeliveryAddress(address: String) = apply { deliveryAddress = address }

        fun build(): CustomOrder {
            val orderTotal = products.sumByDouble {it.price * it.quantity }
            return CustomOrder(customerName, products.toList(), orderTotal, deliveryAddress)
            }
        }

        fun printReceipt() {
            println("${this.customerName}")
            this.products.forEachIndexed { index, product ->
            println("${index + 1}. ${product.name} | ${product.price} | ${product.quantity}")
            }
        println("Total: ${this.total}")
        println("End: ${this.deliveryAddress}")
        }
}

fun main() {
    val customerName = readLine() ?: ""

    val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

    val numProducts = readLine()?.toIntOrNull() ?: 0
    for (i in 1..numProducts) {
        val productName = readLine() ?: ""
        val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
        val productQuantity = readLine()?.toIntOrNull() ?: 0

    orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
    }
    
    val deliveryAddress = readLine() ?: ""

    val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

    customOrder.printReceipt()
}
