package com.reece.demo.service;

import com.reece.demo.exception.ValidationException;
import com.reece.demo.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private static final String ADDRESS_BOOK_MELBOURNE = "melbourne";
    private static final String ADDRESS_BOOK_SYDNEY = "sydney";

    private final Map<String, List<Contact>> addressBooks = new HashMap<>();

    public ContactService() {
        addressBooks.put(ADDRESS_BOOK_MELBOURNE, new ArrayList<>());
        addressBooks.put(ADDRESS_BOOK_SYDNEY, new ArrayList<>());

        this.addContact(ADDRESS_BOOK_MELBOURNE, new Contact("Nikhita", "Bharathy", Arrays.asList("0400000001")));
        this.addContact(ADDRESS_BOOK_MELBOURNE, new Contact("Janani", "Chandran", Arrays.asList("0400000002")));

        this.addContact(ADDRESS_BOOK_SYDNEY, new Contact("Sachin", "Tendulkar", Arrays.asList("0400000003")));
        this.addContact(ADDRESS_BOOK_SYDNEY, new Contact("Dhoni", "CSK", Arrays.asList("0400000004")));
    }

    public Contact addContact(String addressBookId, Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        if (!addressBooks.containsKey(addressBookId)) {
            addressBooks.put(addressBookId, new ArrayList<>());
        }
        addressBooks.get(addressBookId).add(contact);
        return contact;
    }

    public Contact removeContact(String addressBookId, final String contactId) {
        if (!addressBooks.containsKey(addressBookId)) {
            throw new ValidationException("AddressBook with the given Id does not exist");
        }
        Optional<Contact> contactToBeRemoved = addressBooks.get(addressBookId).stream()
                .filter(contact -> contact.getId().equals(contactId)).findFirst();
        if (contactToBeRemoved.isPresent()) {
            addressBooks.get(addressBookId).remove(contactToBeRemoved.get());
            return contactToBeRemoved.get();
        } else {
            throw new ValidationException("The given contact does not exist!");
        }
    }

    public List<Contact> retrieveContacts(String addressBookId) {
        if (!addressBooks.containsKey(addressBookId)) {
            throw new ValidationException("AddressBook with the given Id does not exist");
        }
        return addressBooks.get(addressBookId);
    }

    public List<Contact> retrieveAllUniqueContacts(boolean unique) {
        List<Contact> contacts = new ArrayList<>();
        addressBooks.values().forEach(contacts::addAll);
        if (unique) {
            return contacts.stream().distinct().collect(Collectors.toList());
        }
        return contacts;
    }
}
