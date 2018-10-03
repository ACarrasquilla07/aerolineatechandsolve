package ac.aerolinea.backendTech.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculadoraDeEdad {

	public static EdadPersona calcularEdad(Calendar fechaActual, Calendar fechaNacimiento) {
		int dias = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);
		int meses = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
		int anios = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		if (dias < 0) {
			dias += 30;
			meses--;
		}
		if (meses < 0) {
			meses += 12;
			anios--;
		}
		return new EdadPersona(dias, meses, anios);
	}
	
	public static Calendar convertirDeStringACalendar(String fecha) throws ParseException {	
		
		Calendar cal = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			cal.setTime(sdf.parse(fecha));
		}	
		catch(Exception e){
			System.out.println("Error imprimiendo fecha: "+e.getMessage());
		}
		return cal;
	}
}
