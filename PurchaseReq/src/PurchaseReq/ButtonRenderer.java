package PurchaseReq;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
  
	
	private static final long serialVersionUID = 1L;

public ButtonRenderer() {
	Image image;
	Image scaledImage;
    setOpaque(false);
    setBackground(Color.WHITE);
    image = new ImageIcon(this.getClass().getResource("eye.png")).getImage();
	scaledImage = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	this.setIcon(new ImageIcon(scaledImage));
	
  }
   
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground()); 
    } else{
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText( (value ==null) ? "" : value.toString() );
    return this;
  }
}