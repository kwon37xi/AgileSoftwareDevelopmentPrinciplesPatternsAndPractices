package ppp.ch21;

public class ShapeFactory2Implementation implements ShapeFactory2 {
    @Override
    public Shape make(String shapeName) throws Exception {
        if (shapeName.equals("Circle"))
            return new Circle();
        else if (shapeName.equals("Square"))
            return new Square();
        else
            throw new Exception("ShapeFactory2 cannot create " + shapeName);
    }
}
