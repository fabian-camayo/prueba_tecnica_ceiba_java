package com.ceiba.biblioteca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author Fabian Camayo
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

    private Long id;
    private TipoUsuario tipoUsuario;
    private String identificacion;
    private String nombre;

    public Usuario() {
    }

    public Usuario(Long id, TipoUsuario tipoUsuario, String identificacion, String nombre) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_usuario", nullable = false)
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Column(name = "identificacion", nullable = false)
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipoUsuario=" + tipoUsuario + ", identificacion=" + identificacion + ", nombre=" + nombre + '}';
    }

}
