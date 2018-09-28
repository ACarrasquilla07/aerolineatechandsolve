package ac.aerolinea.backendTech.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;
import ac.aerolinea.backendTech.persistencia.builder.VueloBuilder;
import ac.aerolinea.backendTech.persistencia.entidad.VueloEntity;
import javax.persistence.Query;

@Repository
public class RepositorioVueloPersistente implements RepositorioVuelo{
	private static final String VUELOS_FIND="Vuelo.findAll";
	
	EntityManager entityManager;
	
	public RepositorioVueloPersistente(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void crearVuelo(Vuelo vuelo) {
		VueloEntity vueloEntity = VueloBuilder.convertirAVueloEntity(vuelo);
		entityManager.persist(vueloEntity);
		return;
	}

	private List<VueloEntity> listarVuelos(){
		Query query  = entityManager.createNamedQuery(VUELOS_FIND);
		List<VueloEntity> resultado = query.getResultList();
		return !resultado.isEmpty() ? resultado : null;
	}
	
	@Override
	public List<Vuelo> consultarVuelos() {
		List<VueloEntity> listaEntity = listarVuelos();
		List<Vuelo> vuelos = new ArrayList<>();
		
		if(listaEntity!=null) {
			for(int i =0;i<listaEntity.size();++i) {
				Vuelo vuelo = VueloBuilder.convertirAVuelo(listaEntity.get(i));
				vuelos.add(vuelo);  
			}
		}		
		return vuelos;
	}
	
	
	
	
}
