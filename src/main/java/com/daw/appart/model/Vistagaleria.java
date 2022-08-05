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

@Entity
@Table(name="vistagaleria")
@Immutable
public class Vistagaleria implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@Column
	private String id;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codGaleria;
	
	@Column
	private String email;
	
	@Column
	private String nombreGaleria;
	
	@Column
	private String descripcionGaleria;
	
	@Column
	private int codObra;
	
	@Column
	private String titulo;
	
	@Column
	private String fechaObra;
	
	@Column
	private String autor;
	
	@Column
	private String imagen;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodGaleria() {
		return codGaleria;
	}

	public void setCodGaleria(int codGaleria) {
		this.codGaleria = codGaleria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreGaleria() {
		return nombreGaleria;
	}

	public void setNombreGaleria(String nombreGaleria) {
		this.nombreGaleria = nombreGaleria;
	}

	public String getDescripcionGaleria() {
		return descripcionGaleria;
	}

	public void setDescripcionGaleria(String descripcionGaleria) {
		this.descripcionGaleria = descripcionGaleria;
	}

	public int getCodObra() {
		return codObra;
	}

	public void setCodObra(int codObra) {
		this.codObra = codObra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaObra() {
		return fechaObra;
	}

	public void setFechaObra(String fechaObra) {
		this.fechaObra = fechaObra;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public static String getPk() {
		return PK;
	}

	@Override
	public String toString() {
		return "Vistagaleria [codGaleria=" + codGaleria + ", email=" + email + ", nombreGaleria=" + nombreGaleria
				+ ", codObra=" + codObra + ", titulo=" + titulo + "]";
	}

	

}
