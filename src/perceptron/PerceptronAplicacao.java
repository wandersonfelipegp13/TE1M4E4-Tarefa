package perceptron;

import dados.LerCSV;

public class PerceptronAplicacao {
	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {

		double[] w = PerceptronTreinamento.main(args);

		LerCSV arq = new LerCSV();
		double[][] dados = arq.mat("src/files/Tabela-Amostras-para-validar_RNA_M4_3.6.csv");
		int linhas = arq.getLinhas();
		int colunas = arq.getColunas();

		// adicionado o 1
		double[][] entrada = new double[linhas][colunas + 1];
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas + 1; j++) {
				if (j == 0)
					entrada[i][j] = 1;
				else
					entrada[i][j] = dados[i][j - 1];
			}
		}

		for (int i = 0; i < entrada.length; i++) {
			
			// calcular
			double u = 0;

			for (int j = 0; j < w.length; j++)
				u = u + w[j] * entrada[i][j];

			double yr = sinal(u);

			if (yr == -1.0)
				System.out.println("P1");
			else
				System.out.println("P2");
		}
	}

}
