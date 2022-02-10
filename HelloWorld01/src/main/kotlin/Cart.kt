
/*
creates a list of Items
allows adding, removing and viewing items in the cart
 */
class Cart {

    val cart = mutableListOf<Item>()

    // If item is not null, add it to cart
    fun addItem(item: Item?) {
        if (item != null) {
            cart.add(item)
        }
    }

    // If item is not null, remove it from cart
    fun removeItem(item: Item) {
        cart.remove(item)
    }

    // use for loop to print each item object in cart
    // print subtotals for each item, and total at the end
    fun viewCart(cart: Cart) {
        var total = 0.0f
        println()
        println("---- CART ----")
        for (item in cart.cart) {
            println("x${item.quantity} ${item.name}: $${item.price} --> " +
                    "$${item.price.let { item.quantity.let { it1 -> item.itemSubtotal(it, it1) } }}")
            total += item.itemSubtotal(item.price, item.quantity)
        }
        println("Total: $${total}")
        println()
    }
}