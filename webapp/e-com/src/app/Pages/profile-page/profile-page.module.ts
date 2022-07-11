import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfilePageRoutingModule } from './profile-page.routing.module';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
   declarations: [
     UserProfileComponent
   ],

   imports: [CommonModule, ProfilePageRoutingModule],
})
export class ProfilePageModule {}
