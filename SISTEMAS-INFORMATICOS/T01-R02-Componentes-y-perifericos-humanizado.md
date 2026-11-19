# Tema 01 Relación 02 – Componentes y periféricos

**Alumno:** Mohamed Amin Ben Assad El Arine
**Módulo:** Sistemas informáticos
**Curso:** 1.º DAW – IES Murgi 2026-2027

---

## Ejercicio 1.º – Identificación de componentes

### a) Comandos para identificar la RAM y el monitor

Para sacar la información desde la consola uso dos herramientas: el Símbolo del sistema (CMD) y PowerShell. En los dos casos se apoyan en WMI, que es la parte de Windows que guarda los datos del hardware.

**Memoria RAM** (me da fabricante, modelo, número de serie, capacidad y velocidad):

- En CMD:
  ```
  wmic memorychip get Manufacturer, PartNumber, SerialNumber, Capacity, Speed
  ```
- En PowerShell:
  ```
  Get-CimInstance Win32_PhysicalMemory | Select-Object Manufacturer, PartNumber, SerialNumber, Capacity, Speed
  ```

La capacidad sale en bytes, así que hay que dividirla entre 1.073.741.824 para pasarla a GB.

![Captura del terminal powershell,datos de la RAM](capturasdecomandos/Get-CimInstance%20Win32_PhysicalMemory.PNG )
**Datos de mi RAM** 

| Dato | Valor |
|---|---|
| Fabricante | [Silicon-Power] |
| Modelo (PartNumber) | [RELLENAR] |
| Número de serie | [00000000] |
| Capacidad | [16] GB |
| Velocidad | [2666] MHz |

**Monitor** (fabricante, modelo y número de serie, más la definición de la pantalla):

- En PowerShell, para fabricante, modelo y número de serie:
  ```
  Get-CimInstance -Namespace root\wmi -ClassName WmiMonitorID | ForEach-Object {
    [PSCustomObject]@{
      Fabricante = -join ($_.ManufacturerName | Where-Object {$_ -ne 0} | ForEach-Object {[char]$_})
      Modelo     = -join ($_.UserFriendlyName | Where-Object {$_ -ne 0} | ForEach-Object {[char]$_})
      NumSerie   = -join ($_.SerialNumberID   | Where-Object {$_ -ne 0} | ForEach-Object {[char]$_})
    }
  }
  ```
  Estos datos vienen como códigos ASCII, por eso el comando los convierte a letras.
- En PowerShell, para la definición de la pantalla:
  ```
  Get-CimInstance Win32_VideoController | Select-Object Name, CurrentHorizontalResolution, CurrentVerticalResolution
  ```
- En CMD:
  ```
  wmic path Win32_VideoController get Name, CurrentHorizontalResolution, CurrentVerticalResolution
  wmic /namespace:\\root\wmi path WmiMonitorID get ManufacturerName, ProductCodeID, SerialNumberID, UserFriendlyName
  ```
  En el segundo comando los valores salen en decimal (códigos ASCII), así que habría que traducirlos a texto.

> 📸 **[AQUÍ CAPTURA 2]** – Comandos del monitor (fabricante/modelo/serie) y su resultado.
> *(`capturas/captura2.png`)*
>
> 📸 **[AQUÍ CAPTURA 3]** – Comando de la resolución con su resultado.
> *(`capturas/captura3.png`)*

**Datos de mi monitor** *(⚠️ RELLENA)*:

| Dato | Valor |
|---|---|
| Fabricante (código de 3 letras) | [RELLENAR] |
| Modelo | [RELLENAR] |
| Número de serie | [RELLENAR] |
| Definición de pantalla | [RELLENAR] × [RELLENAR] píxeles |

### b) Identificar el procesador sin abrir el ordenador

Para ver el procesador con una sola instrucción uso:

- En PowerShell:
  ```
  Get-CimInstance Win32_Processor | Select-Object Name, Manufacturer, MaxClockSpeed, L2CacheSize, L3CacheSize, NumberOfCores, NumberOfLogicalProcessors
  ```
- En CMD:
  ```
  wmic cpu get Name, Manufacturer, MaxClockSpeed, L2CacheSize, L3CacheSize, NumberOfCores, NumberOfLogicalProcessors
  ```

Otra forma muy cómoda es el Administrador de tareas (`Ctrl+Shift+Esc` → pestaña *Rendimiento* → *CPU*), donde aparecen también las cachés L1, L2 y L3.

> 📸 **[AQUÍ CAPTURA 4]** – Comando del procesador con su resultado.
> *(`capturas/captura4.png`)*
>
> 📸 **[AQUÍ CAPTURA 5]** – Administrador de tareas → Rendimiento → CPU, con las cachés y los núcleos a la vista.
> *(`capturas/captura5.png`)*

Con esos datos contesto a las cuestiones *(⚠️ RELLENA con los datos de tu CPU)*:

**¿Cuál es su fabricante, modelo y generación o familia?**
El fabricante es **[RELLENAR: Intel / AMD]**, el modelo es **[RELLENAR: por ejemplo, i5-12400]** y pertenece a la **[RELLENAR]** generación/familia.
*(Ayuda: en Intel la generación se ve en las primeras cifras del número, así que un i5-12400 es de 12.ª generación y un i7-8700 de 8.ª. En AMD Ryzen se mira la serie: un Ryzen 5 5600X es de la serie 5000.)*

**¿Cuál es su velocidad máxima de reloj? ¿Está preparado para overclock?**
Su velocidad máxima es de **[RELLENAR] GHz**. El valor `MaxClockSpeed` que da Windows suele ser la frecuencia base, así que la frecuencia máxima en turbo la he comprobado en la ficha oficial del fabricante (Intel ARK o la web de AMD).
Sobre el overclock: en Intel, los procesadores con sufijo **K, KF o KS** tienen el multiplicador desbloqueado y se pueden overclockear, mientras que el resto están bloqueados. En AMD Ryzen casi todos son desbloqueables. Además, hace falta una placa base compatible. Mi procesador **[RELLENAR: sí / no]** está preparado para overclock.

**¿Cuál es la capacidad de su memoria caché y de qué tipo es?**
Tiene **[RELLENAR] KB/MB de L2** y **[RELLENAR] MB de L3** (la L1 aparece en el Administrador de tareas: **[RELLENAR]**). La caché es memoria **SRAM**, muy rápida, que se organiza en niveles: L1 (más pequeña y rápida, una por núcleo), L2 y L3 (más grande y compartida entre núcleos).

**¿Cuántos núcleos tiene?**
Tiene **[RELLENAR] núcleos físicos** y **[RELLENAR] procesadores lógicos (hilos)**.

---

## Ejercicio 2.º – Fuentes de alimentación

Para valorar los consejos me fijo en la eficiencia mínima que exige la certificación 80 Plus en cada nivel de carga (valores para 115 V):

| Certificación | 10 % de carga | 20 % de carga | 50 % de carga | 100 % de carga |
|---|---|---|---|---|
| 80 Plus Platinum | – | 90 % | 92 % | 89 % |
| 80 Plus Titanium | 90 % | 92 % | 94 % | 90 % |

> 📸 **[AQUÍ CAPTURA 6 – OPCIONAL]** – La tabla 80 Plus de tus apuntes o de la web oficial, si quieres apoyar los datos.
> *(`capturas/captura6.png`)*

### a) El consejo que le han dado a Lucía

Me parece **un buen consejo**. Lucía va a usar la fuente casi siempre al 100 % de su carga, y en ese punto la diferencia entre una Titanium (90 %) y una Platinum (89 %) es de solo **un punto**. Pagar mucho más por una Titanium para ganar un 1 % de eficiencia no compensa, y con la Platinum va a tener prácticamente el mismo rendimiento.

Eso sí, le recomendaría escoger una fuente con algo más de potencia de la que necesita. Trabajar siempre al 100 % no es lo ideal, porque calienta más, hace más ruido y desgasta antes los componentes. Lo normal es que una fuente rinda mejor y dure más cerca del 50 % de carga.

### b) El consejo que le han dado a Cecilio

Aquí **no estoy tan de acuerdo**. Cecilio va a usar la fuente muchas horas con una carga de entre el 20 % y el 50 %, y justo en ese tramo la Titanium rinde mejor: 92-94 % frente al 90-92 % de la Platinum, es decir, **dos puntos** de diferencia, el doble que en el caso de Lucía. Además, la Titanium es la única que garantiza un 90 % incluso con cargas muy bajas (10 %), algo que a él le pasará a veces cuando el equipo esté casi en reposo.

Como su equipo está encendido muchas horas, esa mejora se acumula en consumo y en calor generado. Por eso la Titanium tiene más sentido para Cecilio que para Lucía, aunque la Platinum tampoco sería una mala compra si el presupuesto es lo que manda.

---

## Ejercicio 3.º – Impresoras

**No me parece un buen consejo**, por estos motivos:

- **La grasa de litio mineral no es la adecuada para una impresora láser.** Estas máquinas llevan engranajes y piezas de plástico y de goma, y con el tiempo las grasas minerales pueden hincharlos o deteriorarlos. La grasa de silicona es la que se usa precisamente porque no ataca esos materiales y aguanta bien los cambios de temperatura.
- **El grado que propone es demasiado duro.** La dureza de una grasa se mide con la escala NLGI, que va de 000 a 6. Un grado 3 es una grasa bastante espesa y un grado 5 es casi sólida. En engranajes pequeños que mueve un motor ligero, una grasa tan dura aumenta el rozamiento y fuerza el mecanismo.
- **El técnico se contradice.** Primero habla de un grado 5 y después de un grado 3, lo que me da poca confianza en que sepa qué lleva realmente la impresora.
- **Que dure más no sirve de nada si daña la pieza.** Además, en una láser hay zonas muy calientes, como la del fusor, donde hace falta una grasa específica para altas temperaturas. Y si sobra grasa, puede acabar manchando el tambor o el tóner.
- **El precio de la impresora no decide qué grasa usar.** Que cueste más de 1000 € no cambia los materiales de los que está hecha. Lo que hay que mirar es lo que indique el fabricante en el manual de mantenimiento.

Mi conclusión es que seguiría usando **grasa de silicona** (o la grasa que especifique el fabricante) y que no seguiría el consejo del técnico de PC CT.

---

## Ejercicio 4.º – El teclado y el ratón

Primero comparo lo que tiene cada uno.

| | Características principales |
|---|---|
| **Newskill Gungnyr TKL Pro** (teclado de Alfredo) | Teclado de formato TKL, es decir, sin teclado numérico. Es optomecánico, con interruptores Gateron Red de pulsación suave y lineal, cambiables (hot-swap). Va por cable USB (1,8 m), con iluminación RGB y orientado a gaming. Los interruptores están pensados para unos 100 millones de pulsaciones. Es más ruidoso que uno de membrana. |
| **Logitech MX Keys S** (teclado de Elisa) | Teclado de tamaño completo, con teclado numérico. De perfil bajo y teclas cóncavas, de escritura rápida y silenciosa. Inalámbrico por Bluetooth, con receptor Logi Bolt, y puede emparejarse con hasta 3 dispositivos. Batería recargable por USB-C y retroiluminación inteligente. |
| **Microsoft Surface Mouse WS3-00006** (ratón de Alfredo) | Bluetooth, ambidiestro y simétrico, de 3 botones. Es plano y ligero (unos 91 g), con sensor BlueTrack de 1000 dpi y clics silenciosos. Funciona con 2 pilas AAA y declara hasta 12 meses de batería. |
| **Microsoft Mobile Mouse 3600** (ratón de Elisa) | Bluetooth, ambidiestro, de 3 botones con rueda de 4 direcciones. Es muy compacto (unos 95 × 57 mm) y pesa solo 63 g. Usa una pila AA y sensor BlueTrack de 1000 dpi. La rueda va "a pasos" y es algo más ruidosa. |

### Teclados: los dejaría como están

- **Elisa** pasa muchas horas mecanografiando las sesiones del Congreso. El MX Keys S es muy buena opción: es silencioso, las teclas de perfil bajo cansan menos las muñecas y el teclado numérico le sirve para cifras y votaciones. Con un teclado optomecánico duro y ruidoso estaría peor.
- **Alfredo** supervisa nodos de fibra por toda la ciudad, así que escribe menos y apenas necesita la zona numérica. El Gungnyr TKL Pro es compacto, resistente y muy fiable. Aunque sea de aspecto gaming y vaya con cable, para su uso cumple perfectamente, y no hay un motivo claro para cambiarlo.

### Ratones: aquí sí intercambiaría los componentes

- **Elisa** pasa horas sentada, rodeada de gente y en un ambiente tranquilo. Le conviene el **Surface Mouse**: es algo más grande, así que cansa menos la mano, y tiene los clics más silenciosos.
- **Alfredo** se mueve por la ciudad, por lo que le encaja mejor el **Mobile Mouse 3600**, que es más pequeño y ligero y ocupa menos en la mochila.

**Conclusión:** les diría que mantengan los teclados y que **se intercambien los ratones**. La diferencia es pequeña, pero cada uno queda con el que mejor encaja con su forma de trabajar.

> 📸 **[AQUÍ CAPTURA 7 – OPCIONAL]** – Fotos de los cuatro productos (de la web del fabricante o de la tienda) para acompañar la tabla.
> *(`capturas/captura7.png`)*

---

## Ejercicio 5.º – Montaje de dispositivos

### a) Distancia mínima a la pantalla

Parto de estos datos: monitor de **30 pulgadas**, formato **21:9** y **1080p**. Al ser 21:9 con 1080 píxeles de alto, la resolución es de **2560 × 1080**.

1. **Tamaño real de la pantalla.** La diagonal son 30" y la proporción 21:9, así que:
   - Ancho = 30 · 21 / √(21² + 9²) ≈ 27,6" ≈ **70 cm**
   - Alto = 30 · 9 / √(21² + 9²) ≈ 11,8" ≈ **30 cm**
2. **Densidad de píxeles.** La diagonal en píxeles es √(2560² + 1080²) ≈ 2778 px, así que tengo 2778 / 30 ≈ **92,6 ppp**. Cada píxel mide 25,4 mm / 92,6 ≈ **0,274 mm**.
3. **Distancia.** El ojo humano distingue detalles de hasta 1 minuto de arco (1/60 de grado). A partir de esa distancia dejamos de ver los píxeles por separado y notamos toda la definición sin forzar la vista:

   d = 0,274 mm / tan(1/60°) = 0,274 / 0,000291 ≈ 942 mm

**Resultado:** debo sentarme como mínimo a unos **94 cm** (≈ 0,94 m) de la pantalla.

### b) Separación de los altavoces

Para que se note bien el efecto estéreo, los altavoces y la persona deben formar un **triángulo equilátero** (ángulo de unos 60° entre los dos altavoces vistos desde mi posición). Eso significa que la separación entre altavoces tiene que ser igual a la distancia a la que estoy sentado:

**Separación entre altavoces ≈ 94 cm.**

Es decir, cada altavoz queda a unos 47 cm del centro del monitor. Como la pantalla mide unos 70 cm de ancho (35 cm hasta cada borde), cada altavoz quedará unos 12 cm por fuera del borde del monitor. Los colocaría a la altura de los oídos y ligeramente girados hacia mí.

> 📸 **[AQUÍ CAPTURA 8 – OPCIONAL]** – El esquema del enunciado con las distancias anotadas encima (94 cm en la flecha vertical de la silla y 94 cm en la flecha horizontal entre altavoces).
> *(`capturas/captura8.png`)*

---

## Fuentes consultadas

- Certificación 80 Plus (CLEAResult) y artículo de Tom's Hardware sobre los niveles 80 Plus.
- Fichas de producto del fabricante: Newskill Gungnyr TKL Pro, Logitech MX Keys S, Microsoft Surface Mouse y Microsoft Bluetooth Mobile Mouse 3600.
