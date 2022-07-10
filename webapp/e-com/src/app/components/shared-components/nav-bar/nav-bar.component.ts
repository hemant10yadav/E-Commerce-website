import {Component, Input, OnInit} from '@angular/core';
import {HttpUserService} from "../../../services/http-user.service";
import {Router} from "@angular/router";
import {UrlService} from "../../../services/url.service";
import {AuthService} from "../../../services/auth.service";
import {Iuser} from "../../../interfaces/iuser";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  @Input()
  hideSearchBar = false;
  user: Iuser | null;
  isLoggedIn = false;

  constructor(private httpUserService: HttpUserService,
              public authService: AuthService,
              private router: Router,
              private urlService: UrlService) {
  }

  ngOnInit(): void {
   /* this.user = this.authService.user;*/
    /*this.authService.httpGetLoggedUser().then(data => {
      this.user = data as Iuser
      this.isLoggedIn = true;
    }, error => {
      this.isLoggedIn = false;
    })*/
  }


  async logout() {
    this.user = null;
    this.isLoggedIn = false;
    await this.authService.logout();
  }

  signIn() {
    this.router.navigateByUrl("/login")

  }

  signUp() {
    this.router.navigateByUrl("/signUp")
  }
}
