package com.contacts.webproject.webapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cadastro")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "contato")
	private String contato;

	@Column(name = "link_facebook")
	private String linkFacebook;

	@Column(name = "link_instagram")
	private String linkInstagram;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		if (contato.isEmpty()) {
			this.contato = null;
		} else {
			this.contato = contato;
		}
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(String linkFacebook) {
		if (linkFacebook.isEmpty()) {
			this.linkFacebook = null;
		} else {
			this.linkFacebook = linkFacebook;
		}
	}

	public String getLinkInstagram() {
		return linkInstagram;
	}

	public void setLinkInstagram(String linkInstagram) {
		if (linkInstagram.isEmpty()) {
			this.linkInstagram = null;
		} else {
			this.linkInstagram = linkInstagram;
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
