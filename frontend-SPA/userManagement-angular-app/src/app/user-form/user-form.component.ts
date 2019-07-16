import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user-service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent{

  user : User;

  constructor(private route : ActivatedRoute, private router : Router, private userService : UserService) { 
    this.user = new User();
  }

  onSubmit(){
    //this.userService.save(this.user).subscribe(result => this.goToUsersList());
    this.userService.save(this.user).subscribe(result => this.refresh());
  }

  goToUsersList(){
    this.router.navigate(['/users']);
  }

  refresh() : void{
    window.location.reload();
  }

}
