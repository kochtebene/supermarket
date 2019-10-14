package supermarket.shopping;

import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.NotNull;

import supermarket.product.Product;

public class Basket {

	private List<Product> products = new ArrayList<Product>();
	private double price = 0;
	
	public void addProduct(@NotNull Product product){
		getProducts().add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
