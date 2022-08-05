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

import com.daw.appart.repository.ArtistaRepository;

@Entity(name="obragaleria")
public class Obragaleria implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
    private int codGaleria;
    @Column
    private int codObra;
    
	public int getCodGaleria() {
		return codGaleria;
	}
	public void setCodGaleria(int codGaleria) {
		this.codGaleria = codGaleria;
	}
	public int getCodObra() {
		return codObra;
	}
	public void setCodObra(int codObra) {
		this.codObra = codObra;
	}
    
    


}
