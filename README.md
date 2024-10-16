# MiniUrl

This is the parent repository of the MiniUrl application, containing its microservices and their Helm charts. MiniUrl is a scalable URL shortening service built using Spring Boot and Cassandra, deployed on AWS EKS with HTTPS support and traffic management handled by Traefik.

## Services
- **traefik-service**: Manages traffic routing and load balancing across microservices.
- **shortening-service**: Handles URL compression and token generation.
- **redirecting-service**: Redirects shortened URLs to their original destination.
- **token-service**: Issues and validates tokens for secure URL shortening.
- **ui-service**: Frontend interface for managing shortened URLs.

## Technologies Used
- **Backend**: Spring Boot, Java
- **Database**: Cassandra (Amazon Keyspaces)
- **Cloud**: AWS (EKS, ELB, Route 53, Certificate Manager)
- **Traffic Management**: Traefik
- **Orchestration**: Helm, Kubernetes

## References
- [URL Shortener System Design by Tech Dummies](https://youtu.be/JQDHz72OA3c?si=hI53oZgatmm-ucja)
- [Tiny URL System Design by Code Karle](https://youtu.be/AVztRY77xxA?si=gLal0r4cArJcFfoi)