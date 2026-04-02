# Finanzas Personales – Backend

API REST para una aplicación de finanzas personales.  
Permite registrar ingresos y gastos, agregar notas descriptivas y obtener un resumen financiero automático.

El backend está desarrollado con **Spring Boot** y expone endpoints REST consumidos por un frontend en React.

---

## 🚀 Funcionalidades

- Registrar transacciones de tipo **Ingreso** o **Gasto**
- Agregar una **nota opcional** a cada transacción
- Listar todas las transacciones
- Obtener un **resumen financiero**:
  - Total de ingresos
  - Total de gastos
  - Balance
- Usuario fijo en modo desarrollo (sin autenticación)

---

## 🛠 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Base de datos H2 (en memoria)
- Maven

---

## 🖥 Frontend

El frontend de este proyecto está desarrollado en React.

Repositorio del frontend:
👉 https://github.com/carlitti/finanzas-frontend

---

## ▶️ Ejecución del proyecto

### Requisitos
- Java JDK 17 o superior
- Maven

### Pasos

```bash
mvn spring-boot:run
``
