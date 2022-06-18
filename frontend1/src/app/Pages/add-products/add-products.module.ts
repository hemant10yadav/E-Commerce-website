import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "../../app-routing.module";
import {HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AddProductsModule { }
