//Ricky Marske did 50% and Connor Redmon did 50%
import java.util.*;
public class Value {
	public static<T extends Comparable<? super T>> int getDifference(Vertex<T> vertex) {
		if(vertex == null) {
			throw new IllegalArgumentException();
		}
		else {
			ArrayList<Character> array = new ArrayList<Character>();
			Queue<Vertex<T>> iterList = new LinkedList<Vertex<T>>();
			iterList.add(vertex);
			Iterator<Vertex<T>> iter = vertex.iterator();
			Queue<Vertex<T>> first = new LinkedList<Vertex<T>>();
			while(iter.hasNext() && iter.next() != null) {
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
				Character c = 'a';
				Integer i = 0;
				if(iterList.peek().getValue() instanceof String) {
					String s = (String)iterList.remove().getValue();
					c = s.charAt(0);
					array.add(c);
				}
				else if(iterList.peek().getValue() instanceof Character) {
					c = (Character)iterList.remove().getValue();
					array.add(c);
				}
				else if(iterList.peek().getValue() instanceof Integer) {
					i = (Integer)iterList.remove().getValue();
					c = (char)i.intValue();
					array.add(c);
				}
			}	
			Character max = Collections.max(array);
			Character min = Collections.min(array);
			int numMax = (int)max.charValue();
			int numMin = (int)min.charValue();
			return numMax - numMin;
		}
	}
}