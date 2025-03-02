# Prueba Técnica

Este proyecto es una API desarrollada con Spring Boot y Java 21 para la gestión de facturas e invitados.

# Tecnologías Utilizadas

Java: OpenJDK 21.0.6 (Temurin LTS)

Spring Boot

Maven/Gradle (según configuración del proyecto)

PostgreSQL (si se usa base de datos)

# Instalación y Configuración

1. Clonar el repositorio

 git clone https://github.com/Heinz-Delgado/BackEndPruebaTecnica.git
 
 cd Prueba-Tecnica

2. Configurar el entorno

Asegúrate de tener Java 21 instalado y configurado en tu sistema.

 java --version
 javac --version

3. Restaurar la base de datos que se encuentra en el archivo viaticos_db.sql
4. Ejecutar la aplicación
Abrir Spring Boot Dashboard y ejecutar Run en la sección de Apps

La aplicación se ejecutará en http://localhost:8080.

# Endpoints

Facturas

POST → http://localhost:8080/api/facturas (Crear una nueva factura)

GET → http://localhost:8080/api/facturas/todas (Obtener todas las facturas)

Invitados

GET → http://localhost:8080/api/facturas/{id}/invitados (Obtener los invitados de una factura específica)
