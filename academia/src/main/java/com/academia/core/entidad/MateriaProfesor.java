/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academia.core.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "materia_profesor")
public class MateriaProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_profesor")
    private Integer idMateriaProfesor;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materias idMateria;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesores idProfesor;

    public MateriaProfesor() {
    }

    public MateriaProfesor(Integer idMateriaProfesor) {
        this.idMateriaProfesor = idMateriaProfesor;
    }

    public Integer getIdMateriaProfesor() {
        return idMateriaProfesor;
    }

    public void setIdMateriaProfesor(Integer idMateriaProfesor) {
        this.idMateriaProfesor = idMateriaProfesor;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }

    public Profesores getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesores idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaProfesor != null ? idMateriaProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaProfesor)) {
            return false;
        }
        MateriaProfesor other = (MateriaProfesor) object;
        if ((this.idMateriaProfesor == null && other.idMateriaProfesor != null) || (this.idMateriaProfesor != null && !this.idMateriaProfesor.equals(other.idMateriaProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academia.core.entidad.MateriaProfesor[ idMateriaProfesor=" + idMateriaProfesor + " ]";
    }
    
}
