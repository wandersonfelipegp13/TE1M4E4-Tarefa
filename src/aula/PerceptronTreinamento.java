package aula;

public class PerceptronTreinamento {
	
	static final int numEpocas = 100000;
	static final int numAmostras = 6;
	
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}
	
	public static void main(String[] args) {
		
		// Obter os dados de treinamento
		double [][] x = { //theta (bias), peso, pH
				{1, 113, 6.8},
				{1, 122, 4.7},
				{1, 107, 5.2},
				{1, 98, 3.6},
				{1, 115, 2.9},
				{1, 120, 4.2}};
		double [] d = {-1, 1, -1, -1, 1, 1}; //saída esperada: -1 = maçã e 1 = laranja
		// (3) inicar os pesos w
		double [] w = {1, 1, 1}; //pode usar valores aleatórios
		// (4) taxa aprendizagem
		double eta = 0.01;
		// (5) iniciar o erro
		double [] e = {0, 0, 0, 0, 0, 0};
		double u = 0;
		double yr = 0;
		// (6) repetir número de épocas
		for (int epoca = 0; epoca < numEpocas; epoca++) {
			// Para todas amostras treinar:
			for (int amostra = 0; amostra < x.length; amostra ++) {
				u = 0; //somatória
				for (int i=0; i<w.length; i++) {
					u = u + w[i] * x[amostra][i];
				}
				// calcular o yr pela função de ativação - função sinal ou degrau bipolar
				yr = sinal(u);
				// calcular o erro
				e[amostra] = d[amostra] - yr;
				// ajuste dos pesos
				for (int i=0; i<w.length; i++) {
					w[i] = w[i] + eta * e[amostra]*x[amostra][i];
				}
			}
		}
		//saída
		System.out.println("pesos w: ");
		for (int i=0; i<w.length; i++) {
			System.out.print(w[i] + ", ");
		}
		System.out.println("\nerro e: ");
		for (int i=0; i<e.length; i++) {
			System.out.print(e[i] + ", ");
		}		

	}

}
