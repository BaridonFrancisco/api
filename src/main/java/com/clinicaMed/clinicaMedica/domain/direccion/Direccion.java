package com.clinicaMed.clinicaMedica.domain.direccion;


import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Direccion {

    private String calle;
    private String numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle=datosDireccion.calle();
        this.numero=datosDireccion.numero();
        this.ciudad=datosDireccion.ciudad();
        this.complemento=datosDireccion.complemento();
        this.distrito=datosDireccion.distrito();
    }


    public Direccion actualizarDireccion(DatosDireccion datosDireccion) {
        this.calle=datosDireccion.calle();
        this.numero=datosDireccion.numero();
        this.ciudad=datosDireccion.ciudad();
        this.complemento=datosDireccion.complemento();
        this.distrito=datosDireccion.distrito();
        return this;
    }
}
