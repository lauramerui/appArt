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
import javax.persistence.Version;

@Entity(name="galeria")
public class Galeria implements Serializable {

    /** Primary key. */
    protected static final String PK = "codGaleria";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int codGaleria;
    @Column(nullable=false, length=70)
    private String emailUsu;
    @Column(nullable=false, length=50)
    private String nombre;
    @Column(nullable=false, length=50)
    private String descripcion;
    public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column
    private String imagen;

    /** Default constructor. */
    public Galeria() {
        super();
    }

    /**
     * Access method for codGaleria.
     *
     * @return the current value of codGaleria
     */
    public int getCodGaleria() {
        return codGaleria;
    }

    /**
     * Setter method for codGaleria.
     *
     * @param aCodGaleria the new value for codGaleria
     */
    public void setCodGaleria(int aCodGaleria) {
        codGaleria = aCodGaleria;
    }

    /**
     * Access method for emailUsu.
     *
     * @return the current value of emailUsu
     */
    public String getEmailUsu() {
        return emailUsu;
    }

    /**
     * Setter method for emailUsu.
     *
     * @param aEmailUsu the new value for emailUsu
     */
    public void setEmailUsu(String aEmailUsu) {
        emailUsu = aEmailUsu;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
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
     * Compares the key for this instance with another Galeria.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Galeria and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Galeria)) {
            return false;
        }
        Galeria that = (Galeria) other;
        if (this.getCodGaleria() != that.getCodGaleria()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Galeria.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Galeria)) return false;
        return this.equalKeys(other) && ((Galeria)other).equalKeys(this);
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
        i = getCodGaleria();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Galeria |");
        sb.append(" codGaleria=").append(getCodGaleria());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("codGaleria", Integer.valueOf(getCodGaleria()));
        return ret;
    }

}
