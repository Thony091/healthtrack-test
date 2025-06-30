# Proyecto de Automatización de Pruebas: HealthTrack

Este repositorio es una demostración de una estrategia completa de aseguramiento de la calidad (QA) y DevOps para una aplicación ficticia de monitoreo de salud llamada **HealthTrack**. El proyecto parte de un error crítico en el código base y propone una solución integral mediante la implementación de pruebas automatizadas y un pipeline de CI/CD.

## 🎯 Contexto del Problema

La aplicación `HealthTrack` tenía un error lógico en su funcionalidad principal: en lugar de registrar el nuevo peso de un usuario, le restaba 1 kg en cada actualización. Este problema surgió debido a la ausencia total de procesos de validación automatizados.

Este proyecto implementa las soluciones para corregir el error y, más importante aún, para construir una red de seguridad que prevenga errores futuros.

## 🛠️ Implementaciones Realizadas

El proyecto está estructurado para demostrar competencia en tres áreas clave del ciclo de vida del desarrollo de software:

### 1. Análisis y Diseño de Estrategias de Prueba

Se realizó un análisis del estado inicial de la plataforma, identificando no solo el bug, sino también las causas raíz del problema:
- **Falta de Pruebas Unitarias:** Para validar la lógica de negocio en su nivel más básico.
- **Falta de Pruebas Funcionales:** Para verificar los flujos de usuario de extremo a extremo.
- **Falta de un Proceso de CI/CD:** Para automatizar la validación del código antes del despliegue.

En base a este análisis, se diseñó una estrategia de pruebas multicapa para garantizar la robustez y fiabilidad de la aplicación.

### 2. Implementación de Pruebas Automatizadas

Se han implementado dos niveles de pruebas automatizadas utilizando un stack de herramientas moderno basado en Java.

#### ✅ Pruebas Unitarias (JUnit 5)

- **Ubicación:** `src/test/java/com/healthtrack/UsuarioTest.java`
- **Tecnología:** **JUnit 5**
- **Propósito:** Validar que la clase `Usuario` y sus métodos funcionan correctamente de manera aislada. Se prueba tanto la creación de un usuario como la lógica (ya corregida) de actualización de peso.

#### ✅ Pruebas Funcionales de API (REST Assured)

- **Ubicación:** `src/test/java/com/healthtrack/APIFunctionalTest.java`
- **Tecnología:** **REST Assured**, **JUnit 5** y un backend simulado con **Spark Java**.
- **Propósito:** Al no contar con una interfaz de usuario, se simula el flujo funcional a nivel de API. Estas pruebas verifican los endpoints, asegurando que la lógica de negocio se comporta como se espera de extremo a extremo. Incluyen un patrón de "reseteo de estado" para garantizar que las pruebas sean independientes entre sí.

### 3. Automatización con CI/CD y Análisis de Código

La automatización es el pilar de las prácticas DevOps modernas. Este proyecto implementa un pipeline de Integración Continua (CI) robusto utilizando GitHub Actions.

#### 🚀 Pipeline de CI/CD con GitHub Actions

- **Ubicación:** `.github/workflows/ci-cd.yml`
- **Propósito:** Automatizar el proceso de validación del código con cada `push` y `pull request` a la rama `main`.
- **Flujo de Trabajo:**
  1.  **Build & Test:** El pipeline primero compila todo el código.
  2.  **Ejecución de Pruebas:** A continuación, ejecuta automáticamente tanto las **pruebas unitarias** como las **pruebas funcionales de API**. Si alguna prueba falla, el pipeline se detiene y notifica el error.
  3.  **Análisis de Seguridad:** Si las pruebas pasan, se inicia un análisis de seguridad.

#### 🛡️ Análisis de Seguridad con GitHub CodeQL

- **Tecnología:** **GitHub CodeQL**
- **Propósito:** Se ha integrado CodeQL directamente en el pipeline de GitHub Actions como una herramienta de Análisis Estático de Seguridad de Aplicaciones (SAST).
- **Funcionamiento:** CodeQL analiza el código en busca de vulnerabilidades de seguridad y bugs complejos. Los resultados se reportan automáticamente en la pestaña **Security > Code scanning alerts** del repositorio, permitiendo una gestión proactiva de la seguridad del código.

## 💻 Cómo Ejecutar el Proyecto Localmente

1.  **Requisitos Previos:**
    - JDK 11 o superior.
    - Apache Maven.

2.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/Thony091/healthtrack-test.git
    cd https://github.com/Thony091/healthtrack-test.git
    ```

3.  **Ejecutar Todas las Pruebas:**
    Para compilar el proyecto y ejecutar tanto las pruebas unitarias como las funcionales, utiliza el siguiente comando de Maven desde la raíz del proyecto:
    ```bash
    mvn clean install
    ```
    Busca el mensaje `BUILD SUCCESS` para confirmar que todo funcionó correctamente.
