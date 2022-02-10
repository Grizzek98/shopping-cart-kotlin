
/*
initialize a cart and mainmenu options
operate mainmenu loop
 */
fun main() {
    val cart = Cart()
    val mainMenu = mutableListOf("Add", "Remove", "View", "Quit")

    while (true) {
        println("---- MAIN MENU ----")
        for (option in mainMenu) {
            println(option)
        }
        println()

        print("> ")
        when (readLine()) {
            "Add" -> addMenu(cart)
            "Remove" -> removeMenu(cart)
            "View" -> cart.viewCart(cart)
            "Quit" -> exitProcess(1)
        }
    }
}


/*
get user input for what to add
check to see if it exists
if yes, add quantity instead
otherwise, add item like normal
 */
fun addMenu(cart: Cart) {
    println("\n---- ADD ITEM ----")
    println("Please enter item name: ")
    print("> ")
    val name = readLine()

    for (item in cart.cart) {
        if (item.name == name) {
            println("\nItem ${item.name} found with quantity of ${item.quantity}.\n")
            println("Please enter quantity to add: ")
            print("> ")
            val quantity = readLine()

            if (quantity != null) {
                item.quantity += quantity.toInt()
                println("\nQuantity of $quantity added.\n")
                return
            }
        }
    }

    println("Please enter item price: ")
    print("> ")
    val price = readLine()

    println("Please enter item quantity: ")
    print("> ")
    val quantity = readLine()

    val item = price?.let { quantity?.let { it1 -> Item(name, it.toFloat(), it1.toInt()) } }
    cart.addItem((item))
    println()
}


/*
get user input for what to remove
check to make sure item exists
remove by quantity, either completely or partially
*/
fun removeMenu(cart: Cart) {
    println("\n---- REMOVE MENU ----")
    println("Please enter name of item to remove: ")
    print("> ")
    val name = readLine()

    for (item in cart.cart){
        if (item.name == name) {
            println("\nItem ${item.name} found with quantity of ${item.quantity}.\n")
            println("Please enter quantity to remove: ")
            print("> ")
            val quantity = readLine()

            if (quantity != null) {

                if (quantity.toInt() == item.quantity) {
                    cart.removeItem(item)
                    println("\nItem removed.\n")
                    return
                }

                if (quantity.toInt() > item.quantity) {
                    println("\nQuantity to remove cannot be greater than quantity.\n")
                    return
                }

                if (quantity.toInt() < item.quantity) {
                    item.quantity -= quantity.toInt()
                    println("\nQuantity reduced by $quantity.\n")
                    return
                }
            }
        }
    }

}


/*
I think this is the proper way to exit the program
Not positive I understood though...
*/
fun exitProcess(status: Int): Nothing {
    kotlin.system.exitProcess(status)
}

