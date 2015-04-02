/* ******************************************************
*	---- enragedGraphs v0.2 ----						*
*	by:		 Nemanja Micovic							*
*	contact: auroraholding@live.com						*
*					code is still in early stages		*
******************************************************* */

package grafovi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

// TODO 
//	add method to calculate numberOfEdges
//	add BFS method
	
public class Graph
{
	private Vertex[] graph;
	private int numberOfEdges, numberOfVertices;
	
	// Constructors
	// ********************************************************************
	public Graph()
	{
		graph = new Vertex[1];
		graph[0] = new Vertex();
		numberOfEdges = 0;
		numberOfVertices = 1;
	}
	
	public Graph(Vertex[] vertices)
	{
		graph = new Vertex[vertices.length];
		for (int i = 0; i < graph.length; i++) 
		{
			graph[i] = new Vertex(vertices[i]);
		}
		numberOfVertices = graph.length;
	}
	
	// SETers
	// ********************************************************************
	public void setAdjacentVertex(int indexOfActiveVertex, int indexOfneighbour)
	{
		if(indexOfneighbour >= graph.length || indexOfActiveVertex >= graph.length)
		{
			System.out.println("Wrong vertex index!");
		}
		else
		{
			graph[indexOfActiveVertex].getAdjecentVertices().addFirst(indexOfneighbour);
		}
	}
	
	public void insertAdjacentVertices()
	{
		Scanner sc = new Scanner(System.in);
		int vertex;
		System.out.println("Adjacent vertices are inserted by their index in graph. \n-1 will terminate current vertex adjacent vertices insertion");
		for (int i = 0; i < graph.length; i++) 
		{
			System.out.println("Adjacent vertices of " + graph[i]);
			vertex = sc.nextInt();
			while(vertex != -1)
			{
				this.setAdjacentVertex(i, vertex);
				vertex = sc.nextInt();
			}
		}
		sc.close();
	}
	
	// GETers
	// ********************************************************************
	public void getVertices()
	{
		for (int i = 0; i < graph.length; i++) 
		{
			System.out.println(graph[i]);
		}
	}
	
	public Vertex getVertex(int i)
	{
		return graph[i];
	}
	
	public int getNumberOfVertices()
	{
		return numberOfVertices;
	}
	
	public int getVertexIndex(Vertex x)
	{
		for (int i = 0; i < graph.length; i++) 
		{
			if(graph[i].equalTo(x))
				return i;
		}
		return -1;
	}
	
	// Graph traversals
	// ********************************************************************
	
	// DFS ----------------------------------------
	public void DFSfull(int vertex)
	{
		if(vertex >= graph.length)
		{
			System.out.println("Wrong vertex id.");
			return;
		}
		this.clearVisitedInfo();					// we make sure that all vertices are not visited (if before some method altered this)
		DFS(vertex);	
		
		for (int i = 0; i < graph.length; i++) 
		{
			if(i != vertex)
			{
				if(! graph[i].getVisited())
					DFS(i);
			}
		}
	}
	
	public void DFSstart(int vertex)
	{
		if(vertex >= graph.length)
		{
			System.out.println("Wrong vertex id.");
			return;
		}
		this.clearVisitedInfo();
		DFS(vertex);
	}
	
	private void DFS(int vertex)
	{
		int adjacentIndex;
		System.out.println(graph[vertex]);
		graph[vertex].setVisited(true);
		
		for (int i = 0; i < graph[vertex].getAdjecentVertices().size(); i++) 
		{
			adjacentIndex = graph[vertex].getAdjecentVertices().get(i);
			if(! graph[adjacentIndex].getVisited())
				DFS(adjacentIndex);
		}
	}
	
	// BFS -----------
	public void BFSstart(int vertex)
	{
		if(vertex < 0)
		{
			System.out.println("Error in input, method BFSstart. Inserted vertex index is less then 0");
		}
		else if(vertex >= graph.length)
		{
			System.out.println("Error in input, method BFSstart. Inserted vertex index doesn't exist.");
		}
		this.clearVisitedInfo();
		BFS(vertex);
	}
	
	public void BFSfull(int vertex)
	{
		if(vertex < 0)
		{
			System.out.println("Error in input, method BFSstart. Inserted vertex index is less then 0");
		}
		else if(vertex >= graph.length)
		{
			System.out.println("Error in input, method BFSstart. Inserted vertex index doesn't exist.");
		}
		this.clearVisitedInfo();
		BFS(vertex);
		
		for (int i = 0; i < graph.length; i++) 
		{
			if(i != vertex)
			{
				if(! graph[i].getVisited())
				{
					BFS(i);
				}
			}
		}
		
	}
	
	private void BFS(int vertex)
	{
		Queue<Integer> queue = new LinkedList<Integer>();					// We use interface Queue that is implemented in class LinkedList to form a queue
		
		// we add the vertex into queue and check if it was successful (just out of formality)
		if(!queue.add(vertex))
		{
			System.out.println("Queue is full. Error, method BFS");
		}
		graph[vertex].setVisited(true);										// we signal that vertex form which BFS started has been visited	
		
		while(queue.size() != 0)
		{
			int q;
			q = queue.remove();
			System.out.println(graph[q]);
			for(int i = 0; i < graph[q].getAdjecentVertices().size(); i++)
			{
				int currentVertex = graph[q].getAdjecentVertices().get(i);
				if(! graph[currentVertex].getVisited())
				{
					queue.add(currentVertex);
					graph[currentVertex].setVisited(true);		
					// we mark adjacent vertices of graph[q] here (instead of before for loop in order to avoid adding duplicates into queue
				}
			}
		}
	}
	
	// Rest
	// ********************************************************************
	public void clearVisitedInfo()
	{
		for (int i = 0; i < graph.length; i++) 
		{
			graph[i].setVisited(false);
		}
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < graph.length; i++) 
		{
			sb.append(graph[i] + "\n");
			for(int j = 0; j < graph[i].getAdjecentVertices().size(); j++)
			{
				int magicIndex;
				magicIndex = graph[i].getAdjecentVertices().get(j);
				sb.append("  -->");
				sb.append(graph[magicIndex]).append("\n");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
