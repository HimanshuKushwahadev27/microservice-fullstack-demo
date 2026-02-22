# Fullstack Microservices Demo Project

##  Overview

This project is a **cloud-native fullstack microservices application** built to demonstrate real-world backend architecture patterns including:

* ✅ Spring Boot Microservices
* ✅ Reactive API Gateway
* ✅ Service-to-service communication (OpenFeign)
* ✅ Circuit Breaker (Resilience4j)
* ✅ Event-driven architecture with Kafka
* ✅ Centralized logging & monitoring (Grafana Stack)
* ✅ Authentication & Authorization (Keycloak)
* ✅ Database versioning (Flyway)
* ✅ Email notifications (JavaMail)
* ✅ Angular Frontend
* ✅ Deployed to Kubernetes (K8s)

The system simulates an **e-commerce platform** with product management, inventory tracking, order processing, and notifications.

---

# 🏗 Architecture Overview

```
Angular Frontend
        |
        v
Reactive API Gateway (Spring Cloud Gateway)
        |
        |---> Product Service
        |---> Order Service
        |---> Inventory Service
        |---> Notification Service
        |
        v
Kafka (Event Streaming)
        |
        v
Grafana Stack (Monitoring + Logs)
```

Authentication Flow:

```
User → Angular → Keycloak → JWT → API Gateway → Microservices
```

---

#  Microservices

## Product Service

* Manage product catalog
* CRUD operations
* Uses PostgreSQL
* Flyway for DB migrations

##  Inventory Service

* Tracks product stock
* Validates availability during order creation
* Communicates via OpenFeign

##  Order Service

* Creates orders
* Calls Inventory via OpenFeign
* Uses Circuit Breaker (Resilience4j)
* Publishes Order events to Kafka

##  Notification Service

* Consumes Kafka events
* Sends email via JavaMail
* Handles async processing

##  API Gateway (Reactive)

* Built using Spring Cloud Gateway (WebFlux)
* JWT validation via Keycloak
* Circuit Breaker integration
* Central entry point

---

#  Security (Keycloak)

* OAuth2 + OpenID Connect
* JWT-based authentication
* Role-based authorization
* Gateway validates tokens
* Services protected using Spring Security

---

#  Observability Stack (Grafana Stack)

Includes:

* Prometheus → Metrics scraping
* Grafana → Dashboards & visualization
* Loki → Centralized logging
* Micrometer → Metrics instrumentation

Monitored metrics:

* HTTP latency
* JVM metrics
* Circuit breaker states
* Kafka consumer lag
* Service health

---

#  Tech Stack

### Backend

* Java 17+
* Spring Boot
* Spring Cloud Gateway (Reactive)
* OpenFeign
* Resilience4j Circuit Breaker
* Kafka
* PostgreSQL
* Flyway
* JavaMail

### Frontend

* Angular
* JWT authentication
* API integration

### DevOps

* Docker
* Kubernetes (k3s / GKE)
* Grafana Stack
* Keycloak

---

#  Database Management

Each service has its own database.

* PostgreSQL per service
* Flyway manages schema migrations
* Versioned SQL scripts

---

# 📡 Communication Patterns

| Type        | Technology       |
| ----------- | ---------------- |
| Sync        | OpenFeign        |
| Async       | Kafka            |
| API Routing | Reactive Gateway |
| Resilience  | Circuit Breaker  |

---

#  Circuit Breaker

Implemented using Resilience4j:

* Prevents cascading failures
* Fallback responses
* Configurable timeout
* Retry policies

Example use case:

* If Inventory service is slow → Order service fallback triggers.

---

#  Event-Driven Flow

1. Order Created
2. Event published to Kafka
3. Notification service consumes event
4. Email sent via JavaMail

---

#  Kubernetes Deployment

All services are containerized using Docker and deployed to Kubernetes.

## Resources Used:

* Deployments
* Services (ClusterIP / NodePort)
* ConfigMaps
* Secrets
* Ingress (optional)
* Persistent Volumes

## Deployment Steps

```bash
docker build -t <dockerhub>/service-name .
docker push <dockerhub>/service-name

kubectl apply -f k8s/
kubectl get pods
```

---

#  Running Locally (Docker Compose)

```bash
docker-compose up -d
```

Services:

* Kafka
* Zookeeper
* PostgreSQL
* Keycloak
* Grafana Stack
* All microservices

---

#  API Endpoints (Sample)

## Product

```
POST /api/product
GET  /api/product
```

## Order

```
POST /api/order
```

---

#  Monitoring Access

* Grafana → http://<host>:3000
* Prometheus → http://<host>:9090
* Keycloak → http://<host>:8080
* API Gateway → http://<host>:8080

---

#  Key Learning Outcomes

This project demonstrates:

* Real-world microservices architecture
* Secure authentication flow
* Reactive programming
* Distributed tracing & monitoring
* Kubernetes deployment strategy
* Fault tolerance using circuit breakers
* Event-driven systems with Kafka

---

#  Future Improvements

* Add distributed tracing (Zipkin / Tempo)
* Add CI/CD pipeline (GitHub Actions)
* Implement Blue-Green deployment
* Add Redis caching
* Add rate limiting in gateway

---

#  Author

Built as a fullstack cloud-native demo project to showcase backend engineering, DevOps fundamentals, and production-grade architecture.



For educational and demonstration purposes.
