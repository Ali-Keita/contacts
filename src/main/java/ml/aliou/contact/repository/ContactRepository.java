
package ml.aliou.contact.repository;

import ml.aliou.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNameContaining(String name);
    List<Contact> findByPhoneContaining(String phone);
    }



