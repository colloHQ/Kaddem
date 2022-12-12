import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Departement } from './model/departement';
import { Universite } from './model/universite';

@Injectable({
  providedIn: 'root'
})
export class UnivDepartService {

  private URI_DEP: string = environment.uri + "Departement"
  private URI_UNI: string = environment.uri + "Universite"

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(
    private httpClient: HttpClient
  ){}

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
    .pipe(catchError(this.errorHandler))
  }

  getDepartById(departId: number){
    return this.httpClient.get<Departement>(this.URI_DEP + '/getById/' + departId)
    .pipe(catchError(this.errorHandler))
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
  createUniv(univ: Universite){
    return this.httpClient.post<Universite>(this.URI_UNI + '/add/', JSON.stringify(univ), this.httpOptions)
    .pipe(catchError(this.errorHandler))
  }

  getAllUniv(){
    return this.httpClient.get<Universite[]>(this.URI_UNI + '/getAll/')
    .pipe(catchError(this.errorHandler))
  }
  
  getUnivById(univId: number){
    return this.httpClient.get<Universite>(this.URI_UNI + '/getById/' + univId)
    .pipe(catchError(this.errorHandler))
  }

  updateUniv(
    univId: number,
    univ: Universite){
      return this.httpClient.put<Universite>(this.URI_UNI + '/update/', JSON.stringify(univ), this.httpOptions)
    .pipe(catchError(this.errorHandler))
    }

  deleteUniv(univId: number){
    return this.httpClient.delete<Universite>(this.URI_UNI + '/delete/' + univId, this.httpOptions)
  .pipe(catchError(this.errorHandler))
  }
}
