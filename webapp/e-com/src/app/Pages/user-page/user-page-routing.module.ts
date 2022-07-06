import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserPageComponent} from "./user-page.component";
import {UserProfileComponent} from "../../components/user-profile/user-profile.component";
import {MainAuthGuard} from "../../services/main-auth-guard/main-auth-guard";

const routes: Routes = [
  {
    path: '',
    component: UserPageComponent,
    children:[{
      path: 'user-profile',
      component: UserProfileComponent
    },
      {
        path: '',
        component: UserProfileComponent
      }]
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserPageRoutingModule {
}
