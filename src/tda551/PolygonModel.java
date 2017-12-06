package tda551;

import tda551.polygon.IPolygon;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PolygonModel extends JComponent {
  private ArrayList<IPolygon> polygons = new ArrayList<>();

  private boolean direction = true;
  private int ticker = 0;

  public void addPolygon(IPolygon p) {
    polygons.add(p);
  }

  public void paint(Graphics g) {
    for (IPolygon polygon : polygons) {
      polygon.paint(g);
    }
  }

  public void translate(int x, int y) {
    for (IPolygon p : polygons) {
      p.translate(x, y);
    }
  }

  public void update() {
    ticker++;
    int value = direction ? 10 : -10;
    translate(value, value);
    notifyListeners();
    if (ticker > 10) {
      direction = !direction;
      ticker = 0;
    }
  }

  private void notifyListeners() {
    for (AnimateListener l : listeners)
      l.actOnUpdate();
  }

  public void animate() {
    try {
      while (true) {
        Thread.sleep(500);
        update();
      }
    } catch (InterruptedException e) {
    }
  }

  private List<AnimateListener> listeners = new ArrayList<>();

  public void addListener(AnimateListener l) {
    listeners.add(l);
  }
}

