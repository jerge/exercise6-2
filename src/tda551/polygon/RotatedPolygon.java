package tda551.polygon;

import java.awt.*;
import java.util.List;

class RotatedPolygon extends AbstractPolygon implements IPolygon {
    private AbstractPolygon base;
    private double radians;

    RotatedPolygon( AbstractPolygon base, double radians ) {
        this.base = base;
        this.radians = radians;
    }
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

    @Override
    public List<Point> getPoints() {
        return getPointsWithBase( base );
    }

    @Override
    protected void manipulatePoint( Point center, Point p ) {
        rotatePoint( center, p, this.radians );
    }

    private static void rotatePoint( Point center, Point point, double alpha ) {
        double newX = center.x + ( point.x - center.x ) * Math.cos( alpha ) - ( point.y - center.y ) * Math.sin( alpha );
        double newY = center.y + ( point.x - center.x ) * Math.sin( alpha ) + ( point.y - center.y ) * Math.cos( alpha );
        point.x = (int) newX;
        point.y = (int) newY;
    }

    @Override
    public Point getCenterPoint() {
        return base.getCenterPoint();
    }
}
