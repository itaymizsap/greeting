package com.itay.spring.tutorials.microservices.greeting.ui;

import java.util.*;

public class MainExercise {

//    public static void main(String[] args) {

    //	    ArrayList<Integer> A = new ArrayList<>();
    //	    A.add(1);
    //	    A.add(2);
    //	    A.add(3);
    //	    A.add(4);
    //	    int B = 8;
    //	    int rotate = B > A.size() ? B % A.size() : B;
    //
    //	    ArrayList<Integer> ret = new ArrayList<Integer>();
    //		for (int i = 0; i + rotate < A.size(); i++) {
    //			ret.add(A.get(i + rotate));
    //		}
    //
    //		for (int i = 0; i < rotate; i++) {
    //			ret.add(A.get(i));
    //		}
    //
    //	    System.out.println(ret);
//    }


//    public static void main(String[] args) {
//	String stringUnderTest = " H ello Worldwd";
//	HashMap<String, Integer> charsCount = new HashMap<String, Integer>();
//	
//	for (String str : stringUnderTest.split("")) {
//	    charsCount.put(str, charsCount.containsKey(str) ? charsCount.get(str) + 1 : 1);
//	}
//	
//	charsCount.keySet().stream().filter(a -> !a.trim().equals("") && charsCount.get(a) == 1).forEach(b -> System.out.println(b));
//    }


    //Threads
    //==============

//    public static void main(String[] args) {
//	ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
//	String[] names = {"Itay", "Anton", "Shiran", "Liron", "Dagan"};
//	Random ran = new Random();
//	
//	Runnable addNamesToQueueRunnable = 
//		() -> {
//		    long sleepTime = 2000;
//		    while (true) 
//		    {
//			String randomName = names[ran.nextInt(names.length)];
//			try {
//			    queue.put(randomName);
//			    System.out.println("[Queue] <= " + randomName);
//			} catch (InterruptedException e1) {
//			    e1.printStackTrace();
//			}		
//			
//			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {e.printStackTrace();}
//			sleepTime -= sleepTime - 200 < 0 ? -2000 : 200;
//		    }
//		};
//							
//	Thread namesProducer = new Thread(addNamesToQueueRunnable);
//	namesProducer.start();
//	
//	try {
//	    Thread.sleep(10000);
//	    System.out.println("...Consuming");
//	} catch (InterruptedException e1) {
//	    e1.printStackTrace();
//	}
//	
//	Runnable consumeNamesFromRun1 = () -> {while (true) {
//	    try {System.out.println("[DeQueue]=======(Thread-1)======>" + queue.take());} catch (Exception e1) {e1.printStackTrace();}
//	    try {Thread.sleep(2300);} catch (InterruptedException e) {e.printStackTrace();}}};
//
//	Thread namesConsumer1 = new Thread(consumeNamesFromRun1);
//	namesConsumer1.start();
//	
//	Runnable consumeNamesFromRun2 = () -> {while (true) {
//	    try {System.out.println("[DeQueue]=======(Thread-2)======>" + queue.take());} catch (Exception e1) {e1.printStackTrace();}
//	    try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}}};
//
//	Thread namesConsumer2 = new Thread(consumeNamesFromRun2);
//	namesConsumer2.start();
//    }

//   public static void main(String[] args) {
//	int[] A = {-1,9,5,-1,1,1,7,-1,80};
//	
//	HashMap<Integer, HashMap<Integer,HashMap<Integer,ArrayList<Integer>>>> subArrMap = 
//		new HashMap<Integer, HashMap<Integer,HashMap<Integer,ArrayList<Integer>>>>();
//
//	int i = 0;
//	while (i < A.length) {
//	    ArrayList<Integer> arr = new ArrayList<>();
//	    int arrSum = 0;
//	    while (i < A.length && A[i] >= 0) {
//		arr.add(A[i]);
//		arrSum += A[i];
//		i++;
//	    }
//	    
//	    i++;
//	    if (arr.size() == 0) {
//		continue;
//	    }
//	    
//	    if (subArrMap.containsKey((Integer)arrSum)) {
//		if (subArrMap.get((Integer)arrSum).containsKey(arr.size())) {
//		    subArrMap.get((Integer)arrSum).get(arr.size()).put((Integer)arr.get(0), arr);
//		}
//		else { //there's an array with similar sum but different length
//		    subArrMap.get((Integer)arrSum).put(arr.size(), new HashMap<Integer,ArrayList<Integer>>());
//		    subArrMap.get((Integer)arrSum).get(arr.size()).put((Integer)arr.get(0), arr);
//		}
//	    }
//	    else { //there's no array with similar sum
//		subArrMap.put((Integer)arrSum, new HashMap<Integer,HashMap<Integer,ArrayList<Integer>>>());
//		subArrMap.get((Integer)arrSum).put(arr.size(), new HashMap<Integer,ArrayList<Integer>>());
//		subArrMap.get((Integer)arrSum).get(arr.size()).put((Integer)arr.get(0), arr);
//	    } 
//	}
//
//	Integer[] sums = subArrMap.keySet().toArray(new Integer[subArrMap.keySet().size()]);
//	
//	int biggestSum = sums[sums.length-1];	
//	Integer[] lengthsWithBiggestSum = subArrMap.get(biggestSum).keySet()
//		.toArray(new Integer[subArrMap.get(biggestSum).keySet().size()]);
//	
//	int biggestSumAndLength = lengthsWithBiggestSum[lengthsWithBiggestSum.length-1];
//	Integer[] firstindexesOfBiggestLengthsWithBiggestSum = subArrMap.get(biggestSum).get(biggestSumAndLength).keySet()
//		.toArray(new Integer[subArrMap.get(biggestSum).get(biggestSumAndLength).keySet().size()]);
//	
//	int lowestFirstIndexValueArrWithBiggestLengthAndBiggestSum = firstindexesOfBiggestLengthsWithBiggestSum[0];
//	
//	System.out.println(subArrMap.get(biggestSum).get(biggestSumAndLength).get(lowestFirstIndexValueArrWithBiggestLengthAndBiggestSum).
//		toArray(new Integer[subArrMap.get(biggestSum).get(biggestSumAndLength).get(lowestFirstIndexValueArrWithBiggestLengthAndBiggestSum).size()]));
//
//	
//	@SuppressWarnings("unused")
//	int x =0;
//    }

//    public static void main(String[] args) {
//    ConfigurableApplicationContext con = SpringApplication.run(SpringMicroservicesItayApplication.class, args);
//    System.out.println(Arrays.asList(con.getBeanDefinitionNames()));
//    }

    /**
     * Non Symmetric Matrix 
     * [ - - - - ]
     * [ - - - ]
     * [ - - - - - - - - ]
     * [ - ]
     * [ - - - - - - - - - - ]
     *
     * This program accesses all matrix combinations from any item in line=1 with any item in line=2 with any item from....line-n
     *
     * @param args
     */
//    public static void main(String[] args) {
//	
//	String[][] mat = new String[3][];
//	
//	String[] line1 = {"a","b","c"};
//	String[] line2 = {"99","23","77"};
//	String[] line3 = {"#","%","@"};
//	
//	mat[0] = line1;
//	mat[1] = line2;
//	mat[2] = line3;
//	
//	int[] combination = new int[mat.length];
//	
//	do {
//	    printWord(mat, combination);
//	}
//	while (incrementCombination(combination, mat));
//    }
//    
//    private static boolean incrementCombination(int[] combination, String[][] mat) {
//	for (int i = combination.length - 1; i >= 0; i--) {
//	    if (combination[i] < mat[i].length - 1) {
//		combination[i]++;
//		zeroLSBIndexes(combination, i);
//		return true;
//	    }
//	}
//	
//	return false;
//    }
//
//    private static void zeroLSBIndexes(int[] combination, int i) {
//	for (int j = i + 1; j < combination.length; j++) {
//	    combination[j] = 0;
//	}
//    }
//
//    private static void printWord(String[][] mat, int[] combination) {
//	for (int k = 0; k < mat.length; k++) {
//	    System.out.print(mat[k][combination[k]] + ",");
//	} 
//	System.out.print('\n');
//    }
//    
//    private static void printCombination(String[][] mat, int[] combination) {
//	for (int k = 0; k < mat.length; k++) {
//	    System.out.print(combination[k]);
//	} 
//	System.out.print('\n');
//    }


    /**
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * <p>
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * <p>
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     *
     * @param args
     */
    public static void main(String[] args) {

        Set<Node<String>> set = buildGraph(Arrays.asList("hot", "dot", "dog", "lot", "log"));

        //Print Graph
        for (Node<String> node : set) {
            System.out.println(node);
        }

        System.out.println("_________________________________________________\n");

        String startWord = "lag";
        String endWord = "mot";
        List<LinkedList<Node<String>>> validPaths = new ArrayList<>();

        //Populate 'validPaths' list
        LinkedList<Node<String>> pathAccumulator = new LinkedList<>();
        for (Node<String> node : set) {
            if (isDifferByOneCharOnly(startWord, node.val)) {
                if (node.val.equals("hot"))
                    System.out.println("");
                calcTransitionPathFromNode(endWord, node, pathAccumulator, validPaths);
            }
        }

        //Print
        for (LinkedList<Node<String>> validPath : validPaths) {
            System.out.print(startWord);
            validPath.stream().forEach(a -> System.out.print("-->" + a.val));
            System.out.println("-->" + endWord + "\n-----------------------------");
        }
    }


    private static void calcTransitionPathFromNode
            (String endWord, Node<String> node, LinkedList<Node<String>> pathAccumulator, List<LinkedList<Node<String>>> validPaths) {
        if (!pathAccumulator.contains(node)) { //if not visited, i.e. if not DEAD-END
            pathAccumulator.addLast(node);
            if (isDifferByOneCharOnly(node.val, endWord)) {//not visited and is the last node in a valid transition
                LinkedList<Node<String>> validPath = new LinkedList<>();
                validPath.addAll(pathAccumulator);
                validPaths.add(validPath);
                pathAccumulator.removeLast();
            } else {
                for (Node<String> adjacentNode : node.edgeNodes) {
                    //PathAccumulator contain the path so far, and will grow and shrink for every sub-path
                    calcTransitionPathFromNode(endWord, adjacentNode, pathAccumulator, validPaths);
                }
            }
        }
    }

    private static Set<Node<String>> buildGraph(List<String> dictV) {
        Set<Node<String>> graph = new HashSet<>();

        for (String string : dictV) {
            graph.add(new Node<String>(string));
        }

        for (Node<String> node : graph) {
            for (Node<String> neighborNodeCandidate : graph) {
                if (!node.edgeNodes.contains(neighborNodeCandidate)
                        && isDifferByOneCharOnly(node.val, neighborNodeCandidate.val)) {
                    node.edgeNodes.add(neighborNodeCandidate);
                    neighborNodeCandidate.edgeNodes.add(node);
                }
            }
        }

        return graph;
    }

    private static boolean isDifferByOneCharOnly(String val, String val2) {
        byte[] valBytes = val.getBytes();
        byte[] val2Bytes = val2.getBytes();
        int countDiff = 0;
        for (int i = 0; i < valBytes.length; i++) {
            countDiff += valBytes[i] != val2Bytes[i] ? 1 : 0;
        }

        return countDiff == 1;
    }
}