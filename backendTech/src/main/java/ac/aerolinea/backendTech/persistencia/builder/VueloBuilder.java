package ac.aerolinea.backendTech.persistencia.builder;

import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.persistencia.entidad.VueloEntity;

public class VueloBuilder {
	
	private VueloBuilder(){
		super();
	}
	
	public static VueloEntity convertirAVueloEntity(Vuelo vuelo){
		VueloEntity vueloEntity = new VueloEntity();
		vueloEntity.setOrigen(vuelo.getOrigen());
		vueloEntity.setDestino(vuelo.getDestino());
		vueloEntity.setAsientosDisponibles(vuelo.getAsientosDisponibles());
		vueloEntity.setCosto(vuelo.getCosto());
		return vueloEntity;
	}
	
	public static Vuelo convertirAVuelo(VueloEntity vueloEntity){
		Vuelo vuelo = new Vuelo();
		vuelo.setCodigoVuelo(vueloEntity.getId().toString());
		vuelo.setDestino(vueloEntity.getDestino());
		vuelo.setOrigen(vueloEntity.getOrigen());
		vuelo.setAsientosDisponibles(vueloEntity.getAsientosDisponibles());
		vuelo.setCosto(vueloEntity.getCosto());
		return vuelo;		
	}
}
