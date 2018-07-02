package StacksAndQueues;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked List data structure.
 */

//----- SOLUTION --------

import java.util.LinkedList;

/**
 * Use separate queues for dogs and cats, and to pla ce them within a wrapper class called Anima lQueue. We then store some sort of timestamp
 * to mark when each animal was enqueued. When we call dequeueAny, we peek at the heads of both the
 * dog and cat queue and return the oldest.
 */
public class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal dequeuAny() {
        if (dogs.size() == 0) dequeueDogs();
        else if (cats.size() == 0) dequeuCats();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) return dequeueDogs();
        else return dequeuCats();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeuCats() {
        return cats.poll();
    }

    public class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }

    public class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }
}

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}


