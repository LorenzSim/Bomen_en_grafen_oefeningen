package ui;
import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {

		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeE2 = new BinaryTree<>("E");
		BinaryTree<String> nodeE3 = new BinaryTree<>("E");
		BinaryTree<String> nodeE4 = new BinaryTree<>("E");

		BinaryTree<String> nodeC = new BinaryTree<>("C", null, nodeE);
		BinaryTree<String> nodeH1 = new BinaryTree<>("H", nodeC, nodeE2);
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeH2 = new BinaryTree<>("H", nodeA, nodeH1);

		BinaryTree<String> nodeH3 = new BinaryTree<>("H", null, nodeE3);
		BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH3, nodeE4);
		BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);

		BinaryTree<String> boom = new BinaryTree<>("A", nodeH2, nodeG);

		System.out.println("Count tests: \n" + boom.count("I"));
		System.out.println(boom.count("A"));
		System.out.println(boom.count("H"));
		System.out.println(boom.count("E"));
		System.out.println(boom.count("Q"));

		System.out.println("\nDistance tests: \n" + boom.getNodesAtDistance(0));
		System.out.println(boom.getNodesAtDistance(1));
		System.out.println(boom.getNodesAtDistance(2));
		System.out.println(boom.getNodesAtDistance(3));
		System.out.println(boom.getNodesAtDistance(4));

		System.out.println("\ndeelZonder test: \n" + boom.getDataLeaves());
		System.out.println(boom.deelZonder("I").getDataLeaves());



		/*BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);

		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		//boom.printPreorder();
*/


		/*BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
		BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);

		BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
		BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);

		BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);

		System.out.println(boom.contains("D"));
		System.out.println(boom.contains("H"));
		System.out.println(boom.contains("F"));
		System.out.println(boom.contains("Q"));

		System.out.println(boom.getDataLeaves());
		System.out.println(boom.getDepth());*/



	}


}
