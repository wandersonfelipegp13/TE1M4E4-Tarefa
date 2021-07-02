package perceptron;

import java.util.Iterator;

import dados.LerCSV;

/**
 * Nessa versão a quantidade de registros de óleos, assim como a quantidade de
 * propriedades desses óleos é processada dinamicamente.
 * 
 * @author Wanderson
 *
 */
public class PerceptronTreinamento {

	static final int numEpocas = 100000;
	static final int numAmostras = 30;

	static double sinal(double u) {
		if (u <= 0)
			return -1;
		return 1;
	}

	public static void main(String[] args) {

		LerCSV arq = new LerCSV();
		double[][] dados = arq.mat("src/files/Tabela_Dados_Treinamento_M4_3.6_RNA.csv");
		int linhas = arq.getLinhas();
		int colunas = arq.getColunas();

		// Obter os dados de treinamento
		// 1.0,-0.6508,0.1097,4.0009,-1.0000 (exemplo de x)
		// theta (bias), p1, p2, p3 (p = propriedade físico-química), d
		// colunas + 1 pois adiciono 1 na posição 0 de x
		double[][] x = new double[linhas][colunas + 1];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas + 1; j++) {
				if (j == 0)
					x[i][j] = 1;
				else
					x[i][j] = dados[i][j - 1];
			}
		}

		// OBS: a saida esperada ja vem com o x do jeito implementado
		double[] d = { -1, 1, -1, -1, 1, 1 }; // saída esperada: -1 = P1 e 1 = P2
		// (3) inicar os pesos w

		// TODO fazer esses valores aleatórios
		double[] w = { 1, 1, 1, 1 }; // pode usar valores aleatórios

		// (4) taxa aprendizagem
		double eta = 0.01;
		// (5) iniciar o erro
		double[] e = new double[linhas];
		for (int i = 0; i < e.length; i++)
			e[i] = 0;

		double u = 0;
		double yr = 0;
		// (6) repetir número de épocas
		for (int epoca = 0; epoca < numEpocas; epoca++) {

			// Para todas amostras treinar:
			// x.length - 1 pois a ultima coluna é o d
			for (int amostra = 0; amostra < x.length - 1; amostra++) {

				u = 0; // somatória

				for (int i = 0; i < w.length; i++)
					u = u + w[i] * x[amostra][i];

				// calcular o yr pela função de ativação - função sinal ou degrau bipolar
				yr = sinal(u);
				// calcular o erro
				// e[amostra] = d[amostra] - yr;
				// colunas - 1 considerando que sempre o d vai estar na última posição do x  
				e[amostra] = x[amostra][colunas] - yr;
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
