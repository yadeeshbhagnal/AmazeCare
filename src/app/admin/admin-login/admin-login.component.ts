import { Component } from '@angular/core';
import { AuthRequest } from 'src/app/Model/AuthRequest';
import { JwtClientService } from 'src/app/jwt-client.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

  
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

  let response =  this.jwtService.getGeneratedTokenAdmin(authRequest);
     response.subscribe( (genToken)=> {
          this.token = genToken ;
          console.log(genToken);}) 
 }

}
