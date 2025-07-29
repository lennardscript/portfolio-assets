# Sistema de Gestión de Portafolios de Inversión con Spring Boot

Este proyecto es un sistema backend desarrollado en Java con Spring Boot, diseñado para modelar, gestionar y analizar la evolución de portafolios de inversión basados en activos y precios históricos.

## Propósito del Proyecto

El objetivo principal de esta aplicación es:
* **Modelar Portafolios:** Representar activos, precios, cantidades, pesos y el valor total de un portafolio a lo largo del tiempo.
* **Carga de Datos ETL:** Implementar un proceso ETL (Extract, Transform, Load) para importar datos históricos de activos y precios desde un archivo Excel (`datos.xlsx`).
* **Cálculo de Evolución:** Calcular y entregar la evolución temporal de los pesos ($w_{i,t}$) de cada activo y el valor total del portafolio ($V_t$) a través de endpoints RESTful.
* **Gestión de Operaciones (Bonus):** Procesar operaciones de compra/venta de activos y recalcular el historial del portafolio.

# Levantar el proyecto

Desde la raíz del proyecto en tu terminal:

1.  **Compilar y Descargar Dependencias:**
    La primera vez que levantes el proyecto o si has añadido nuevas dependencias al `pom.xml`, ejecuta:
    ```bash
    ./mvnw clean install
    ```
    Este comando compilará el código, ejecutará las pruebas y descargará todas las dependencias necesarias.

2.  **Ejecutar la Aplicación Spring Boot:**
    Una vez compilado, puedes levantar la aplicación con:
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación se iniciará en el puerto 8080 por defecto. Verás mensajes en la consola indicando que el servidor Tomcat ha arrancado.
