package com.reece.demo.controller;


import com.reece.demo.model.Contact;
import com.reece.demo.service.ContactService;
import com.reece.demo.starter.AddressBookDemoApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = AddressBookDemoApplication.class)
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    private final Map<String, List<Contact>> addressBooks = new HashMap<>();
    private static final String ADDRESS_BOOK_MELBOURNE = "melbourne";
    private static final String ADDRESS_BOOK_SYDNEY = "sydney";

    Contact melbContact1 = new Contact("Nikhita", "Bharathy", Arrays.asList("0400000001"));
    Contact melbContact2 = new Contact("Anandha", "Chandran", Arrays.asList("0400000002"));
    Contact sydContact1 = new Contact("Sachin", "Tendulkar", Arrays.asList("0400000003"));
    Contact sydContact2 = new Contact("Dhoni", "CSK", Arrays.asList("0400000004"));

    List<Contact> melbourneList = new ArrayList<>();
    List<Contact> sydneyList = new ArrayList<>();


    @BeforeEach
    public void setUp(){
        melbourneList.add(melbContact1);
        melbourneList.add(melbContact2);
        sydneyList.add(sydContact1);
        sydneyList.add(sydContact2);
        addressBooks.put(ADDRESS_BOOK_MELBOURNE,melbourneList);
        addressBooks.put(ADDRESS_BOOK_SYDNEY,sydneyList);
    }


    @Test
    public void testGetContactsFromAllAddress() throws Exception {

        when(contactService.retrieveContacts(Mockito.anyString())).thenReturn(melbourneList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/contacts?unique=true")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testGetContactsFromAddressBook() throws Exception {

        when(contactService.retrieveContacts(Mockito.anyString())).thenReturn(melbourneList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/address-book/melbourne/contacts")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testDeleteContact() throws Exception {

        when(contactService.retrieveContacts(Mockito.anyString())).thenReturn(melbourneList);
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/address-book/sydney/contacts/Dhoni")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void test404Error() throws Exception {

        when(contactService.retrieveContacts(Mockito.anyString())).thenReturn(melbourneList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/address-book/sydney/contacts/Dhoni")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /*
    @Test
    public void testAddAddressBook() throws Exception {

        when(contactService.addContact(Mockito.anyString(),any(Contact.class))).thenReturn(sydContact1);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/address-book/sydney/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }*/
}
