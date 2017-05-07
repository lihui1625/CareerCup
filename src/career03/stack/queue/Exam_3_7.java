package career03.stack.queue;

public class Exam_3_7 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class Animal {
  public long puttime;
}

class Cat extends Animal {

}

class Dog extends Animal {

}

class AnimalQueue {
  private MyQueue catQueue;
  private MyQueue dogQueue;

  public AnimalQueue() {
    catQueue = new MyQueue();
    dogQueue = new MyQueue();
  }

  public void enqueue(Animal animal) {
    animal.puttime = System.currentTimeMillis();
    if (animal instanceof Cat) {
      catQueue.enqueue(animal);
    } else if (animal instanceof Dog) {
      dogQueue.enqueue(animal);
    }

  }

  public Cat dequeueCat() {
    return (Cat) this.catQueue.dequeue();
  }

  public Dog dequeueDog() {
    return (Dog) this.dogQueue.dequeue();
  }

  public Animal dequeueAny() {
    Dog dog = (Dog) this.dogQueue.top();
    if (dog == null) {
      return (Cat) this.catQueue.dequeue();
    }
    Cat cat = (Cat) this.catQueue.top();
    if (cat == null) {
      return (Dog) this.dogQueue.dequeue();
    }
    if (dog.puttime < cat.puttime) {
      return (Dog) this.dogQueue.dequeue();
    } else {
      return (Cat) this.catQueue.dequeue();
    }
  }

}