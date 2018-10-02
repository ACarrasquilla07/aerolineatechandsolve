import { Component, OnInit } from '@angular/core';
import { IngresoVuelosService } from '../ingreso-vuelos/ingreso-vuelos.service';
import { Vuelo } from '../model/Vuelo';
import { Reserva } from '../model/Reserva';

@Component({
  selector: 'app-consulta-vuelos',
  templateUrl: './consulta-vuelos.component.html',
  styleUrls: ['./consulta-vuelos.component.css']
})
export class ConsultaVuelosComponent implements OnInit {
  vuelos: Vuelo[] = [];
  listaCalificaciones: number[] = [0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  constructor(private ingresoVuelosService: IngresoVuelosService) { }

  ngOnInit() {
    this.ingresoVuelosService.consultarVuelos().subscribe(
      res=> {
        this.vuelos = res;
      });
  }

  reservarVuelo(indice: number){
    var reserva: Reserva = new Reserva();
    reserva.codigoVuelo = this.vuelos[indice].codigoVuelo;
    reserva.idCliente = "1038414958";
    
    this.ingresoVuelosService.crearReserva(reserva);
    alert("vuelo "+this.vuelos[indice].codigoVuelo+ " destino: "+ this.vuelos[indice].destino);
  }
  
}
