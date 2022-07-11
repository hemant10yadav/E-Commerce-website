import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {RouterModule} from "@angular/router";
import { AccountDropdownComponent } from './account-dropdown/account-dropdown.component';



@NgModule({
  declarations: [
    NavBarComponent,
    AccountDropdownComponent,
  ],
  exports: [
    NavBarComponent,
    AccountDropdownComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class SharedComponentModule { }
