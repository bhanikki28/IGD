package com.reece.demo.controller;

import java.util.List;

import com.reece.demo.model.Contact;
import com.reece.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "Address Book Management", protocols = "http")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @ApiOperation(value = "To add contact to Address Book", response = Contact.class,
            code = 200)
    @PostMapping("/address-book/{addressBookId}/contacts")
    public Contact addContactToAddressBook(
            @PathVariable String addressBookId, @Valid @RequestBody Contact newContact) {

        return contactService.addContact(addressBookId, newContact);
    }

    @ApiOperation(value = "To delete the contact in a address book", response = Contact.class,
            code = 200)
    @DeleteMapping("/address-book/{addressBookId}/contacts/{contactId}")
    public Contact removeContactFromAddressBook(@PathVariable String addressBookId,
                                                @PathVariable String contactId) {
        return contactService.removeContact(addressBookId, contactId);
    }

    @ApiOperation(value = "To get all contacts in a address book", response = Contact.class,
            code = 200)
    @GetMapping("/address-book/{addressBookId}/contacts")
    public List<Contact> retrieveContactsFromAddressBook(@PathVariable String addressBookId) {
        return contactService.retrieveContacts(addressBookId);
    }

    @ApiOperation(value = "To retrieve contacts across address books based on unique flag", response = Contact.class,
            code = 200)
    @GetMapping("/contacts")
    public List<Contact> retrieveUniqueContactsFromAllAddressBooks(@RequestParam(value = "unique", defaultValue = "false") Boolean unique) {
        return contactService.retrieveAllUniqueContacts(unique);
    }

}
