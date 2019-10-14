package supermarket.offer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Offers {

	APPLEOFFER("Apple",p -> {if(p.getQuantity() % 2 != 0){p.setQuantity(p.getQuantity()+1); };
							p.setTotalPrice(p.getQuantity()/2 * p.getPrice());}),
	WATERMELONOFFER("Watermelon",p -> {
										double toReduce = p.getPrice() * ((int)p.getQuantity()/3); 
										p.setTotalPrice(p.getQuantity() * p.getPrice() - toReduce);
									}) ;
	
	private String productName;
	private Offer offer;
	
	private Offers(String productName, Offer offerDetails) {
		this.productName = productName;
		this.offer = offerDetails;
	}
	
	public static Offer getOfferDetails(String productName){
		List<Offers> offers = Arrays.stream(values()).filter(offer -> offer.productName.equals(productName)).collect(Collectors.toList());
		return offers.isEmpty()? null : offers.get(0).offer;
	}
}
