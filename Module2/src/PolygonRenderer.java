import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer {
    private Polygon polygon;
    private Color color;
    List<Vector2d> verties;
    public double angle = 0.0;

    public PolygonRenderer (Color color,Vector2d... verties){
        this.verties =Arrays.asList(verties);
        this.color = color;
        this.polygon = new Polygon();
    }
    public void updatePolygon(Vector2d position) {
        this.polygon.reset();
//        Vector2d center = new Vector2d();
//        this.verties.forEach(vector2d -> center.addUp(vector2d));
//        center.multiply(1.0f/this.verties.size());
        Vector2d center = this.verties.stream().reduce(new Vector2d(),(v1, v2) -> v1.addUp(v2)).multiply(1.0f/this.verties.size()).rotate(this.angle);
        Vector2d translate = position.subtract(center);
//        List<Vector2d> newVerties = new ArrayList<>();
//        this.verties.forEach(vector2d -> {
//            Vector2d newPosition = vector2d.add(translate);
//            newVerties.add(newPosition);
//        });
//        List<Vector2d> newVerties = this.verties.stream().map(vector2d -> vector2d.add(translate)).collect(Collectors.toList());
        this.verties.stream().map(vector2d -> vector2d.rotate(angle)).map(vector2d -> vector2d.add(translate)).forEach(vertex -> polygon.addPoint((int)vertex.x,(int)vertex.y));
    }
    public void render(Graphics graphics, Vector2d position){
        graphics.setColor(this.color);
        this.updatePolygon(position);
        graphics.fillPolygon(this.polygon);
    }
}
