import { Component, OnInit } from '@angular/core';
import { Vuelo } from '../model/Vuelo';
import { IngresoVuelosService } from '../ingreso-vuelos/ingreso-vuelos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ingreso-vuelos',
  templateUrl: './ingreso-vuelos.component.html',
  styleUrls: ['./ingreso-vuelos.component.css']
})
export class IngresoVuelosComponent implements OnInit {
  vuelo: Vuelo;
  constructor(private ingresoVuelosService: IngresoVuelosService, private router: Router ) {
   }

  ngOnInit() {
    this.vuelo = new Vuelo();
  }

  crearVuelo(){
    this.vuelo.codigoVuelo = "1";
    this.ingresoVuelosService.crearVuelo(this.vuelo);
  }

}
