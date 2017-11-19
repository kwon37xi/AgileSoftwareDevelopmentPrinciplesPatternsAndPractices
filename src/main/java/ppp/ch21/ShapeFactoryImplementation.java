package ppp.ch21;

public class ShapeFactoryImplementation implements ShapeFactory {
    @Override
    public Shape makeCircle() {
        return new Circle();
    }

    @Override
    public Shape makeSquare() {
        return new Square();
    }
}
