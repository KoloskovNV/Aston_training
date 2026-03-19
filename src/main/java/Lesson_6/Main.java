package Lesson_6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: Список студентов\n");
        java.util.Set<Student> students = new java.util.HashSet<>();
        students.add(new Student("Владимир Петров", "202", 2, java.util.Arrays.asList(5, 4, 5)));
        students.add(new Student("Платон Дроздов", "101", 1, java.util.Arrays.asList(3, 3, 3)));
        students.add(new Student("Степан Зайцев", "102", 1, java.util.Arrays.asList(2, 2, 3)));
        students.add(new Student("Екатерина Комарова", "203", 2, java.util.Arrays.asList(4, 5, 4)));
        students.add(new Student("Лариса Федосеева", "301", 3, java.util.Arrays.asList(2, 3, 3)));
        students.add(new Student("Ада Журавлева", "103", 1, java.util.Arrays.asList(5, 3, 2)));
        System.out.println("Список студентов:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
        Student.printStudents(students, 1);
        Student.removeStudents(students);
        System.out.println("Список студентов после отчисления:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
        Student.transferStudents(students);
        System.out.println("Список студентов после перевода на следующий курс:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
        Student.printStudents(students, 2);
        Student.printStudents(students, 3);

        System.out.println("\nЗадание2: Телефонный справочник\n");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аршавин", "+7-917-917-17-17");
        phoneBook.add("Кержаков", "+7-927-927-27-27");
        phoneBook.add("Дзюба", "+7-905-905-05-05");
        phoneBook.add("Березуцкий", "+7-961-961-61-61");
        phoneBook.add("Березуцкий", "+7-900-900-00-00");
        phoneBook.add("Карпин", "+7-999-999-99-99");
        phoneBook.printAll();
        System.out.println("Поиск телефонов для фамилии 'Аршавин':");
        java.util.List<String> arshavinPhones = phoneBook.get("Аршавин");
        if (arshavinPhones.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            for (String phone : arshavinPhones) {
                System.out.println("- " + phone);
            }
        }
        System.out.println();
        System.out.println("Поиск телефонов для фамилии 'Березуцкий':");
        java.util.List<String> berezutskyPhones = phoneBook.get("Березуцкий");
        if (berezutskyPhones.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            for (String phone : berezutskyPhones) {
                System.out.println("- " + phone);
            }
        }
        System.out.println();
        System.out.println("Поиск телефонов для фамилии 'Месси':");
        java.util.List<String> messiPhones = phoneBook.get("Месси");
        if (messiPhones.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            for (String phone : messiPhones) {
                System.out.println("- " + phone);
            }
        }
    }
}