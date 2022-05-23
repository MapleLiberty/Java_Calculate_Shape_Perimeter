public class Triangle implements Shape {
	double base;
	double side1;
	double side2;
	
	Triangle(double side1,double base, double side2) throws IllegalArgumentException{
		if(side1 > 0 && base > 0 && side2 > 0 && side2 < ( side1 + base ) ) { // correct
			this.base = base;
			this.side1 = side1;
			this.side2 = side2;
		}
		else if(side1 < 0 || base < 0 || side2 < 0) { // throw exception - zero or negative value
			throw new IllegalArgumentException("Invalid side(s)!");
		}
		else if(side2 > side1 + base) { // throw exception - Triangle: longest side < side1 + side2
			throw new IllegalArgumentException("Invalid side(s)!");  // Wrong values for three sides of a triangle
		}
	}
	
	public String toString() {
		return getClass().getSimpleName() + " {s1="+side1+", s2="+base+", s3="+side2+"} perimeter = "+getPerimeter();
	}
	
	public void setSideOne(double side) throws IllegalArgumentException{
		if(side > 0)
			side1 = side;
		else{
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public void setSideTwo(double side) throws IllegalArgumentException{
		if(side > 0)
			base = side;
		else{
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public void setSideThree(double side) throws IllegalArgumentException{
		if(side > 0)
			side2 = side;
		else{
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public double getSideOne() {
		return side1;
	}
	
	public double getSideTwo() {
		return base;
	}
	
	public double getSideThree() {
		return side2;
	}
	
	public double getPerimeter() {
		return (double)Math.round((base + side1 + side2)*100)/100;
	}
}
