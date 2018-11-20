package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Grafo {

	private List<Nodo> nodos;
	private int cantDeNodos;
	private ListaDeAdyacencia listaDeAdyacencia;

	public Grafo(int cantDeNodos) {
		this.cantDeNodos = cantDeNodos;
		this.nodos = new ArrayList<>();
		this.listaDeAdyacencia = new ListaDeAdyacencia(cantDeNodos);

		for (int i = 0; i < cantDeNodos; i++) {
			this.nodos.add(new Nodo(i));
		}

	}

	public void setUnion(int nodoI, int nodoJ) {
		this.listaDeAdyacencia.setUnion(nodoI, nodoJ);
	}

	public boolean[] calcularDFS() {
		boolean[] nodosVisitados = new boolean[this.cantDeNodos];
		Stack<Integer> pilaDeNodos = new Stack<>();
		int nodoActual;
		boolean hayNodosSinVisitar = true, hayAdyacencia = false;

		while (hayNodosSinVisitar) {
			
			nodoActual = getPrimerNodoSinVisitar(nodosVisitados);
			//Si me dio -1 es que no quedan mas nodos por visitar (sirve para grafos no conexos)
			if(nodoActual == -1) {
				hayNodosSinVisitar = false;
			}else {
				pilaDeNodos.push(nodoActual);
			}
			
			while (!pilaDeNodos.isEmpty() && hayNodosSinVisitar) {
				nodoActual = pilaDeNodos.peek();
				nodosVisitados[nodoActual] = true;
				hayAdyacencia = false;
				// Busco adyacentes al nodo actual
				for (Integer nodoAdyacente : this.listaDeAdyacencia.getListaUniones(nodoActual)) {
					if (nodosVisitados[nodoAdyacente] == false) {
						pilaDeNodos.push(nodoAdyacente);
						hayAdyacencia = true;
						break;			
					}
				}
				if(!hayAdyacencia) {
					pilaDeNodos.pop();
				}
			}
		}

		return nodosVisitados;
	}

	private int getPrimerNodoSinVisitar(boolean[] nodosVisitados) {
		int i = 0;

		while (i < nodosVisitados.length && nodosVisitados[i] == true) {
			i++;
		}

		if (i == nodosVisitados.length) {
			return -1;
		}

		return i;
	}

}
