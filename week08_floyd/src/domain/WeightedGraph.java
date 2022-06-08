package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
        for (int i = 0; i < DMatrix.length; i++) {
            DMatrix[i] = DMatrix[i].clone();
        }

        for (int t = 0; t < getAantalKnopen(); t++){
            for (int n = 0; n < getAantalKnopen(); n++){
                for (int v = 0; v < getAantalKnopen(); v++){
                    double tmp = DMatrix[v][t] + DMatrix[t][n];
                    if (tmp < DMatrix[v][n]){
                        DMatrix[v][n] = tmp;
                        pointerMatrix[v][n] = t + 1;
                    }
                }
            }
        }

		return pointerMatrix;

	}

	public List<Integer> getShortestPath(int i, int j, int[][] pointer) {
		List<Integer> res = new ArrayList<>();
        if (i == j) return res;
        res.add(i);
        int k = j - 1;
        while (pointer[i - 1][k] != 0){
            k = pointer[i - 1][k] - 1;
            res.add(k + 1);
        }
        res.add(j);
        return res;

	}
	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		return som;
	}

}
