/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Evan
 */
public class CanvasHandler extends JPanel {
    //handle drawing on the canvas
    
    private ArrayList<MyShapes> shapes = new ArrayList<MyShapes>();
    private BottomLabel coordinates = new BottomLabel();
    private Point point1, point2;
    private boolean filled;
    private boolean dashed;
    private MyShapes currentShape;
    private GradientPaint currentGradient;
    private String shapeType;
    private int dashLength;
    private int lineWidth;
    private Color color1, color2;
    
    public CanvasHandler(BottomLabel bottomLabel) {
        shapeType = "Line";
        setBackground(Color.WHITE);
        addMouseMotionListener(new handler());
        addMouseListener(new handler());
        coordinates = bottomLabel;
        this.color1 = Color.RED;
        this.color2 = Color.RED;
        point1 = new Point(0,0);
        point2 = new Point(0,0);
        dashLength = 1;
        
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D)g;
       for (MyShapes s: shapes) {
           s.draw(g2d);
       }
       
       
    }
    
    public void undo() {
        if(shapes.isEmpty()) {
            
        } else {
        shapes.remove(shapes.size()-1);
        repaint();
        }
    }
    
    public void clear() {
        shapes.clear();
        repaint();
    }
    
    
    
    
    public Point getPoint1() {
        return point1;
    }
    public Point getPoint2() {
        return point2;
    }
    public void setCurrentShape(String s) {
        shapeType = s;
        
    }
    public void setGradient(GradientPaint g) {
        currentGradient = g;
    }
    
    public void setDashedLength(int dashLength_) {
        dashLength = dashLength_;
    }
    public void setLineWidth(int lineWidth_) {
        lineWidth = lineWidth_;
    }
    public void setDashed(boolean g) {
        dashed = g;
    }
    public void setFilled(boolean g) {
        filled = g;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setColor1(Color c) {
        color1 = c;
    }
    public void setColor2(Color c) {
        color2 = c;
    }
    
    class handler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mousePressed(MouseEvent me) {
            point1 = me.getPoint();
            point2 = new Point(0,0);
            
            switch (shapeType) {
                case "Line":
                    currentShape = new Line(point1,point2, currentGradient, new BasicStroke(lineWidth));
                    if (dashed) {
                        float dash[] = { dashLength };
                        currentShape.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
                        
                    } else
                        currentShape.setStroke(new BasicStroke(lineWidth));
                    shapes.add(currentShape);
                    break;
                case "Oval":
                    currentShape = new Oval(point1,point2, currentGradient, new BasicStroke(lineWidth));
                    if (dashed) {
                        float dash[] = { dashLength };
                        currentShape.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
                    } else
                        currentShape.setStroke(new BasicStroke(lineWidth));
                    currentShape.setFilled(isFilled());
                    shapes.add(currentShape);
                    break;
                case "Square":
                    currentShape = new Square(point1,point2, currentGradient, new BasicStroke(lineWidth));
                    if (dashed) {
                        float dash[] = { dashLength };
                        currentShape.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
                    } else
                        currentShape.setStroke(new BasicStroke(lineWidth));
                    currentShape.setFilled(isFilled());
                    shapes.add(currentShape);
                    break;
            }
            }
        
        @Override
        public void mouseReleased(MouseEvent me) {
            point2 = me.getPoint();
            
            
            
            repaint();
        }
        @Override
        public void mouseDragged(MouseEvent me) {
            coordinates.setCoordinates(me.getX()+"," +me.getY());
            
            point2.x = me.getX();
            point2.y = me.getY();
            
            repaint();
        } //To change body of generated methods, choose Tools | Templates.
        @Override
        public void mouseMoved(MouseEvent me) {
            coordinates.setCoordinates(me.getX()+"," +me.getY());
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
        }

        @Override
        public void mouseExited(MouseEvent me) {
            coordinates.setCoordinates("Please return to the drawing screen");
        }
    }
}