import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { IngresoVuelosComponent } from './ingreso-vuelos/ingreso-vuelos.component';
import { IngresoVuelosService } from './ingreso-vuelos/ingreso-vuelos.service';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { ConsultaVuelosComponent } from './consulta-vuelos/consulta-vuelos.component';
import { ReservasComponent } from './reservas/reservas.component';
import { MisReservasComponent } from './mis-reservas/mis-reservas.component';

@NgModule({
  declarations: [
    AppComponent,
    IngresoVuelosComponent,
    ConsultaVuelosComponent,
    ReservasComponent,
    MisReservasComponent
  ],    
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [IngresoVuelosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
