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

@Entity(name="obrafav")
public class Obrafav implements Serializable {

    /** Primary key. */
    protected static final String PK = "codObraFav";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int codObraFav;
    @Column
    private String emailUsu;
    @Column
    private int codObra;
	public int getCodObraFav() {
		return codObraFav;
	}
	public void setCodObraFav(int codObraFav) {
		this.codObraFav = codObraFav;
	}
	public String getEmailUsu() {
		return emailUsu;
	}
	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}
	public int getCodObra() {
		return codObra;
	}
	public void setCodObra(int codObra) {
		this.codObra = codObra;
	}
	@Override
	public String toString() {
		return "Obrasfav [codObraFav=" + codObraFav + ", emailUsu=" + emailUsu + 
				 ", codObra=" + codObra + "]";
	}


}
