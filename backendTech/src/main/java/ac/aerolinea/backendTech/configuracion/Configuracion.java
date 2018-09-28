package ac.aerolinea.backendTech.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ac.aerolinea.backendTech.dominio.Core;

@Configuration 
public class Configuracion {
	
	@Bean
	public Core inicializarCore(){
		return new Core();
	}
}
