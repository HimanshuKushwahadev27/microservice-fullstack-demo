import { Component, signal, inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HeaderComponent } from "./shared/header/header";
import { RouterOutlet } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { authConfig } from './auth.config';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  private readonly oauthService = inject(OAuthService);
  private readonly platformId = inject(PLATFORM_ID);

  protected readonly title = signal('microservice-frontend');

  constructor() {

    if (isPlatformBrowser(this.platformId)) {

      authConfig.redirectUri = window.location.origin;

      this.oauthService.configure(authConfig);
      this.oauthService.loadDiscoveryDocumentAndTryLogin();

    }
  }
}