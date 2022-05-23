public class Rectangle implements Shape {
	double length;
	double width;
	TwoParamArea area;
	
	Rectangle(double width,double length) throws IllegalArgumentException{
		if(width > 0 && length > 0) { // correct
			this.length = length;
			this.width = width;
			area = (x,y)-> (double)Math.round((x*y)*100)/100;
		}
		else{ // throw exception - zero or negative value
			throw new IllegalArgumentException("Invalid side(s)!");
		}
	}
	
	public String toString() {
		return getClass().getSimpleName() + " {w="+width+", h="+length+"} perimeter = "+getPerimeter() + " Area = " + area.getArea(length,width);
	}
	
	public void setLength(double length) throws IllegalArgumentException{
		if(length > 0)
			this.length = length;
		else{ 
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public void setWidth(double width) throws IllegalArgumentException{
		if(width > 0)
			this.width = width;
		else{
			throw new IllegalArgumentException("Invalid side!");
		}
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getPerimeter() {
		return (double)Math.round((2 * length + 2 * width)*10000)/10000;
	}
}
