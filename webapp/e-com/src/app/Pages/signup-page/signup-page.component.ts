import { Component } from '@angular/core';
import { LoginSignUpService } from '../../services/login-signUp.service';
import {
   AbstractControl,
   AsyncValidatorFn,
   FormBuilder,
   ValidationErrors,
   ValidatorFn,
   Validators,
} from '@angular/forms';
import { map } from 'rxjs';

@Component({
   selector: 'app-signup-page',
   templateUrl: './signup-page.component.html',
   styleUrls: ['./signup-page.component.scss'],
})
export class SignupPageComponent {
   /*public data = {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      username: '',
   };*/
   public form = this.formBuilder.group({
      email: [
         '',
         {
            validators: [Validators.required, Validators.email],
         },
      ],
      lastName: ['', { validators: [Validators.required] }],
      username: [
         '',
         {
            validators: [Validators.required, Validators.minLength(4)],
            asyncValidators: [this.usernameAlreadyTaken()],
            updateOn: 'blur',
         },
      ],
      firstName: ['', { validators: [Validators.required] }],
      password: [
         '',
         {
            validators: [
               Validators.required,
               Validators.minLength(6),
               this.checkPasswordStrength(),
            ],
         },
      ],
      confirmPassword: [
         '',
         {
            validators: [Validators.required, Validators.minLength(6)],
         },
      ],
   });

   constructor(
      private loginSignUpService: LoginSignUpService,
      private formBuilder: FormBuilder
   ) {}

   /*public submit(data: any): void {
      console.log(this.data);
      this.loginSignUpService.doSignUp(this.data).subscribe(
         data => {
            console.log(data, 'done');
         },
         e => {
            console.log(e, 'Something went wrong');
         }
      );
   }*/

   /* public isUsernameAvailable(): void {
      if (this.data?.username && this.data.username.length > 4) {
         this.loginSignUpService.checkUsername(this.data?.username).subscribe(
            res => {
               if (res.status === 200) {
                  this.isUsernamePresent = false;
               } else if (res.status === 201) {
                  this.isUsernamePresent = true;
               }
            },
            err => {
               console.log(err);
            }
         );
      }
   }*/

   public get email() {
      return this.form.controls['email'];
   }

   public get password() {
      return this.form.controls['password'];
   }

   public get firstName() {
      return this.form.controls['firstName'];
   }

   public get lastName() {
      return this.form.controls['lastName'];
   }

   public get username() {
      return this.form.controls['username'];
   }

   public get confirmPassword() {
      return this.form.controls['confirmPassword'];
   }

   private checkPasswordStrength(): ValidatorFn {
      return (control: AbstractControl): ValidationErrors | null => {
         const value = control.value;
         if (!value) {
            return null;
         }
         const hasUpperCase = /[A-Z]+/.test(value);
         const hasLowerCase = /[a-z]+/.test(value);
         const hasNumeric = /\d+/.test(value);
         const passwordValid = hasNumeric && hasLowerCase && hasUpperCase;
         return !passwordValid ? { passwordStrength: true } : null;
      };
   }

   private usernameAlreadyTaken(): AsyncValidatorFn {
      /*return (control: AbstractControl): ValidationError => {
          return  this.loginSignUpService.checkUsername(control.value).subscribe(res => {
            if (res.status === 200) {
              console.log(false)
               return {usernameTaken1: 'available'}
            } else if (res.status === 201) {
              console.log(true)
              return  {usernameTaken1: 'taken'}
            } else {
              console.log("null")
              return null
            }
         },error => {
            console.log("null")
            return null;
          });
      };*/
      return (control: AbstractControl) => {
         return this.loginSignUpService.checkUsername(control.value).pipe(
            map((response: any) => {
               return response.status === 201 ? { usernameTaken: true } : null;
            })
         );
      };
   }
}
