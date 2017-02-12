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
public abstract class BoundedShapes extends MyShapes {
    @Override
    public abstract void draw(Graphics2D g2D);
    
    public BoundedShapes(Point pointA_, Point pointB_, GradientPaint gradient_, Stroke stroke_) {
        super(pointA_, pointB_, gradient_, stroke_);
    }
    
    
}
