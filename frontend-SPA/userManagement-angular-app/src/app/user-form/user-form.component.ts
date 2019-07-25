import { Component, Output, Input, EventEmitter, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user-service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent{

  user : User;
  @Output() saveUserEvent = new EventEmitter<User>();

  constructor(private userService : UserService) { 
    this.user = new User();
  }

  onSubmit(){
    this.saveUserEvent.emit(this.user);
  }

}
