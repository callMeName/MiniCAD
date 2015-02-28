package zju.yuhao.xu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	private TargetController c_targetController; 
	private MyActionListener c_myActionListener;
	private boolean ifImage = false;
	private List<BufferedImage> c_imageList = new ArrayList<BufferedImage>();
	
	
	public Canvas(TargetController targetController, MyActionListener myActionListener){
		this.c_targetController = targetController;
		this.c_myActionListener = myActionListener;
		this.setBackground(new Color(144, 144, 144));
		this.addMouseListener(c_myActionListener);
		this.addMouseMotionListener(c_myActionListener);
	}
	
	public void setImage(BufferedImage image){
		c_imageList.add(image);
		ifImage = true;
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(ifImage){
			for(BufferedImage image:c_imageList)
				g.drawImage(image, this.getX(), this.getY(), this);
		}	
		this.c_targetController.renderAll(g);

		
	}
	
	
	
	
	
	

}
