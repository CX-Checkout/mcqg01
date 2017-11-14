package befaster.solutions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class AppTest {

	@Test
	public void checkoutIndividualItems() {
		assertThat(App.checkout("ABCD"), equalTo(115));
	}
	
	@Test
	public void checkoutMoreThanOnePurchase() {
		assertThat(App.checkout("AA"), equalTo(100));
	}

	@Test
	public void checkoutOffers() {
		assertThat(App.checkout("AAA"), equalTo(130));
	}
	
	@Test
	public void checkoutOffersAnNotOffers() {
		assertThat(App.checkout("AAAA"), equalTo(180));
	}
	
	@Test
	public void illegalInput() {
		assertThat(App.checkout("aa"), equalTo(-1));
	}
	
	@Test
	public void differentInputs() {
		assertThat(App.checkout("AABB"), equalTo(145));
	}
}
