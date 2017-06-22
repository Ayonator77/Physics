import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class OrbitPlane extends JPanel{
	static JFrame frame = new JFrame();
	Mover ball = new Mover(30,30);
	Mover moon = new Mover(100,200);
	ArrayList<Mover> movers = new ArrayList<Mover>();
	ArrayList<Attractor > attractors = new ArrayList<Attractor>();
	Attractor a = new Attractor(200,200);
	Attractor b = new Attractor(500,100);
	Attractor c = new Attractor (300,150);
	Attractor d = new Attractor (350,400);
	Vector attractiveForce;
	static Timer t = new Timer();
	Vector gravity = new Vector(0,0.001);
	Vector wind = new Vector (.0001, 0);
	
	OrbitPlane(){
		
		for(int i = 0; i < 55; i++){
			movers.add(new Mover( (int)(Math.random()*1000 ),(int)(Math.random()*1000)));
		}
		
		for(int a = 0; a < 4; a++){
			int angle = (int) ((int) (a * Math.PI) + Math.PI/3);
			attractors.add(new Attractor((int)(100*Math.cos(angle)+500), (int)(100*Math.sin(angle)+300)));
		}
//		attractors.add(a);
//		attractors.add(b);
//		attractors.add(c);
//		attractors.add(d);
		for(Mover mover : movers){
			this.add(mover);
		}
		this.setSize(1000,1000);
		t.schedule(new TimerTask(){
			public void run(){
				a.update();
				for(Attractor a : attractors){
					for(Mover mover : movers){
						mover.applyForce(a.attract(mover));
						mover.update();
					}
				}
				frame.repaint();
			}
		},0,1);
	}
	
	public void paint(Graphics g){
		Vector subVelocity;
		for(Attractor a : attractors){
			a.draw(g);
			a.update();
			for(Mover aMover : movers){
				for(Mover mover : movers){
					if(!mover.equals(aMover)){
						subVelocity = mover.location.sub(aMover.location);
						if(subVelocity.getMagnitutde() < 5){
							//subVelocity = subVelocity.multiply(-1);
							subVelocity = subVelocity.normalize().mult(0.005);
							mover.velocity = mover.velocity.add(subVelocity);
						}
					}
					mover.applyForce(a.attract(mover));
					mover.draw(g);
					mover.update();
				}
			}
		}
	
//		int x1, y1, x2, y2;
//		x1 = (int)ball.location.x;
//		y1 = (int)ball.location.y;
//		x2 =  (int)a.location.x;
//		y2 =  (int) a.location.y;
		
		//g.drawLine(x1, y1, x2,y2);
		System.out.println("x: "+ a.location.x+ " "+ "y: "+ a.location.y);
	}
	
	public static void main(String[] args){
		OrbitPlane plane = new OrbitPlane();
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(plane);
		frame.setVisible(true);
	}
}