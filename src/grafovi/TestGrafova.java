/* ******************************************************
*	---- enragedGraphs v0.2 ----						*
*	by:		 Nemanja Micovic							*
*	contact: auroraholding@live.com						*
*					code is still in early stages		*
******************************************************* */

package grafovi;

import java.util.LinkedList;
import java.util.Queue;

public class TestGrafova
{
	// HELLO WORLD
	public static void main(String[] args)
	{
		Vertex[] niz = new Vertex[6];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = new Vertex("v" + i, i);
		}
		for (int i = 0; i < niz.length; i++) {
			System.out.println(niz[i]);
			
		}
		System.out.println();
		
		Graph G = new Graph(niz);
		G.insertAdjacentVertices();System.out.println("DFS:");
		G.DFSstart(0);
		System.out.println("END OF DFS");
		System.out.println(G);
		System.out.println("\nBFS START");
		G.BFSstart(0);
		System.out.println("BFS END");
	
	}

}

// Graph example 1
//	3 1 -1 3 2 0 -1 5 3 1 -1 2 1 0 -1 5 -1 4 2 -1
//	DFS: 0 1 2 3 5 4
//	BFS: 0 1 3 2 5 4