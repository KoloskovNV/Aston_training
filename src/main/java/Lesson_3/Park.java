package Lesson_3;

public class Park {
    private String name;
    private String city;
    private Attraction attraction;
    public Park(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public Attraction getAttraction() {return attraction;}
    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
    public class Attraction {
        private String attractionName;
        private String workingHours;
        private int cost;
        public Attraction(String attractionName, String workingHours, int cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " руб.");
            System.out.println("Парк: " + name + ", г. " + city);
            System.out.println();
        }
    }
}