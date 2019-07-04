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
    UserListComponent,
    UserFormComponent  ]
})
export class AppModule { 

  constructor(private injector: Injector) {}

  ngDoBootstrap(): void {

    const { injector } = this;

        // create custom elements from angular components
        const ngCustomUserListComponent = createCustomElement(UserListComponent, {injector});
        const ngUserFormComponent = createCustomElement(UserFormComponent, {injector});


        // define in browser registry
        customElements.define('ng-el-list', ngCustomUserListComponent);
        customElements.define('ng-el-form', ngUserFormComponent);

  }
}
