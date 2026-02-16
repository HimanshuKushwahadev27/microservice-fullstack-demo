import { AsyncPipe, CommonModule, JsonPipe } from '@angular/common';
import { Component, OnInit, inject} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OAuthService } from 'angular-oauth2-oidc';
import { OrderService } from '../../services/order/order';
import { ProductService } from '../../services/product/product.service';
import { Router } from '@angular/router';
import { Product } from '../../models/product';
import { Order } from '../../models/order';
import { ChangeDetectorRef } from '@angular/core';

import { HeaderComponent } from '../../shared/header/header';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    CommonModule, 
    AsyncPipe,
    JsonPipe,
    FormsModule
  ],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit{
private cdr = inject(ChangeDetectorRef);

  private readonly oAuthService = inject(OAuthService);
  private readonly productService = inject(ProductService);
  private readonly orderService = inject(OrderService);
  public  readonly router = inject(Router);

  isLoggedIn = false;

  products : Array<Product> = [];
  quantityIsNull = false;
  orderSuccess = false;
  orderFailed = false;

   trackBySku(index: number, product: Product): string {
    return product.skuCode;
  }

  private loadProducts() {
  this.isLoggedIn = true;

  console.log("Calling product API...");

  this.productService.getProducts().subscribe({
    next: products => {
      console.log("Products:", products);
      this.products = products;
      this.cdr.detectChanges();
    },
    error: err => {
      console.error("Product API error:", err);
    }
  });
}


ngOnInit(): void {
  this.isLoggedIn = this.oAuthService.hasValidAccessToken();

  if (this.isLoggedIn) {
    this.loadProducts();
  }
}


orderProduct(product: Product, quantity: string) {

  const claims: any = this.oAuthService.getIdentityClaims();

  

  if (!claims) {
    this.orderFailed = true;
    return;
  }

  const userDetails = {
    email: claims.email,
    firstName: claims.given_name,
    lastName: claims.family_name
  };

  if (!quantity) {
    this.orderFailed = true;
    this.orderSuccess = false;
    this.quantityIsNull = true;
    return;
  }

  const order: Order = { 
    pricePaid: product.price,
    quantity: Number(quantity),
    skuCode: product.skuCode,
  };
  
  this.orderService.orderProduct(order).subscribe({
    next: () => {
      this.orderSuccess = true;
      this.orderFailed = false;
    },
    error: () => {
      this.orderFailed = true;
      this.orderSuccess = false;
    }
  });

 }
}
