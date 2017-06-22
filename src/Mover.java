import java.awt.*;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Mover extends JComponent{
	Vector location;
	Vector velocity;
	Vector acceleration;
	double mass;
	
	
	Mover(int x, int y){
		location = new Vector(x, y);
		velocity = new Vector(0,0);
		acceleration = new Vector(0,0);
		mass = 1;
	}
	
	
	void applyForce(Vector force){
		Vector f = force.divide(mass);
		acceleration = acceleration.add(f);
		
	}
	void update(){
		location = location.add(velocity);
		velocity = velocity.add(acceleration);
		acceleration = acceleration.mult(0.01);
		double mag = velocity.getMagnitutde();
		if(mag > 6){
			velocity = velocity.normalize();
			velocity = velocity.mult(6);
		}
	}
	int a = 0;
	public void draw(Graphics g){
		g.fillOval((int)location.x,(int)location.y,5,5);
		
	}
	public static int constrain(double num, int upperBound, int lowerBound){
		if (num > upperBound){
			num = upperBound;
		}
		if (num < lowerBound){
			num = lowerBound;
		}
		
		
		
		return (int)num;
	 }
	

}

