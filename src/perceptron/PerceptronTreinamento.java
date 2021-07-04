package perceptron;

import dados.LerCSV;
import java.util.Random;

/**
 * Nessa versão a quantidade de registros de óleos, assim como a quantidade de
 * propriedades desses óleos é processada dinamicamente.
 * 
 * @author Wanderson
 *
 */
public class PerceptronTreinamento {

	private static int numEpocas;
	private static int numAmostras;
	private static Random gerador = new Random();

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
		numAmostras = linhas;

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
		// double[] d = { -1, 1, -1, -1, 1, 1 }; // saída esperada: -1 = P1 e 1 = P2

		// (3) inicar os pesos w
		double[] w = new double[colunas];

		for (int i = 0; i < colunas; i++) {

			// w[i] = gerador.nextDouble();

			if (gerador.nextDouble() >= 0.5)
				w[i] = 1;
			else
				w[i] = 0;
			/**/
		}

		// (4) taxa aprendizagem
		double eta = 0.01;
		// (5) iniciar o erro
		double[] e = new double[linhas];
		for (int i = 0; i < e.length; i++)
			e[i] = 0;

		// Iniciar o contador de épocas com 0
		numEpocas = 0;

		double u = 0;
		double yr = 0;

		int amostra;

		int erro = 1;
		// for (int epoca = 0; epoca < numEpocas; epoca++) {
		// do {
		while (erro == 1) {

			// Erro = inexiste (0)
			erro = 0;

			// Para todas amostras treinar:
			for (amostra = 0; amostra < x.length; amostra++) {

				u = 0; // somatória

				for (int i = 0; i < w.length; i++)
					u = u + w[i] * x[amostra][i];

				// calcular o yr pela função de ativação - função sinal ou degrau bipolar
				yr = sinal(u);

				/**
				 * Quando esse bloco de código fica fora do if abaixo o erro é calculado mesmo
				 * se y == d(k). Isso garante que todos os valores dos erros sejam atualizados,
				 * já que quando eles fican dentro do if abaixo, na primeira vez que o erro não
				 * existe, os valores do erro não são calculados, e assim, nao são atualizados
				 * no vetor 'e' para 0, que é o resultado que se espera.
				 * Uso colunas considerando que sempre o d vai estar na última posição do x.
				 */
				e[amostra] = x[amostra][colunas] - yr;

				// Se y != d(k)
				if (x[amostra][colunas] != yr) {

					// ajuste dos pesos
					for (int i = 0; i < w.length; i++)
						w[i] = w[i] + eta * e[amostra] * x[amostra][i];

					erro = 1; // erro = existe (1)
					break;
				}

			}

			numEpocas++;

			// } while (erro == 1);
		}
		// saída
		System.out.println("pesos w: ");

		for (int i = 0; i < w.length; i++)
			System.out.print(w[i] + ", ");

		System.out.println("\nerro e: ");

		for (int i = 0; i < e.length; i++)
			System.out.print(e[i] + ", ");

		System.out.println("\nÉpocas: " + numEpocas);

	}

}
