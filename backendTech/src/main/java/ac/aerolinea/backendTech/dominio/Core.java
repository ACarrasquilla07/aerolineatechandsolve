package ac.aerolinea.backendTech.dominio;

import java.util.ArrayList;
import java.util.List;

public class Core {
		
	public List<Vuelo> consultarVuelos() {
		Vuelo vuelo = new Vuelo();
		vuelo.setOrigen("Medellin");
		vuelo.setDestino("Madrid");		
		List<Vuelo> vuelos = new ArrayList<>();
		vuelos.add(vuelo);
		return vuelos;
	}
	
	public List<Reserva> consultarReservas(){
		
		return null;
	}

	public Vuelo ingresarNuevoVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		return null;
	}
}
