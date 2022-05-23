public class Parallelogram extends Rectangle {
	
	Parallelogram(double width,double length){
		super(width,length);
	}
	
	public String toString() {
		return getClass().getSimpleName() + " {w="+width+", h="+length+"} perimeter = "+getPerimeter();
	}
}
