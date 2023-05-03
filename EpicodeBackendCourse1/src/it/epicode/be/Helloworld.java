package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

		

		public static void main (String[] args)
			{
				// Stampa a console  la frase
				System.out.println("This is my first Epicode Java Project!");

				//es. 2/1
				int x= 8;
				int y=5;
		
				System.out.println("Es 2/1: " + moltiplica(x,y));
				
				//es. 2/2
				String a = "Anno:";
				int b = 1997;
				
				System.out.println("Es 2/2: " + concatena(a,b));
				
				//es. 2/3
				String arr1[]= new String[5];
				arr1[0]= "a";
				arr1[1]= "b";
				arr1[2]= "d";
				arr1[3]= "e";
				arr1[4]= "f";
				
				String add= "c";
				
				String arr2[] = new String [arr1.length +1];
				
				for(int i = 0; i < arr2.length; i++) {
					if(i < 2) {
						arr2[i]= arr1[i];
					} else if(i == 2) {
						arr2[i]= add;
					} else if (i > 2){
						arr2[i]= arr1[i-1];
					}
					System.out.println("elemento arr: " + arr2[i]);
				}

				//es. 3 
				Scanner sc= new Scanner(System.in);
				System.out.print("Inserisci una STRINGA");
				String s= sc.next();
				
				Scanner sb= new Scanner(System.in);
				System.out.print("Inserisci una STRINGA");
				String t= sb.next();
				
				Scanner sa= new Scanner(System.in);
				System.out.print("Inserisci una STRINGA");
				String p= sa.next();
				
				System.out.println("Es 3: " + s + " " + t + " " + p);
				
				//es. 4/1
				double h=4.3;
				double g=3.2;
				
				System.out.println("Es. 4/1: " + perimetroRetangolo(h,g));
				
				//es. 4/2
				int num1= 3;
				
				System.out.println("Es. 4/2: " + pariDispari(num1));
				
			
				
			}
		
		//es. 2/1
		public static  int moltiplica(int x, int y)
			{
				return x*y;
			}
		//es. 2/2
		public static String concatena(String a, int b) 
			{
				return a+b;
			}

		//es. 4/1
		public static double perimetroRetangolo(double h, double g)
			{
				return (h+g)*2;
			}
		
		//es. 4/2
		public static String pariDispari(int num1)
			{
			float res = num1 % 2;
				if (res == 0){
					return "Pari";
				} else {
					return "Dispari";
				} 
			}
		
		
		
}



