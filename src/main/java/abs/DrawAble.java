package abs;

public interface DrawAble extends Printable, Playable {
    void draw();
}

class Triangle implements DrawAble{

    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }

    @Override
    public void print() {

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}
class Circle implements DrawAble{

    @Override
    public void draw() {
        System.out.println("Draw circle");
    }

    @Override
    public void print() {

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}

class Square implements DrawAble{

    @Override
    public void draw() {
        System.out.println("Draw square");
    }

    @Override
    public void print() {

    }

    @Override
    public void play() {
        
    }

    @Override
    public void stop() {

    }
}

class DrawTester{
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
        Triangle triangle = new Triangle();
        triangle.draw();
        Square square = new Square();
        square.draw();
        triangle.printDefault();
    }
}
