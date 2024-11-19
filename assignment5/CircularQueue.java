public class CircularQueue {
    private int[] queueArray;
    private int front, rear, size, capacity;
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void addToQueue(int item) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        size++;
        System.out.println("Enqueued " + item);
    }
    
    public void deleteFromQueue() {
        if (size == 0) {
            System.out.println("Queue is empty, cannot dequeue");
            return;
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued " + item);
    }
    
    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.addToQueue(33);
        q.addToQueue(82);
        q.addToQueue(63);
        q.printQueue();
        q.deleteFromQueue();
        q.printQueue();
    }
}

