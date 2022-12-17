import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsPageRoutingModule } from './products-page-routing.module';
import { ProductDetailComponent } from '../product-detail/product-detail.component';

@NgModule({
	declarations: [ProductDetailComponent],
	imports: [CommonModule, ProductsPageRoutingModule],
})
export class ProductsPageModule {}
