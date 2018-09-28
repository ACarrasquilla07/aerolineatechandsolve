import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { IngresoVuelosComponent } from './ingreso-vuelos/ingreso-vuelos.component';

const routes: Routes =[
  { path: 'ingreso-vuelos', component:  IngresoVuelosComponent}
]

@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
