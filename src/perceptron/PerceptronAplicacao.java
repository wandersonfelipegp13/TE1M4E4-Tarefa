package perceptron;

public class PerceptronAplicacao {
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}
	public static void main(String[] args) {
		
		// Depois de treinada, a rede pode ser usada para classificar novas entradas
		double [] w = { -240.2800000000491, 11.640000000021278, -250.17200000021353 };
		double [] entrada = {1, 110, 6.5};
		
		//calcular
		double u = 0;
		
		for (int i=0; i<w.length; i++)
			u = u + w[i] * entrada[i];
		
		double yr = sinal(u);
		
		if (yr == -1.0)
			System.out.println("maçã");
		else
			System.out.println("laranja");
	
	}

}
