import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {
    private final AddressBook addressBook = new AddressBook();

    @Test
    public void should_add_an_address_to_the_book() {
        // given
        String name = "Alex";
        String address = "Lenina 6";

        // when
        addressBook.add(name, address);

        // then
        AddressBook.Address expected = new AddressBook.Address("Lenina", "6");
        AddressBook.Address actual = addressBook.get(name);
        assertEquals(expected, actual);
    }

    @Test
    public void should_delete_a_person() {
        // given
        String name = "Ann";
        addressBook.add(name, "Sadovaya 4");

        // when
        addressBook.delete(name);

        // then
        AddressBook.Address actual = addressBook.get(name);
        assertNull(actual);
    }

    @Test
    public void should_get_an_address() {
        // given
        String name = "Paul";
        addressBook.add(name, "Lugovaya 11");

        // when
        AddressBook.Address actual = addressBook.get(name);

        // then
        AddressBook.Address expected = new AddressBook.Address("Lugovaya", "11");
        assertEquals(expected, actual);
    }

    @Test
    public void should_change_an_address() {
        // given
        String name = "Nick";
        String address = "Lesnaya 5";
        addressBook.add(name, "Dorozhnaya 23");

        // when
        addressBook.change(name, address);

        // then
        AddressBook.Address actual = addressBook.get(name);
        AddressBook.Address expected = new AddressBook.Address("Lesnaya", "5");
        assertEquals(expected, actual);
    }

    @Test
    public void should_get_a_liststreet() {
        // given
        String street = "Nekrasova";
        addressBook.add("Dima", "Nekrasova 54");
        addressBook.add("Roman", "Nekrasova 32");

        // when
        String actual = addressBook.liststreet(street);

        // then
        String expected = "[Dima, Roman]";
        assertEquals(expected, actual);
    }
    @Test
    public void should_get_a_liststreet_2() {
        // given
        String street = "Mira";
        addressBook.add("Dima", "Nekrasova 54");
        addressBook.add("Roman", "Nekrasova 32");
        addressBook.add("Bob", "Mira 8");

        // when
        String actual = addressBook.liststreet(street);

        // then
        String expected = "[Bob]";
        assertEquals(expected, actual);
    }

    @Test
    public void should_get_a_listhouse() {
        // given
        String house = "8";
        addressBook.add("Dima", "Nekrasova 54");
        addressBook.add("Roman", "Nekrasova 8");
        addressBook.add("Bob", "Mira 8");

        // when
        String actual = addressBook.listhouse(house);

        // then
        String expected = "[Bob, Roman]";
        assertEquals(actual, expected);
    }
}