package com.iescierva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.NaturalId;

import java.util.Set;

@Entity
@Table(name = "pilotos")
public class Piloto extends Persona{

    @Column(name = "licencia")
    private String licencia;

    @ManyToMany(mappedBy = "pilotos")
    private Set<Tipo> tipos;

    public Piloto() {
    }

    public Piloto(String nss, String nombre, String direccion, String licencia) {
        super(nss, nombre, direccion);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "licencia='" + licencia + '\'' +
                '}';
    }
}
