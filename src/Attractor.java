import java.awt.*;

public class Attractor {
	Vector location;
	Vector velocity;
	
	double mass;

	
	Attractor(int x, int y){
		
		location = new Vector(x,y);
		velocity = new Vector(.1,.001);

		mass = 20;
	}
	 public Vector attract(Mover m){
		 Vector force = location.sub(m.location);
		 
		 return force.mult(.000000001);
		
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


