package com.webonise.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.model.Contact;
import com.webonise.service.ContactService;

@Controller
public class ContactController {
	
@Autowired
private ContactService contactService;
@RequestMapping(value= "/contacts", method=RequestMethod.GET)
public String allContacts(Map<String, Object> map)
{  
    map.put("allContacts", contactService.listContact());
	/*System.out.println("inside all contacts action"+ map.get("allContacts"));*/
	return "contact";
	
}

@RequestMapping(value = "/addContact", method = RequestMethod.POST)
public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

    contactService.addContact(contact);

    return "redirect:/contacts";
}

@RequestMapping("contacts/delete/{contactId}")
public String deleteContact(@PathVariable("contactId")
Integer contactId) {

    contactService.removeContact(contactId);

    return "redirect:/contacts";
}

@RequestMapping(value ="contacts/edit/{contactId}",method= RequestMethod.GET)
public ModelAndView editContact(@PathVariable("contactId")Integer contactId,org.springframework.web.servlet.ModelAndView mv) {

    Contact contact = contactService.getContact(contactId);
    mv.addObject("contact",contact);
    mv.setViewName("editContact");
    return mv;
}


@RequestMapping(value ="/updateContact",method= RequestMethod.POST)
public String updateContact(@ModelAttribute Contact contact, HttpServletRequest req) {
    
    contactService.updateContact(Integer.parseInt(req.getParameter("contact_id")), contact);
    System.out.println("inside update contact");
    return "redirect:/contacts";
}



@RequestMapping(value= "/", method=RequestMethod.GET)
public String hello(Map<String, Object> map)
{  
	return "redirect:/contacts";
	
}




}
