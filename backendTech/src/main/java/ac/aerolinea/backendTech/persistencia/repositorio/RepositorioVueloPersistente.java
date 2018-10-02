package ac.aerolinea.backendTech.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;
import ac.aerolinea.backendTech.persistencia.builder.VueloBuilder;
import ac.aerolinea.backendTech.persistencia.entidad.VueloEntity;

@Repository
public class RepositorioVueloPersistente implements RepositorioVuelo{
	private static final String VUELOS_FIND="Vuelo.findAll";
	private static final String VUELOS_FIND_ID ="Vuelo.findById";
	
	EntityManager entityManager;
	
	public RepositorioVueloPersistente(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void crearVuelo(Vuelo vuelo) {
		VueloEntity vueloEntity = VueloBuilder.convertirAVueloEntity(vuelo);
		entityManager.persist(vueloEntity);		
	}

	private List<VueloEntity> listarVuelos(){
		Query query  = entityManager.createNamedQuery(VUELOS_FIND);
		List<VueloEntity> resultado = query.getResultList();
		return !resultado.isEmpty() ? resultado : null;
	}
	
	@Override
	public List<Vuelo> consultarVuelos() {
		List<VueloEntity> listaEntity = listarVuelos();
		return cambiarListaEntityAVuelos(listaEntity);				
	}

	private List<Vuelo> cambiarListaEntityAVuelos(List<VueloEntity> listaEntity) {
		List<Vuelo> vuelos = new ArrayList<>();
		
		if(listaEntity!=null) {
			for(int i =0;i<listaEntity.size();++i) {
				Vuelo vuelo = VueloBuilder.convertirAVuelo(listaEntity.get(i));
				vuelos.add(vuelo);  
			}
		}
		return vuelos;
	}

	@Override
	public Vuelo consultarVuelo(String codigoVuelo) {
		Query query = entityManager.createNamedQuery(VUELOS_FIND_ID);
		query.setParameter("id", Long.parseLong(codigoVuelo));
		VueloEntity vueloEntity = (VueloEntity) query.getSingleResult();		
		return vueloEntity != null ? VueloBuilder.convertirAVuelo(vueloEntity): null;
	}
}
