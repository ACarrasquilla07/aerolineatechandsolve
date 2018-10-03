import { Component, OnInit } from '@angular/core';
import { IngresoVuelosService } from '../ingreso-vuelos/ingreso-vuelos.service';
import { Vuelo } from '../model/Vuelo';
import { Reserva } from '../model/Reserva';
import { Cliente } from '../model/Cliente';
import swal from 'sweetalert';

@Component({
  selector: 'app-consulta-vuelos',
  templateUrl: './consulta-vuelos.component.html',
  styleUrls: ['./consulta-vuelos.component.css']
})
export class ConsultaVuelosComponent implements OnInit {  
  cliente: Cliente;
  vuelos: Vuelo[] = [];
  edadPermitida: boolean;
  constructor(private ingresoVuelosService: IngresoVuelosService) { }

  ngOnInit() {
    this.cliente = new Cliente();
    this.ingresoVuelosService.consultarVuelos().subscribe(
      res=> {
        this.vuelos = res;
      });
  }

  reservarVuelo(indice: number){        
    if(!this.validarDatos()){
      return;
    }

    this.ingresoVuelosService.validarCliente(this.cliente).subscribe(res=>{
      this.edadPermitida = res;
    });
    if(this.edadPermitida){      
      var reserva: Reserva = new Reserva();
      reserva.codigoVuelo = this.vuelos[indice].codigoVuelo;
      reserva.idCliente = this.cliente.documentoIdentidad;
      
      this.ingresoVuelosService.crearReserva(reserva);
      this.mensajeExito("Reserva exitosa");
    }
    else {
      this.mensajeError("El cliente no tiene la edad permitida");
    }
  }

  validarDatos(){
    if(this.cliente.documentoIdentidad == undefined){
      this.mensajeError("Falta ingresar documento de identidad");
      return false;
    } else if(this.cliente.fechaNacimiento == undefined){
      this.mensajeError("Falta ingresar fecha de nacimiento");
      return false;
    } else {
      return true;
    }
  }
  

  mensajeError(mensaje: string) {
    swal({
      title: 'Error!',
      icon: "error",
      text: mensaje,
    });
  }

  mensajeExito(mensaje: string) {
    swal({
      title: 'Excelente!',
      icon: "success",
      text: mensaje,
    });
  }
  
}
