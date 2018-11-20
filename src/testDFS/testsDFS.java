package testDFS;

import org.junit.Test;

import DFS.Grafo;

public class testsDFS {

	@Test
	public void ejCarpeta() {
		Grafo gDFS = new Grafo(13);
		gDFS.setUnion(0, 1);
		gDFS.setUnion(0, 8);
		gDFS.setUnion(1, 2);
		gDFS.setUnion(1, 5);
		gDFS.setUnion(2, 3);
		gDFS.setUnion(5, 4);
		gDFS.setUnion(5, 6);
		gDFS.setUnion(5, 9);
		gDFS.setUnion(6, 7);
		gDFS.setUnion(4, 8);
		gDFS.setUnion(8, 9);
		gDFS.setUnion(9, 10);
		gDFS.setUnion(11, 12);

		boolean[] nodosVisitados = gDFS.calcularDFS();
		System.out.println("NODOS VISITADOS: ");
		for (int i = 0; i < nodosVisitados.length; i++) {
			if (nodosVisitados[i]) {
				System.out.print(i + "  ");
			}
		}
	}
	
	
	@Test
	public void unSoloNodo() {
		Grafo gDFS = new Grafo(1);
		
		boolean[] nodosVisitados = gDFS.calcularDFS();
		System.out.println("NODOS VISITADOS: ");
		for (int i = 0; i < nodosVisitados.length; i++) {
			if (nodosVisitados[i]) {
				System.out.print(i + "  ");
			}
		}
	}

}
