package homework;

public class Rettangolo {
	int base;
	int altezza;
	
	public Rettangolo(int a, int b) {
		this.base= a;
		this.altezza= b;
	}
	
	private int perimetro() {
		int perimetro = 2*(this.base+this.altezza);
		return perimetro ;
	}
	
	private int area() {
		int area = this.base*this.altezza;
		return area;
	}
	
	public static void stampaRettangolo(Rettangolo r) {
		System.out.println("Perimetro: " + r.perimetro());
		System.out.println("Area: " + r.area());
	}
	
	public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		System.out.println("Somma perimetri: " + (r1.perimetro() + r2.perimetro()));
		System.out.println("Somma area: " + (r1.area() + r2.area()));
	}
	
}
