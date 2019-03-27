# Simple Subject 2x Classes

# Mark 3: 
## Create class `Product` with the following attributes:
### - `productName` of type `String`;
### - `category` of type `String`;
### - `price` of type `double`; 
### - All the attributes must be `private`;
 
## Create class `ShoppingCart` with the following attributes:
### -`products` of type `List<Product>`;
### -`applyDiscount` of type `boolean`;
### -`discountPercentage` of type `double`;
### - All the attributes must be `private`;

# Mark 4: 
## Create access modifiers for the classes: `Product` and `ShoppingCart` respecting the camelCase format:
### -`public ATTR_TYPE getAttributeName()`
### -`public void setAttributeName()`
### - Each `setter` must have validation

# Mark 5: 
## Implement Cloneable and Comparable in class `Product`

# Mark 6:
## Implement equals() and hashCode();

# Mark 7:
## Create a class named `ShopUtils` with 2 methods:
### - `public void writeShoppingCartBinary()`
### - `public ShoppingCart readShoppingCartBinary()`

# Mark 8-9:
## Create 2 methods in the `ShopUtils` class:
### - `public Map<String, Integer> formatShoppingCart(List<Product> products)` where the key is the name of the product and the value is represented by the number of products with that name from the `products` list.
### - `public Set<Product> getUniqueProducts(List<Product> products)` that should return all the unique products from the shopping cart;

# Mark 10:
## Create a method that takes an argument of type `ShoppingCart` that should compute the final price using `map` and `reduce`:
### - public double computeFinalPrice(ShoppingCart cart);


