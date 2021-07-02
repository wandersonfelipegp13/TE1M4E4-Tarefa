package perceptron;

import java.util.Iterator;

import dados.LerCSV;

public class PerceptronTreinamento {

	static final int numEpocas = 100000;
	static final int numAmostras = 6;

	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {

		LerCSV arq = new LerCSV();
		double[][] dados = arq.mat("src/files/Tabela_Dados_Treinamento_M4_3.6_RNA.csv");
		
		for (int i = 0; i < arq.getLinhas(); i++) {
			for (int j = 0; j < arq.getColunas(); j++) {
				System.out.print(dados[i][j] + ",");
			}
			System.out.println();
		}

		// TODO add 1 para meus x
		// Obter os dados de treinamento
		// theta (bias), P1, P2, P3 (P = propriedades físico-químicas)
		
		// 1.0,-0.6508,0.1097,4.0009,-1.0000
		
		double[][] x = new double[1][1];
		
		/*
		for (int i = 0; i < dados.length; i++) {
			x[i]
		}
		*/

		// OBS: a saida esperada ja vem com o x do jeito implementado
		double[] d = { -1, 1, -1, -1, 1, 1 }; // saída esperada: -1 = maçã e 1 = laranja
		// (3) inicar os pesos w

		// TODO fazer esses valores aleatórios
		double[] w = { 1, 1, 1 }; // pode usar valores aleatórios

		// (4) taxa aprendizagem
		double eta = 0.01;
		// (5) iniciar o erro
		double[] e = { 0, 0, 0, 0, 0, 0 };
		double u = 0;
		double yr = 0;
		// (6) repetir número de épocas
		for (int epoca = 0; epoca < numEpocas; epoca++) {

			// Para todas amostras treinar:
			for (int amostra = 0; amostra < x.length; amostra++) {

				u = 0; // somatória

				for (int i = 0; i < w.length; i++)
					u = u + w[i] * x[amostra][i];

				// calcular o yr pela função de ativação - função sinal ou degrau bipolar
				yr = sinal(u);
				// calcular o erro
				e[amostra] = d[amostra] - yr;
				// ajuste dos pesos
				for (int i = 0; i < w.length; i++)
					w[i] = w[i] + eta * e[amostra] * x[amostra][i];

			}
		}
		// saída
		System.out.println("pesos w: ");

		for (int i = 0; i < w.length; i++)
			System.out.print(w[i] + ", ");

		System.out.println("\nerro e: ");

		for (int i = 0; i < e.length; i++)
			System.out.print(e[i] + ", ");

	}

}
