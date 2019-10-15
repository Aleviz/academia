/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academia.core.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "materias")
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Size(max = 15)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private List<MateriaProfesor> materiaProfesorList;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne(optional = false)
    private Carreras idCarrera;

    public Materias() {
    }

    public Materias(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @XmlTransient
    public List<MateriaProfesor> getMateriaProfesorList() {
        return materiaProfesorList;
    }

    public void setMateriaProfesorList(List<MateriaProfesor> materiaProfesorList) {
        this.materiaProfesorList = materiaProfesorList;
    }

    public Carreras getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carreras idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academia.core.entidad.Materias[ idMateria=" + idMateria + " ]";
    }
    
}
