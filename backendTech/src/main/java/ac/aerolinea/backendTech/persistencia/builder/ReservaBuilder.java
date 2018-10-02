package ac.aerolinea.backendTech.persistencia.builder;

import ac.aerolinea.backendTech.dominio.Cliente;
import ac.aerolinea.backendTech.dominio.Reserva;
import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.persistencia.entidad.ReservaEntity;

public class ReservaBuilder {

	private ReservaBuilder() {
		super();
	}

	public static ReservaEntity convertirAEntity(Reserva reserva) {
		ReservaEntity reservaEntity = new ReservaEntity();
		reservaEntity.setCodigoVuelo(reserva.getVuelo().getCodigoVuelo());
		reservaEntity.setIdCliente(reserva.getCliente().getDocumentoIdentidad());
		return reservaEntity;
	}

	public static Reserva convertirAReserva(ReservaEntity reservaEntity) {
		Reserva reserva = new Reserva();
		Cliente cliente = new Cliente();
		cliente.setDocumentoIdentidad(reservaEntity.getIdCliente());
		Vuelo vuelo = new Vuelo();
		vuelo.setCodigoVuelo(reservaEntity.getCodigoVuelo());
		reserva.setCliente(cliente);
		reserva.setVuelo(vuelo);
		return reserva;
	}

}
