package befaster.solutions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class OrderTest {

	@Test
	public void calculateTotalPrice() {
		OrderItem item = new OrderItem('A', 50, 2);
		
		assertThat(item.calculateTotal(), equalTo(100));
	}

}

