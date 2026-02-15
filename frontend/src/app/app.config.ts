import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(withInterceptorsFromDi()),
    provideRouter(routes),

    importProvidersFrom(
      OAuthModule.forRoot({
        resourceServer: {
          allowedUrls: ['http://localhost:8084'],
          sendAccessToken: true
        }
      })
    )
  ]
};
