//Ricky Marske did 50% and Connor Redmon did 50%
import java.util.*;
public class Breadth {
	public static <T> T[] getList(Vertex<T> vertex) {
		ArrayList<T> array = new ArrayList<T>();
		Queue<Vertex<T>> iterList = new LinkedList<Vertex<T>>();
		if(vertex != null) {
			iterList.add(vertex);
			Iterator<Vertex<T>> iter = vertex.iterator();
			Queue<Vertex<T>> first = new LinkedList<Vertex<T>>();
			while(iter.hasNext()) {
				Vertex<T> e = iter.next();
				if(e != null) {
					if(!iterList.contains(e)) {
						iterList.add(e);
						first.add(e);
					}
				}
			}
			while(!first.isEmpty()) {
				Vertex<T> vert = first.remove();
				Iterator<Vertex<T>> firstIter = vert.iterator();
				while(firstIter.hasNext()) {
					Vertex<T> thisVert = firstIter.next();
					if(thisVert != null) {
						if(!iterList.contains(thisVert)) {
							iterList.add(thisVert);
							first.add(thisVert);
						}
					}
				}
			}
			while(!iterList.isEmpty()) {
				array.add(iterList.remove().getValue());
			}
			Object[] values = new Object[array.size()];
			for(int i = 0; i < array.size(); i++) {
				values[i] = array.get(i);
			}
			return (T[])values;
		}
		Object[] nullResult = new Object[array.size()];
		return (T[])nullResult;
	}
}