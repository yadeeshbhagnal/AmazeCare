import { Component } from '@angular/core';
import { AuthRequest } from 'src/app/Model/AuthRequest';
import { JwtClientService } from 'src/app/jwt-client.service';

@Component({
  selector: 'app-patient-login',
  templateUrl: './patient-login.component.html',
  styleUrls: ['./patient-login.component.css']
})
export class PatientLoginComponent {
  response: any;
  token: any;

  authRequest: AuthRequest = new AuthRequest();

  constructor(private jwtService:JwtClientService){}

  readFormData(formData:any){

    this.authRequest.username = formData.form.value.username;
    this.authRequest.password = formData.form.value.password;

    this.getAccessToken(this.authRequest);

 }

 public getAccessToken(authRequest:any){

  let response =  this.jwtService.getGeneratedTokenPatient(authRequest);
     response.subscribe( (genToken)=> {
          this.token = genToken ;
          console.log(genToken);}) 
 }
}
