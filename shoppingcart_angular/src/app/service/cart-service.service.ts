import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import {HttpServiceService} from '../http-service.service';
import { error } from 'protractor';


@Injectable({
  providedIn: 'root'
})
export class CartServiceService {
  public cartServiceEvent = new BehaviorSubject({});
  cartQty = 0;
  cartObj = [];
 public cartTotalPrice: any;

  constructor(private http: HttpServiceService) {
   this.getCartDetailsByUser();
   }

   getCartDetailsByUser() {
     this.http.postRequestWithToken('api/addtocart/getCartsByUserId', {}).subscribe((data: any) => {
         this.cartObj = data;
         this.cartQty = data.length;
         this.cartTotalPrice = this.getTotalAmounOfTheCart();
         this.cartServiceEvent.next({status: 'completed'}); // emitter
         // tslint:disable-next-line:no-shadowed-variable
     }, error => {
       alert('Error while fetching the cart Details');
     });
   }


  addCart(obj) {
    // this.cartServiceEvent.next({"status":"completed"})//emitter
    const request  = {
      productId: obj.productId,
      qty: obj.qty,
      price: obj.price
    };
    this.http.postRequestWithToken('api/addtocart/addProduct', request).subscribe((data: any) => {
      this.getCartDetailsByUser();
    },
        // tslint:disable-next-line:no-shadowed-variable
    error => {
      // if the products is already in cart
        alert('Error in AddCart API ' + error.message);
    });
  }
  getCartOBj() {
    return this.cartObj;
  }
  getTotalAmounOfTheCart() {
    const obj = this.cartObj;
    let totalPrice  = 0;

    for (const o in obj ) {
      totalPrice = totalPrice + parseFloat(obj[o].price);
    }

    return totalPrice.toFixed(2);
  }
  getQty() {
    return this.cartQty;
  }


  removeCart(cartId) {
      const request = {
          productId: 'dummy_val',
          cartId,
      };
      this.http.postRequestWithToken('api/addtocart/removeProductFromCart', request).subscribe((data: any) => {
          this.getCartDetailsByUser();
          // tslint:disable-next-line:no-shadowed-variable
      }, error => {
        alert('Error while fetching the cart Details');
      });
  }
}
