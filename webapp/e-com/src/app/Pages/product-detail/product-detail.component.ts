import { Component, OnInit } from '@angular/core';
import {
	ActivatedRoute,
	Router,
	RouterState,
} from '@angular/router';
import { Iproduct } from '../../interfaces/iproduct';
import { HttpProductService } from '../../services/http-product.service';
import { Iuser } from '../../interfaces/iuser';
import { HttpUserService } from '../../services/http-user.service';
import { LoginSignUpService } from '../../services/login-signUp.service';
import { AuthService } from '../../services/auth.service';

@Component({
	selector: 'app-product-detail',
	templateUrl: './product-detail.component.html',
	styleUrls: ['./product-detail.component.scss'],
})
export class ProductDetailComponent implements OnInit {
	public product: Iproduct;
	public displayImage: string;
	public user: Iuser;

	constructor(
		private activatedRoute: ActivatedRoute,
		private router: Router,
		private httpProductService: HttpProductService,
		private httpUserService: HttpUserService,
		private loginSignUpService: LoginSignUpService,
		private authService: AuthService
	) {
		const routerState =
			this.router.getCurrentNavigation()?.extras.state;
		this.product = routerState?.product;
		this.displayImage = this.product?.image[0];
		this.user = routerState?.user;
	}

	ngOnInit(): void {
		if (!this.product) {
			const id = this.activatedRoute.snapshot.params['id'];
			console.log(id);
			this.httpProductService
				.httpGetProductById(id)
				.subscribe(data => {
					this.product = data;
					this.displayImage = this.product.image[0];
				});
		}
	}

	public changeDisplayImage(event: any, index: number) {
		this.displayImage = this.product.image[index];
	}

	public addToCart(accountId: number, productId: number) {
		if (this.user) {
			this.httpUserService
				.HttpAddToCart(accountId, productId)
				.subscribe(data => {
					this.user = data as Iuser;
					this.authService.user = data as Iuser;
				});
		} else this.loginSignUpService.goToLoginPage();
	}

	public addToWishlist(userId: number, productId: number) {
		if (this.user) {
			this.httpUserService
				.httpAddToWishlist(userId, productId)
				.subscribe(data => {
					this.user = data as Iuser;
					this.authService.user = data as Iuser;
				});
		} else this.loginSignUpService.goToLoginPage();
	}
}
