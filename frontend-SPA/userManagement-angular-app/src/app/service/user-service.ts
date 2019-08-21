import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http';

/*
User-Service-Klasse, baut die Verbindung zu dem Backend auf.
Definiert zusätzlich Methoden, um Benutzer abzufragen, zu speichern und zu löschen.
*/
@Injectable()
export class UserService {

  private usersUrl:string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8083/users';
  }

  public findAll(): Observable<User[]>{
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user : User){
    return this.http.post<User>(this.usersUrl, user);
  }

  public deleteUser(user : User){
    return this.http.delete(this.usersUrl+"/"+user.id);
  }
}
