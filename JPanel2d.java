/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Evan
 */
public class JPanel2d extends JPanel {
    private JPanel subPanel1 = new JPanel();
    private JPanel subPanel2 = new JPanel();
    private JButton undo = new JButton("Undo");
    private JButton clear = new JButton("Clear");
    private JComboBox shapeChoice = new JComboBox();
    private JCheckBox fillCheck = new JCheckBox("Fill");
    private JCheckBox gradientCheck = new JCheckBox("Gradient");
    private JButton color1Button = new JButton("Color 1");
    private JButton color2Button = new JButton("Color 2");
    private JTextField lineWidth = new JTextField(3);
    private JLabel lineWidthLabel = new JLabel("Line Width:");
    private JTextField dashLength = new JTextField("1",3);
    private JLabel dashLengthLabel = new JLabel("Dash Length:");
    private JCheckBox dashCheck = new JCheckBox("Dashed");
    private BottomLabel coordinates = new BottomLabel();
    private CanvasHandler canvas = new CanvasHandler(coordinates);
    private Color color1, color2;
    private BasicStroke stroke;
    private Paint gradient;
    
    
    
    
    public JPanel2d(CanvasHandler canvas_) {
        
        color1 = Color.RED;
        color2 = Color.RED;
        handler myhandler = new handler();
        canvas = canvas_;
        setLayout(new GridLayout(2, 1));
        add(subPanel1);
        add(subPanel2);
        undo.setSize(50, 25);
        undo.addActionListener(myhandler);
        undo.setVisible(true);
        clear.setSize(50, 25);
        clear.addActionListener(myhandler);
        clear.setVisible(true);
        subPanel1.setLayout(new FlowLayout());
        subPanel1.add(undo);
        subPanel1.add(clear);
        clear.addActionListener(myhandler);
        subPanel1.add(shapeChoice);
        subPanel1.add(fillCheck);
        subPanel2.setLayout(new FlowLayout());
        subPanel2.add(gradientCheck);
        subPanel2.add(color1Button);
        color1Button.addActionListener(myhandler);
        subPanel2.add(color2Button);
        color2Button.addActionListener(myhandler);
        subPanel2.add(lineWidthLabel);
        subPanel2.add(lineWidth);
        lineWidth.addActionListener(myhandler);
        subPanel2.add(dashLengthLabel);
        subPanel2.add(dashLength);
        dashLength.addActionListener(myhandler);
        subPanel2.add(dashCheck);
        gradientCheck.addItemListener(myhandler);
        dashCheck.addItemListener(myhandler);
        fillCheck.addItemListener(myhandler);
        shapeChoice.addItem("Line");
        shapeChoice.addItem("Oval");
        shapeChoice.addItem("Square");
        shapeChoice.addActionListener(myhandler);
        canvas.setGradient(new GradientPaint(0,0,color1,50,50,color1,true));
        
        
        
    }
    
    public Paint getGradient() {
        return gradient;
    }
    public BasicStroke getStroke() {
        return stroke;
    }
    
    class handler implements ActionListener, ItemListener  {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == undo) {
                canvas.undo();
            }
            else if (ae.getSource() == clear) {
                canvas.clear();
            }
            
            
            else if (ae.getSource() == color1Button) {
                
                color1 = JColorChooser.showDialog(subPanel2, "Choose color 1", color1);
                canvas.setColor1(color1);
                if(gradientCheck.isSelected()) {
                    canvas.setGradient(new GradientPaint(0,0,color1,50,50,color2,true));
                } else
                    canvas.setGradient(new GradientPaint(0,0,color1,50,50,color1,true));
            }
            else if (ae.getSource() == color2Button) {
                
                color2 = JColorChooser.showDialog(subPanel2,"Choose color 2", color2);
                canvas.setColor2(color2);
                if(gradientCheck.isSelected()) {
                    canvas.setGradient(new GradientPaint(0,0,color1,50,50,color2,true));
                } else
                    canvas.setGradient(new GradientPaint(0,0,color1,50,50,color1,true));
            }
            else if (ae.getSource() == lineWidth) {
                int width = Integer.parseInt(lineWidth.getText());
                canvas.setLineWidth(width);
            }
            else if (ae.getSource() == dashLength) {
                int length;
                length = Integer.parseInt(dashLength.getText());
                canvas.setDashedLength(length);
            }
            
            
            
            
            
            String shape = shapeChoice.getSelectedItem().toString();
            switch (shape) {
                case "Line":
                    canvas.setCurrentShape("Line");
                    break;
                case "Oval":
                    canvas.setCurrentShape("Oval");
                    break;
                case "Square":
                    canvas.setCurrentShape("Square");
                    break;
            }
            
            
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            
            if (gradientCheck.isSelected()) {
                canvas.setGradient(new GradientPaint(0,0,color1,50,50,color2,true));
            }
            else if (!gradientCheck.isSelected())
                canvas.setGradient(new GradientPaint(0,0,color1,50,50,color1,true));
            
            if (dashCheck.isSelected()) {
                canvas.setDashed(true);
            }
            else if (!dashCheck.isSelected()) {
                canvas.setDashed(false);
            }
            if (fillCheck.isSelected()) {
                canvas.setFilled(true);
            }
            else if (!fillCheck.isSelected())
                canvas.setFilled(false);
        }
                
    }
}

