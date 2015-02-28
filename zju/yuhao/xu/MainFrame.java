package zju.yuhao.xu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -829899122432614586L;
	private Dimension frameSize;
	private JPanel northPanel;
	private ChangeTarget changeTarget;
	private CreateTarget createTarget;
	private Canvas canvas;
	private TargetController m_TargetController;
	private MyActionListener m_myActionListener;
	
	public MainFrame(TargetController targetController, MyActionListener myActionListener) {
		m_TargetController = targetController;
		m_myActionListener = myActionListener;
		// TODO Auto-generated constructor stub
		makeFrame();
	}
	
	
	private void makeFrame() {
		// TODO Auto-generated method stub
		this.setTitle("MiniCAD");
		this.setMinimumSize(new Dimension(500, 500));
		Toolkit tk = Toolkit.getDefaultToolkit();  
	    Dimension screenSize = tk.getScreenSize();  
	    System.out.println(screenSize);
	    frameSize = new Dimension((int)screenSize.getWidth()/3*2, (int)screenSize.getHeight()/3*2);
	    this.setSize(frameSize);
	    System.out.println(this.getSize());
	    this.setLocationRelativeTo(null);
//        this.setResizable(false);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.pack();
		this.setLayout(new BorderLayout(5,5));
		addContainers();
		this.setVisible(true);
	}
	
	
	private void addContainers() {
		// TODO Auto-generated method stub
		
		this.northPanel = new JPanel(new BorderLayout());
		this.changeTarget = new ChangeTarget(new Dimension((int)(frameSize.getWidth()/2),(int)(frameSize.getHeight()/6)), m_myActionListener);
		this.northPanel.add(changeTarget, BorderLayout.EAST);
		
		
		this.createTarget = new CreateTarget(new Dimension((int)(frameSize.getWidth()/2),(int)(frameSize.getHeight()/6)), m_myActionListener);
		this.northPanel.add(createTarget, BorderLayout.WEST);	
		this.add(northPanel,BorderLayout.NORTH);

			
		this.canvas = new Canvas(this.m_TargetController, this.m_myActionListener);
		this.add(canvas, BorderLayout.CENTER);
		
		
		
			
		JMenuBar menubar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		JMenuItem saveItem = new JMenuItem("save");
		JMenuItem loadItem = new JMenuItem("load");
		JMenuItem quitItem = new JMenuItem("quit");
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = image.createGraphics();
				canvas.paintComponent(g2);
				
				File saveFile = new File("savedimage.jpg");
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("./"));
				chooser.setSelectedFile(saveFile);
				
				int rval = chooser.showSaveDialog(canvas);
				if (rval == JFileChooser.APPROVE_OPTION) {
					saveFile = chooser.getSelectedFile();
					try {
						ImageIO.write(image, "jpg", saveFile);
					} catch (IOException ex){
						System.out.println("can not save a image");
						ex.printStackTrace();
					}
				}	
			}
		});
		
		loadItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("./"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
				chooser.setFileFilter(filter);
				int rval = chooser.showOpenDialog(canvas);
				File openFile = null;
				if (rval == JFileChooser.APPROVE_OPTION){
					openFile = chooser.getSelectedFile();
					try{
						BufferedImage image = ImageIO.read(openFile);
						canvas.setImage(image);
						repaintCanvas();
					} catch (IOException ex){
						System.out.println("can not load a image");
					}
				}
				System.out.println("load a jpg");	
			}
		});
		
		quitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(quitItem);
		this.setJMenuBar(menubar);	
	}
	
	public void repaintCanvas(){
		canvas.repaint();
	}
	
	public Graphics2D getCanvasGarphics2d(){
		return (Graphics2D)canvas.getGraphics();
	}
	
	
}
