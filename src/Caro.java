import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Caro extends JPanel  {
	public int i,j;
  JPanel title_panel = new JPanel();
  JPanel button_panel = new JPanel();
  JLabel textfield = new JLabel();
  public JButton[][] buttons = new JButton[18][18];
  boolean tick[][] = new boolean[18][18];
  
  Caro() {
    this.setSize(600, 600);
    this.setBackground(new Color(50, 50, 50));
    this.setLayout(new BorderLayout());
    textfield.setBackground(new Color(25, 25, 25));
    textfield.setForeground(new Color(25, 255, 0));
    textfield.setFont(new Font("Ink Free", Font.BOLD, 15));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Cá rô");
    textfield.setOpaque(true);
    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0, 0, 600, 100);
    button_panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
    button_panel.setLayout(new GridLayout(18, 18));
    button_panel.setBackground(new Color(150, 150, 150));

    for (int i = 0; i < 18; i++) {
      for (int j = 0; j < 18; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].setBackground(Color.WHITE);
        button_panel.add(buttons[i][j]);
        buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 13));
        buttons[i][j].setFocusable(false);       
        tick[i][j] = false;
      }
    }
    title_panel.add(textfield);
    this.add(title_panel, BorderLayout.NORTH);
    this.add(button_panel);
    firstTurn();
  }

  public void firstTurn() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
}
  public void reset() {
	  for (int i = 0; i < 18; i++) {
	      for (int j = 0; j < 18; j++) {
	        tick[i][j] = false;
	        buttons[i][j].setName("");
	        buttons[i][j].setIcon(null);
	      }
	    }
  }
}