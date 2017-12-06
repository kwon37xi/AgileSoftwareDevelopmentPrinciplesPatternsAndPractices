package ppp.ch26;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    public void testOrderPrice() {
        Order o = new Order("Bob");
        Product toothpaste = new Product("Toothpaste", 129);
        o.addItem(toothpaste, 1);
        assertThat(o.total()).isEqualTo(129);

        Product mouthwash = new Product("Mouthwash", 342);
        o.addItem(mouthwash, 2);
        assertThat(o.total()).isEqualTo(813);
    }
}