import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfilePageComponent} from './profile-page.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {WishlistComponent} from "./wishlist/wishlist.component";

const routes: Routes = [
   {
      path: '',
      component: ProfilePageComponent,
      children: [
        {
          path: 'wishlist',
          component: WishlistComponent,
        },
         {
            path: 'user-profile',
            component: UserProfileComponent,
         },

      ],
   },
];

@NgModule({
   imports: [RouterModule.forChild(routes)],
   exports: [RouterModule],
})
export class ProfilePageRoutingModule {}
