
package ml.aliou.contact.controller;




import ml.aliou.contact.model.Contact;
import ml.aliou.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "contact/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/form";
    }

    @PostMapping
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable Long id, Model) {
//        Contact = contactService.findById(id);
//        model.addAttribute("contact", contact);
//        return "contact/form";
//    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }

    @GetMapping("/search")
    public String searchContacts(@RequestParam("query") String query, Model model) {
        List<Contact> contacts = contactService.searchByName(query);
        model.addAttribute("contacts", contacts);
        return "contact/list";
    }
}


