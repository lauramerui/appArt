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

@Entity(name="obra")
public class Obra implements Serializable, Comparable<Obra> {

    /** Primary key. */
    protected static final String PK = "codObra";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int codObra;
    @Column(nullable=false, precision=10)
    private int codCorriente;
    @Column(nullable=false, precision=10)
    private int codArtista;
    @Column(nullable=false, length=100)
    private String titulo;
    @Column(length=50)
    private String fecha;
    @Column(length=100)
    private String tecnica;
    @Column(length=50)
    private String dimension;
    @Column(length=200)
    private String ubicacion;
    @Column(nullable=false, length=10000)
    private String descripcion;
    @Column
    private String imagen;

    /** Default constructor. */
    public Obra() {
        super();
    }

    /**
     * Access method for codObra.
     *
     * @return the current value of codObra
     */
    public int getCodObra() {
        return codObra;
    }

    /**
     * Setter method for codObra.
     *
     * @param aCodObra the new value for codObra
     */
    public void setCodObra(int aCodObra) {
        codObra = aCodObra;
    }

    /**
     * Access method for codEstilo.
     *
     * @return the current value of codEstilo
     */
    public int getCodCorriente() {
        return codCorriente;
    }

    /**
     * Setter method for codEstilo.
     *
     * @param aCodEstilo the new value for codEstilo
     */
    public void setCodCorriente(int aCodEstilo) {
        codCorriente = aCodEstilo;
    }

    /**
     * Access method for codArtista.
     *
     * @return the current value of codArtista
     */
    public int getCodArtista() {
        return codArtista;
    }

    /**
     * Setter method for codArtista.
     *
     * @param aCodArtista the new value for codArtista
     */
    public void setCodArtista(int aCodArtista) {
        codArtista = aCodArtista;
    }

    /**
     * Access method for titulo.
     *
     * @return the current value of titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter method for titulo.
     *
     * @param aTitulo the new value for titulo
     */
    public void setTitulo(String aTitulo) {
        titulo = aTitulo;
    }

    /**
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(String aFecha) {
        fecha = aFecha;
    }

    /**
     * Access method for tecnica.
     *
     * @return the current value of tecnica
     */
    public String getTecnica() {
        return tecnica;
    }

    /**
     * Setter method for tecnica.
     *
     * @param aTecnica the new value for tecnica
     */
    public void setTecnica(String aTecnica) {
        tecnica = aTecnica;
    }

    /**
     * Access method for dimension.
     *
     * @return the current value of dimension
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * Setter method for dimension.
     *
     * @param aDimension the new value for dimension
     */
    public void setDimension(String aDimension) {
        dimension = aDimension;
    }

    /**
     * Access method for ubicacion.
     *
     * @return the current value of ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Setter method for ubicacion.
     *
     * @param aUbicacion the new value for ubicacion
     */
    public void setUbicacion(String aUbicacion) {
        ubicacion = aUbicacion;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for imagen.
     *
     * @return the current value of imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Setter method for imagen.
     *
     * @param aImagen the new value for imagen
     */
    public void setImagen(String aImagen) {
        imagen = aImagen;
    }
    
//    public Artista getArtista(int codArtista) {
//    	ArtistaRepository artRep = null;
//    	return artRep.findByCodArtista(codObra);
//    }

    /**
     * Compares the key for this instance with another Obra.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Obra and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Obra)) {
            return false;
        }
        Obra that = (Obra) other;
        if (this.getCodObra() != that.getCodObra()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Obra.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Obra)) return false;
        return this.equalKeys(other) && ((Obra)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getCodObra();
        result = 37*result + i;
        return result;
    }

    

    @Override
	public String toString() {
		return "Obra [codObra=" + codObra + ", codCorriente=" + codCorriente + ", codArtista=" + codArtista
				+ ", titulo=" + titulo + ", fecha=" + fecha + ", tecnica=" + tecnica + ", dimension=" + dimension
				+ ", ubicacion=" + ubicacion  + ", imagen=" + imagen + "]";
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

	@Override
	public int compareTo(Obra o) {
		// TODO Auto-generated method stub
		return this.getTitulo().compareTo(o.getTitulo());
	}

}
