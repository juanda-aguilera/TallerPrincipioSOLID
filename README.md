# Taller 9: Principios SOLID paso a paso — ParqueaderoSOLID

**Integrantes:** Juan David Aguilera y Marianna Fernandez

Sistema de cobro mensual de un parqueadero: mensualistas, vehículos que pagan por minuto o por día, bicicletas y casilleros para cascos.

Cada carpeta es una versión completa y ejecutable del mismo proyecto. Cada paso se construyó copiando la carpeta anterior y aplicando sobre la copia un principio SOLID.

## Resumen de cambios por paso

| Carpeta | Principio | Qué cambió | Clases nuevas / modificadas |
|---|---|---|---|
| `00-inicio` | — | Proyecto de partida. Viola los cinco principios a propósito. | Todas las originales |
| `01-responsabilidad-unica` | **S** — Responsabilidad única | La exportación a CSV y el envío del SMS salen de `GestorParqueadero`. El gestor conserva el cálculo y coordina el cierre con `cerrarMes`. | Nuevas: `ExportadorCSV`, `NotificadorSMS`. Modificadas: `GestorParqueadero`, `Main` |
| `02-abierto-cerrado` | **O** — Abierto/cerrado | Se elimina el `switch` sobre `tipo`. `Vehiculo` pasa a ser abstracta con `calcularCobro()` y cada modelo de cobro es una subclase. Se demuestra el principio agregando `VehiculoPorDia` sin tocar ninguna clase existente. | Nuevas: `VehiculoMensual`, `VehiculoPorMinutos`, `VehiculoPorDia`. Modificadas: `Vehiculo`, `Bicicleta`, `GestorParqueadero`, `Main` |
| `03-sustitucion-liskov` | **L** — Sustitución de Liskov | `calcularPuntos()` sale de `Vehiculo` y pasa a la interfaz `Fidelizable`, que solo implementa `VehiculoMensual`. `Bicicleta` extiende `Vehiculo` directamente y ya no lanza excepciones. | Nueva: `Fidelizable`. Modificadas: `Vehiculo`, `VehiculoMensual`, `Bicicleta`, `Main` |
| `04-segregacion-interfaces` | **I** — Segregación de interfaces | `ServicioParqueadero` se divide en `ConMinutos`, `ConSeguro` y `ConLavado`. `Casillero` solo implementa `ConMinutos` y desaparecen sus métodos vacíos. | Nuevas: `ConMinutos`, `ConSeguro`, `ConLavado`. Eliminada: `ServicioParqueadero`. Modificadas: `Vehiculo`, `Casillero`, `Main` |
| `05-inversion-dependencias` | **D** — Inversión de dependencias | `GestorParqueadero` deja de crear con `new` un `RepositorioMySQL`: depende de la interfaz `RepositorioCobros` recibida por el constructor. Se agrega `RepositorioEnMemoria` para probar sin base de datos. | Nuevas: `RepositorioCobros`, `RepositorioEnMemoria`. Modificadas: `RepositorioMySQL`, `GestorParqueadero`, `Main` |

## Qué viola cada principio en `00-inicio`

- **S**: `GestorParqueadero` calcula, guarda en la base de datos, exporta el CSV y envía el SMS.
- **O**: `calcularCobro` usa un `switch` sobre el texto `tipo`; cada modelo de cobro nuevo obliga a modificarlo.
- **L**: `Bicicleta` hereda `calcularPuntos()` y lanza una excepción.
- **I**: `ServicioParqueadero` obliga a `Casillero` a escribir `calcularSeguro()` y `solicitarLavados()` vacíos.
- **D**: `GestorParqueadero` crea con `new` un `RepositorioMySQL`.

## Cómo compilar y ejecutar cualquier versión

Como todas las clases declaran el paquete `com.gitb.juandaaguilera.principiosSolid`, la clase principal se ejecuta con su nombre completo. Desde la raíz del repositorio:

```
cd 00-inicio
javac -d out *.java
java -cp out com.gitb.juandaaguilera.principiosSolid.Main
```

(Cambie `00-inicio` por cualquiera de las otras cinco carpetas.) La carpeta `out/` queda ignorada por Git.

## Notas por paso

- **Paso 2:** `Main` hay un bloque que recorre todos los vehículos llamando `calcularPuntos()`. Al descomentarlo lanza `UnsupportedOperationException` con la bicicleta: es la violación de Liskov que se corrige en el paso 3.
- **Paso 3:** ese mismo bloque queda activo y funciona, porque solo los objetos `Fidelizable` calculan puntos.
- **Paso 5:** `Main` ejecuta primero una prueba con `RepositorioEnMemoria` (imprime `PRUEBA OK`) y luego el mismo gestor con `RepositorioMySQL`.
