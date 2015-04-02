/* ******************************************************
*	---- enragedGraphs v0.2 ----						*
*	by:		 Nemanja Micovic							*
*	contact: auroraholding@live.com						*
*					code is still in early stages		*
******************************************************* */
package grafovi;

import java.util.LinkedList;

public class Vertex
{
	private String name;								// Vertex name
	private int index;									// Vertex index
	private boolean visited;							// Has vertex been visited
	private LinkedList<Integer> adjacentVertices;		// List that points to adjacent vertices
	
	// Constructors 
	// ********************************************************************
	public Vertex()
	{
		name = new String();
		adjacentVertices = new LinkedList<Integer>();
	}
	
	public Vertex(int index)
	{
		this.index = index;
		name = new String();
		adjacentVertices = new LinkedList<Integer>();
	}
	
	public Vertex(String name, int index)
	{
		this.name = new String(name);
		this.index = index;
		adjacentVertices = new LinkedList<Integer>();
	}
	
	public Vertex(String name, int index, boolean visited)
	{
		this.name = new String(name);
		this.index = index;
		this.visited = visited;
		adjacentVertices = new LinkedList<Integer>();
	}
	
	public Vertex(final Vertex y)
	{
		this.name = y.name;
		this.index = y.index;
		this.adjacentVertices = new LinkedList<Integer>(y.adjacentVertices);
	}
	
	// SETers
	// ********************************************************************
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	public void setVertex(String name, int index)
	{
		this.index = index;
		this.name = name;
	}
	
	public void setVisited(boolean toWhat)
	{
		visited = toWhat;
	}
	
	// GETers
	// ********************************************************************
	public String getName()
	{
		return name;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public LinkedList<Integer> getAdjecentVertices()
	{
		return this.adjacentVertices;
	}
	
	public boolean getVisited()
	{
		return this.visited;
	}
	// Rest
	// ********************************************************************
	@Override
	public String toString()
	{
		if(visited)
			return "[" + index + "] " + name;
		else
			return "[" + index + "]* " + name;			// * signifies that Vertex has been visited (used for BFS, DFS)
	}
	
	public boolean equalTo(Vertex x)
	{
		if(this.getName().equals(x.getName()) && this.getAdjecentVertices() == x.getAdjecentVertices())
			return true;
		else
			return false;
	}
}
