import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class CalculateShape {
	public static void main(String[] args) {
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");
		
		String filename = "Shapes.txt";
		
		String s;
		
		int count = 0;
		try(BufferedReader brTest = new BufferedReader(new FileReader(filename))){
			while((s = brTest.readLine()) != null) {
				count++;
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		Shape shapes[] = new Shape[count];
		int is = 0; // index of shape
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				
				if(tokens[0].equals("Circle")) {
					if(tokens.length != 2) { // ignore - does not contain necessary number of values
					}
					else {
						try {
							shapes[is] = new Circle(Double.parseDouble(tokens[1]));
							is++;
						}
						catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				else if(tokens[0].equals("Parallelogram")) {
					if(tokens.length != 3) { // ignore - does not contain necessary number of values
					}
					else {
						try {
							shapes[is] = new Parallelogram(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
							is++;
						}
						catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				else if(tokens[0].equals("Rectangle")) {
					if(tokens.length != 3) { // ignore - does not contain necessary number of values
					}
					else {
						try {
							shapes[is] = new Rectangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
							is++;
						}
						catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				else if(tokens[0].equals("Square")) {
					if(tokens.length != 2) { // ignore - does not contain necessary number of values
					}
					else {
						try {
							shapes[is] = new Square(Double.parseDouble(tokens[1]));
							is++;
						}
						catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}					
				}
				else if(tokens[0].equals("Triangle")) {
					if(tokens.length != 4) { // ignore - does not contain necessary number of values
					}
					else {
						try {
							shapes[is] = new Triangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
							is++;
						}
						catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println( is + " shapes were created:");
		
		for(int i=0; i < is; i++) {
			System.out.println(shapes[i].toString());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("------->Task 2 ... <-------");
		
		double minTriPeri = 0;
		double maxCirPeri = 0;
		
		for(int i = 0; i < is; i++) {  // search for Minimum Triangle Perimeter and Maximum Circle Perimeter
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				double temp = shapes[i].getPerimeter();
				if(minTriPeri == 0 || temp < minTriPeri )
					minTriPeri = temp;
			}
			else if(shapes[i].getClass().getSimpleName().equals("Circle")) {
				double temp = shapes[i].getPerimeter();
				if(maxCirPeri == 0 || temp > maxCirPeri )
					maxCirPeri = temp;
			}
		}
		
		for(int i = 0; i < is; i++) { // remove Triangle with minimum perimeter and Circle with maximum perimeter from the array 
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				if(shapes[i].getPerimeter() == minTriPeri) {
					for(int j = i; j < is-1; j++) {
						shapes[j] = shapes[j+1];
					}
					is--;
					i--; // shifted element gets skipped at checking, so decrement the counter to make sure the shifted element gets checked
				}
			}	
			else if(shapes[i].getClass().getSimpleName().equals("Circle")) {		
				if(shapes[i].getPerimeter() == maxCirPeri) {
					for(int j = i; j < is-1; j++) {
						shapes[j] = shapes[j+1];
					}
					is--;
					i--; // shifted element gets skipped at checking, so decrement the counter to make sure the shifted element gets checked
				}		
			}
		}
		
		for(int i = 0; i < is; i++) {
			System.out.println(shapes[i].toString());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("------->Task 3 ... <-------");
		
		double totalPar = 0;
		double totalTri = 0;
		
		for(int i = 0; i < is; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Parallelogram")) {
				totalPar += shapes[i].getPerimeter();
			}
			else if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				totalTri += shapes[i].getPerimeter();
			}
		}
		
		System.out.println("Total perimeter of Parallelogram is: " + totalPar);
		System.out.println("Total perimeter of Triangle is: " + totalTri);
		
	}
}
