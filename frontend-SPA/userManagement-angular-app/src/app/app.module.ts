import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injector } from '@angular/core';
import { createCustomElement } from '@angular/elements';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './service/user-service';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [],  entryComponents: [
    AppComponent,
    UserFormComponent,
    UserListComponent]
})
export class AppModule { 

  constructor(private injector: Injector) {}

  ngDoBootstrap(): void {

    const { injector } = this;

        const ngUserRegisterComponent = createCustomElement(AppComponent, {injector});
        customElements.define('user-management-service', ngUserRegisterComponent);

  }
}
