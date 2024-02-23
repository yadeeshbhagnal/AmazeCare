import { Component } from '@angular/core';
import { JwtClientService} from 'src/app/jwt-client.service';
import { AuthRequest } from 'src/app/Model/AuthRequest';

@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css']
})
export class DoctorLoginComponent {

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

  let response =  this.jwtService.getGeneratedTokenDoctor(authRequest);
     response.subscribe( (genToken)=> {
          this.token = genToken ;
          console.log(genToken);}) 
 }
}
