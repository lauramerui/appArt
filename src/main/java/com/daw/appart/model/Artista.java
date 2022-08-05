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

import org.springframework.beans.factory.annotation.Autowired;

import com.daw.appart.service.CorrienteService;

@Entity(name="artista")
public class Artista implements Serializable {

    /** Primary key. */
    protected static final String PK = "codArtista";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int codArtista;
    @Column(nullable=false, precision=10)
    private int codCorriente;
    @Column(nullable=false, length=50)
    private String nombre;
    @Column(nullable=false)
    private int fechaNac;
    private int fechaMuerte;
    @Column(nullable=false, length=50)
    private String nacionalidad;
    @Column(nullable=false, length=50)
    private String imagen;
    @Column
    private String descripcion;
    

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/** Default constructor. */
    public Artista() {
        super();
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
     * Access method for fechaNac.
     *
     * @return the current value of fechaNac
     */
    public int getFechaNac() {
        return fechaNac;
    }

    /**
     * Setter method for fechaNac.
     *
     * @param aFechaNac the new value for fechaNac
     */
    public void setFechaNac(int aFechaNac) {
        fechaNac = aFechaNac;
    }

    /**
     * Access method for fechaMuerte.
     *
     * @return the current value of fechaMuerte
     */
    public int getFechaMuerte() {
        return fechaMuerte;
    }

    /**
     * Setter method for fechaMuerte.
     *
     * @param aFechaMuerte the new value for fechaMuerte
     */
    public void setFechaMuerte(int aFechaMuerte) {
        fechaMuerte = aFechaMuerte;
    }

    /**
     * Access method for nacionalidad.
     *
     * @return the current value of nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Setter method for nacionalidad.
     *
     * @param aNacionalidad the new value for nacionalidad
     */
    public void setNacionalidad(String aNacionalidad) {
        nacionalidad = aNacionalidad;
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
     * Compares the key for this instance with another Artista.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Artista and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Artista)) {
            return false;
        }
        Artista that = (Artista) other;
        if (this.getCodArtista() != that.getCodArtista()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Artista.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Artista)) return false;
        return this.equalKeys(other) && ((Artista)other).equalKeys(this);
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
        i = getCodArtista();
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
        StringBuffer sb = new StringBuffer("[Artista |");
        sb.append(" codArtista=").append(getCodArtista());
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
        ret.put("codArtista", Integer.valueOf(getCodArtista()));
        return ret;
    }

}
