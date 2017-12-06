package tda551.polygon;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class BasePolygon extends AbstractPolygon implements IPolygon {
  private Point centerPoint;
  private List<Point> points;

  protected BasePolygon(List<Point> points) {
    this.points = defensiveCopyPointList(points);
    centerPoint = calculateCenterPoint(this.points);
  }

  // defensive copying of all points in a list
  private List<Point> defensiveCopyPointList(List<Point> points) {
    List<Point> newList = new LinkedList<>();
    for (Point point : points) {
      newList.add(new Point(point));
    }
    return newList;
  }

  private static Point calculateCenterPoint(List<Point> points) {
    int maxX = points.get(0).x, minX = points.get(0).x, maxY = points.get(0).y, minY = points.get(0).y;
    for (Point point : points) {
      maxX = Math.max(point.x, maxX);
      minX = Math.min(point.x, minX);
      maxY = Math.max(point.y, maxY);
      minY = Math.min(point.y, minY);
    }
    return new Point((maxX - minX) / 2 + minX, (maxY - minY) / 2 + minY);
  }

  @Override
  public IPolygon translate(int x, int y) {
    return null;
  }

  @Override
  public IPolygon rotate(double radians) {
    return null;
  }

  @Override
  public IPolygon scale(double x, double y) {
    return null;
  }

  @Override
  public List<Point> getPoints() {
    // defensive copying of every point in list
    return defensiveCopyPointList(this.points);
  }

  @Override
  protected void manipulatePoint(Point center, Point p) {
    ; // In base, we don't do manipulations
  }

  @Override
  public Point getCenterPoint() {
    // defensive copying
    return new Point(centerPoint);
  }
}
