import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user-service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent{

  @Input() users: User[];
  @Output() deleteUserEvent = new EventEmitter<User>();

  constructor(private userService : UserService) {

   }

  deleteUser(user: User): void {
    this.deleteUserEvent.emit(user);
  };

}
