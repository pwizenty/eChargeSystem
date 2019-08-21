import { Component, OnInit, ViewEncapsulation} from '@angular/core';
import { User } from './model/user';
import { UserService } from './service/user-service';
/*
App-Komponente dient als Wrapper für die User-List und User-Form-Komponente.
Definiert Methoden wie ngOnit, damit in der init-Phase die Benutzer geladen werden und desweiteren
Methoden um Benutzer zu löschen und zu speichern.
*/
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title : string;
  users : User[];
  
  constructor(private userService : UserService) {
    this.title = 'UserManagement';
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  onUserDelete(user: User) {
    this.userService.deleteUser(user).subscribe(data => {
      this.users = this.users.filter (u=>u !== user);
    })
  }

  onUserSave(user: User) {
    this.userService.save(user).subscribe(data => {
      this.users.push (data);
    });
  }

}
