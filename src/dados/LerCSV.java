package dados;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerCSV {
	
	private static int linhas = -1;
	private static int colunas;

	private void dimensoes(String caminho) {

		try {

			BufferedReader in = new BufferedReader(new FileReader(caminho));
			
			String linha = in.readLine();
			String values[] = linha.split(",");
			colunas = values.length;

			while (linha != null) {
				linhas++;
				linha = in.readLine();
			}

			in.close();

		} catch (Exception e) {
			System.out.println("Erro ao calcular as dimensões: " + e.getMessage());
		}

	}

	public double[][] mat(String caminho) {
		
		this.dimensoes(caminho);

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

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
}
