import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        AddressBook addressBook = new AddressBook();
        System.out.println("Добавление - add, удаление - delete, получение по имени - get, " +
                "изменение данных - change, получение списка по улице/ дому - liststreet/ listhouse, " +
                "получение адресной книги - getAddressBook, выход - exit,");
        Scanner in = new Scanner(System.in);
        String task = in.nextLine();
        while(!task.equals("exit")) {
            if (task.equals("add")) {
                System.out.println("Name:");
                String name = in.nextLine();
                System.out.println("Address(street and house):");
                String address = in.nextLine();
                addressBook.add(name, address);
            }
            if (task.equals("delete")) {
                System.out.println("Name:");
                String name = in.nextLine();
                addressBook.delete(name);
            }
            if (task.equals("get")) {
                System.out.println("Name:");
                String name = in.nextLine();
                System.out.println(addressBook.get(name).getStreet() + " " + addressBook.get(name).getHouse());
            }
            if (task.equals("change")) {
                System.out.println("Name:");
                String name = in.nextLine();
                System.out.println("New address:");
                String address = in.nextLine();
                addressBook.change(name, address);
            }
            if (task.equals("liststreet")) {
                System.out.println("Street:");
                String Street = in.nextLine();
                String result = addressBook.liststreet(Street);
                System.out.println(result);
            }
            if (task.equals("listhouse")) {
                System.out.println("House:");
                String address = in.nextLine();
                String result = addressBook.listhouse(address);
                System.out.println(result);
            }
            if (task.equals("getAddressBook")) {
                System.out.println(addressBook.getAddressBook());
            }
            in = new Scanner(System. in);
            task = in.nextLine();
        }
    }
}
