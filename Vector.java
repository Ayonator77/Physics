
public class Vector {
	double x;
	double y;
	
	Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getXComponent(){
		return this.x;
	}
	
	public double getYComponent(){
		return this.y; 
	}
	
	public double getMagnitutde(){
		double mag;
		mag = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		return mag;
	} 
	 
	public Vector add(Vector vector){ 
		double newX, newY;
		Vector sumVec;
		newX = this.x + vector.x;
		newY = this.y + vector.y;
		sumVec = new Vector(newX, newY);
		return sumVec;
	}
	
	public Vector sub(Vector vector){
		double newX, newY;
		Vector diffVec;
		newX = this.x - vector.x;
		newY = this.y - vector.y; 
		diffVec = new Vector(newX, newY);
		return diffVec;
	}
	
	public double cross(Vector vector){
		 return (this.x * this.y) + (vector.x * vector.y);
	}
	
	public double dot(Vector vector){
		return (this.x * vector.x) + (this.y * vector.y);
	} 
	
	public static void main(String[] args){
		Vector newVector = new Vector(6,4);
		Vector someVector = new Vector(3,5);
		Vector vect;
		vect = someVector.sub(newVector);
		System.out.println("X component: "+vect.getXComponent());
		System.out.println(newVector.getMagnitutde());
		
	}

}