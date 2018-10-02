package ac.aerolinea.backendTech.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ac.aerolinea.backendTech.BackendTechApplication;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioReserva;
import ac.aerolinea.backendTech.dominio.repositorio.RepositorioVuelo;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { BackendTechApplication.class })
//@DataJpaTest
public class coreTest {

	//@Autowired
	private Core core;

	@Test
	public void consultarReservasTest() {

	}

	@Test
	public void crearReservaTest() {
		Cliente cliente = new Cliente();
		cliente.setDocumentoIdentidad("1038414958");
		Vuelo vuelo = new Vuelo();
		vuelo.setCodigoVuelo("1");
		Reserva reserva = new Reserva();
		reserva.setCliente(cliente);
		reserva.setVuelo(vuelo);

		Reserva reservaingresada = core.crearReserva("1038414958", "1");

		assertEquals(reservaingresada.getCliente().getDocumentoIdentidad(),
				reserva.getCliente().getDocumentoIdentidad());
	}

	@Test
	public void crearVueloTest() {
		Vuelo vuelo = new Vuelo();
		vuelo.setCodigoVuelo("1");
		vuelo.setAsientosDisponibles(200);
		vuelo.setDestino("Madrid");
		vuelo.setOrigen("Medellin");
		
		Vuelo vueloInt = core.ingresarNuevoVuelo(vuelo);
		
		assertEquals(vuelo.getDestino(), vueloInt.getDestino());
	}
	
	@Test
	public void validarVueloTest(){
		Vuelo vuelo = new Vuelo();		
		vuelo.setAsientosDisponibles(0);
		RepositorioVuelo repositorioVuelo = Mockito.mock(RepositorioVuelo.class);
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioVuelo.consultarVuelo(Mockito.anyString())).thenReturn(vuelo);
		Core core = new Core(repositorioVuelo, repositorioReserva);
		
		assertNull(core.validarVuelo("19928"));		
	}
	
	@Test
	public void validarVueloConDisponibilidadTest(){
		Vuelo vuelo = new Vuelo();		
		vuelo.setCodigoVuelo("19928");
		vuelo.setDestino("Madrid");
		vuelo.setOrigen("Medellin");
		vuelo.setAsientosDisponibles(9);
		
		RepositorioVuelo repositorioVuelo = Mockito.mock(RepositorioVuelo.class);
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioVuelo.consultarVuelo(Mockito.anyString())).thenReturn(vuelo);
		Core core = new Core(repositorioVuelo, repositorioReserva);
		
		assertEquals(core.validarVuelo("19928"), vuelo);		
	}
}
