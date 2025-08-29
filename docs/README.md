# 🧪 Laboratorio 3 - Pruebas de Software – Agilismo y Scrum – Análisis de Requerimientos

**Integrantes:**
- Oscar Andres Sanchez Porras.
- Juan Pablo Caballero Castellanos.
- Robinson Steven Nuñez Portela.

**Nombre De la Rama:**
`feature/lab3_CaballeroJuan_SanchezOscar_NuñezRobinson_2025-2`
---
## ✅ Preguntas Iniciales

## 1. ¿Cuál es la diferencia principal entre una prueba unitaria y una prueba de integración E2E?
Una prueba unitaria valida una pieza muy pequeña y aislada del código y normalmente se ejecuta rápido. Su objetivo es comprobar la lógica interna y que las unidades hagan lo que deben en aislamiento (con mocks/stubs si es necesario).

Una prueba de integración E2E verifica que varios componentes funcionen juntos como un todo.
Las E2E son más lentas, detectan problemas de integración, flujos de usuario y configuración, y suelen usarse para 
validar escenarios reales completos que no cubren las pruebas unitarias.

---


## 2. En Scrum ¿Cuál es el propósito de la Sprint Retrospective y porque es crucial para la mejora continua del equipo?
La Sprint Retrospective es la reunión donde el equipo mira hacia atrás en el ultimo sprint para identificar qué salió bien, qué no, y decidir acciones concretas para mejorar. 

Este es crucial ya que transforma la experiencia en aprendizaje y sin este espacio las mismas fricciones se repiten. Además fomenta la confianza y la responsabilidad del equipo al convertir problemas en acciones pequeñas y medibles que se prueban en la siguiente sprint.

---

## 3. Explique la diferencia entre una Épica, una Feature y una historia de Usuario. Proporcione un ejemplo de cada una si tenemos un sistema de streaming de video como lo es Netflix.

- ***Épica:*** Es un objetivo grande o una iniciativa de alto nivel que se divide en varias features/historias.
Como se puede ser mejorar el catologo ya sea con mas contenido, perzonalización etc...

- ***Feature:*** Es una funcionalidad concreta que forma parte de la épica, es más pequeña que la épica pero puede requerir varias historias se puede usar para el sistema de recomendaciones por perfil en Netflix.

- ***Historia de Usuario:*** Es una unidad de trabajo pequeña y entregable, escrita desde la perspectiva del usuario, con criterios de aceptación.

RJP: Como usuario, quiero ver una lista de recomendaciones personalizadas en mi pantalla de inicio para descubrir películas relevantes. Y que no sean las mismas que el perfil de mis otros miembros de mi familia. 

---

## 4. ¿Qué es una cobertura de Código (code coverage) y porque una cobertura del 100% no garantiza necesariamente que el software esté libre de errores?
La cobertura de código mide qué porcentaje de líneas o ramas del código son ejecutadas por los tests. Es una métrica útil para detectar código sin pruebas, pero no asegura calidad por sí sola. Tener 100% puede significar que hay tests superficiales que sólo ejecutan líneas sin verificar resultados o casos borde. Errores de integración, condiciones de carrera, datos reales, y bugs en la lógica que no se validan en los asserts no se detectan sólo con alta cobertura. Por lo tanto La cobertura es una señal mas no la prueba definitiva de corrección.

---

## 5. Describa que es un Diagrama de Casos de Uso y que elementos lo componen. ¿Para qué sirve en la fase de análisis de requerimientos?

***Elementos que lo componen:***
- Actores (Tienen ciertos roles)
- Caso de uso (óvalos)
- Relaciones (asociación, include, extend, generalización)

Un Diagrama de Casos de Uso muestra las interacciones entre actores  y el sistema a través de casos de uso que son funcionalidades. 

En análisis de requerimientos sirve para visualizar quién usa qué partes del sistema, identificar alcance funcional, aclarar límites y descubrir escenarios relevantes que luego se traducen en historias de usuario o en requisitos más formales.

--- 

## 6. ¿Cuál es la diferencia entre el uso de Junit y Jacoco en un proyecto, y como complementa SonarQube este proceso en términos de calidad de software?

- ***JUnit:*** Es un framework para escribir y ejecutar pruebas unitarias usando asserts, fixtures y paramétricos.

- ***JaCoCo:*** Es como una herramienta que mide la cobertura de las pruebas como que líneas o branches fueron ejecutadas.

- ***SonarQube:** Esta plataforma de análisis de calidad que agrega métricas como la cobertura, duplicaciones, complejidad, bugs, vulnerabilidades, smells, utiliza datos de JaCoCo y resultados de tests para ofrecer un panorama global y aplicar quality gates que ayudan a prevenir regresiones y problemas de mantenibilidad. En conjunto: JUnit crea pruebas, JaCoCo mide su alcance, SonarQube evalúa calidad y riesgos.

---

## 7. ¿Qué ventajas tiene el uso de Planning Poker frente a otros métodos de estimación tradicional y como ayuda a mejorar la transparencia y compromiso del equipo?
Planning Poker es una técnica colaborativa donde cada miembro da su estimación en silencio y luego se discute la diferencia. 

***Ventajas:** 
- Evita el anchoring esto quiere decir que no se deja influenciar por la primera voz
- Fomenta la discusión sobre supuestos ocultos, hace que expertos y novatos compartan perspectiva, y conduce a estimaciones más consensuadas y realistas. 
- Mejora la transparencia porque las decisiones surgen del diálogo y mejora el compromiso porque el equipo participa y acepta las estimaciones acordadas.

---

## 8. Menciona los valores de Scrum y explica cual consideras más difícil de aplicar en un equipo.
Valores de Scrum son: Compromiso, Enfoque, Apertura, Respeto y Coraje.

Considero el Coraje como el más difícil, ya que es dificil decir abiertamente que tienes errores. Pero es preferible hacerlo que mas tarde el error se convierta en algo grave que afecte a todo el equipo y al proyecto.
Requiere un entorno seguro y maduro pero sin él, los equipos tienden a esconder incertidumbres y a acumular deuda técnica.

