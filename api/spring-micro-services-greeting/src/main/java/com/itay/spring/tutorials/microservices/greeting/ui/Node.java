package com.itay.spring.tutorials.spring.microservices;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
	public final T val;
	public final Set<Node<T>> edgeNodes = new HashSet<Node<T>>();
	
	public Node(T val) {
	    this.val = val;
	}
	
	@Override
	public String toString() {
	
	    StringBuilder sb = new StringBuilder();
	    for (Node<T> node : edgeNodes) {
		sb.append(val + " <---> " + node.val + "\n");
	    }
	    
	    sb.append("------------------------");
	    
	    return sb.toString();
	}
}
