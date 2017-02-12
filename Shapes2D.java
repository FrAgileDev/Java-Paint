 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Evan
 */
public class Shapes2D {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Add all components to the window
        JFrame window = new JFrame("Java 2D Drawings");
        BottomLabel info = new BottomLabel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        CanvasHandler canvas = new CanvasHandler(info);
        JPanel2d panels = new JPanel2d(canvas);
        window.add(panels, BorderLayout.NORTH);
        window.add(canvas, BorderLayout.CENTER);
        window.add(info, BorderLayout.SOUTH);
        

        //window characteristics
        window.setVisible(true);
        
        
        
    }
    
}
