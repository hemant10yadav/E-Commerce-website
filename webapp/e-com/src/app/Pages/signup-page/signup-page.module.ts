import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupPageRoutingModule } from './signup-page-routing.module';

@NgModule({
   declarations: [],
   imports: [
      CommonModule,
      FormsModule,
      HttpClientModule,
      SignupPageRoutingModule,
   ],
})
export class SignupPageModule {}
