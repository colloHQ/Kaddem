import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Encadrant } from '../model/encadrant';

@Injectable({
  providedIn: 'root'
})
export class EncadrantService {

  uri: string = environment.uri + 'Encadrant'

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(
    private http: HttpClient
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

  // Encadrant CRUD 
  addEncadrant(Encadrant: Encadrant){
    return this.http.post<Encadrant>(this.uri + '/add/', JSON.stringify(Encadrant), this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }

  getAllEncadrants(){
    return this.http.get<Encadrant[]>(this.uri + '/getAll/')
    .pipe(catchError(this.errorHandler))
  }

  getEncadrantById(EncadrantId: number){
    return this.http.get<Encadrant>(this.uri + '/getById/' + EncadrantId)
    .pipe(catchError(this.errorHandler))
  }

  updateEncadrant(
    EncadrantId: number,
    Encadrant: Encadrant){
      return this.http.put<Encadrant>(this.uri + '/update/', JSON.stringify(Encadrant), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  deleteEncadrant(EncadrantId: number){
    return this.http.delete<Encadrant>(this.uri + '/delete/' + EncadrantId, this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

}
