package ppp.ch23;

import java.util.Vector;

/**
 * 여러 {@link Shape} 객체들을 보유하고 draw() 메소드를 proxy 한다.
 */
public class CompositeShape implements Shape {
    private Vector<Shape> itsShapes = new Vector<>();

    public void add(Shape e) {
        itsShapes.add(e);
    }

    @Override
    public void draw() {
        for (int i = 0; i < itsShapes.size(); i++) {
            Shape shape = itsShapes.elementAt(i);
            shape.draw();
        }
    }
}
