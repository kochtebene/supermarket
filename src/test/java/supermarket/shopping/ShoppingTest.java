package supermarket.shopping;

import static junit.framework.Assert.*;

import org.junit.Test;

import supermarket.product.Apple;
import supermarket.product.Orange;
import supermarket.product.Watermelon;

public class ShoppingTest {

	@Test
	public void testConstructBasket(){
		Shopping shopping = new Shopping();
		String[] args = {"A2","O5","W4"};
		Basket basket = shopping.constructBasket(args);
		assertNotNull(basket);
		assertEquals(basket.getProducts().size(), 3);
	}
	
	@Test
	public void testCalculateTolalPrice(){
		Apple apple = new Apple();
		apple.setQuantity(2);
		
		Orange orange = new Orange();
		orange.setQuantity(5);
		
		Watermelon watermelon = new Watermelon();
		watermelon.setQuantity(4);
		
		Basket basket = new Basket();
		basket.addProduct(apple);
		basket.addProduct(orange);
		basket.addProduct(watermelon);
		
		Shopping shopping = new Shopping();
		shopping.calculateTolalPrice(basket);
		
		assertEquals(5.1000000000000005, basket.getPrice());
		
	}
	
}
