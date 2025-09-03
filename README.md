# 🧪 Laboratorio 3 - Pruebas de Software – Agilismo y Scrum – Análisis de Requerimientos

**Integrantes:**
- Oscar Andres Sanchez Porras.
- Juan Pablo Caballero Castellanos.
- Robinson Steven Nuñez Portela.

**Nombre De la Rama:**
`feature/lab3_CaballeroJuan_SanchezOscar_NuñezRobinson_2025-2`
---
## Pruebas de ejecución (Lab 3 parte 1), parte 1.

![alt text](docs/imagenes/pruebaEjecucion.png) 

---
## Parte 2.

![alt text](docs/imagenes/pruebaEjecucion1.png)

---
## ✅ Retos Completados
## Reto 1 ✅
### Descripción :
• Identifiquen reglas de negocio:

- El número de cuenta tiene que tener exactamente 10 dígitos.
- La cuenta es válida si los dos primeros dígitos corrresponden a un banco registrado, por ejemplo 01 BANCOLOMBIA, 02 DAVIVIENDA
- La cuenta no debe tener caracteres especiales ni letras.
- Las cuentas deben ser únicas en el sistema.
- Al momento de la creación de la cuenta el monto disponible se inicializa en cero.
- Los depositos deben ser positivos.
- Al  hacer un deposito a una cuenta no puede depositar si la cuenta no existe.

• Definan las funcionalidades principales:

- Crear una cuenta.
-  Permite validar que el número de la cuenta creada cumpla con las reglas del negocio.
- Permite verificar el saldo de una cuenta.
- Permite realizar depositos a cuentas existentes.
- Rechazar depositos que se hagan a cuentas inexistentes.

• Actores Principales:

Banco registrado: Son los usuarios que pueden crear cuentas, consultar salgo y Realizar depositos.

Clientes: Provee numeros de cuentas, Garantiza la cuenta este asegurada a un seguro de perdidas.


• Documenten las precondiciones necesarias para el sistema:

- El Sistema debe tener un conjunto de reglas y código limpio implementado SOLID.

- Se deben implementar pequeñas pruebas unitarias usando moks y stubs para asegurar que el código interno para el banco esté funcionando correctamente.

- Diseñamos el código y casos de uso UML para el usuario en su cuenta bancaria.

- Refactorizamos el código y volvemos a realizar las pruebas usando Junit.

- Se debe realizar una prueba E2E para comprobar el sistema en su conjunto y que se pueda validar escenarios e historias para el usuario y brindarle una buena app para que confié en los sistemas bancario.

## ✅ Retos Completados
## Reto 2 ✅
### Descripción :
- Diagrama de contexto: Se conoce que actores interactuan y sus conexiones en el sistema de software.

![alt text](docs/uml/DiagramaDeContexto.drawio.png)


- Diagrama de Casos de Uso: Muestra quién usa el sistema y para qué lo puede usar. 
   - Los clientes pueden validar, crear, consultar y realizar transacciones.
   - El banco provee cuentas y valida las transacciones de las cuentas.
  
![alt text](docs/uml/DiagramaDeCasos.png)

- Historia de Usuario:
  - Como Cliente, quiero Consultar el saldo de mi cuenta, para saber cuánto dinero tengo disponible.
  - Como Cliente, quiero Crear una cuenta, para poder acceder a los servicios financieros.
  - Como Cliente, quiero realizar depósitos, para aumentar el saldo disponible.
  - Como cliente, quiero validar/verificar mi número de cuenta antes de crearla, para asegurar que tiene el formato correcto y pertenece a un banco registrado.
  - Como banco, quiero proveer los códigos de cuenta válidos, para aumentar el saldo disponible.
  - Como banco, quiero Validar las transacciones realizadas en las cuentas, para garantizar que sean seguras y autorizadas.
- Atributos de calidad:

![alt text](docs/uml/tablaExcel.png)

  - Disponibilidad asegura acceso. 
  - Rendimiento asegura rapidez. 
  - Seguridad protege la información. 
  - Usabilidad facilita el uso. 
  - Mantenibilidad asegura mejoras y correcciones. 
  - Escalabilidad asegura crecimiento.

- ***Diagrama de Clases:***

![alt text](docs/uml/Digrama_Clases_Reto2.png)


## ✅ Retos Completados
## Reto 3 ✅

Evidencia codigo:

![alt text](docs/imagenes/reto3_1.png)
![alt text](docs/imagenes/reto3_2.png)
![alt text](docs/imagenes/reto3_3.png)
![alt text](docs/imagenes/reto3_4.png)
![alt text](docs/imagenes/reto3_5.png)
![alt text](docs/imagenes/reto3_6.png)

📝 Entrada:

**Caso que diverge:**

![alt text](docs/imagenes/reto3_diverge.png)

**Casos en los que estamos deacuerdo:**

![alt text](docs/imagenes/reto3_entrada.png)

📢 Salida:

![Captura](docs/imagenes/reto3_salida.png)


**Principios SOLID**

***Single Responsibility Principle:***

Hicimos que el codigo para que cada clase se encargara de su respectiva tarea.

- History representa una historia de usuario.

- Member representa a un integrante y su voto.

- VotingService gestiona cómo se realizan los votos.

- PlanningPoker organiza el proceso de votación.

- EstimacionAutomatizada es el punto de entrada (ejecuta todo).


***Open/Closed Principle:***

- Si quieres agregar una nueva forma de votar como el promedio, mayoría simple, votos secretos solo se extiende VotingService.

- No se tiene que modificar las demás clases PlanningPoker, History, etc solo enchufar la nueva estrategia.

***Patrones de Diseño:***

- Strategy :VotingService encapsula cómo se hace la votación. 


- Facade EstimacionAutomatizada actúa como fachada:
El usuario solo llama a ejecutar3(), y por dentro se maneja History, Member, VotingService y PlanningPoker.
El cliente no necesita saber los detalles internos.

***Scrum/Agile:***
PLANNING POKER: Es una técnica ágil de estimación en la que todo el equipo asigna un número para votar por una historia, de manera colaborativa, el esfuerzo de una historia usando cartas con valores (generalmente la secuencia de Fibonacci).
Se revelan todos los votos a la vez si hay diferencias, se diverge hasta llegar a un consenso.

---

## Reto 4 ✅

Evidencia código de las clases modelo (getters y setters):

![alt text](docs/imagenes/reto4_1.jpg)
![alt text](docs/imagenes/reto4_2.jpg)
![alt text](docs/imagenes/reto4_3.jpg)
![alt text](docs/imagenes/reto4_4.jpg)
![alt text](docs/imagenes/reto4_5.jpg)
![alt text](docs/imagenes/reto4_6.jpg)
![alt text](docs/imagenes/reto4_7.jpg)


**Primer Ciclo TDD para AccountValidator:**

🔴 Rojo:

![alt text](docs/imagenes/reto4_rojo1_Cuentas.png)

🟢 Verde:

***Evidencia código de la clase de Validar*** :

![alt text](docs/imagenes/reto4_refactor1_Cuentas.png)

***Pasan las pruebas luego de la implementación:***

![alt text](docs/imagenes/reto4_verde1_Cuentas.jpg)


♻️ Refactor: 

![alt text](docs/imagenes/reto4_refactor0_Cuentas.png)
![alt text](docs/imagenes/reto4_refactor2_Cuentas.png)


---


**Segundo Ciclo TDD para AccountService:**


🔴 Rojo:

![alt text](docs/imagenes/reto4_rojo1_Gestion.jpg)
![alt text](docs/imagenes/reto4_rojo2_Gestion.jpg)
![alt text](docs/imagenes/reto4_rojo3_Gestion.jpg)


🟢 Verde:

***Evidencia de codigo de Clases de Gestión de Cuentas:***

![alt text](docs/imagenes/reto4_9.png)
![alt text](docs/imagenes/reto4_10.png)
![alt text](docs/imagenes/reto4_11.png)
![alt text](docs/imagenes/reto4_12.png)
![alt text](docs/imagenes/reto4_13.png)

***Pasan las pruebas luego de la implementación:***

![alt text](docs/imagenes/reto4_verde1_Gestion.png)


♻️ Refactor:

![alt text](docs/imagenes/reto4_refactor1_Gestion.png)
![alt text](docs/imagenes/reto4_refactor2_Gestion.png)



**Principios SOLID**

***Single Responsibility Principle:***

Hicimos que el codigo para que cada clase se encargara de su respectiva tarea.

- Account la encargada de la informacion de los clientes 

- AccountValidator verifica y valida que la cuenta creada por un usuario sea veridica 

- FeatureManageAccount para la persistencia de memoria de las cuentas 

- AccountService encargada de la gestión de las cuentas 

***Dependency Injection:***
AccountService depende de abstracciones por las clases AccountRepository y AccountValidator en lugar de implementaciones concretas


**Patrones de Diseño:**

- Templated method: En AccountService, los métodos como deposit o findAccount siguen un esqueleto fijo de pasos como validar, buscar una cuenta o modificar el estado


***TDD***

- Rojo 🔴 Primero escribimos pruebas unitarias para las funcionalidades principales 

- Verde 🟢 Luego implementamos la logica para que ls pruebas pasaran 

- Refactor ♻️ Una vez todo funcionaba entonces tratabamos de refactorizar y mejorar el codigo


---
## Historial de commits
e08c238 2025-08-28 | Parte 1 – Robinson Steven Nuñez Portela: Añadir historial de commits al README general | Robinson677  
908fef2 2025-08-28 | Parte 1 – Robinson Steven Nuñez Portela: Preguntas resueltas LAB03 | Robinson677  
7303049 2025-08-28 | Parte 1 - Juan Pablo Caballero: Estructura de carpetas | Juan Pablo Caballero  
ffa50aa 2025-08-28 | Parte 1 - Sanchez Oscar: Preparación del espacio de Trabajo | Oscar Sanchez  
d413ee9 2025-08-28 | Initial commit | Oscar Sanchez
