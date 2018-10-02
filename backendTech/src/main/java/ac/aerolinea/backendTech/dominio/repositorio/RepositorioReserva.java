package ac.aerolinea.backendTech.dominio.repositorio;

import java.util.List;

import ac.aerolinea.backendTech.dominio.Reserva;

public interface RepositorioReserva {
	public List<Reserva> consultarReservasPorId(String id);
	public void crearReserva(Reserva reserva);
}
