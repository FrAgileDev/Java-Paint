/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/**
 *
 * @author Evan
 */
public class Line extends MyShapes {
    
    public Line(Point pointA_, Point pointB_, GradientPaint gradient_, Stroke stroke_) {
        super(pointA_, pointB_, gradient_, stroke_);
    }
    
    @Override
    public void draw(Graphics2D g2D) {
        g2D.setPaint(getGradient());
        g2D.setStroke(getStroke());
        g2D.drawLine((int)getPointA().getX(), (int)getPointA().getY(), (int)getPointB().getX(), (int)getPointB().getY());
    }
}
