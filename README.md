# Granja

Aplicación de consola en Java que gestiona los animales de una granja (vacas, cerdo, ovejas) usando clases abstractas, herencia e interfaces.

## Diseño

**Clase abstracta `Animal`**: `nombre`, `peso`, `edad`, estado (vivo/muerto). Método abstracto `tipoAnimal()`.

**Interfaz `LecheProducida`**: `ordenyar()` — devuelve entre 3 y 8 litros (un decimal). La implementa `Vaca`.

**Subclases**
- `Vaca` — `uso` (leche/carne), implementa `LecheProducida`
- `Cerdo` — `colorPiel` (único, reemplazable si muere)
- `Oveja` — `tipoPelo`

## Datos iniciales

3 vacas (Romera, Facunda, Fina), 1 cerdo (Petro) y 3 ovejas (Mota, Coral, Cebra), con sus datos fijos en el enunciado. Número de vacas y ovejas fijo; el cerdo es el único reponible tras morir.

## Menú

1. Marcar animal como muerto
2. Listado de animales
3. Listado de animales completo
4. Mostrar tipo de animal
5. Sumar año a un animal
6. Cambiar peso animal
7. Adquirir nuevo cerdo
8. Obtención de leche
9. Venta de leche

Los animales muertos dejan de aparecer en listados y menús de selección.

## Reglas de negocio

- Leche: cada vaca de leche viva produce entre 3 y 8 l (aleatorio, un decimal) al usar la opción 8; se acumula en stock.
- Venta: precio fijo de 0.5 €/l; descuenta del stock y acumula ganancias.
- Cerdo: solo se puede adquirir uno nuevo si el actual ha muerto.

## Autor

**Kaori** — DAW 2025/2026  
[GitHub](https://github.com/Mia-Kaori)
