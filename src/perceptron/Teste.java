package perceptron;

public class Teste {
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {

		double[] w = PerceptronTreinamento.main(args);
		
		// double[] entrada = { 1, -0.3665, 0.0620, 5.9891 };
		// double[] entrada = { 1, -0.7842, 1.1267, 5.5912 };
		// double[] entrada = { 1, 0.3012, 0.5611, 5.8234 };
		// double[] entrada = { 1, 0.7757, 1.0648, 8.0677 };
		// double[] entrada = { 1, 0.1570, 0.8028, 6.3040 };
		double[] entrada = { 1, -0.7014, 1.0316, 3.6005 };
		// double[] entrada = { 1, 0.3748, 0.1536, 6.1537 };
		// double[] entrada = { 1, -0.6920, 0.9404, 4.4058 };
		// double[] entrada = { 1, -1.3970, 0.7141, 4.9263 };
		// double[] entrada = { 1, -1.8842, -0.2805, 1.2548 };

		double u = 0;

		for (int i = 0; i < w.length; i++) {
			u = u + w[i] * entrada[i];
		}

		double yr = sinal(u);
		if (yr == -1.0)
			System.out.println("P1");
		else
			System.out.println("P2");
	}
}
