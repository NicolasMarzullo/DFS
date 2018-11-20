package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaDeAdyacencia {

	private List<List<Integer>> adyacencia;

	public ListaDeAdyacencia(int cantDeNodos) {
		this.adyacencia = new ArrayList<>();

		for (int i = 0; i < cantDeNodos; i++) {
			this.adyacencia.add(new LinkedList<>());
		}
	}

	public void setUnion(int nodoI, int nodoJ) {
		if (nodoI == nodoJ) {
			return;
		}

		// DFS es para grafos no dirigidos y no ponderados
		this.adyacencia.get(nodoI).add(nodoJ);
		this.adyacencia.get(nodoJ).add(nodoI);
	}

	public boolean hayUnion(int nodoI, int nodoJ) {
		if (nodoI == nodoJ) {
			return false;
		}
		return this.adyacencia.get(nodoI).contains(nodoJ);
	}
	
	public List<Integer> getListaUniones(int nodoI) {
		return this.adyacencia.get(nodoI);
	}


}
