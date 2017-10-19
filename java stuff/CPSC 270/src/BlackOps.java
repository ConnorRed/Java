//Ricky Marske did 50% and Connor Redmon did 50%
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BlackOps {
	public static int minimumRoads(int[][]  roads, int insertion, int extraction) {
		Queue<int[]> streets = new LinkedList<int[]>();
		Queue<int[]> extractRoads = new LinkedList<int[]>();
		int[] extractRoad = new int[2];
		for(int i = 0; i < roads.length; i++) {
			streets.add(roads[i]);
		}
		Queue<Integer> houses = new LinkedList<Integer>();
		Queue<int[]> streetsCopy = new LinkedList<int[]>(streets);
		while(!streets.isEmpty()) {
			int[] street = streets.remove();
			System.out.println("[" + street[0] + ", " + street[1] + "]");
			if(street[1] == extraction || street[0] == extraction) {
				extractRoads.add(street);
			}
			if(!houses.contains(street[0])) {
				houses.add(street[0]);
			}
			if(!houses.contains(street[1])) {
				houses.add(street[1]);
			}
		}
		Queue<Vertex<Integer>> houseVertices = new LinkedList<Vertex<Integer>>();
		while(!houses.isEmpty()) {
			int house = houses.remove();
			Vertex<Integer> aHouse = new Vertex<Integer>(house);
			houseVertices.add(aHouse);
		}
		Queue<Vertex<Integer>> housesNeighbors = new LinkedList<Vertex<Integer>>();
		Queue<Vertex<Integer>> verticesCopy = new LinkedList<Vertex<Integer>>(houseVertices);
		LinkedList<Vertex<Integer>> ourList = (LinkedList<Vertex<Integer>>) verticesCopy;
		for(int i =  0; i < verticesCopy.size(); i++) {
			Vertex<Integer> building = ourList.get(i);
			Queue<int[]> copy = new LinkedList<int[]>(streetsCopy);
			Queue<Vertex<Integer>> neighbors = new LinkedList<Vertex<Integer>>();
			while(!streetsCopy.isEmpty()) {
				int[] myStreet = streetsCopy.remove();
				if(myStreet[0] == building.getValue()) {
					int streetNum  = myStreet[1];
					for(int j = 0;  j < ourList.size(); j++) {
						if(ourList.get(j).getValue() == streetNum) {
							neighbors.add(ourList.get(j));
						}
					}					
				}
				if(myStreet[1] == building.getValue()) {
					int streetNum  = myStreet[0];
					for(int j = 0;  j < ourList.size(); j++) {
						if(ourList.get(j).getValue() == streetNum) {
							neighbors.add(ourList.get(j));
						}
					}
				}
			}
			while(!neighbors.isEmpty()) {
				building.add(neighbors.remove());
			}
			housesNeighbors.add(building);
			streetsCopy = copy;
		}
		System.out.println("The houses with their neighbors are: " + housesNeighbors);
		System.out.println("The point of insertion is: " + insertion + " and extraction is: " + extraction);
		ArrayList<Integer> array = new ArrayList<Integer>();
		Queue<Vertex<Integer>> graphCopy = new LinkedList<Vertex<Integer>>(housesNeighbors);
		Vertex<Integer> insertionVertex = null;
		while(!housesNeighbors.isEmpty()) {
			Vertex<Integer> theThing = housesNeighbors.remove();
			if(theThing.getValue() == insertion) {
				insertionVertex = theThing;
			}
		}
		System.out.println(insertionVertex);
		Queue<Vertex<Integer>> iterList = new LinkedList<Vertex<Integer>>();
		iterList.add(insertionVertex);
		System.out.println("iterList is " + iterList);
		Iterator<Vertex<Integer>> iter = insertionVertex.iterator();
		Queue<Vertex<Integer>> first = new LinkedList<Vertex<Integer>>();
		Queue<Integer[]> distances = new LinkedList<Integer[]>();
		int n = 1;
		Iterator<Vertex<Integer>> tempIter = insertionVertex.iterator();
		System.out.println(insertionVertex);
		if(tempIter.hasNext()) {
			Vertex<Integer> ee = tempIter.next();
			System.out.println("ee is " + ee);
			while(iter.hasNext()) {
				if(!iterList.contains(ee)) {
					System.out.println("ee is again" + ee);
					iterList.add(ee);
					first.add(ee);
					Integer[] distance = new Integer[]{ee.getValue(), n};
					distances.add(distance);
				}
				ee = iter.next();
			}
		}
		n++;
		while(!first.isEmpty()) {
			Vertex<Integer> vert = first.remove();
			System.out.println("vert is " + vert);
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
		System.out.println("distances is " + distances);
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
		System.out.println(copy + "THIS IS AN ARRAY OF STUFF");
		Queue<Integer[]> tempo = new LinkedList<Integer[]>();
		Integer furthest = 0;
		Integer farVert = 0;
		Queue<Integer[]> moreDistances = new LinkedList<Integer[]>(distances);
		while(!distances.isEmpty()) {
			Integer[] highest = distances.remove();
			if(highest[1] > furthest) {
				furthest = highest[1];
				farVert = highest[0];
			}
			tempo.add(highest);
		}
		if(furthest > 1) {
			furthest--;
		}
		//Subtracted one here because furthest held number of vertices from the first to the last, which
		//includes the first, and that number will always be 1 greater than the number of streets used.
		System.out.println("The furthest distance to the farVert is: " + furthest);
		LinkedList<Vertex<Integer>> tracingBack = (LinkedList<Vertex<Integer>>) copy;
		LinkedList<Integer[]> M = (LinkedList<Integer[]>) moreDistances;
		Vertex<Integer> farNode = null;
		for(int i = 0; i < tracingBack.size(); i++) {
			for(int j = 0; j < M.size(); j++) {
				if(tracingBack.get(i).getValue() == M.get(j)[0]) {
					farNode = tracingBack.get(i);
				}
			}
		}
		tempIter = farNode.iterator();
		iter = farNode.iterator();
		Queue<Vertex<Integer>> finalIterList = new LinkedList<Vertex<Integer>>();
		finalIterList.add(farNode);
		Queue<Integer[]> finalDistances = new LinkedList<Integer[]>();
		n = 1;
		Queue<Vertex<Integer>> second = new LinkedList<Vertex<Integer>>();
		if(tempIter.hasNext()) {
			Vertex<Integer> ee = tempIter.next();
			System.out.println("ee is " + ee);
			while(iter.hasNext()) {
				if(!finalIterList.contains(ee)) {
					System.out.println("ee is again" + ee);
					finalIterList.add(ee);
					second.add(ee);
					Integer[] distance = new Integer[]{ee.getValue(), n};
					finalDistances.add(distance);
				}
				ee = iter.next();
			}
		}
		n++;
		while(!second.isEmpty()) {
			Vertex<Integer> vert = second.remove();
			System.out.println("vert is " + vert);
			Iterator<Vertex<Integer>> firstIter = vert.iterator();
			while(firstIter.hasNext()) {
				Vertex<Integer> thisVert = firstIter.next();
				if(!finalIterList.contains(thisVert)) {
					finalIterList.add(thisVert);
					second.add(thisVert);
					System.out.println(thisVert.getValue());
					Integer[] distance = new Integer[]{thisVert.getValue(), n};
					finalDistances.add(distance);
				}
			}
			n++;
		}
		int leaveDistance = 0;
		M = (LinkedList<Integer[]>) finalDistances;
		for(int i = 0;  i  < finalDistances.size(); i++) {
			if(M.get(i)[0] == extraction) {
				leaveDistance = M.get(i)[1];
			}
		}
		if(leaveDistance > 1) {
			leaveDistance--;
		}
		//Subtracting 1 from  this for the same reason above, the number of streets traversed is 1 less
		//than the number of vertices visited.
		return furthest + leaveDistance;
		
		
		
		
//		Vertex<Integer> hasMax = new Vertex<Integer>(5);
//		Vertex<Integer> hasMin = new Vertex<Integer>(5);
//		int max = 0;
//		int min = 0;
//		while(!copy.isEmpty()) {
//			Vertex<Integer> x = copy.remove();
//			
//			
//			if(x.getValue() == max) {
//				hasMax = x;
//			}
//			if(x.getValue() == min) {
//				hasMin = x;
//			}
//		}
//		System.out.println(array);
//		//Now have min and max nodes, haven't accounted for multiple min and max yet though
//		Queue<Integer[]> thisPath = new LinkedList<Integer[]>();
//		Iterator<Vertex<Integer>> minIter = hasMin.iterator();
//		Vertex<Integer> uno = hasMin;
//		Queue<Vertex<Integer>> needToGo = new LinkedList<Vertex<Integer>>();
//		Vertex<Integer> dos;
//		ArrayList<Vertex<Integer>> been = new ArrayList<Vertex<Integer>>();
//		while(minIter.hasNext()) {
//			dos = minIter.next();
//			needToGo.add(dos);
//			Integer[] vector = new Integer[]{uno.getValue(), dos.getValue(), n};
//			thisPath.add(vector);
//			been.add(uno);
//		}
//		while(!needToGo.isEmpty()) {
//			
//			uno = needToGo.remove();
//			Iterator<Vertex<Integer>> unoIter = uno.iterator();
//			while(unoIter.hasNext() && !been.contains(uno)) {
//				dos = unoIter.next();
//				needToGo.add(dos);
//				if(!been.contains(dos)) {
//					Integer[] vector = new Integer[]{uno.getValue(),dos.getValue(), n};
//					thisPath.add(vector);
//				}
//			}
//			been.add(uno);
//		}
//		Queue<Integer[]> copyOfPath = new LinkedList<Integer[]>(thisPath);
//		Queue<Integer[]> endingVectors = new LinkedList<Integer[]>();
//		while(!copyOfPath.isEmpty()) {
//			Integer[] endVector = copyOfPath.remove();
//			if(endVector[1] == max) {
//				endingVectors.add(endVector);
//			}
//		}
//		Integer[] lowestFinishing = endingVectors.remove();
//		while(!endingVectors.isEmpty()) {
//			Integer[] nextOne = endingVectors.remove();
//			if(nextOne[2] < lowestFinishing[2]) {
//				lowestFinishing  = nextOne;
//			}
//		}
//		ArrayList<Integer> thePath = new ArrayList<Integer>();
//		thePath.add(max);
//		thePath.add(lowestFinishing[0]);
//		System.out.println(thePath);
//		int count = 1;
//		while(!thePath.contains(min)) {
//			Queue<Integer[]> copyOfPath1 = new LinkedList<Integer[]>(thisPath);
//			Queue<Integer[]> endingVectors1 = new LinkedList<Integer[]>();
//			while(!copyOfPath1.isEmpty()) {
//				Integer[] endVector1 = copyOfPath1.remove();
//				if(endVector1[1] == thePath.get(count)) {
//					endingVectors1.add(endVector1);
//				}
//			}
//			Integer[] lowestFinishing1 = endingVectors1.remove();
//			while(!endingVectors1.isEmpty()) {
//				Integer[] nextOne1 = endingVectors1.remove();
//				if(nextOne1[2] < lowestFinishing1[2]) {
//					lowestFinishing1  = nextOne1;
//				}
//			}
//			thePath.add(lowestFinishing1[0]);
//			count++;
//		}
//		System.out.println(thePath);
//		Collections.reverse(thePath);
//		System.out.println(thePath);
//		Integer[] path = new Integer[thePath.size()];
//		for(int i = 0; i < path.length; i++) {
//			path[i] = thePath.get(i);
//		}
//		return 0;
//		
	}
}