package zju.yuhao.xu;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CreateTarget extends JPanel {
	
	private JButton lineButton, rectButton, circleButton, textButton;
	private Dimension d_size;
	
	public CreateTarget(Dimension size, MyActionListener myActionListener){
		d_size = size;
		this.setPreferredSize(size);
		this.setBorder(BorderFactory.createTitledBorder("Draw Target"));
		
		lineButton = new JButton("Line");
		lineButton.setActionCommand(Target.TARGET_TYPE_LINE + "");
		lineButton.addActionListener(myActionListener);
		
		rectButton = new JButton("Rect");
		rectButton.setActionCommand(Target.TARGET_TYPE_RECT + "");
		rectButton.addActionListener(myActionListener);
		
		circleButton = new JButton("Circle");
		circleButton.setActionCommand(Target.TARGET_TYPE_CIRCLE + "");
		circleButton.addActionListener(myActionListener);
		
		textButton = new JButton("Text");
		textButton.setActionCommand(Target.TARGET_TYPE_TEXT + "");
		textButton.addActionListener(myActionListener);
		
		this.add(lineButton);
		this.add(rectButton);
		this.add(circleButton);
		this.add(textButton);
		
			
	}
	
	
	
	
}
