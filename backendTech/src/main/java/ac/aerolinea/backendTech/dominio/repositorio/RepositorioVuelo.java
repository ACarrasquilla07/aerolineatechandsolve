package ac.aerolinea.backendTech.dominio.repositorio;

import java.util.List;

import ac.aerolinea.backendTech.dominio.Vuelo;

public interface RepositorioVuelo {
	public void crearVuelo(Vuelo vuelo);
	public List<Vuelo> consultarVuelos();
	public Vuelo consultarVuelo(String codigoVuelo);	
}
