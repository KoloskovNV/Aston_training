package Lesson_6;

public class Student {
    private String name;
    private String group;
    private int course;
    private java.util.List<Integer> score = new java.util.ArrayList<>();

    public Student(String name, String group, int course, java.util.List<Integer> score) {
        this.name = name;
        this.group = group;
        this.course = course;
        if (score != null) {
            this.score = score;
        }
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public java.util.List<Integer> getScore() {
        return score;
    }

    public double getAverageScore() {
        if (score.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int s : score) {
            sum += s;
        }
        return (double) sum / score.size();
    }

    @Override
    public String toString() {
        return "Студент: " + name + ", группа " + group + ", курс " + course + ", средняя оценка " + String.format("%.1f", getAverageScore()) + ".";
    }

    public static void removeStudents(java.util.Set<Student> students) {
        Student[] studentsArray = students.toArray(new Student[0]);
        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i].getAverageScore() < 3.0) {
                students.remove(studentsArray[i]);
            }
        }
        System.out.println("Студенты со средним баллом < 3 отчислены.");
    }

    public static void transferStudents(java.util.Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageScore() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
        System.out.println("Студенты со средним баллом >= 3 переведены на следующий курс.");
    }

    public static void printStudents(java.util.Set<Student> students, int course) {
        System.out.println("Список студентов на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName());
            }
        }
    }
}
