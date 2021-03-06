/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema3;

/**
 *
 * @author ROG
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
       private Node<E> header = null;
	private Node<E> trailer = null;
	private int size = 0;
        
 public LinkedPositionalList() {
	header = new Node<>(null, null, null);
	trailer = new Node<>(null, header, null);
	header.setNext(trailer);
	}
 /**
  * 
  * @param p   Node to validate 
  * @return the verified node
  * @throws IllegalArgumentException when a node is not found
  */
 private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
    @Override
    /**
     * the used space of the array
     */
  
    public int size() {
        return size;
    }
    /**
     * 
     * @param node the element sent to wrap 
     * @return the wrapped node
     */
 private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}
    @Override
    
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /**
     * @return the first element of the list
     */
    public Position<E> first() {
       	return position(header.getNext());
    }

    @Override
    /**
     * @return the last element (the previous of the trailer ) 
     */
    public Position<E> last() {
       return position(trailer.getPrev());
     
    }
/**
 * 
 * @param e the element that has to be inserted 
 * @return 
 */
    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
/**
 * 
 * @param e the element that is going to be inserted 
 * @return the add between the trailer and the last node
 */
    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
       Node<E> node = validate(p);
		return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
       Node<E> node = validate(p);
      return position(node.getNext());
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
       Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
    }
    /**
     * 
     * @param e the element to insert 
     * @param pred the previous node
     * @param succ the next node 
     * @return the new node
     */
private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
    @Override
    /**
     * 
     * @return the list with out the value 
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
                Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
    }

    @Override
   
    /**
     * @param p the node that is gone be change
     * @param q 
     * it takes the information of the node p and q keep it in a temporate pivot for  q and p and takes de the data in a temporate generic variable
     * so later the element of the pivot is set  in the temporatePivot value(which is also the node p and q ). 
     */
    public void swap(Position<E> p, Position<E> q) {
        
            Node<E> temporatePivot1 = validate(p); 
            Node<E> temporatePivot2 = validate(q); 
            E  temporate1 = temporatePivot1.getElement(); 
            E temporate2 = temporatePivot2.getElement();
            temporatePivot1.setElement(temporate2);
            temporatePivot2.setElement(temporate1);
    }

   
}
