package shapes;
public class ShapesDemo {

    private void run() {
        Graphics console = new ConsoleGraphics();
        var shapes = new Shapes(console);

        shapes.add(new TextBox("Hello!"));
        shapes.add(new Rectangle(32,1));
        shapes.add(new RightArrow());
        shapes.draw();
    }
    public static void main(String[] args) {
        new ShapesExample.run();
    }
}

