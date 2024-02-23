import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Amazecare';
  selectedUserType: string = '';

  loginAs(userType: string) {
    this.selectedUserType = userType;
  }
}
