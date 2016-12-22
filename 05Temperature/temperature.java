import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame implements ActionListener {

    private Container pane;
    private JTextField cels, fahr;

    public Temperature() {
	this.setTitle("Temperature Converter");
	this.setSize(600,600);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	JButton cToF = new JButton("cToF");
	cToF.addActionListener(this);
	cToF.setActionCommand("cToF");
	JButton fToC = new JButton("fToC");
	fToC.addActionListener(this);
	fToC.setActionCommand("fToC");
	
	cels = new JTextField(5);
	fahr = new JTextField(5);
	
	pane.add(cToF);
	pane.add(fToC);
	pane.add(cels);
	pane.add(fahr);
    }
  
    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();

	if (event.equals("cToF")) {
	    double cel = Double.parseDouble(cels.getText());
	    c = (9.0 / 5) * c + 32;
	    fahr.setText(String.valueOf(c));
	}
	if (event.equals("fToC")) {
	    double far = Double.parseDouble(fahr.getText());
	    f = (5.0 / 9) * (f - 32);
	    cels.setText(String.valueOf(f));
	}
    }

    public static void main(String[] args) {
	Temperature g = new Temperature();
	g.setVisible(true);
    }

}
