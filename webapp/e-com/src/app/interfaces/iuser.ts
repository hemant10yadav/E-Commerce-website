import { Iwishlist } from './iwishlist';
import {Icart} from "./icart";

export interface Iuser {
   id: number;
   firstName: string;
   lastName: string;
   username: string;
   email: string;
   date: Date;
   cart: Icart;
   wishlist: Iwishlist;
}
