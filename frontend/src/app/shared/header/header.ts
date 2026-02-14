import { Component, inject, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class HeaderComponent  {

  private oauthService = inject(OAuthService);

  login() {
    this.oauthService.initCodeFlow();
  }

  register() {
     this.oauthService.initCodeFlow(undefined, {
    kc_action: 'register'
  });
  }

  logout() {
    this.oauthService.logOut();
  }

  isLoggedIn(): boolean {
    return this.oauthService.hasValidAccessToken();
  }

  getUserName(): string | null {
    const claims: any = this.oauthService.getIdentityClaims();
    return claims?.preferred_username ?? null;
  }
}