package studio6;

public class beer {
public static String bottlesOfBeer(int n) {
if (n == 0) {
	String beer = "0 bottles of beer on the wall";
	return beer; 
	}
else {
	String beer2 = n +" bottles of beer on the wall," + n +" bottles of beer, you take one down, pass it around, ";
	return beer2 + bottlesOfBeer (n-1);
	}
}

public static void main(String[] args) {
	
	System.out.println(bottlesOfBeer(5));
}

}
