package testt;

public class maina {
	int x;
	Float y = 99f;
	String name = "Hello World";
	
	public maina() {
//		x = Integer.parseInt(x);
		y.toString();
		y.longValue();
//		System.out.print(x);
		System.out.println(y.MAX_VALUE); //untuk cek batas data type
		System.out.println(name.equals("hello world")); //cek sama atau gak
		System.out.println(name.equalsIgnoreCase("hello world")); //cek sama atau gk tp gapeduliin lower/uppercase
		System.out.println(name.compareTo("Budi ")); //untuk bandingin asciinya
		System.out.println(name.substring(2)); //untuk potong output string
		System.out.println(name.indexOf("W")); //cari index
	}

	public static void main(String[] args) {
		new maina();
	}

}
