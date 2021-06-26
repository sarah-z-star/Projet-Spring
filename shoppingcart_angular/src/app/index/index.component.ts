import { Component, OnInit } from '@angular/core';
import {CartServiceService} from '../service/cart-service.service';
import {HttpServiceService} from '../http-service.service';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  categoryList: any = [];
  sCategoryList: any;
  productsList: any;
  newProductsList: any;
  constructor(private cartService: CartServiceService, private http: HttpServiceService) { }

  ngOnInit() {
    this.http.postRequestWithToken('api/product/getAllCategory', {}).subscribe(data => {
      this.sCategoryList = data;
      let i: number;
      if (this.sCategoryList.length > 1) {
        for (i = 0; i < this.sCategoryList.length; i++ ) {

          // tslint:disable-next-line:triple-equals
          if (data[i].id != 1) {
            this.categoryList.push(data[i]);
          }
          this.getNewProductsByCateogy(data[1]);
          this.getProductsByCategory(data[0]);
        }
      }
    }, error => {
      alert('Server connection error ' + error);
    });

  }



  addCart(cartProductObj) {
    const cartObj = {
      productId: cartProductObj.id,
      qty: '1',
      price: cartProductObj.price
    };
    this.cartService.addCart(cartObj);
  }
  getProductsByCategory(obj) {
    const request = {
      cat_id: obj.id
    };
    this.http.postRequestWithToken('api/product/getProductsByCategory', request).subscribe(data => {
      this.productsList = data;
      // tslint:disable-next-line:triple-equals
      if (this.productsList.length == 0) {
        alert('No Product is found..');
      }
   }, error => {
     alert('Error in login ' + error);
   });
  }

  getNewProductsByCateogy(obj) {
    const request = {
      cat_id: obj.id
    };
    this.http.postRequestWithToken('api/product/getProductsByCategory', request).subscribe(data => {
      this.newProductsList = data;
      // tslint:disable-next-line:triple-equals
      if (this.newProductsList.length == 0) {
        alert('No Product is found..');
      }
    }, error => {
      alert('Error in login ' + error);
    });
  }

}
