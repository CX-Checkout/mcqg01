package befaster.solutions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class OfferTest {

	@Test
	public void returnCorrectPriceBasedOnAmount() {
		Offer offer = new Offer('A', 3, 130);
		
		assertThat(offer.getPriceBasedOnOffer(6), equalTo(260));
	}

	@Test
	public void returnItemsNotInOffer() {
		Offer offer = new Offer('A', 3, 130);
		
		assertThat(offer.getItemsNotOnOffer(7), equalTo(1));
	}
}
