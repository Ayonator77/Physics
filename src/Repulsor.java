import java.awt.Graphics;

public class Repulsor {
	Vector location;
	Vector velocity;
	
	double mass;

	
	Repulsor(int x, int y){
		
		location = new Vector(x,y);
		velocity = new Vector(.1,.001);

		mass = 20;
	}
	 public Vector repulse(Mover m){
		 Vector force = location.sub(m.location);
		 
		 return force.mult(-.0000001);
		
	}
	 
	public void update(){
//		location = location.add(velocity);
//		if(location.x > 1000){
//			location.x += -location.x;
//		}
//		if(location.y > 1000){
//			location.y += -location.y;
//		}
	}
	 
	
	 
	void draw(Graphics g){
		g.fillOval((int) location.x, (int)location.y, (int)mass*2, (int)mass*2);
		
	}

}


