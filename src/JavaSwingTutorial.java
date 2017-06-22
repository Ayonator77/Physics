import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

@SuppressWarnings("serial")
public class JavaSwingTutorial extends JFrame{
	
	public JavaSwingTutorial(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		this.setSize(400,400);
		int xPos = (dim.width/2) - (this.getWidth());
		int yPos = (dim.height+10) - (this.getHeight());
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		this.setTitle("My first frame");
		
		JPanel newPanel = new JPanel();
		JLabel label1 = new JLabel("Tell me something");
		label1.setToolTipText("Nothing");
		newPanel.add(label1);
		JButton b1 = new JButton("Something");
		newPanel.add(b1);
		JTextField newField = new JTextField(10);
		newPanel.add(newField);
		this.add(newPanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		JavaSwingTutorial obj = new JavaSwingTutorial();
	}
	
	
}
