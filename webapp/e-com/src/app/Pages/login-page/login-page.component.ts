import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpUserService } from '../../services/http-user.service';
import { LoginSignUpService } from '../../services/login-signUp.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-login-page',
	templateUrl: './login-page.component.html',
	styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {
	public token = '';
	data = {
		username: '',
		password: '',
	};
	url = 'http://localhost:8080/e-com/api/login';
	public wrongCredentials = false;
	public loginDisable = true;
	public message: String;

	constructor(
		private httpClient: HttpClient,
		private httpService: HttpUserService,
		private loginSignUpService: LoginSignUpService,
		private router: Router
	) {}

	ngOnInit(): void {}

	async login() {
		await this.loginSignUpService.doLogin(this.data);
		await this.router.navigate(['/home'], {
			replaceUrl: true,
		});
	}

	checkValue() {
		if (
			this.data.username === '' ||
			this.data.password == ''
		) {
			this.loginDisable = true;
		} else {
			this.loginDisable = false;
		}
	}
}
