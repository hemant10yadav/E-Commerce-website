import {IcartProduct} from "./icart-product";

export interface Icart {
  id: number;
  cartProducts: IcartProduct[];
}
