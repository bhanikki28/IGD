package com.reece.demo.unit.controller;

import com.reece.demo.controller.ContactController;
import com.reece.demo.model.Contact;
import com.reece.demo.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ConcatControllerUnitTest {

    @InjectMocks
    ContactController contactController;

    @Mock
    ContactService contactService;

    private final Map<String, List<Contact>> addressBooks = new HashMap<>();
    private static final String ADDRESS_BOOK_MELBOURNE = "melbourne";
    private static final String ADDRESS_BOOK_SYDNEY = "sydney";

    Contact melbContact1 = new Contact("Nikhita", "Bharathy", Arrays.asList("0400000001"));
    Contact melbContact2 = new Contact("Anandha", "Chandran", Arrays.asList("0400000002"));
    Contact sydContact1 = new Contact("Sachin", "Tendulkar", Arrays.asList("0400000003"));
    Contact sydContact2 = new Contact("Dhoni", "CSK", Arrays.asList("0400000004"));

    List<Contact> melbourneList = new ArrayList<>();
    List<Contact> sydneyList = new ArrayList<>();
    List<Contact> contactListUniv = new ArrayList<>();



    @BeforeEach
    public void setUp(){
        melbourneList.add(melbContact1);
        melbourneList.add(melbContact2);
        sydneyList.add(sydContact1);
        sydneyList.add(sydContact2);
        contactListUniv.addAll(melbourneList);
        contactListUniv.addAll(sydneyList);
        addressBooks.put(ADDRESS_BOOK_MELBOURNE,melbourneList);
        addressBooks.put(ADDRESS_BOOK_SYDNEY,sydneyList);
    }

    @Test
    public void testGetAllContacts()
    {
        when(contactService.retrieveAllUniqueContacts(Mockito.anyBoolean())).thenReturn(contactListUniv);
        List<Contact> contactList = contactController.retrieveUniqueContactsFromAllAddressBooks(true);
        Assertions.assertEquals(4, contactList.size());
    }

    @Test
    public void testGetContactFromAddressBook()
    {
        when(contactService.retrieveContacts("sydney")).thenReturn(sydneyList);
        List<Contact> contactList = contactController.retrieveContactsFromAddressBook("sydney");
        Assertions.assertEquals(2, contactList.size());
    }

    @Test
    public void testCreateContact()
    {
        when(contactService.addContact("melbourne",melbContact1)).thenReturn(melbContact1);
        Contact contact = contactController.addContactToAddressBook("melbourne",melbContact1);
        Assertions.assertEquals("Nikhita",contact.getFirstName());
    }


}
