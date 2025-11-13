
public class Esercizio_3_2_1 {
	private int dim;
	
	public Esercizio_3_2_1(int d) {
		dim = d;
	}
	
	public void show() {
		for(int i = 1; i <= dim; i++) {
			for(int j = 1; j <= dim; j++) {
				System.out.print(i * j);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("---");
	}

	public static void main(String[] args) {
		Esercizio_3_2_1 x = new Esercizio_3_2_1(5);
		Esercizio_3_2_1 y = new Esercizio_3_2_1(10);
		Esercizio_3_2_1 z = new Esercizio_3_2_1(12);
		x.show();y.show();z.show();
	}
}
