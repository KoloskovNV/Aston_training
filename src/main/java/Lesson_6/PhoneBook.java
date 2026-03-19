package Lesson_6;

public class PhoneBook {
    private java.util.Map<String, java.util.List<String>> phoneBook = new java.util.HashMap<>();

    public void add(String surname, String phone) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new java.util.ArrayList<>());
        }
        phoneBook.get(surname).add(phone);
    }

    public java.util.List<String> get(String surname) {
        if (phoneBook.containsKey(surname)) {
            return phoneBook.get(surname);
        }
        return new java.util.ArrayList<>();
    }

    public void printAll() {
        System.out.println("Телефонный справочник:");
        for (String surname : phoneBook.keySet()) {
            System.out.print(surname + ": ");
            java.util.List<String> phones = phoneBook.get(surname);
            for (int i = 0; i < phones.size(); i++) {
                System.out.print(phones.get(i));
                if (i < phones.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
