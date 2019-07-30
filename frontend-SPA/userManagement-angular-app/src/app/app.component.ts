import { Component, OnInit, ViewEncapsulation} from '@angular/core';
import { User } from './model/user';
import { UserService } from './service/user-service';

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
