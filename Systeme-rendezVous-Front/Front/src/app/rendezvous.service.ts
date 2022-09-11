import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rendezvous } from './models/rendezvous';

@Injectable({
  providedIn: 'root'
})
export class RendezvousService {

  private baseUrl="http://localhost:8081/api/v1/rendezvous";
  constructor(private httpClient: HttpClient) { }

  getRendezVousList(): Observable<Rendezvous[]>{
    return this.httpClient.get<Rendezvous[]>(`${this.baseUrl}`);
  }

  createRendezvous(rendezvous:Rendezvous): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, rendezvous);

  }

  getRdvById(idRdv:number):Observable<Rendezvous>{
    return this.httpClient.get<Rendezvous>(`${this.baseUrl}/${idRdv}`);
  }

  updateRendezvous(id: number, rdv:Rendezvous): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,rdv);
  }

  deleteRendezvous(idRdv: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${idRdv}`);
  }

}

