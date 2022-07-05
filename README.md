# Coffee Shop App with Spring Boot

## Description
The back-end part (front-end only with Swagger, detailed below) of an online shop specialized in coffee related products.

This app allows you to find products, add them to a cart and place an order.
It also allows adding, updating and deleting products and users.

Login???

## How to Run

#### Pre-requirement
- IDE of your choice
- Spring Boot
- MySQL database

#### Steps
- Download and import project in your IDE;
- Open MySQL and run "schema.sql", located in the "resources" folder to create the database and the tables;
- Run "data.sql", also located in the "resources" folder to populate the tables with some values;
- Access the endpoints which are detailed below.


## Endpoints

#### Users

- http://localhost:8080/users
  - retrieve a list of all the users
  - save a user to the database
- http://localhost:8080/users/page/{pageNum}
  - retrieve a list of all the users using pages:
    - {pageNum} = the page's number you want to see
- http://localhost:8080/users/{id}
  - retrieve a user based on its id ({id})
  - update a user based on its id ({id})
  - delete a user based on its id ({id})
- http://localhost:8080/users/{id}/update-status
  - update the status of a user based on its id ({id})

#### Categories

- http://localhost:8080/categories
  - retrieve a list of all the categories
  - save a category to the database
- http://localhost:8080/categories/{id}
  - retrieve a category based on its id ({id})
  - update a category based on its id ({id})
  - delete a category based on its id ({id})
- http://localhost:8080//parents/{id}
  - retrieve a list of all the categories which have a certain parent ({id})

#### Products

- http://localhost:8080/products
  - retrieve a list of all the products
  - save a product to the database
- http://localhost:8080/products/page/{pageNum}
  - retrieve a list of all the products using pages:
    - {pageNum} = the page's number you want to see
- http://localhost:8080/products/{id}
  - retrieve a product based on its id ({id})
  - update a product based on its id ({id})
  - delete a product based on its id ({id})

#### Technical Details

- http://localhost:8080/technical-details
  - retrieve a list of all the technical-details
  - save a technical detail to the database
- http://localhost:8080/technical-details/{id}
  - retrieve a technical detail based on its id ({id})
  - update a technical detail based on its id ({id})
  - delete a technical detail based on its id ({id})
- http://localhost:8080/technical-details/product/{id}
  - retrieve the technical details for a certain product ({id})

#### Orders

- http://localhost:8080/orders
  - retrieve a list of all the orders
  - save an order to the database
- http://localhost:8080/orders/{id}
  - retrieve an order based on its id ({id})
  - delete an order based on its id ({id})
- http://localhost:8080/orders/user/{userId}
  - retrieve the orders for a certain user ({userId})
- http://localhost:8080/orders/{id}/updateStatus
  - update the status of an order based on its id ({id})

#### Cart Items

- http://localhost:8080/cart
  - retrieve the cart for a user
  - empty the cart for a user
- http://localhost:8080/cart/add/{productId}/{quantity}
  - add a product to the cart:
    - {productId} = the product's id
    - {quantity} = the quantity you want to add
- http://localhost:8080/cart/update/{productId}/{quantity}
  - modify a product's quantity:
    - {productId} = the product's id
    - {quantity} = the new quantity
- http://localhost:8080/cart/remove/{productId}
  - remove a product from the cart:
    - {productId} = the product's id

#### Checkout

- http://localhost:8080/checkout
  - place an order, the following things happen:
    - if the cart has any items, an order is created for that user
    - the items in the cart are transferred in the order-details table
    - the items in the cart for that user are deleted

## Contributors

Danut Florentin Radu,
Angel Alin Madalin Stanciu,
Miruna Cristina Balanescu,
Madalina Mandoiu,
Felix Dumitru Marinau,
Emilian Mihai Covreag