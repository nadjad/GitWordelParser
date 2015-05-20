package gui.graphic;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public interface Drawable {

	public void draw(Graphics2D engine);

	public Point getCenter();

	public Point getLinkPoint();

	public boolean contains(Point2D p);

	public void setPosition(Point2D p);

	public void move(int dx, int dy);
}
