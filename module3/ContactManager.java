import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Shabab Khan", new Contact("Shabab Khan", "+1 718 651 7833"));
        contacts.put("Captain Rex", new Contact("Captain Rex", "+1 678 908 2345"));
        contacts.put("Darth Maul", new Contact("Darth Maul", "+1 879 123 4567"));
        contacts.put("Jon Snow", new Contact("Jon Snow", "+1 785 921 7493"));

        if (contacts.get("Ada Lovelace") == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(contacts.get("Ada Lovelace"));
        }

        if (contacts.get("Darth Maul") == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(contacts.get("Darth Maul"));
        }

        if (contacts.get("Anakin Skywalker") == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(contacts.get("Anakin Skywalker"));
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contacts.get(contact.getName()));
        }

    }
}
