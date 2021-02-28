import java.util.*;
import java.lang.String;

public class AddressBook {
    /**
     * Address
     */
    public static class Address {
        private final String street;
        private final String house;

        public Address(String street, String house) {
            this.street = street;
            this.house = house;
        }

        public Address(String streetAndHouseNumber) {
            final String[] streetAndHouseNumberArr = streetAndHouseNumber.split(" ");
            this.street = streetAndHouseNumberArr[0];
            this.house = streetAndHouseNumberArr[1];
        }

        public String getHouse() {
            return house;
        }

        public String getStreet() {
            return street;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(street, address.street) &&
                    Objects.equals(house, address.house);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, house);
        }

        @Override
        public String toString() {
            return street + " " + house;
        }
    }

    private final Map<String, Address> book = new HashMap<>();

    /**
     * Adding a new address
     */
    public void add(String name, String address) {
        book.put(name, new Address(address));
    }

    /**
     * Deleting person
     */
    public void delete(String name) {
        book.remove(name);
    }

    /**
     * Getting an address
     */
    public Address get(String name) {
        return book.get(name);
    }

    /**
     * Changing an address
     */
    public void change(String name, String address) {
        book.replace(name, new Address(address));
    }

    /**
     * Getting a list of people living on the same street
     */

    public String liststreet(String street) {
        if (street == null) return "There are not any people living on this street";
        List<String> result = new ArrayList<>();
        book.forEach((key, value) -> {
            if (value.getStreet().equals(street)) {
                result.add(key);
            }
        });
        if (result.size() == 0) result.add("There are not any people living on this street");
        return result.toString();
    }

    /**
     * Getting a list of people living in the same house
     */
    public String listhouse(String house) {
        if (house == null) return "There are not any people living in this house";
        List <String> result = new ArrayList<>();
        book.forEach((key, value) -> {
            if (value.getHouse().equals(house)) {
                result.add(key);
            }
        });
        if (result.size() == 0) result.add("There are not any people living in this house");
        return result.toString();
    }

    /**
     * Getting a book
     */
    public Map<String, Address> getAddressBook() {
        return book;
    }
}

