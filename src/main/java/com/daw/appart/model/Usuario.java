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

@Entity(name="usuario")
public class Usuario implements Serializable {
	/** Primary key. */
    protected static final String PK = "email";

    @Id
    @Column(unique=true, nullable=false, length=70)
    private String email;
    @Column(nullable=false, length=40)
    private String nombre;
    @Column(nullable=false, length=40)
    private String apellidos;
    @Column(nullable=false, length=30)
    private String password;
    @Column(nullable=true, length=70)
    private String foto;
    @Column(nullable=false, length=1)
    private boolean admin;
    @Column(nullable=true)
    private LocalDate fechaCreacion;

    /** Default constructor. */
    public Usuario() {
        super();
    }
    
    public Usuario(String email, String nombre, String apellidos, String password, String foto, boolean admin) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.foto = foto;
		this.admin = admin;
		this.fechaCreacion = LocalDate.now();
	}

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
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
     * Access method for apellidos.
     *
     * @return the current value of apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter method for apellidos.
     *
     * @param aApellidos the new value for apellidos
     */
    public void setApellidos(String aApellidos) {
        apellidos = aApellidos;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for foto.
     *
     * @return the current value of foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Setter method for foto.
     *
     * @param aFoto the new value for foto
     */
    public void setFoto(String aFoto) {
        foto = aFoto;
    }

    /**
     * Access method for admin.
     *
     * @return true if and only if admin is currently true
     */
    public boolean getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(boolean aAdmin) {
        admin = aAdmin;
    }

    /**
     * Access method for fechaCreacion.
     *
     * @return the current value of fechaCreacion
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Setter method for fechaCreacion.
     *
     * @param aFechaCreacion the new value for fechaCreacion
     */
    public void setFechaCreacion(LocalDate aFechaCreacion) {
        fechaCreacion = aFechaCreacion;
    }

    /**
     * Compares the key for this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Usuario and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Usuario)) {
            return false;
        }
        Usuario that = (Usuario) other;
        Object myEmail = this.getEmail();
        Object yourEmail = that.getEmail();
        if (myEmail==null ? yourEmail!=null : !myEmail.equals(yourEmail)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Usuario)) return false;
        return this.equalKeys(other) && ((Usuario)other).equalKeys(this);
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
        if (getEmail() == null) {
            i = 0;
        } else {
            i = getEmail().hashCode();
        }
        result = 37*result + i;
        return result;
    }

    

    @Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + ", password=" + password
				+ ", foto=" + foto + ", admin=" + admin + ", fechaCreacion=" + fechaCreacion + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("email", getEmail());
        return ret;
    }

}
