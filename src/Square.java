public class Square implements Shape{
	double length;
	OneParamArea area;
	
	Square(double length) throws IllegalArgumentException{
		if(length > 0) { // correct
			this.length = length;
			area = x -> (double)Math.round((x*x)*100)/100;
		}
		else{ // throw exception - zero or negative value
			throw new IllegalArgumentException("Invalid side!");
			
		}
	}
	
	public String toString() {
		return getClass().getSimpleName() + " {s="+length+"} perimeter = "+getPerimeter() + " Area = " + area.getArea(length);
	}
	
	public void setLength(double length) throws IllegalArgumentException {
		if(length > 0)
			this.length = length;
		else{
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public double getLength() {
		return length;
	}
	
	public double getPerimeter() {
		return 4 * length;
	}
	
}
