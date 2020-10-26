package exercises7;

public class Book {
	 private String name;
	 private int pages;
	 private int nowRead;
	 private int readPage;
	 
	public Book(String name, int pages) {
//		super();
		this.name = name;
		this.pages = pages;
		this.nowRead = 0;
	}
	public void read(int readPage) {
		this.nowRead = this.nowRead + readPage;
	}
	public int getNowRead() {
		return nowRead;
	}

	
	
	
 
}
