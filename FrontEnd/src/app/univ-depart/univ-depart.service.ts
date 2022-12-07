import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Departement } from './model/departement';

@Injectable({
  providedIn: 'root'
})
export class UnivDepartService {

  private URI_DEP: string = "http://localhost:8089/Departement"
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(
    private httpClient: HttpClient
  ) { }

  errorHandler(error: any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }

  // Departement CRUD 
  createDepart(depart: Departement){
    return this.httpClient.post<Departement>(this.URI_DEP + '/add/', JSON.stringify(depart), this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }

  getAllDeparts(){
    return this.httpClient.get<Departement[]>(this.URI_DEP + '/getAll/')
    .pipe(
      catchError(this.errorHandler)
    )
  }

  getDepartById(departId: number){
    return this.httpClient.get<Departement>(this.URI_DEP + '/getById/' + departId)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  updateDepart(
    departId: number,
    depart: Departement){
      return this.httpClient.put<Departement>(this.URI_DEP + '/update/', JSON.stringify(depart), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  deleteDepart(departId: number){
    return this.httpClient.delete<Departement>(this.URI_DEP + '/delete/' + departId, this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }


  // Universite CRUD
  getAllUniv(){}
  createUniv(){}
  getUnivById(){}
  updateUniv(){}
  deleteUniv(){}
}
