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

@Entity(name="corriente")
public class Corriente implements Serializable {

    /** Primary key. */
    protected static final String PK = "codCorriente";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int codCorriente;
    @Column(nullable=false, length=40)
    private String nombre;
    @Column(nullable=false, length=50)
    private String epoca;
    @Column(nullable=false, length=1000)
    private String descripcion;
    @Column(nullable=false, length=50)
    private String imagen;

    /** Default constructor. */
    public Corriente() {
    }

    /**
     * Access method for codCorriente.
     *
     * @return the current value of codCorriente
     */
    public int getCodCorriente() {
        return codCorriente;
    }

    /**
     * Setter method for codCorriente.
     *
     * @param aCodCorriente the new value for codCorriente
     */
    public void setCodCorriente(int aCodCorriente) {
        codCorriente = aCodCorriente;
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
     * Access method for epoca.
     *
     * @return the current value of epoca
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * Setter method for epoca.
     *
     * @param aEpoca the new value for epoca
     */
    public void setEpoca(String aEpoca) {
        epoca = aEpoca;
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
    


    /**
     * Compares the key for this instance with another Corriente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Corriente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Corriente)) {
            return false;
        }
        Corriente that = (Corriente) other;
        if (this.getCodCorriente() != that.getCodCorriente()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Corriente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Corriente)) return false;
        return this.equalKeys(other) && ((Corriente)other).equalKeys(this);
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
        i = getCodCorriente();
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
        StringBuffer sb = new StringBuffer("[Corriente |");
        sb.append(" codCorriente=").append(getCodCorriente());
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
        ret.put("codCorriente", Integer.valueOf(getCodCorriente()));
        return ret;
    }

}
