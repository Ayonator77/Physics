import java.awt.Graphics;
import javax.swing.*;

@SuppressWarnings("serial")
public class BouncingBall extends JPanel{
	int xPos = 0;
	int yPos = 0;
	int angleX = 10;
	int angleY = 10;
	//int speed = 5;
	
	
	public void move(){
		if(xPos + angleX < 0){
			angleX = 5;
		} else if(xPos + angleX > getWidth()-10){
			angleX = -5;
		} else if(yPos + angleY < 0){
			angleY = 5;
		} else if(yPos + angleY > getHeight()-10){
			angleY = -5;
		}
		
		xPos += angleX;
		yPos += angleY;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(xPos, yPos, 10, 10);
	}
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Moving Ball");
		BouncingBall ball = new BouncingBall();
		frame.add(ball);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			ball.move();
			ball.repaint();
			Thread.sleep(10);
		}
	}
}