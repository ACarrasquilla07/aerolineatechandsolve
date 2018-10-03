import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { map, catchError } from 'rxjs/operators';
//import { Observable } from 'rxjs/';
import { Vuelo } from '../model/Vuelo';
import { Reserva } from '../model/Reserva';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cliente } from '../model/Cliente';
const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
    providedIn: 'root'
})
export class IngresoVuelosService {
    private url = "http://localhost:8182/aerolinea";
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private options = new RequestOptions({ headers: this.headers });

    constructor(private _http: Http, private http: HttpClient) { }

    crearVuelo(vuelo: Vuelo) {
        return this.http.post(this.url + "/crear-vuelo", vuelo, httpOptions).subscribe(result => {
            console.log(result);
        }, error => console.log('There was an error en crearVuelo: '));
    }

    consultarVuelos() {
        return this._http.get(this.url + '/listavuelos', this.options).
            pipe(map((response: Response) => response.json()),
                catchError(error => {
                    return ("Error!!")
                }));
    }

    crearReserva(reserva: Reserva) {
        return this.http.post(this.url + "/crear-reserva", reserva, httpOptions).subscribe(result => {
            console.log(result);
        }, error => console.log('There was an error: '));
    }

    obtenerVuelosReservados(idCliente: String) {
        return this._http.get(this.url + '/vuelos-reservados?idCliente=' + idCliente, this.options).
            pipe(map((response: Response) => response.json()),
                catchError(error => {
                    return ("Error!!!")
                }));
    }

    validarCliente(cliente: Cliente){
        return this.http.post(this.url + "/validar-cliente", cliente, httpOptions).pipe(map((response: Response) => response.json()),
        catchError(error => {
            return ("Error!!!")
        }));
    }

}
