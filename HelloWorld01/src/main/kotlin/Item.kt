
/*
items need to hold a name, price and quantity
Need to be able to return subtotal of price and quantity
 */
class Item (var name: String?, var price: Float, var quantity: Int) {

    // subtotal of item based on price and quantity
    fun itemSubtotal(price: Float, quantity: Int): Float {
        return price * quantity
    }

}