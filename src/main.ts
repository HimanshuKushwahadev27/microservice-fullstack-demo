import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { authConfig } from './app/auth.config';
import { OAuthService } from 'angular-oauth2-oidc';


bootstrapApplication(App, appConfig)
  .then(appRef => {
    const oauthService = appRef.injector.get(OAuthService);

    oauthService.configure(authConfig);
    oauthService.loadDiscoveryDocumentAndTryLogin();
    oauthService.setupAutomaticSilentRefresh();

  })
  .catch((err) => console.error(err));
