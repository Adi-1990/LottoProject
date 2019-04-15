package lotto6Of49;
//Lotto 6 din 49

// PAS : declaram un sir de 6 numere, pentru "biletul lotto"
// PAS : Generam 6 numere aleatore, de la 1 la 49. Daca numarul generat exista deja, se genereaza unul nou
// PAS : Cele 6 numere aleatoare se vor pune intr-un sir
// PAS : Vom compara cele 2 siruri pentru a vedea cate numere din cele 6 am "nimerit"
// PAS : in functie de cate numere avem, rezulta premiul

import java.util.Arrays;
import java.util.Random;

public class Lotto6Of49 {

	public static void main(String[] args) {

		int[] nrBilet = { 28, 7, 12, 24, 36, 17 };

		// Se verifica daca biletul are 6 numere
		if (nrBilet.length != 6) {
			System.out.println("Biletul nu este valid");
		}

		// Se genereaza numere aleatoare, de la 1 la 49, fara a se repeta
		int[] numere = new int[6];
		Random random = new Random();
		for (int i = 0; i < numere.length; i++) {
		while (numere[i] == 0) {
				numere[i] = random.nextInt(49);
			}
			for (int j = 0; j <= i - 1; j++) {
				if (numere[j] == numere[i] || numere[i] == 0) {
					numere[i] = random.nextInt(49);
					j = -1;
				}
			}
		}
		// Arrays.sort(numere);
		System.out.print("Numerele extrase: ");
		System.out.println(Arrays.toString(numere));
		System.out.print("Numerele de pe bilet: ");
		System.out.println(Arrays.toString(nrBilet));

		// Compararea "numerelor de pe bilet" cu cele "Extrase" si incrementarea
		// numerelor ghicite
		int numereGhicite = 0;
		for (int i = 0; i < nrBilet.length; i++) {
			for (int j = 0; j < numere.length; j++) {
				if (nrBilet[i] == numere[j]) {
					numereGhicite++;
				}
			}
		}
		System.out.println("Numere ghicite: " + numereGhicite);
	}
}
