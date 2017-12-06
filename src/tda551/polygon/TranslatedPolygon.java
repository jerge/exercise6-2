package tda551.polygon;

import java.awt.*;
import java.util.List;

class TranslatedPolygon extends AbstractPolygon implements IPolygon {
  private AbstractPolygon base;
  int xMove;
  int yMove;

  TranslatedPolygon(AbstractPolygon polygonToTranslate, int x, int y) {
    this.base = polygonToTranslate;
    this.xMove = x;
    this.yMove = y;
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
    // the points from base are already defensively copied
    return getPointsWithBase(base);
  }

  @Override
  protected void manipulatePoint(Point center, Point p) {
    p.x += this.xMove;
    p.y += this.yMove;
  }

  @Override
  public Point getCenterPoint() {
    // the centerpoint from base is already defensively copied
    Point baseCenter = base.getCenterPoint();
    baseCenter.x += xMove;
    baseCenter.y += yMove;
    return baseCenter;
  }
}
