package ac.aerolinea.backendTech.dominio;

import java.util.List;

import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioReserva;

public class Core {

	private RepositorioVuelo repositorioVuelo;
	private RepositorioReserva repositorioReserva;

	public Core(RepositorioVuelo repoVuelo, RepositorioReserva repoReserva) {
		this.repositorioVuelo = repoVuelo;
		this.repositorioReserva = repoReserva;
	}

	public List<Vuelo> consultarVuelos() {
		List<Vuelo> vuelos = repositorioVuelo.consultarVuelos();
		return vuelos;
	}

	public List<Reserva> consultarReservas(String id) {
		return repositorioReserva.consultarReservasPorId(id);
	}

	public Vuelo ingresarNuevoVuelo(Vuelo vuelo) {
		repositorioVuelo.crearVuelo(vuelo);
		return vuelo;
	}

	public Reserva crearReserva(String idCLiente, String codigoVuelo) {
		//Vuelo vuelo = validarVuelo(codigoVuelo);
		Vuelo vuelo = new Vuelo();
		vuelo.setAsientosDisponibles(100);
		vuelo.setCodigoVuelo(codigoVuelo);
		
		Cliente cliente = new Cliente();
		cliente.setDocumentoIdentidad(idCLiente);

		Reserva reserva = new Reserva();
		reserva.setVuelo(vuelo);
		reserva.setCliente(cliente);

		repositorioReserva.crearReserva(reserva);
		return reserva;
	}

	public Vuelo validarVuelo(String codigoVuelo) {
		Vuelo vuelo = repositorioVuelo.consultarVuelo(codigoVuelo);
		return vuelo.asientosDisponibles == 0 ? null : vuelo;
	}

}
