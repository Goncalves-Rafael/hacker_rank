package data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class QueueTwoStacks<T> {
  private Deque<T> queueOne;
  private Deque<T> queueTwo;

  public QueueTwoStacks() {
      queueOne = new LinkedList<>();
      queueTwo = new LinkedList<>();
  }

  public void enqueue(T data) {
      queueOne.push(data);
  }

  public T dequeue() {
    if (queueTwo.isEmpty()) {
      sendToQueueTwo();
    }
    return queueTwo.pop();
  }

  public T peek() {
    if (queueTwo.isEmpty()) {
      sendToQueueTwo();
    }
    return queueTwo.peek();
  }

  private void sendToQueueTwo() {
    while (!queueOne.isEmpty()) {
      queueTwo.push(queueOne.pop());
    }
  }
}
