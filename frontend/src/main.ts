import { bootstrapApplication } from '@angular/platform-browser';
import { App } from './app/app';
import { appConfig } from './app/app.config';
import { OAuthService } from 'angular-oauth2-oidc';
import { authConfig } from './app/auth.config';

bootstrapApplication(App, appConfig)
  .then(appRef => {
    const oauthService = appRef.injector.get(OAuthService);

    oauthService.configure(authConfig);

    oauthService.loadDiscoveryDocumentAndTryLogin().then(() => {
      if (!oauthService.hasValidAccessToken()) {
        oauthService.initLoginFlow();
      }
    });
  })
  .catch(err => console.error(err));
