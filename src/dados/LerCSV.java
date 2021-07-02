package dados;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerCSV {
	
	static final String caminho = "src/files/Tabela_Dados_Treinamento_M4_3.6_RNA.csv";
	
	
	public double[][] mat(){
		
		double v[][] = new double[30][4];
		int i = 0;
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(caminho));
			String linha = in.readLine();
			linha = in.readLine();
			while (linha != null) {
				
				String values[] = linha.split(",");
				
				v[i][0] = Double.parseDouble(values[0]);
				v[i][1] = Double.parseDouble(values[1]);
				v[i][2] = Double.parseDouble(values[2]);
				v[i][3] = Double.parseDouble(values[3]);
				i++;
				
				linha = in.readLine();
			}
			
			in.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return v;
		
	}
	
	public static void main(String args[]) {
		LerCSV t = new LerCSV();
		double m[][] = t.mat();
		
		for (double[] ds : m) {
			System.out.println(ds[0] + "," + ds[1] + "," + ds[2]+ "," + ds[3]);
		}
		
	}

}
