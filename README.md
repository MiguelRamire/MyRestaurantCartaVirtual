# MyRestaurant — Carta Virtual

Aplicación móvil Android que permite a los clientes de un restaurante consultar el menú por categorías, ver la información de las sedes y realizar reservas directamente a través de WhatsApp.

---

## Descripción

MyRestaurant es una carta virtual que busca reemplazar el menú físico con una experiencia digital sencilla, organizada y fácil de navegar desde cualquier dispositivo Android.

---

## Funcionalidades

- Pantalla principal con acceso rápido al menú, sedes y reservas
- Menú organizado por categorías con nombre, descripción e imagen:
  - Entradas
  - Platos Fuertes
  - Bebidas
  - Postres
  - Licores
- Vista de detalle por categoría con nombre, descripción y precio de cada plato
- Información de sedes del restaurante
- Reserva directa vía WhatsApp con mensaje predefinido
- Verificación de instalación de WhatsApp con mensaje de error si no está disponible

---

## Conocido

- El botón de Promociones está visible en la pantalla principal pero aún no está implementado. Al presionarlo la aplicación se cierra. Se encuentra pendiente para una próxima versión.

---

## Menu

### Entradas
| Plato | Precio |
|---|---|
| Empanadas | $2.500 |
| Patacones | $8.000 (porción) |
| Sopa de zanahoria | $10.000 (porción) |
| Deditos de Queso | $12.000 (porción) |
| Pan de Queso | $1.500 |

### Platos Fuertes
| Plato | Precio |
|---|---|
| Sancocho | $18.000 |
| Bandeja Paisa | $25.000 |
| Frijoles | $15.000 (porción) |
| Mondongo | $20.000 (porción) |
| Tilapia | $22.000 |

### Bebidas
| Bebida | Precio |
|---|---|
| Cocacola | $4.000 (500 ml) |
| Pepsi | $3.500 (500 ml) |
| Limonada | $6.000 (vaso) |
| Agua de Coco | $7.000 (vaso) |
| Soda Saborizada | $3.500 (500 ml) |

### Postres
| Postre | Precio |
|---|---|
| Tiramisu | $12.000 (porción) |
| Flan | $8.000 (porción) |
| Helado | $2.000 (bola) |
| Oreo | $5.000 (porción) |
| Fresas con Crema | $10.000 (porción) |

### Licores
| Licor | Precio |
|---|---|
| Aguardiente Antioqueño | $15.000 (trago) |
| Smirnoff | $18.000 (trago) |
| Corona | $8.000 (botella) |
| Aguila | $6.000 (botella) |
| Pilsen | $7.000 (botella) |

---

## Tecnologias utilizadas

| Tecnologia | Uso |
|---|---|
| Java | Lenguaje principal |
| Android Studio | Entorno de desarrollo |
| Android SDK 34 | Compilacion y target |
| Intents | Navegacion entre pantallas |
| ListView + BaseAdapter | Listado de categorias y platos |
| WhatsApp URI API | Integracion para reservas |
| EdgeToEdge | Diseno a pantalla completa |

---

## Estructura del proyecto

```
MyRestaurantCartaVirtual/
└── app/src/main/
    ├── java/com/upb/myrestaurantevirtual/
    │   ├── MainActivity.java          # Pantalla principal
    │   ├── MenuActivity.java          # Lista de categorias del menu
    │   ├── EntradasActivity.java      # Categoria: Entradas
    │   ├── PlatosFuertesActivity.java # Categoria: Platos fuertes
    │   ├── BebidasActivity.java       # Categoria: Bebidas
    │   ├── PostresActivity.java       # Categoria: Postres
    │   ├── LicoresActivity.java       # Categoria: Licores
    │   ├── PromocionActivity.java     # Promociones (no implementado)
    │   ├── SedeActivity.java          # Informacion de sedes
    │   ├── ReservaActivity.java       # Pantalla de reserva
    │   └── Plato.java                # Modelo de datos: plato y categoria
    └── res/                          # Recursos (layouts, imagenes, strings)
```

---

## Requisitos

- Android Studio Hedgehog o superior
- Android SDK 34
- Dispositivo o emulador con Android 14+
- WhatsApp instalado en el dispositivo para usar la funcion de reservas

---

## Instalacion y ejecucion

1. Clona el repositorio:
   ```bash
   git clone https://github.com/MiguelRamire/MyRestaurantCartaVirtual.git
   ```

2. Abre el proyecto en Android Studio:
   - `File > Open` y selecciona la carpeta del proyecto

3. Sincroniza las dependencias de Gradle:
   - Android Studio lo hace automaticamente al abrir el proyecto

4. Ejecuta la aplicacion:
   - Conecta un dispositivo Android o inicia un emulador
   - Presiona el boton Run

---

## Arquitectura

La aplicacion sigue una arquitectura basada en Activities, donde cada pantalla es una Activity independiente. La navegacion entre pantallas se realiza mediante Intents explicitos.

El modelo de datos principal es la clase `Plato`, que representa tanto los platos del menu como las categorias mostradas en la lista principal:

```java
public class Plato {
    public String titulo;
    public String descripcion;
    public Integer imagen; // Referencia al recurso drawable
}
```

El listado de categorias y platos se renderiza con un BaseAdapter personalizado (`MyAdapterMenu`) que infla un layout propio para cada item.

---

## Integracion con WhatsApp

La reserva se realiza abriendo WhatsApp directamente con un numero y mensaje predefinido mediante URI:

```java
Uri uri = Uri.parse("whatsapp://send?phone=" + phone + "&text=" + Uri.encode(message));
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(uri);
startActivity(i);
```

Si WhatsApp no esta instalado, la app muestra un Toast informando al usuario.
