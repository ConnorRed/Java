//Ricky Marske did 50% and Connor Redmon did 50%
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Path {
	public static Integer[] getShortest(Vertex<Integer> vertex) {
		
		if(vertex == null) {
			throw new IllegalArgumentException();
		}
		else {
			ArrayList<Integer> array = new ArrayList<Integer>();
			Queue<Vertex<Integer>> iterList = new LinkedList<Vertex<Integer>>();
			iterList.add(vertex);
			Iterator<Vertex<Integer>> iter = vertex.iterator();
			Queue<Vertex<Integer>> first = new LinkedList<Vertex<Integer>>();
			Queue<Integer[]> distances = new LinkedList<Integer[]>();
			int n = 1;
			Iterator<Vertex<Integer>> tempIter = vertex.iterator();
			if(tempIter.hasNext()) {
				Vertex<Integer> ee = iter.next();
				while(iter.hasNext()) {
					if(ee != null) {
						if(!iterList.contains(ee)) {
							iterList.add(ee);
							first.add(ee);
							Integer[] distance = new Integer[]{ee.getValue(), n};
							distances.add(distance);
						}
					}
					ee = iter.next();
				}
			}
			n++;
			while(!first.isEmpty()) {
				Vertex<Integer> vert = first.remove();
				Iterator<Vertex<Integer>> firstIter = vert.iterator();
				while(firstIter.hasNext()) {
					Vertex<Integer> thisVert = firstIter.next();
					if(!iterList.contains(thisVert)) {
						iterList.add(thisVert);
						first.add(thisVert);
						System.out.println(thisVert.getValue());
						Integer[] distance = new Integer[]{thisVert.getValue(), n};
						distances.add(distance);
					}
				}
				n++;
			}
			Queue<Vertex<Integer>> copy = new LinkedList<Vertex<Integer>>();
			while(!iterList.isEmpty()) {
				Integer i = 0;
				if(iterList.peek().getValue() instanceof Integer) {
					Vertex<Integer> e = iterList.peek();
					i = (Integer)iterList.remove().getValue();
					array.add(i);
					copy.add(e);
				}
			}
			System.out.println(copy);
			Integer max = Collections.max(array);
			Integer min = Collections.min(array);
			Vertex<Integer> hasMax = null;
			Vertex<Integer> hasMin = null;
			Queue<Integer[]> tempo = new LinkedList<Integer[]>();
			Integer shortestDistance = 0;
			while(!distances.isEmpty()) {
				Integer[] highest = distances.remove();
				if(highest[0] == max) {
					shortestDistance = highest[1];
				}
				tempo.add(highest);
				
			}
			System.out.println("The shortest distance to the max is: " + shortestDistance);
			while(!copy.isEmpty()) {
				Vertex<Integer> x = copy.remove();
				if(x.getValue() == max) {
					hasMax = x;
				}
				if(x.getValue() == min) {
					hasMin = x;
				}
			}
			if(hasMin == hasMax) {
				Integer[] result = new Integer[]{hasMin.getValue()};
				return result;
			}
			System.out.println(array);
			//Now have min and max nodes, haven't accounted for multiple min and max yet though
			Queue<Integer[]> thisPath = new LinkedList<Integer[]>();
			Iterator<Vertex<Integer>> minIter = hasMin.iterator();
			Vertex<Integer> uno = hasMin;
			Queue<Vertex<Integer>> needToGo = new LinkedList<Vertex<Integer>>();
			Vertex<Integer> dos;
			ArrayList<Vertex<Integer>> been = new ArrayList<Vertex<Integer>>();
			while(minIter.hasNext()) {
				dos = minIter.next();
				needToGo.add(dos);
				Integer[] vector = new Integer[]{uno.getValue(), dos.getValue(), n};
				thisPath.add(vector);
				been.add(uno);
			}
			while(!needToGo.isEmpty()) {
				
				uno = needToGo.remove();
				Iterator<Vertex<Integer>> unoIter = uno.iterator();
				while(unoIter.hasNext() && !been.contains(uno)) {
					dos = unoIter.next();
					needToGo.add(dos);
					if(!been.contains(dos)) {
						Integer[] vector = new Integer[]{uno.getValue(),dos.getValue(), n};
						thisPath.add(vector);
					}
				}
				been.add(uno);
			}
			Queue<Integer[]> copyOfPath = new LinkedList<Integer[]>(thisPath);
			Queue<Integer[]> endingVectors = new LinkedList<Integer[]>();
			while(!copyOfPath.isEmpty()) {
				Integer[] endVector = copyOfPath.remove();
				if(endVector[1] == max) {
					endingVectors.add(endVector);
				}
			}
			Integer[] lowestFinishing = endingVectors.remove();
			while(!endingVectors.isEmpty()) {
				Integer[] nextOne = endingVectors.remove();
				if(nextOne[2] < lowestFinishing[2]) {
					lowestFinishing  = nextOne;
				}
			}
			ArrayList<Integer> thePath = new ArrayList<Integer>();
			thePath.add(max);
			thePath.add(lowestFinishing[0]);
			System.out.println(thePath);
			int count = 1;
			while(!thePath.contains(min)) {
				Queue<Integer[]> copyOfPath1 = new LinkedList<Integer[]>(thisPath);
				Queue<Integer[]> endingVectors1 = new LinkedList<Integer[]>();
				while(!copyOfPath1.isEmpty()) {
					Integer[] endVector1 = copyOfPath1.remove();
					if(endVector1[1] == thePath.get(count)) {
						endingVectors1.add(endVector1);
					}
				}
				Integer[] lowestFinishing1 = endingVectors1.remove();
				while(!endingVectors1.isEmpty()) {
					Integer[] nextOne1 = endingVectors1.remove();
					if(nextOne1[2] < lowestFinishing1[2]) {
						lowestFinishing1  = nextOne1;
					}
				}
				thePath.add(lowestFinishing1[0]);
				count++;
			}
			System.out.println(thePath);
			Collections.reverse(thePath);
			System.out.println(thePath);
			Integer[] path = new Integer[thePath.size()];
			for(int i = 0; i < path.length; i++) {
				path[i] = thePath.get(i);
			}
			return path;
		}
	}
}