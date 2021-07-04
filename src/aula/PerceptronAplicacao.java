package aula;

public class PerceptronAplicacao {
	
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {
		// Depois de treinada, a rede pode ser usada para classificar novas entradas
		double[] w = { -369.99999999998755, 95.0000000000127, -1998.2200000004568 };
		// -370. 95. -1998.22]
		double[] entrada = { 1, 110, 6.5 };
		// calcular
		double u = 0;
		for (int i = 0; i < w.length; i++) {
			u = u + w[i] * entrada[i];
		}
		double yr = sinal(u);
		if (yr == -1.0)
			System.out.println("maçã");
		else
			System.out.println("laranja");
	}

}
