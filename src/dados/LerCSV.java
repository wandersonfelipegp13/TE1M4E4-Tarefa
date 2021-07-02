package dados;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerCSV {

	private int[] dimensoes(String caminho) {

		int c[] = { -1, 0 };

		try {

			BufferedReader in = new BufferedReader(new FileReader(caminho));
			
			String linha = in.readLine();
			String values[] = linha.split(",");
			c[1] = values.length;

			while (linha != null) {
				c[0]++;
				linha = in.readLine();
			}

			in.close();

		} catch (Exception e) {
			System.out.println("Erro ao calcular as dimensões: " + e.getMessage());
		}

		return c;
	}

	public double[][] mat(String caminho) {

		int d[] = dimensoes(caminho);
		int linhas = d[0];
		int colunas = d[1];

		double v[][] = new double[linhas][colunas];
		int i = 0;

		try {

			BufferedReader in = new BufferedReader(new FileReader(caminho));
			String linha = in.readLine();
			linha = in.readLine();
			while (linha != null) {

				String values[] = linha.split(",");
				
				for (int j = 0; j < colunas; j++)
					v[i][j] = Double.parseDouble(values[j]);
				
				i++;

				linha = in.readLine();
			}

			in.close();

		} catch (Exception e) {
			System.out.println("Erro ao preencher a matriz: " + e.getMessage());
		}

		return v;

	}

	public static void main(String args[]) {
		LerCSV t = new LerCSV();
		double m[][] = t.mat("src/files/Tabela_Dados_Treinamento_M4_3.6_RNA.csv");

		for (double[] ds : m) {
			System.out.println(ds[0] + "," + ds[1] + "," + ds[2] + "," + ds[3]);
		}

	}

}
