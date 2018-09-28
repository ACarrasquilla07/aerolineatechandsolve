package ac.aerolinea.backendTech.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ac.aerolinea.backendTech.dominio.Core;
import ac.aerolinea.backendTech.dominio.Vuelo;

@EnableAutoConfiguration
@RestController
@CrossOrigin
@Transactional
@RequestMapping(value="/aerolinea")
public class Controlador {
	
	@Autowired
	Core core;

	@RequestMapping(value = "/listavuelos", method = RequestMethod.GET)
	@ResponseBody
	public List<Vuelo> listarVuelos() {
		return core.consultarVuelos();
	}	
	
	@RequestMapping(value = "/crearVuelo", method = RequestMethod.POST)
	@ResponseBody
	public Vuelo crearLibroServicio(@RequestBody Vuelo vuelo) {
		return core.ingresarNuevoVuelo(vuelo);
}
}
