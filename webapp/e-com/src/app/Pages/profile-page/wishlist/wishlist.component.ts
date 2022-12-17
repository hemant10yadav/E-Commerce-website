import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Iuser } from '../../../interfaces/iuser';
import { HttpProductService } from '../../../services/http-product.service';
import { Iproduct } from '../../../interfaces/iproduct';
import { HttpUserService } from '../../../services/http-user.service';

@Component({
	selector: 'app-wishlist',
	templateUrl: './wishlist.component.html',
	styleUrls: ['./wishlist.component.scss'],
})
export class WishlistComponent implements OnInit {
	public user: Iuser;
	products = Array<Iproduct>();

	constructor(
		private authService: AuthService,
		private httpProductService: HttpProductService,
		private httpUserService: HttpUserService
	) {}

	ngOnInit(): void {
		this.user = this.authService.user as Iuser;
		this.getWishlistProduct();
	}

	async getWishlistProduct() {
		await this.user.wishlist.wishlistProduct.forEach(
			wishListProduct =>
				this.httpProductService
					.httpGetProductById(wishListProduct.productId)
					.subscribe(data => {
						this.products.push(data as Iproduct);
					})
		);
	}

	addToCart(productId: number) {
		this.httpUserService
			.HttpAddToCart(this.user.id, productId)
			.subscribe(data => {
				this.user = data as Iuser;
				this.authService.user = data as Iuser;
			});
	}

	removeFromWishlist(product: Iproduct, i: number) {
		this.httpUserService
			.httpAddToWishlist(this.user.id, product.id)
			.subscribe(data => {
				this.user = data as Iuser;
				this.authService.user = data as Iuser;
				this.products.splice(i, 1);
			});
	}
}
