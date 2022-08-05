// Generated with g9.

package com.daw.appart.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="puntuacion")
public class Puntuacion implements Serializable {
	/** Primary key. */
    protected static final String PK = "email";

    @Id
    @Column
    private String email;
    @Column
    private int puntos;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
    
    

}
