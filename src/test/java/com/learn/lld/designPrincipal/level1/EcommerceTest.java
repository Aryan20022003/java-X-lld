package com.learn.lld.designPrincipal.level1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.learn.lld.designPrincipal.level1.Cost.DiscountType;
import com.learn.lld.designPrincipal.level1.checkout.CheckoutResponse;
import com.learn.lld.designPrincipal.level1.payment.Card;

public class EcommerceTest {
    private Ecommerce ecommerce;
    private Product sampleProduct;
    private Card sampleCard;

    @Before
    public void setUp() {
        ecommerce = new Ecommerce();
        sampleProduct = new Product("PROD1", "Test Product", 100.0);
        sampleCard = new Card("1234-5678-9012-3456", "Test User", 123);
    }

    @Test
    public void testAddProduct() {
        assertTrue("Should successfully add a product", ecommerce.addProduct(sampleProduct, 1));
        assertEquals(100.0, ecommerce.getPriceBeforeDiscount(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullProduct() {
        ecommerce.addProduct(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithZeroQuantity() {
        ecommerce.addProduct(sampleProduct, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithNegativeQuantity() {
        ecommerce.addProduct(sampleProduct, -1);
    }

    @Test
    public void testRemoveProduct() {
        ecommerce.addProduct(sampleProduct, 2);
        assertTrue("Should successfully remove a product", ecommerce.removeProduct(sampleProduct, 1));
        assertEquals(100.0, ecommerce.getPriceBeforeDiscount(), 0.01);
    }

    @Test
    public void testFixedDiscount() {
        ecommerce.addProduct(sampleProduct, 1);
        double discountedPrice = ecommerce.applyFixedDiscount(20.0);
        assertEquals(80.0, discountedPrice, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeFixedDiscount() {
        ecommerce.addProduct(sampleProduct, 1);
        ecommerce.applyFixedDiscount(-20.0);
    }

    @Test
    public void testPercentageDiscount() {
        ecommerce.addProduct(sampleProduct, 1);
        double discountedPrice = ecommerce.applyPercentageDiscount(20);
        assertEquals(80.0, discountedPrice, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPercentageDiscount() {
        ecommerce.addProduct(sampleProduct, 1);
        ecommerce.applyPercentageDiscount(101);
    }

    @Test
    public void testSuccessfulCheckout() {
        ecommerce.addProduct(sampleProduct, 1);
        CheckoutResponse response = ecommerce.finalCheckoutWithCard(DiscountType.FIXED, 20.0, sampleCard);
        
        assertTrue(response.isSuccess());
        assertEquals(80.0, response.getFinalAmount(), 0.01);
        assertNotNull(response.getTransactionId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckoutWithEmptyCart() {
        ecommerce.finalCheckoutWithCard(DiscountType.FIXED, 20.0, sampleCard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckoutWithNullCard() {
        ecommerce.addProduct(sampleProduct, 1);
        ecommerce.finalCheckoutWithCard(DiscountType.FIXED, 20.0, null);
    }

    @Test
    public void testMultipleProductsPrice() {
        Product product2 = new Product("PROD2", "Test Product 2", 50.0);
        ecommerce.addProduct(sampleProduct, 2);  // 2 * 100 = 200
        ecommerce.addProduct(product2, 1);       // 1 * 50 = 50
        assertEquals(250.0, ecommerce.getPriceBeforeDiscount(), 0.01);
    }

    @Test
    public void testFixedDiscountGreaterThanTotal() {
        ecommerce.addProduct(sampleProduct, 1); // Total = 100
        double discountedPrice = ecommerce.applyFixedDiscount(150.0);
        assertEquals(0.0, discountedPrice, 0.01);
    }

    @Test
    public void testComplexCheckoutScenario() {
        Product product2 = new Product("PROD2", "Test Product 2", 50.0);
        ecommerce.addProduct(sampleProduct, 2);  // 2 * 100 = 200
        ecommerce.addProduct(product2, 1);       // 1 * 50 = 50
        // Total = 250, apply 10% discount
        CheckoutResponse response = ecommerce.finalCheckoutWithCard(DiscountType.PERCENTAGE, 10, sampleCard);
        
        assertTrue(response.isSuccess());
        assertEquals(225.0, response.getFinalAmount(), 0.01);
        assertNotNull(response.getTransactionId());
        assertNotNull(response.getMessage());
    }
}
