package supermarket.shopping;

import java.util.Arrays;
import java.util.stream.Stream;





import com.sun.istack.internal.NotNull;

import supermarket.offer.*;
import supermarket.product.Product;
import supermarket.product.ProductFactory;

public class Shopping {

	
	
	public static void main(String[] args) {
		Shopping shopping = new Shopping();
		Basket basket = shopping.constructBasket(args);
		shopping.calculateTolalPrice(basket);
		System.out.println("price "+basket.getPrice());
	}

	public void calculateTolalPrice(@NotNull Basket basket) {
		
		basket.getProducts().stream().forEach(product -> {Offer offer = Offers.getOfferDetails(product.getName());
										if(offer != null){offer.applyOffer(product);} else {product.setTotalPrice(product.getQuantity() * product.getPrice());}
										basket.setPrice( basket.getPrice()+product.getTotalPrice());
											});
										
		
	}

	public Basket constructBasket(String[] args) {
		Basket basket = new Basket();
		Stream<String> argsStream = Arrays.stream(args);
		ProductFactory productFactory = new ProductFactory();
		
		argsStream.forEach(arg -> {String productCode = arg.substring(0, 1);
			int quantity = Integer.parseInt(arg.substring(1));
			Product product = productFactory.getProduct(productCode);
			product.setQuantity(quantity);
			basket.addProduct(product);
			});
		return basket;
		
	}

}
