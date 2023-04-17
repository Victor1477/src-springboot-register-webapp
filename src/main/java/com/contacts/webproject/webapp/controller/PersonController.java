package com.contacts.webproject.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contacts.webproject.webapp.dao.PersonDao;
import com.contacts.webproject.webapp.entity.Person;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	private static long requestNumber = 0;

	private static Map<Integer, Person> deletedPeople = new HashMap<>();

	@Autowired
	private PersonDao personDao;

	private static void countRequest() {
		requestNumber++;
		System.out.println("\nRequest Number: " + requestNumber);
	}

	@RequestMapping(value = "/list")
	public String getAll(Model model) {
		countRequest();
		System.out.println("Get list of all.");

		List<Person> people = personDao.getAll();

		System.out.println("List size: " + people.size());

		people.sort((p1, p2) -> p1.getNome().toLowerCase().compareTo(p2.getNome().toLowerCase()));

		model.addAttribute("people", people);

		return "list-all";
	}

	@RequestMapping(value = "/form")
	public String showFormForAdd(Model model) {
		countRequest();
		System.out.println("Open new form.");

		Person person = new Person();

		model.addAttribute("person", person);

		return "form";
	}

	@RequestMapping(value = "/updateForm")
	public String showFormForUpdate(Model model, @RequestParam("personId") int id) {
		Person person = personDao.getSingle(id);

		countRequest();

		System.out.println("Open update form for: " + person.getNome());

		model.addAttribute("person", personDao.getSingle(id));

		return "form";
	}

	@RequestMapping(value = "/save")
	public String addOrUpdate(@ModelAttribute("person") Person person) {
		countRequest();
		System.out.println("Save: " + person.getNome());

		if (person.getNome().isEmpty()) {
			System.out.println("Saving Error: person name is empty.");
			return "redirect:/person/list";
		} else {
			personDao.saveOrUpdate(person);
			return "redirect:/person/list";
		}
	}

	@RequestMapping(value = "/delete")
	public String deleteById(@RequestParam("personId") int id) {
		Person person = personDao.getSingle(id);

		deletedPeople.put(id, person);

		countRequest();

		System.out.println("Delete: " + person.getNome());

		personDao.delete(id);

		return "redirect:/person/list";
	}

	@RequestMapping(value = "/deleted")
	public String showDeleted(Model model) {
		model.addAttribute("people", deletedPeople);

		return "list-deleted";
	}

	@RequestMapping(value = "/restore")
	public String restoreDeleted(@RequestParam("personId") int id) {
		Person person = deletedPeople.get(id);

		System.out.println("restore: " + person.getNome());

		person.setId(0);

		personDao.saveOrUpdate(person);

		deletedPeople.remove(id);

		return "redirect:/person/deleted";
	}
}