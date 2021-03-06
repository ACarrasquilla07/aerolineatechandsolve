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
}
