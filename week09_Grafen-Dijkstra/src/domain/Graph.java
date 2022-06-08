package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;
	private final int inf = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}
		this.gewichtenMatrix = matrix.clone();
	}

	private int getAantalKnopen() {
		return gewichtenMatrix.length;
	}


	private int[][] initMatrixDijkstra(int vanKnoop) {
		// laatste rij is rij met kortste lengtes vanuit vanKnoop
		int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];

		// oefening 9.3
		int vanKnoopIndex = vanKnoop - 1;
		for (int r = 0; r < gewichtenMatrix.length + 1; r++){
			for (int k = 0; k < gewichtenMatrix.length; k++){
				if (r == gewichtenMatrix.length && k != vanKnoopIndex) {
					res[r][k] = inf;
				}
				else if (k == vanKnoopIndex || gewichtenMatrix[r][k] == inf) {
					res[r][k] = 0;
				}
				else {
					res[r][k] = gewichtenMatrix[r][k];
				}
			}
		}
		return res;
	}

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);

		// oefening 9.4
		int startIndex = vanKnoop - 1;
		int resIndex = res.length - 1;
		ArrayList<Integer> bezocht = new ArrayList<>() {{ add(startIndex); }};

		while (true){
			int minKolomIndex = inf, minRowIndex = inf, min = inf;
			for(int s : bezocht){
				for (int k = 0; k < res[0].length; k++){
					if (res[resIndex][k] == inf && res[s][k] != 0){
						int gewicht = res[s][k] + res[resIndex][s];
						if (gewicht < min){
							min = gewicht;
							minKolomIndex = k;
							minRowIndex = s;
						}

					}
				}
			}
			if (minKolomIndex == inf) break;

			for (int i = 0; i < res.length -1; i++){
				if(i != minRowIndex){
					res[i][minKolomIndex] = 0;
				}
			}
			bezocht.add(minKolomIndex);
			res[resIndex][minKolomIndex] = min;
		}

		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();

		// oefening 9.5
		int vanIndex = vanKnoop -1 , naarIndex = naarKnoop -1 ;
		while(vanIndex != naarIndex){
			for (int r = 0; r < res.length -1 ; r++){
				if (res[r][naarIndex] != 0){
					pad.add(0, r + 1);
					naarIndex = r;
					break;
				}
			}
		}
		pad.add(naarKnoop);
		return pad;
	}

	public String berekenPaden(int vanKnoop) {
		String uit = "";
		int[][] res = this.Dijkstra(vanKnoop);

		System.out.println("Resulterende matrix: \n");
		printIntMatrix(res);

		for (int i = 0; i < getAantalKnopen(); i++) {
			if ((i + 1) != vanKnoop) {
				if (res[getAantalKnopen()][i] == Integer.MAX_VALUE) {
					uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
				} else {
					uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[getAantalKnopen()][i] + "\n";
					uit += "via ";

					int j = (i + 1);
					ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
					uit += pad + "\n";
				}
			}
		}

		return uit;
	}

	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";

		System.out.println(result);
	}

}