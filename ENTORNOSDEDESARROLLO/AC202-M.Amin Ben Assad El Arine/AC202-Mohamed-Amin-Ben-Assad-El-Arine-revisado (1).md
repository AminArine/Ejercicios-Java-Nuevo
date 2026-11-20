# AC202-Mohamed Amin Ben Assad El Arine
**Mohamed Amin Ben Assad El Arine**<br>
**Módulo:** Entornos de Desarrollo<br>
**Curso:** 1.º DAW

## Enunciado

**Caso de estudio: mantener el entorno y el código de MurgiTIC**

El equipo de MurgiTIC necesita conservar una configuración de trabajo común, mejorar el código Java existente, investigar errores y compartir cambios mediante Git.

Instrucciones: responde por escrito y razona las cinco situaciones. Puedes referirte a las funciones de IntelliJ IDEA y VS Code vistas en el tema. No es necesario realizar cambios en el código ni en la configuración. Cada pregunta vale 0,6 puntos.

## Solución / procedimiento

### 1. Personalización y configuración reproducible

**Enunciado:** Tras formatear su ordenador, una desarrolladora pierde los temas, atajos, extensiones y snippets que había configurado. Explica cómo podrían ayudarle los dotfiles, ".editorconfig" y las funciones de sincronización de ajustes a conservar o compartir su configuración, y qué opciones tendría para personalizar IntelliJ IDEA o VS Code.

**Respuesta:**

Para no tener que configurar todo otra vez después de formatear, se puede guardar la configuración de varias formas:

- **Dotfiles:** son archivos de configuración cuyo nombre empieza por punto, como " .gitconfig " o ".bashrc ". Si los subo a un repositorio de Git, en el ordenador nuevo solo tengo que hacer un " git clone " y ya los tengo.
- **" .editorconfig ":** es un archivo que se pone en la base del proyecto y define cosas como la sangría o la codificación. Lo leen tanto IntelliJ IDEA como VS Code, así que todo el equipo puede tener el mismo estilo aunque usen IDE distintos. Así no aparecen cambios en Git que son solo de formato.
- **Sincronización de ajustes:**
  - En VS Code está *Settings Sync*. Se activa con " Ctrl+Shift+P "→ *Settings Sync: Turn On*, se elige qué sincronizar (ajustes, atajos, extensiones, snippets...) y se inicia sesión con GitHub o Microsoft. En el equipo nuevo se hace lo mismo y se elige descargar.
  - En IntelliJ IDEA se puede sincronizar con la cuenta de JetBrains. También se pueden exportar los ajustes a un archivo (*File > Manage IDE Settings > Export Settings*) y volver a importarlos después.
  - Esto guarda el editor, los atajos, los plugins, los snippets y la apariencia, pero no el código de los proyectos (eso va en Git).
- **Script de instalación:** se puede hacer un script (por ejemplo "setup.ps1" con "winget") que instale de una vez VS Code, Git y la extensión de Java.

Con esto, después de formatear solo tendría que instalar el IDE y recuperar la configuración para tener otra vez sus temas, atajos, extensiones y snippets.

**Opciones para personalizar el IDE:**

| Aspecto | IntelliJ IDEA | VS Code |
|---|---|---|
| Abrir la configuración | "Ctrl+Alt+S" (File > Settings) | "Ctrl+," o editando "settings.json" |
| Tema | Light, Dark y otros que se pueden instalar | Extensiones de temas |
| Fuente | Editor > Font (por ejemplo JetBrains Mono o Fira Code con ligaduras) | "editor.fontFamily" y "editor.fontLigatures" |
| Atajos | Keymap | Atajos de teclado y extensiones de keymap |
| Plugins / extensiones | Settings > Plugins | "Ctrl+Shift+X" |
| Guardado | Automático | "files.autoSave" |

---

### 2. Refactorización

**Enunciado:** Un método de una aplicación Java tiene 200 líneas y realiza varias tareas. Explica qué es refactorizar y por qué se debe conservar el comportamiento del programa. Describe dos refactorizaciones disponibles en IntelliJ IDEA —por ejemplo, Rename, Extract Method o Change Signature— y qué cambiaría cada una.

**Respuesta:**

Refactorizar es mejorar la estructura del código para que sea más fácil de leer y de mantener, pero sin cambiar lo que hace el programa por fuera.

Hay que conservar el comportamiento porque, si el programa empieza a hacer algo distinto, ya no es una refactorización y pueden aparecer errores nuevos. Por eso comprobaría que el programa funciona igual antes y después de los cambios. En cambios grandes, IntelliJ IDEA enseña una previsualización (*Refactoring Preview*) que conviene mirar antes de aplicarlos.

En el caso del método de 200 líneas que hace varias cosas, usaría estas dos refactorizaciones:

1. **Extract Method** ("Ctrl+Alt+M"): selecciono un bloque de código y IntelliJ lo convierte en un método nuevo, dejando una llamada en su lugar. Así el método de 200 líneas se divide en métodos pequeños que hacen una sola cosa, y si hay código repetido se puede reutilizar.

   ```java
   // Antes
   double area1 = Math.PI * radius1 * radius1;
   double area2 = Math.PI * radius2 * radius2;

   // Después de Extract Method
   double area1 = calcularArea(radius1);
   double area2 = calcularArea(radius2);

   private static double calcularArea(double radius) {
       return Math.PI * radius * radius;
   }
   ```

2. **Rename** ("Shift+F6"): cambia el nombre de una variable, método o clase y actualiza todos los sitios donde se usa. Me sirve para cambiar nombres que no dicen nada, como "x" o "tmp", por otros más claros, como "precioTotal".

También existen otras como *Change Signature* ("Ctrl+F6", para cambiar los parámetros de un método), *Extract Variable* ("Ctrl+Alt+V") y *Safe Delete* ("Alt+Delete").

---

### 3. Depuración con breakpoints

**Enunciado:** Una aplicación Java muestra un error en la línea 50, pero el dato incorrecto se asignó en la línea 12. Explica cómo usarías un punto de interrupción para seguir la ejecución y examinar las variables. Distingue entre Step Over, Step Into y Step Out.

**Respuesta:**

Como el dato incorrecto se asigna en la línea 12, pondría ahí el breakpoint, no en la 50:

1. Pongo el **breakpoint** en la línea 12 (clic en el margen del editor en IntelliJ IDEA, o "F9" en VS Code).
2. Inicio la depuración ("Shift+F9" en IntelliJ IDEA, "F5" en VS Code). El programa se para cuando llega a esa línea.
3. En la ventana de **variables** miro el nombre, el tipo y el valor de cada variable, para ver si el dato ya está mal en ese momento.
4. Voy avanzando paso a paso hacia la línea 50 y miro cuándo cambia el valor. Si hace falta, puedo cambiar el valor de una variable mientras el programa está parado para probar otros casos, o usar un breakpoint condicional para que solo pare cuando se cumpla una condición.

**Diferencia entre Step Over, Step Into y Step Out:**

| Comando | IntelliJ IDEA | VS Code | Qué hace |
|---|---|---|---|
| Step Over | "F8" | "F10" | Ejecuta la línea actual y pasa a la siguiente, sin entrar en los métodos que llame |
| Step Into | "F7" | "F11" | Entra dentro del método que se llama en la línea actual |
| Step Out | "Shift+F8" | "Shift+F11" | Termina el método en el que estoy y vuelve al código que lo llamó |

Normalmente uso Step Over para avanzar sin meterme en otros métodos, Step Into cuando quiero ver qué pasa dentro de uno, y Step Out para salir de él cuando ya he visto lo que me interesaba.

---

### 4. Control de versiones integrado

**Enunciado:** IntelliJ IDEA y VS Code ofrecen integración con Git. Explica por qué conviene usar control de versiones durante el desarrollo y describe qué significan commit, push y pull. Comenta qué ventajas y qué límites tiene realizar estas operaciones desde la interfaz del IDE frente a usar la terminal.

**Respuesta:**

Conviene usar control de versiones porque permite ver qué cambios se han hecho en el código, volver a una versión anterior si algo falla y trabajar en equipo sin pisar el trabajo de los demás. Es útil incluso en proyectos pequeños.

- **commit:** guarda en el repositorio local un conjunto de cambios con un mensaje que explica qué se ha hecho. Lo ideal es que cada commit sea un cambio con sentido.
- **push:** sube al repositorio remoto los commits que tengo en local.
- **pull:** descarga los cambios del repositorio remoto y los junta con los de mi repositorio local.

**IDE frente a terminal:**

| | Desde el IDE | Desde la terminal |
|---|---|---|
| Ventajas | Es más visual: veo los archivos modificados, elijo qué meter en cada commit, comparo versiones y resuelvo conflictos con un editor de fusiones. Tiene atajos como "Ctrl+K" (commit) y "Ctrl+Shift+K" (push) en IntelliJ IDEA, o "Ctrl+Shift+G" en VS Code. | Tengo más control y los comandos son iguales en cualquier equipo e IDE. Sirve también para operaciones más avanzadas. |
| Límites | Cubre lo normal, pero no todas las opciones de Git, y cambia de un IDE a otro. | Hay que acordarse de los comandos ("git add", "git commit", "git push"...) y es menos visual. |

Además, los dos IDE tienen terminal integrada, así que puedo usar la terminal sin salir del programa.

---

### 5. Elegir un IDE para Java multiplataforma

**Enunciado:** MurgiTIC desarrollará una aplicación Java de backend que debe poder mantenerse en Windows, Linux y macOS. Compara IntelliJ IDEA y VS Code en cuanto a integración con Java, herramientas disponibles, consumo de recursos y trabajo multiplataforma. ¿Cuál recomendarías como IDE principal para el equipo y por qué?

**Respuesta:**

| Criterio | IntelliJ IDEA | VS Code |
|---|---|---|
| Integración con Java | Muy buena. Está pensado para Java y tiene muy buen análisis de código y refactorización | Buena, gracias al Extension Pack for Java (autocompletado, depuración, pruebas, Maven) |
| Herramientas | Trae muchas ya incluidas: refactorización, depurador, Git, Local History, Maven y Gradle | Hay que instalar extensiones para tener casi todo (Extension Pack for Java, Gradle for Java, etc.) |
| Consumo de recursos | Gasta más, porque es un IDE completo y más pesado | Es más ligero y abre rápido |
| Multiplataforma | Windows, Linux y macOS | Windows, Linux y macOS |
| Licencia | Tiene versión gratuita y versión de pago (los estudiantes pueden pedir licencia gratis) | Gratuito y de código abierto |

**Recomendación:** como IDE principal para el equipo recomendaría **IntelliJ IDEA**. Para una aplicación de backend en Java tiene las mejores herramientas para refactorizar y depurar, y funciona igual en Windows, Linux y macOS. VS Code lo usaría para cosas rápidas o archivos sueltos, porque es más ligero. En los dos pondría el mismo ".editorconfig" para que todo el equipo tenga el mismo formato de código.

---

## Capturas / evidencias

La actividad indica que no hace falta cambiar nada del código ni de la configuración, así que no se piden capturas.
