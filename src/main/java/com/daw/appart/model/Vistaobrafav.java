// Generated with g9.

package com.daw.appart.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name="vistafavs")
@Table(name="vistafavs")
@Immutable
public class Vistaobrafav implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@Column
	private String id;
	

	@Column(unique = true, nullable = false, precision = 10)
	private int codObra;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int codObraFav;
	
	@Column
	String email;
	
	@Column
	private String tituloObra;
	
	@Column
	private String autor;
	
	@Column(length = 50)
	private String fechaObra;
	
	@Column(nullable = false, length = 100)
	private String imagenObra;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodObra() {
		return codObra;
	}

	public void setCodObra(int codObra) {
		this.codObra = codObra;
	}

	public int getCodObraFav() {
		return codObraFav;
	}

	public void setCodObraFav(int codObraFav) {
		this.codObraFav = codObraFav;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTituloObra() {
		return tituloObra;
	}

	public void setTituloObra(String tituloObra) {
		this.tituloObra = tituloObra;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaObra() {
		return fechaObra;
	}

	public void setFechaObra(String fechaObra) {
		this.fechaObra = fechaObra;
	}

	public String getImagenObra() {
		return imagenObra;
	}

	public void setImagenObra(String imagenObra) {
		this.imagenObra = imagenObra;
	}

	public static String getPk() {
		return PK;
	}

	@Override
	public String toString() {
		return "Vistaobrafav [codObraFav=" + codObraFav + ", email=" + email + ", tituloObra=" + tituloObra + "]";
	}
	

	

}
