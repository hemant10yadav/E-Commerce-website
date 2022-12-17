import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { HttpProductService } from '../../../services/http-product.service';
import { HttpUserService } from '../../../services/http-user.service';
import { Iuser } from '../../../interfaces/iuser';
import { Iproduct } from '../../../interfaces/iproduct';

@Component({
	selector: 'app-cart',
	templateUrl: './cart.component.html',
	styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {
	public user: Iuser;
	public products = new Array<Iproduct>();
	public totalAmount = 0;

	constructor(
		private authService: AuthService,
		private httpProductService: HttpProductService,
		private httpUserService: HttpUserService
	) {}

	ngOnInit(): void {
		this.user = this.authService.user as Iuser;
		this.getCartProduct();
	}

	async getCartProduct() {
		await this.user.cart.cartProducts.forEach(cartProduct =>
			this.httpProductService
				.httpGetProductById(cartProduct.productId)
				.subscribe(data => {
					this.products.push(data as Iproduct);
					this.calculateTotalPrice();
				})
		);
	}

	async removeFromCart(productId: number, i: number) {
		console.log(productId);
		await this.httpUserService
			.HttpAddToCart(this.user.id, productId, true)
			.subscribe(data => {
				this.user = data as Iuser;
				this.authService.user = data as Iuser;
				this.products.splice(i, 1);
				this.calculateTotalPrice();
			});
	}

	calculateTotalPrice() {
		let sum = 0;
		if (this.products.length === 0) {
			this.totalAmount = 0;
		} else {
			this.products.forEach(product => {
				sum = sum + product.price;
				this.totalAmount = sum;
			});
		}
	}

	async addToWishlist(productId: number, i: number) {
		if (
			this.user.wishlist.wishlistProduct.findIndex(
				obj => obj.productId === productId
			) === -1
		) {
			await this.httpUserService
				.httpAddToWishlist(this.user.id, productId)
				.subscribe(data => {
					this.user = data as Iuser;
					this.authService.user = data as Iuser;
					this.removeFromCart(productId, i);
				});
		} else this.removeFromCart(productId, i);
	}
}
