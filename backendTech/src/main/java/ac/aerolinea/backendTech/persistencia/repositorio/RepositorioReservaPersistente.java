package ac.aerolinea.backendTech.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ac.aerolinea.backendTech.dominio.Reserva;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioReserva;
import ac.aerolinea.backendTech.persistencia.builder.ReservaBuilder;
import ac.aerolinea.backendTech.persistencia.entidad.ReservaEntity;
import ac.aerolinea.backendTech.persistencia.entidad.VueloEntity;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva{
	
	private static final String FIND_BY_ID = "Reserva.findByIdCliente";
	EntityManager entityManager;
	
	public RepositorioReservaPersistente(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Reserva> consultarReservasPorId(String id) {
		List<ReservaEntity> listaEntity = listarReservasPorId(id);
		return cambiarListaEntityAReserva(listaEntity);		
	}

	private List<ReservaEntity> listarReservasPorId(String id) {
		
		Query query  = entityManager.createNamedQuery(FIND_BY_ID);
		List<ReservaEntity> resultado = query.getResultList();
		return !resultado.isEmpty() ? resultado : null;
	}
	
	private List<Reserva> cambiarListaEntityAReserva(List<ReservaEntity> listaEntity) {
		List<Reserva> reservas = new ArrayList<>();
		
		if(listaEntity!=null) {
			for(int i =0;i<listaEntity.size();++i) {
				Reserva reserva = ReservaBuilder.convertirAReserva(listaEntity.get(i));
				reservas.add(reserva);  
			}
		}
		return reservas;
	}

	@Override
	public void crearReserva(Reserva reserva) {
		ReservaEntity reservaEntity = ReservaBuilder.convertirAEntity(reserva);
		entityManager.persist(reservaEntity);
	}
}
