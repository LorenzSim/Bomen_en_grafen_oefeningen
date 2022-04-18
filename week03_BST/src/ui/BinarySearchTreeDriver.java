package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {

		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		printBoomInfo(boom);
		System.out.println("\nKnopen tussen 5 en 8: "+boom.geefKnopenBinnenInterval(5,8));
		System.out.println("\nKnopen tussen 3 en 5: "+boom.geefKnopenBinnenInterval(3,5));
		System.out.println("\nKnopen tussen 8 en 9: "+boom.geefKnopenBinnenInterval(8,9));
		System.out.println("\nKnopen tussen -10 en 0: "+boom.geefKnopenBinnenInterval(-10,0));
		System.out.println("\nKnopen tussen 100 en 110: "+boom.geefKnopenBinnenInterval(100,110));



		/*
		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		printBoomInfo(boom);



		// tests voor lookUp:
		System.out.println("\nVerwacht: true, true, true, false");
		System.out.println(boom.lookup(4));
		System.out.println(boom.lookup(5));
		System.out.println(boom.lookup(9));
		System.out.println(boom.lookup(10));

		System.out.println("\n" + boom.getPath(7));*/


	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInorder();
			System.out.println();
			System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
			System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
		}


	}
}
