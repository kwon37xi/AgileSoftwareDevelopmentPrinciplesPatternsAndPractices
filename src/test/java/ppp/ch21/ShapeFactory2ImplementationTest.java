package ppp.ch21;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeFactory2ImplementationTest {
    private ShapeFactory2 shapeFactory2;

    @Before
    public void setUp() throws Exception {
        shapeFactory2 = new ShapeFactory2Implementation();
    }


    @Test
    public void createCircle() throws Exception {
        Shape s = shapeFactory2.make("Circle");
        assertThat(s).isInstanceOf(Circle.class);
    }
}