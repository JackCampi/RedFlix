/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usr_alias")
    private String usrAlias;
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Column(name = "usr_apellido")
    private String usrApellido;
    @Column(name = "usr_email")
    private String usrEmail;
    @Column(name = "usr_cel")
    private String usrCelular;
    @Column(name = "usr_contr")
    private String usrContrasenna;
    @Column(name = "usr_fnacimiento")
    private LocalDate usrFechana;

    /*@OneToMany(mappedBy = "transmision")
    private List<Transmision> transmision;*/

    public String getUsrAlias() {
        return usrAlias;
    }

    public void setUsrAlias(String usrTitulo) {
        this.usrAlias = usrTitulo;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(String usrCelular) {
        this.usrCelular = usrCelular;
    }

    public String getUsrContrasenna() {
        return usrContrasenna;
    }

    public void setUsrContrasenna(String usrContrasenna) {
        this.usrContrasenna = usrContrasenna;
    }

    public LocalDate getUsrFechana() {
        return usrFechana;
    }

    public void setUsrFechana(LocalDate usrFechana) {
        this.usrFechana = usrFechana;
    }

}
