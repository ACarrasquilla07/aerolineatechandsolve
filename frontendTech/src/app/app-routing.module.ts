import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { IngresoVuelosComponent } from './ingreso-vuelos/ingreso-vuelos.component';
import { ConsultaVuelosComponent } from './consulta-vuelos/consulta-vuelos.component';
import { MisReservasComponent } from './mis-reservas/mis-reservas.component';
import { FormsModule } from '@angular/forms';

const routes: Routes =[
  { path: 'ingreso-vuelos', component:  IngresoVuelosComponent },
  { path: 'consulta-vuelos', component: ConsultaVuelosComponent },
  { path: 'mis-reservas', component: MisReservasComponent }
]

@NgModule({
  imports: [
    FormsModule, CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})

export class AppRoutingModule { }
