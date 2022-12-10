import {Component} from '@angular/core';
import {LoginSignUpService} from '../../services/login-signUp.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss'],
})
export class SignupPageComponent {
  public data = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    username: '',
  };
  public confirmPassword: string;
  public isUsernamePresent = false;

  constructor(private loginSignUpService: LoginSignUpService) {
  }

  public submit(data: any): void {
    console.log(this.data);
    this.loginSignUpService.doSignUp(this.data).subscribe(
      data => {
        console.log(data,"done")
      },
      e => {
        console.log(e,'Something went wrong');
      }
    );
  }

  public isUsernameAvailable(): void {
    if (this.data?.username && this.data.username.length > 4) {
      this.loginSignUpService.checkUsername(this.data?.username).subscribe((res) => {
        if (res.status === 200) {
          this.isUsernamePresent = false;
        } else if (res.status === 201) {
          this.isUsernamePresent = true
        }
      }, (err) => {
        console.log(err)
      })
    }
  }
}
