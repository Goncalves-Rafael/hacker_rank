package data_structures;

public class InserNodeInLinkedList {
  public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    if (llist == null || position == 0) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = llist;
        return newNode;
    }
    SinglyLinkedListNode currentNode = llist;
    SinglyLinkedListNode prevNode = llist;
    for(int i = 0; i < position; i++) {
        prevNode = currentNode;
        currentNode = currentNode.next;
    }
    
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    newNode.next = currentNode;
    prevNode.next = newNode;
    
    return llist;
  }

  private static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
  
    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }
}
