import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

import { ProfilePageRoutingModule } from './profile-page.routing.module';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {WishlistComponent} from "./wishlist/wishlist.component";
import {CartComponent} from "./cart/cart.component";

@NgModule({
   declarations: [
     UserProfileComponent,
     WishlistComponent,
     CartComponent
   ],

   imports: [CommonModule, ProfilePageRoutingModule],
})
export class ProfilePageModule {}
