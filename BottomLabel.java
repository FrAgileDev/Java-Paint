 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes2d;

import javax.swing.JLabel;

/**
 *
 * @author Evan
 */
public class BottomLabel extends JLabel {
    
    public BottomLabel() {
        setText("Mouse Coordinates");
    }
    public void setCoordinates(String g) {
        setText(g);
        
    }
    
}
