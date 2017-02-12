/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author Evan
 */
public class Square extends BoundedShapes {
    public Square(Point pointA_, Point pointB_, GradientPaint gradient_, Stroke stroke_) {
        super(pointA_, pointB_, gradient_, stroke_);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setPaint(getGradient());
        g2D.setStroke(getStroke());
        if (isFilled() != true) g2D.drawRect(Math.min((int)getPointA().getX(), (int)getPointB().getX()), Math.min((int)getPointA().getY(), (int)getPointB().getY()),Math.abs((int)getPointA().getX()-(int)getPointB().getX()) ,Math.abs((int)getPointA().getY()-(int)getPointB().getY())); 
        else {
            g2D.fillRect(Math.min((int)getPointA().getX(), (int)getPointB().getX()), Math.min((int)getPointA().getY(), (int)getPointB().getY()),Math.abs((int)getPointA().getX()-(int)getPointB().getX()) ,Math.abs((int)getPointA().getY()-(int)getPointB().getY()));
        }
        
    }
    
    
}
