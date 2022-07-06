import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductsComponent} from "./products.component";

const routes: Routes = [
  {
    path: '',
    component: ProductsComponent
  },
  {
    path: ':id/product-detail',
    loadChildren: () => import('../product-detail/product-detail.module').then(m => m.ProductDetailModule),
  }
]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductsRoutingModule {
}
