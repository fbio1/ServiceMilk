package com.pa2.milk.api.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.br.CPF;

import com.pa2.milk.api.model.AbstractModel;
import com.pa2.milk.api.model.enums.TipoPerfilUsuario;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario extends AbstractModel<Integer> {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
//	@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "id_seq_usuario", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;

	@CPF
	@Column(unique = true, length = 16)
	private String cpf;

	@Column(length = 11)
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private TipoPerfilUsuario tipoPerfilUsuario;

	@OneToOne(mappedBy = "usuario")
	@Cascade({ CascadeType.ALL })
	private Credencial credencial;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPerfilUsuario getTipoPerfilUsuario() {
		return tipoPerfilUsuario;
	}

	public void setTipoPerfilUsuario(TipoPerfilUsuario tipoPerfilUsuario) {
		this.tipoPerfilUsuario = tipoPerfilUsuario;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
