package Lesson_4;

public class Bowl {
    private int food;

    public Bowl(int foodInBowl) {
        if (foodInBowl < 0) {
            this.food = 0;
        } else {
            this.food = foodInBowl;
        }
    }

    public int getFood() {
        return food;
    }

    public void eatFood(int count) {
        if (count < 0) {
            return;
        }
        this.food = this.food - count;
        if (this.food < 0) {
            this.food = 0;
        }
    }

    public void addFood(int count) {
        if (count > 0) {
            this.food += count;
            System.out.println("В миску добавили " + count + " еды." + " Всего в миске: " + food + " еды.");
        }
    }

    public void printInfo() {
        System.out.println("В миске " + food + " еды");
    }
}
