package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.CartItemException;
import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final UserService userService;
    private final ProductService productService;

    public List<CartItem> findCartItemsByUser(long userId) {
        return cartItemRepository.findCartItemsByUserId(userId);
    }

    public String addProductToCart(long userId, long productId, short quantity) {
        if(quantity > 15) {
            throw new CartItemException("Could not add " + quantity + " items " +
                    "to your shopping cart. Maximum allowed quantity is 15.");
        }

        User user = userService.findById(userId);
        short updatedQuantity = quantity;
        Product product = productService.findById(productId);
        CartItem cartItem = cartItemRepository.findCartItemByUserIdAndProductId(userId, productId);

        if (cartItem != null) { // If cart already has that product, update quantity
            updatedQuantity = (short) (cartItem.getQuantity() + quantity);
            if (updatedQuantity > 15) {
                throw new CartItemException("Could not add more " + quantity + " item(s) " +
                        " because there's already " + cartItem.getQuantity() + " item(s) " +
                        "in your shopping cart. Maximum allowed quantity is 15.");
            }
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
        }

        cartItem.setQuantity(updatedQuantity);

        cartItemRepository.save(cartItem);

        return "Product " + product.getName() + " x" + updatedQuantity + " has been added to the cart.";
    }

    public String updateProductQuantity(long userId, long productId, short quantity) {
        CartItem cartItem = cartItemRepository.findCartItemByUserIdAndProductId(userId, productId);
        if (cartItem == null) {
            return "The product is not in the cart.";
        }
        if (quantity > 15) {
            throw new CartItemException("Could not update quantity to " + quantity +
                    ". Maximum allowed quantity is 15.");
        }
        cartItemRepository.updateProductQuantity(quantity, userId, productId);
        return "Quantity has been updated! New quantity: " + quantity;
    }

    public String removeProductFromCart(long userId, long productId) {
        if (cartItemRepository.findCartItemByUserIdAndProductId(userId, productId) == null) {
            return "The product is not in the cart.";
        }
        cartItemRepository.deleteCartItemByUserIdAndProductId(userId, productId);
        return "The product has been removed from your shopping cart.";
    }

    public String deleteCartByUser(long userId) {
        if (findCartItemsByUser(userId).isEmpty()) {
            return "Cart is already empty";
        }
        cartItemRepository.deleteCartItemsByUserId(userId);
        return "Cart has been deleted!";
    }
}