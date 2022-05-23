import static java.lang.Math.PI;

public class Circle implements Shape {
	private double radius; 
	OneParamArea area;
	
	Circle(double radius) throws IllegalArgumentException{
		if(radius > 0) { // correct
			this.radius = radius;
			area = x -> (double) Math.round((Math.PI * x * x)*100)/100;
		}
		else{ // throw exception - zero or negative value
			throw new IllegalArgumentException("Invalid radius!");
		}
	}
	
	public String toString() {
		return getClass().getSimpleName() + " {r="+radius+"} perimeter = "+getPerimeter() + " Area = " + area.getArea(radius); // put functionalInterface in main
	}
	
	public void setRadius(double radius) throws IllegalArgumentException{
		if(radius > 0)
			this.radius = radius;
		else{
			throw new IllegalArgumentException("Invalid radius!");
		}
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getPerimeter() {
		return (double)Math.round((2 * radius * PI)*100000)/100000; 
	}
	
}
