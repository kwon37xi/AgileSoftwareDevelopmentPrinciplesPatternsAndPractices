package ppp.ch05;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PrimeGeneratorTest {

    @Test
    public void primes() throws Exception {
        int[] nullArray = PrimeGenerator.generatePrimes(0);
        assertThat(nullArray.length).isEqualTo(0);

        int[] minArray = PrimeGenerator.generatePrimes(2);
        assertThat(minArray.length).isEqualTo(1);
        assertThat(minArray[0]).isEqualTo(2);

        int[] threeArray = PrimeGenerator.generatePrimes(3);
        assertThat(threeArray.length).isEqualTo(2);
        assertThat(threeArray[0]).isEqualTo(2);
        assertThat(threeArray[1]).isEqualTo(3);

        int[] centArray = PrimeGenerator.generatePrimes(100);
        assertThat(centArray.length).isEqualTo(25);
        assertThat(centArray[24]).isEqualTo(97);
    }

    @Test
    public void exhaustive() throws Exception {
        for (int i = 2; i < 500; i++)
            verifyPrimeList(PrimeGenerator.generatePrimes(i));
    }

    private void verifyPrimeList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            verifyPrime(list[i]);
        }
    }

    private void verifyPrime(int n) {
        for (int factor = 2; factor < n; factor++)
            assertThat(n % factor).isNotZero();
    }
}