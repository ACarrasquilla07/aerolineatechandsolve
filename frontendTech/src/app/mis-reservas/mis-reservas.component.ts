import { Component, OnInit } from '@angular/core';
import { Vuelo } from '../model/Vuelo';
import { IngresoVuelosService } from '../ingreso-vuelos/ingreso-vuelos.service';

@Component({
  selector: 'app-mis-reservas',
  templateUrl: './mis-reservas.component.html',
  styleUrls: ['./mis-reservas.component.css']
})
export class MisReservasComponent implements OnInit {
  identificacion: String;
  vuelos: Vuelo[] = [];

  constructor(private ingresoVuelosService: IngresoVuelosService) { }

  ngOnInit() {
  }

  consultarVuelos(){
    alert(this.identificacion);
    this.ingresoVuelosService.obtenerVuelosReservados(this.identificacion).subscribe(
      res=> {
        this.vuelos = res;
      });
  }

}
