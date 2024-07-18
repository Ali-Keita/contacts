package ml.aliou.contact.service;




import ml.aliou.contact.exception.ContactNotFoundException;
import ml.aliou.contact.model.Contact;
import ml.aliou.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ContactService {

        @Autowired
        private ContactRepository contactRepository;

        public List<Contact> findAll() {
            return contactRepository.findAll();
        }

        public Contact findById(Long id) {
            return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
        }

        public Contact save(Contact contact) {
            return contactRepository.save(contact);
        }

        public void delete(Long id) {
            contactRepository.deleteById(id);
        }

        public List<Contact> searchByName(String name) {
            return contactRepository.findByNameContaining(name);
        }

        public List<Contact> searchByPhone(String phone) {
            return contactRepository.findByPhoneContaining(phone);
        }
    }


