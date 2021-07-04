package perceptron;

public class PerceptronAplicacao {
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {

		double[] w = PerceptronTreinamento.main(args);

		double[] entrada = { 1, -0.3665, 0.0620, 5.9891 };

		// calcular
		double u = 0;

		for (int i = 0; i < w.length; i++)
			u = u + w[i] * entrada[i];

		double yr = sinal(u);

		if (yr == -1.0)
			System.out.println("P1");
		else
			System.out.println("P2");

	}

}
