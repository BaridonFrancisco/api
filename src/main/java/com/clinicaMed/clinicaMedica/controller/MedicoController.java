package com.clinicaMed.clinicaMedica.controller;

import com.clinicaMed.clinicaMedica.model.DatosMedicos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico(@RequestBody DatosMedicos datosMedicos){
        System.out.println("Request llego existosamente");
        System.out.println(datosMedicos);
    }
    /*
    //Post data
{
	"nombre":"Francisco",
	"email":"emailrandom@gmail.com",
	"documento":"123213",
	"especialidad":"ORTOPEDIA",
	"direccion":{
			"calle":"1271",
			"distrito":"La Plata",
			"ciudad":"Buenos Aires",
			"complemento":"no"
	}

}*/
}