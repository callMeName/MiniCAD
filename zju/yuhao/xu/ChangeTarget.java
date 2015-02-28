package zju.yuhao.xu;


import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChangeTarget extends JPanel{

	private JButton sizeButton, posButton, colorButton;
	private Dimension c_size;
	private MyActionListener c_myActionListener;
	
	public ChangeTarget(Dimension size, MyActionListener myActionListener) {
		// TODO Auto-generated constructor stub
		c_size = size;
		c_myActionListener = myActionListener;
		this.setPreferredSize(c_size);
		this.setBorder(BorderFactory.createTitledBorder("Change Target"));
		
		

		sizeButton = new JButton("Size");
		sizeButton.setActionCommand(MyActionListener.TYPE_CHANGE_SIZE + "");
		sizeButton.addActionListener(c_myActionListener);
		
		posButton = new JButton("Position");
		posButton.setActionCommand(MyActionListener.TYPE_CHANGE_POS + "");
		posButton.addActionListener(c_myActionListener);
		
		colorButton = new JButton("Color");
		colorButton.setActionCommand(MyActionListener.TYPE_CHANGE_COLOR + "");
		colorButton.addActionListener(c_myActionListener);

		this.add(sizeButton);
		this.add(posButton);
		this.add(colorButton);
	}
	
	
	
}
