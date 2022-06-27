package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.model.Category;
import com.endava.mentorship2022.model.Order;
import com.endava.mentorship2022.model.OrderDetail;
import com.endava.mentorship2022.model.OrderStatus;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.model.TechnicalDetail;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.model.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CheckoutServiceTest {

    @Mock
    private OrderService orderService;
    @Mock
    private CartItemService cartItemService;
    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService(orderService, cartItemService);
    }

    @Test
    void canPlaceOrder() {
        // given
        User user = new User(1L,
                "FirstName",
                "LastName",
                "first_name@gmail.com",
                "pass",
                "Str. add",
                "06546465645",
                LocalDate.now(),
                UserStatus.ACTIVE);

        Category category = new Category(1L,
                "Category",
                "category",
                null);

        Product product1 = new Product(1L,
                "Product 1",
                "product-1",
                "Description",
                "No-name",
                15.49F,
                1500,
                true,
                category,
                Set.of(new TechnicalDetail(1, "Brand:", "No-name", new Product(1L)))
        );

        Product product2 = new Product(1L,
                "Product 2",
                "product-2",
                "Description",
                "No-name",
                45.86F,
                1000,
                true,
                category,
                Set.of(new TechnicalDetail(1, "Release Date:", "10/10/2020", new Product(2L)))
        );

        List<CartItem> cartItems = List.of(
                new CartItem(1L, (short) 2, user, product1),
                new CartItem(1L, (short) 1, user, product2)
        );

        Set<OrderDetail> orderDetails = Set.of(
                new OrderDetail(1L, (short) 2, 15.49F, 30.98F, new Order(1L), new Product(1)),
                new OrderDetail(2L, (short) 1, 45.86F, 45.86F, new Order(1L), new Product(2))
        );
        Order order = new Order(1,
                LocalDate.now(),
                76.84F,
                user,
                orderDetails,
                OrderStatus.PENDING
        );

        given(cartItemService.findCartItemsByUser(anyLong())).willReturn(cartItems);
        given(orderService.createOrder(anyLong(), any(List.class))).willReturn(order);
        given(cartItemService.deleteCartByUser(anyLong())).willReturn("Cart has been deleted!");

        // when
        String actual = checkoutService.placeOrder(anyLong());

        // then
        assertThat(actual).isEqualTo("Order has been placed. Thank you for purchase.");
    }

    @Test
    void cannotPlaceOrderCartIsEmpty() {
        // given
        given(cartItemService.findCartItemsByUser(anyLong())).willReturn(Collections.emptyList());

        // when
        String actual = checkoutService.placeOrder(anyLong());

        // then
        assertThat(actual).isEqualTo("Cart is empty.");
        verify(orderService, never()).createOrder(anyLong(), any(List.class));
        verify(cartItemService, never()).deleteCartByUser(anyLong());
    }
}