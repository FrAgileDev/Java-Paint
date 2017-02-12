/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author Evan
 */
public abstract class MyShapes {
    private Stroke stroke;
    private Paint paint;
    private Point pointA, pointB;
    boolean filled;
    
    public MyShapes(Point pointA_, Point pointB_, Paint paint_, Stroke stroke_) {
        pointA = pointA_;
        pointB = pointB_;
        stroke = stroke_;
        paint = paint_;
    }
    
    public abstract void draw(Graphics2D g2D);

    /**
     * @return the stroke
     */
    public Stroke getStroke() {
        return stroke;
    }
    public void setStroke(Stroke s) {
        stroke = s;
    }
    public void setFilled(boolean g) {
        filled = g;
    }
    public boolean isFilled() {
        return filled == true;
    }

    /**
     * @return the gradient
     */
    public Paint getGradient() {
        return paint;
    }

    /**
     * @return the pointA
     */
    public Point getPointA() {
        return pointA;
    }

    /**
     * @return the pointB
     */
    public Point getPointB() {
        return pointB;
    }
    
    
}
