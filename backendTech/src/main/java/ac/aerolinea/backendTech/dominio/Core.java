package ac.aerolinea.backendTech.dominio;

import java.util.ArrayList;
import java.util.List;

import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;

public class Core {
	
	private RepositorioVuelo repositorioVuelo;
	
	public Core(RepositorioVuelo repoVuelo){
		this.repositorioVuelo = repoVuelo;
	}
		
	public List<Vuelo> consultarVuelos() {		
		List<Vuelo> vuelos = repositorioVuelo.consultarVuelos();
		return vuelos;
	}
	
	public List<Reserva> consultarReservas(){
		
		return null;
	}

	public Vuelo ingresarNuevoVuelo(Vuelo vuelo) {
		repositorioVuelo.crearVuelo(vuelo);
		return vuelo;
	}
}
