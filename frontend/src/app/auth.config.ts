import { AuthConfig } from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:8181/realms/microservices-demo',
  redirectUri: '',
  clientId: 'microservice-frontend',
  responseType: 'code',
  scope: 'openid profile email offline_access',
  showDebugInformation: true,
  strictDiscoveryDocumentValidation: false,
  requireHttps: false,
  useSilentRefresh: true
};