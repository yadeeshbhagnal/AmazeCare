import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor(private http:HttpClient) {}

  baseURL:string = 'http://localhost:8080/api/';

  getGeneratedTokenDoctor(requestBody: any){
    return this.http.post(this.baseURL+"doctor/login",requestBody,{responseType: 'text' as 'json'});
  }

  getGeneratedTokenAdmin(requestBody: any){
    return this.http.post(this.baseURL+"admin/login",requestBody,{responseType: 'text' as 'json'});
  }

  getGeneratedTokenPatient(requestBody: any){
    return this.http.post(this.baseURL+"patient/login",requestBody,{responseType: 'text' as 'json'});
  }
}
