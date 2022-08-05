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
@Table(name="vistaobra")
@Immutable
public class Vistaobra implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@Column
	private String id;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int codObra;
	@Column(nullable = false, precision = 10)
	private int codCorriente;
	@Column
	private String corrienteObra;
	@Column(nullable = false, precision = 10)
	private int codArtista;
	@Column
	private String autorObra;
	@Column(nullable = false, length = 100)
	private String tituloObra;
	@Column(length = 50)
	private String fechaObra;
	@Column(length = 100)
	private String tecnicaObra;
	@Column(length = 50)
	private String dimensionObra;
	@Column(length = 200)
	private String ubicacionObra;
	@Column(nullable = false, length = 10000)
	private String descripcionObra;
	@Column(nullable = false, length = 100)
	private String imagenObra;

	/** Default constructor. */
	public Vistaobra() {
		super();
	}



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

	public int getCodCorriente() {
		return codCorriente;
	}

	public void setCodCorriente(int codCorriente) {
		this.codCorriente = codCorriente;
	}

	public String getCorrienteObra() {
		return corrienteObra;
	}

	public void setCorrienteObra(String corrienteObra) {
		this.corrienteObra = corrienteObra;
	}

	public int getCodArtista() {
		return codArtista;
	}

	public void setCodArtista(int codArtista) {
		this.codArtista = codArtista;
	}

	public String getAutorObra() {
		return autorObra;
	}

	public void setAutorObra(String autorObra) {
		this.autorObra = autorObra;
	}

	public String getTituloObra() {
		return tituloObra;
	}

	public void setTituloObra(String tituloObra) {
		this.tituloObra = tituloObra;
	}

	public String getFechaObra() {
		return fechaObra;
	}

	public void setFechaObra(String fechaObra) {
		this.fechaObra = fechaObra;
	}

	public String getTecnicaObra() {
		return tecnicaObra;
	}

	public void setTecnicaObra(String tecnicaObra) {
		this.tecnicaObra = tecnicaObra;
	}

	public String getDimensionObra() {
		return dimensionObra;
	}

	public void setDimensionObra(String dimension) {
		this.dimensionObra = dimension;
	}

	public String getUbicacionObra() {
		return ubicacionObra;
	}

	public void setUbicacionObra(String ubicacionObra) {
		this.ubicacionObra = ubicacionObra;
	}

	public String getDescripcionObra() {
		return descripcionObra;
	}

	public void setDescripcionObra(String descripcionObra) {
		this.descripcionObra = descripcionObra;
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
		return "Vistaobra [codObra=" + codObra + ", autorObra=" + autorObra + ", tituloObra=" + tituloObra + "]";
	}
	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("codObra", Integer.valueOf(getCodObra()));
		return ret;
	}

}
