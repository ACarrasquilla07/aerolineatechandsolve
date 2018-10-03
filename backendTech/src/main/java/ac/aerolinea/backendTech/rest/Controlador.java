package ac.aerolinea.backendTech.rest;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ac.aerolinea.backendTech.dominio.Cliente;
import ac.aerolinea.backendTech.dominio.Core;
import ac.aerolinea.backendTech.dominio.Reserva;
import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.rest.dto.ReservaDTO;

@EnableAutoConfiguration
@RestController
@CrossOrigin
@Transactional
@RequestMapping(value = "/aerolinea")
public class Controlador {

	@Autowired
	Core core;

	@RequestMapping(value = "/listavuelos", method = RequestMethod.GET)
	@ResponseBody
	public List<Vuelo> listarVuelos() {
		return core.consultarVuelos();
	}

	@RequestMapping(value = "/crear-vuelo", method = RequestMethod.POST)
	@ResponseBody
	public Vuelo crearLibroServicio(@RequestBody Vuelo vuelo) {
		return core.ingresarNuevoVuelo(vuelo);
	}
	
	@RequestMapping(value = "/crear-reserva", method = RequestMethod.POST)
	@ResponseBody
	public Reserva crearReserva(@RequestBody ReservaDTO reservaDTO) {
		return core.crearReserva(reservaDTO.getIdCliente(), reservaDTO.getCodigoVuelo());
	}
	
	@RequestMapping(value = "/listareservas", method = RequestMethod.GET)
	@ResponseBody
	public List<Reserva> listarReservas(@RequestParam String id) {
		return core.consultarReservas(id);
	}	
				
	@RequestMapping(value = "/vuelos-reservados", method = RequestMethod.GET)
	@ResponseBody
	public List<Vuelo> obtenerVuelosReservadosPorId(@RequestParam String idCliente) {
		return core.obtenerVuelosReservados(idCliente);
	}
	
	@RequestMapping(value = "/validar-cliente", method = RequestMethod.POST)
	@ResponseBody
	public boolean validarCliente(@RequestBody Cliente cliente) throws ParseException {
		return core.validarCliente(cliente);
	}
}


