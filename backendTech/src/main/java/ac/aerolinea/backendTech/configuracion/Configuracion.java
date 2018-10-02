package ac.aerolinea.backendTech.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ac.aerolinea.backendTech.dominio.Core;
import ac.aerolinea.backendTech.dominio.Vuelo;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioReserva;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;

@Configuration 
public class Configuracion {
	
	@Bean
	public Core inicializarCore(RepositorioVuelo repoVuelo, RepositorioReserva repoReserva){				
		return new Core(repoVuelo, repoReserva);				
	}
	
	public void InicializarVuelos(Core core){
		Vuelo vuelo = new Vuelo();
		vuelo.setAsientosDisponibles(100);
		vuelo.setCodigoVuelo("1");
		vuelo.setCosto(2950000);
		vuelo.setDestino("Madrid");
		vuelo.setOrigen("Medellin");	
		core.ingresarNuevoVuelo(vuelo);
		
		vuelo.setAsientosDisponibles(50);
		vuelo.setCodigoVuelo("2");
		vuelo.setCosto(77000);
		vuelo.setDestino("Bogota");
		vuelo.setOrigen("Cartagena");		
		core.ingresarNuevoVuelo(vuelo);
	}
}
