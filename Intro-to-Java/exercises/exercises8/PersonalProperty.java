package exercises8;

public class PersonalProperty {
	private final int value;
	private int year;

	public PersonalProperty(int value, int year) {
		this.value = value;
		this.year = year;
	}
	public int depreciatedValue() {
		return (int)(value * Math.pow(0.80, year));
	}
	
	public void yearOlder() {
		this.year = this.year+1;
	}

	@Override
	public String toString() {
		return "PersonalProperty [value=" + value + ", year=" + year + "]";
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//	}

}
