public class Esercizio_3_2_3 {
	private int dim;
	
	public Esercizio_3_2_3(int d) {
		dim = d;
	}
	
	public void show() {
		int i = 1;
        do {
            int j = 1;
            do {
                System.out.print(i * j);
                System.out.print("\t");
                j++;
            } while(j <= dim);
            System.out.println();
            i++;
        } while(i <= dim);
		System.out.println("---");
	}

	public static void main(String[] args) {
		Esercizio_3_2_3 x = new Esercizio_3_2_3(5);
		Esercizio_3_2_3 y = new Esercizio_3_2_3(10);
		Esercizio_3_2_3 z = new Esercizio_3_2_3(12);
		x.show();y.show();z.show();
	}
}