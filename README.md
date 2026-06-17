# Actividad Sumativa 3: Boutique de Aromas 🕯️

* **Autor:** Fabrizio Fernandini
* **Ramo:** Fundamentos de Programación
* **Sección:** 005A

## 📝 Descripción

Este proyecto consiste en una aplicación de escritorio desarrollada en Java orientada a la gestión de caja y productos
para **Boutique de Aromas**. La herramienta cuenta con una interfaz gráfica basada en Java Swing que permite registrar,
editar, listar y eliminar productos en tiempo real, además de generar reportes estadísticos avanzados sobre los precios
y ofrecer incentivos comerciales según el volumen de compra.

---

## 🚀 Características y Componentes

* **Arquitectura Orientada a Capas:** Estructura modular limpia distribuida en paquetes específicos para separar la
  interfaz del usuario (`boutiquedearomas.gui`), el núcleo del negocio (`boutiquedearomas.logica`) y el arranque del
  sistema (`boutiquedearomas.app`).
* **Estructuras de Datos Dinámicas:** Uso de colecciones nativas `ArrayList` para mantener en memoria de manera
  organizada los códigos, nombres, precios y orígenes de los productos.
* **Módulo de Analítica Integrado:** Algoritmos matemáticos dedicados a calcular valores totales acumulados, promedios
  de precios con formato decimal controlado, y la detección del producto más caro y el más económico de la tienda.
* **Estrategia de Fidelización Automatizada:** Motor lógico que evalúa el gasto total y gatilla mensajes dinámicos con
  recompensas o cupones de descuento para incentivar las ventas.

---

## 📊 Reglas de Negocio y Beneficios Comerciales

El sistema calcula de forma dinámica el total acumulado en caja y entrega un beneficio exclusivo impreso en pantalla de
acuerdo con los siguientes tramos de precios:

| Gasto Total Calculado        | Mensaje / Recompensa Desplegada                                                                |
|:-----------------------------|:-----------------------------------------------------------------------------------------------|
| **Mayor a $100.000**         | `¡Gracias por elegir fragancias conscientes! Has ganado un set exclusivo de velas aromáticas.` |
| **Entre $30.000 y $100.000** | `Obtienes un cupón del 15% de descuento en tu próxima visita`                                  |
| **Menor a $30.000**          | `Gracias por tu compra. ¡Esperamos verte pronto en Boutique de Aromas!`                        |

---

## 🛠️ Requisitos e Instalación

* Tener instalado el **Java Development Kit (JDK) versión 26** (Desarrollado y testeado bajo entornos de la versión más
  reciente de Java).
* Entorno gráfico compatible con **Java Swing**.

### 💻 Ejecución directa desde la Terminal

Gracias a las capacidades del JDK moderno, puedes ejecutar el proyecto compuesto por múltiples archivos fuentes con una
sola línea de comandos. Ubícate en la raíz de tu directorio de código fuente (`src`) y ejecuta:

```bash
java boutiquedearomas/app/Main.java
```

📝 Simulación del Flujo del Sistema
1️⃣ Registro de Productos
Al completar los campos en la ventana de la caja con los siguientes datos:

Código: AR-01

Nombre: Difusor Lavanda

Precio: 35000

Origen: Francia

Al presionar Agregar Producto, la lógica procesa los datos, valida que el formato numérico sea correcto y actualiza de
inmediato el panel principal de resultados:

```
--- Lista de Productos Registrados ---
1. Código: AR-01 | Nombre: Difusor Lavanda | Precio: $35000 | Origen: Francia
```

2️⃣ Generación de Estadísticas y Beneficios
### 2️⃣ Generación de Estadísticas y Beneficios
Si añadimos un segundo artículo, por ejemplo, un *Aceite de Vainilla* a `$5.000`, y hacemos clic en el botón **Calcular Estadísticas**, el sistema imprimirá de manera automatizada el balance económico junto al cupón de descuento ganado por superar los $30.000 acumulados:

```
--- Lista de Productos Registrados ---
1. Código: AR-01 | Nombre: Difusor Lavanda | Precio: $35000 | Origen: Francia
2. Código: AR-02 | Nombre: Aceite Vainilla | Precio: $5000 | Origen: Chile

--- Estadísticas ---
Total gastado: $40000
Promedio de precios: $20000.0
El producto más caro registrado es Difusor Lavanda y su precio es $35000
El producto más económico registrado es Aceite Vainilla y su precio es $5000

Obtienes un cupón del 15% de descuento en tu próxima visita
```

3️⃣ Edición y Control de Errores
Búsqueda por Llave: Si ingresas el código AR-01 y cambias el nombre a "Difusor Lavanda Premium", al pulsar Editar
Producto, el sistema sobrescribe la posición exacta del artículo en todos los arreglos internos.

Control de Pilas: El botón Borrar Último Registro funciona con una lógica tipo POP, removiendo la última posición
ocupada en los ArrayList para agilizar la anulación de un cobro errado.