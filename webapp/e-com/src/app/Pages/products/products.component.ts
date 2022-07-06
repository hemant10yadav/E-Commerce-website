import {Component, OnInit} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Iproduct} from "../../interfaces/iproduct";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  products: Array<Iproduct>;

  constructor(private httpService: HttpService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.httpService.httpGetProducts().subscribe(data => {
      this.products = data;
    });
  }

  async openProductDetail(product: Iproduct) {
    await this.router.navigate([product.id + '/product-detail'],
      {relativeTo: this.activatedRoute});
  }
}
