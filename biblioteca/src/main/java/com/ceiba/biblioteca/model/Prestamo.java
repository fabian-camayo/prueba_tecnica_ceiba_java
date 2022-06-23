package com.ceiba.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Fabian Camayo
 */
@Entity
@Table(name = "prestamos")
public class Prestamo implements Serializable {

    private Long id;
    private Libro libro;
    private Usuario usuario;
    private Date FechaPrestamo;

    public Prestamo() {
    }

    public Prestamo(Long id, Libro libro, Usuario usuario, Date FechaPrestamo) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.FechaPrestamo = FechaPrestamo;
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
    @JoinColumn(name = "libro", nullable = false)
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name = "fecha_prestamo", nullable = false, length = 100)
    public Date getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(Date FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", libro=" + libro + ", usuario=" + usuario + ", FechaPrestamo=" + FechaPrestamo + '}';
    }

}
