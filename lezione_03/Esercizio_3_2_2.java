
public class Esercizio_3_2_2 {
	private int dim;
	
	public Esercizio_3_2_2(int d) {
	    dim = d;
    }
	
	public void show() {
		int i = 1;
		while(i <= dim) {
			int j = 1;
			while(j <= dim) {
				System.out.print(i * j);
				System.out.print("\t");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("---");
	}

	public static void main(String[] args) {
		Esercizio_3_2_2 x = new Esercizio_3_2_2(5);
		Esercizio_3_2_2 y = new Esercizio_3_2_2(10);
		Esercizio_3_2_2 z = new Esercizio_3_2_2(12);
		x.show();y.show();z.show();
	}
}
