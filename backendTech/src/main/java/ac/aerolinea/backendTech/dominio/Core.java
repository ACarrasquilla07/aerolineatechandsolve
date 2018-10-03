package ac.aerolinea.backendTech.dominio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;
import ac.aerolinea.backendTech.util.CalculadoraDeEdad;
import ac.aerolinea.backendTech.util.EdadPersona;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioReserva;

public class Core {

	private static final int ANIOS_PERMITIDOS = 18;
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
	
	public boolean validarCliente(Cliente cliente) throws ParseException{
		Calendar fechaNacimientoConvertida = CalculadoraDeEdad.convertirDeStringACalendar(cliente.getFechaNacimiento());
		EdadPersona edadCliente = CalculadoraDeEdad.calcularEdad(Calendar.getInstance(), fechaNacimientoConvertida);		
		return edadCliente.getAnios() >= ANIOS_PERMITIDOS;
	}

	public Reserva crearReserva(String idCLiente, String codigoVuelo) {
		Vuelo vuelo = validarVuelo(codigoVuelo);		
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

	public List<Vuelo> obtenerVuelosReservados(String idCliente) {
		List<Reserva> reservas = repositorioReserva.consultarReservasPorId(idCliente);
		List<Vuelo> vuelos = new ArrayList<>();
		for (Reserva reserva : reservas) {
			vuelos.add( repositorioVuelo.consultarVuelo(reserva.getVuelo().getCodigoVuelo()) );
		}
		return vuelos;
	}

}
