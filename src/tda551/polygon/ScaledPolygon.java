package tda551.polygon;

import java.awt.*;
import java.util.List;

class ScaledPolygon extends AbstractPolygon implements IPolygon {
    private AbstractPolygon base;
    double xFactor, yFactor;

    ScaledPolygon( AbstractPolygon base, double xFactor, double yFactor ) {
        this.base = base;
        this.xFactor = xFactor;
        this.yFactor = yFactor;
    }

    @Override
    public IPolygon translate( int x, int y ) {
        List<Point> pointList = base.getPoints();
        return new TranslatedPolygon( new BasePolygon( pointList ), x, y );
    }

    @Override
    public IPolygon rotate( double radians ) {
        List<Point> pointList = base.getPoints();
        return new RotatedPolygon( new BasePolygon( pointList ), radians );
    }

    @Override
    public IPolygon scale( double x, double y ) {
        List<Point> pointList = base.getPoints();
        return new ScaledPolygon( new BasePolygon( pointList ), x, y );
    }

    protected void manipulatePoint( Point center, Point point ) {
        double newX = ( point.x - center.x ) * xFactor + center.x;
        double newY = ( point.y - center.y ) * yFactor + center.y;
        point.x = (int) newX;
        point.y = (int) newY;
    }

    public List<Point> getPoints() {
        return getPointsWithBase( base );
    }

    @Override
    public Point getCenterPoint() {
        return base.getCenterPoint();
    }
}
