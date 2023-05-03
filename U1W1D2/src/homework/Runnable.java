package homework;

public class Runnable {
	public static void main (String[] args) {
		Rettangolo r1 = new Rettangolo(5,10);
		Rettangolo r2 = new Rettangolo(3,8);
		
		Rettangolo.stampaRettangolo(r1);
		Rettangolo.stampaRettangolo(r2);
		
		Rettangolo.stampaDueRettangoli(r1, r2);
		}
}
