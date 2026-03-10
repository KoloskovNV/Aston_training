package Lesson_4;

public class Cat extends Animal {
    private boolean isNotHungry;

    public Cat(String name) {
        super(name, 200, 0, false);
        this.isNotHungry = false;
        numberCat++;
    }

    public void catIsEating(Bowl bowl, int amountFood) {
        if(bowl.getFood() >= amountFood) {
            bowl.eatFood(amountFood);
            this.isNotHungry = true;
            System.out.println(name + " съел " + amountFood + " еды");
        } else {
            System.out.println(name + " не ест, мало еды (" + bowl.getFood() + ") " + ", нужно (" + amountFood + ")");
        }
    }

    public boolean isNotHungry() { return isNotHungry; }
    public void printCatStatus() {
        System.out.println(name + (isNotHungry ? " сытый" : " голодный"));
    }
}