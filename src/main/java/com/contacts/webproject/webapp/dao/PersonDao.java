package com.contacts.webproject.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.contacts.webproject.webapp.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PersonDao {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public List<Person> getAll() {

		Session session = entityManager.unwrap(Session.class);

		Query<Person> query = session.createQuery("from Person", Person.class);

		List<Person> people = query.getResultList();

		return people;
	}

	@Transactional
	public Person getSingle(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query<Person> query = session.createQuery("from Person where id=" + id, Person.class);

		Person person = query.getSingleResult();

		return person;
	}

	@Transactional
	public void saveOrUpdate(Person person) {

		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(person);
	}

	@Transactional
	public void delete(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query<Person> query = session.createQuery("from Person where id=" + id, Person.class);

		Person person = query.getSingleResult();

		session.delete(person);
	}
}
