# AC202-Mohamed Amin Ben Assad El Arine
**Mohamed Amin Ben Assad El Arine**<br>
**Módulo:** Entornos de Desarrollo<br>
**Curso:** 1.º DAW

## Solución / procedimiento

### 1. Personalización y configuración reproducible

**Problema:** Tras formatear su ordenador, una desarrolladora pierde los temas, atajos, extensiones y snippets que había configurado. Hay que explicar cómo le ayudarían los dotfiles, el .editorconfig y la sincronización de ajustes a conservar o compartir su configuración, y qué opciones tiene para personalizar IntelliJ IDEA o VS Code.

Para no tener que configurar todo de nuevo después de formatear, se pueden guardar los ajustes de varias formas:

- **Dotfiles:** son archivos de configuración cuyo nombre empieza por punto (como ".gitconfig" o ".bashrc"). Si los guardo en un repositorio de Git, puedo recuperarlos en otro equipo haciendo un `git clone`.
- **" .editorconfig ":** va en la raíz del proyecto y define cosas como la sangría, el fin de línea o la codificación. Lo leen IntelliJ IDEA y VS Code, por lo que el equipo puede mantener el mismo estilo aunque use IDE distintos. Así se evitan cambios que solo afectan al formato del código.
- **Sincronización de ajustes:**
  - En **VS Code** se usa *Settings Sync*: `Ctrl+Shift+P` → *Settings Sync: Turn On*, se eligen qué cosas sincronizar (ajustes, atajos, extensiones, snippets, estado de la interfaz) y se inicia sesión con GitHub o Microsoft. En el equipo nuevo se activa lo mismo y se elige *Download*.
  - En **JetBrains** se puede sincronizar con la cuenta de JetBrains o, con el plugin *Settings Repository*, usando un repositorio Git propio.
  - Esto guarda la configuración del editor, los atajos, los plugins, los snippets y la apariencia, pero **no** el código de los proyectos.
- **Scripts de instalación:** un script, por ejemplo `setup.ps1` con `winget`, puede instalar VS Code, Git, Oh My Posh y la extensión de Java de una sola vez.

Después de formatear, instalaría el IDE y recuperaría la configuración para volver a tener sus temas, atajos, extensiones y snippets.

**Opciones de personalización:**

| Aspecto | IntelliJ IDEA | VS Code |
|---|---|---|
| Abrir la configuración | `Ctrl+Alt+S` (File > Settings) | `Ctrl+,` o editar `settings.json` |
| Tema | Light, Dark y otros instalables | Extensiones de temas |
| Fuente | Editor > Font (JetBrains Mono, Fira Code con ligaduras) | `editor.fontFamily` y `editor.fontLigatures` |
| Atajos | Keymap | Atajos de teclado y extensiones de keymap |
| Plugins / extensiones | Settings > Plugins | `Ctrl+Shift+X` |
| Guardado | Automático | `files.autoSave` |

---

### 2. Refactorización

**Qué es:** refactorizar es mejorar la estructura del código y hacerlo más fácil de entender **sin cambiar lo que hace por fuera**. Forma parte del mantenimiento del código.

**Por qué hay que conservar el comportamiento:** si el programa empieza a hacer algo distinto, ya no sería solo una refactorización. Podrían aparecer errores, así que comprobaría que funciona igual antes y después. En cambios grandes también revisaría la previsualización (*Refactoring Preview*) antes de aplicarlos.

**Caso:** un método de 200 líneas que hace varias cosas a la vez.

Usaría dos refactorizaciones de IntelliJ IDEA:

1. **Extract Method** (`Ctrl+Alt+M`): coge el bloque que selecciono, lo convierte en un método nuevo y lo reemplaza por una llamada. Con esto el método de 200 líneas se parte en métodos pequeños con una sola tarea cada uno, y se quita el código repetido.

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

2. **Rename** (`Shift+F6`): cambia el nombre de una variable, método o clase y actualiza todas las referencias a la vez. Me sirve para cambiar nombres que no dicen nada (`x`, `tmp`) por otros más claros, como `precioTotal`.

También existen *Change Signature* (`Ctrl+F6`, para cambiar los parámetros de un método), *Extract Variable* (`Ctrl+Alt+V`) y *Safe Delete* (`Alt+Delete`).

---

### 3. Depuración con breakpoints

**Problema:** el error salta en la línea 50, pero el dato incorrecto se asignó en la línea 12.

**Cómo lo investigaría:**

1. Pondría un **breakpoint** en la línea 12, que es donde se asigna el dato (clic en el margen del editor en IntelliJ IDEA o `F9` en VS Code).
2. Iniciaría la depuración (`Shift+F9` en IntelliJ IDEA, `F5` en VS Code). El programa se para al llegar a ese punto.
3. En la ventana de **variables locales** miraría el nombre, el tipo y el valor de cada variable para comprobar si el dato ya está mal en ese momento.
4. Iría avanzando paso a paso hacia la línea 50 fijándome en cuándo cambia el valor. Si hace falta, puedo modificar el valor de una variable mientras está parado para probar otros casos, o usar un breakpoint condicional para que solo pare cuando se cumpla una condición.

**Diferencia entre los comandos de ejecución controlada:**

| Comando | IntelliJ IDEA | VS Code | Qué hace |
|---|---|---|---|
| **Step Over** | `F8` | `F10` | Ejecuta la línea actual y pasa a la siguiente sin entrar en los métodos que llame |
| **Step Into** | `F7` | `F11` | Entra dentro del método que se llama en la línea actual |
| **Step Out** | `Shift+F8` | `Shift+F11` | Termina el método en el que estoy y vuelve al código que lo llamó |

Normalmente usaría Step Over para avanzar sin entrar en otros métodos, Step Into si quiero revisar lo que ocurre dentro y Step Out para volver al método anterior.

---

### 4. Control de versiones integrado

**Por qué conviene usarlo:** permite ver los cambios del código, recuperar versiones anteriores si algo falla y trabajar en equipo sin perder el trabajo de los demás. Es útil incluso en proyectos pequeños.

**Conceptos:**

- **commit:** guarda en el repositorio local un conjunto de cambios con un mensaje que explica qué se ha hecho. Cada commit debería ser un cambio lógico.
- **push:** sube los commits locales al repositorio remoto.
- **pull:** descarga los cambios del repositorio remoto y los junta con los del local.

**Hacerlo desde el IDE o desde la terminal:**

| | Desde el IDE | Desde la terminal |
|---|---|---|
| Ventajas | Es visual: veo los archivos modificados, elijo qué incluir en cada commit, comparo versiones y resuelvo conflictos con el editor de fusiones. Tiene atajos como `Ctrl+K` (commit) y `Ctrl+Shift+K` (push) en IntelliJ IDEA, o `Ctrl+Shift+G` en VS Code. | Da control total, los comandos son los mismos en cualquier equipo e IDE y sirve para operaciones avanzadas. |
| Límites | Cubre lo habitual, pero no todas las opciones avanzadas de Git, y cambia de un IDE a otro. | Hay que acordarse de los comandos (`git add`, `git commit`, `git push`...) y es menos visual. |

También puedo usar la terminal integrada del IDE, sin tener que salir del programa.

---

### 5. Elegir un IDE para Java multiplataforma

**Comparativa:**

| Criterio | IntelliJ IDEA | VS Code |
|---|---|---|
| Integración con Java | Excelente, es el IDE de referencia para Java, con muy buen análisis de código y refactorización | Buena, gracias al Extension Pack for Java (autocompletado, depuración, pruebas, Maven) |
| Herramientas | Trae muchas de serie: refactorización avanzada, depurador, Git, Local History, Maven y Gradle | Hay que instalar extensiones (Extension Pack for Java, Gradle for Java, SonarQube for IDE) |
| Recursos | Consume más, es un IDE completo y más pesado | Es ligero y arranca en segundos |
| Multiplataforma | Windows, Linux y macOS | Windows, Linux y macOS |
| Licencia | Community gratuita; Ultimate de pago (gratis con el Student Pack) | Gratuito y de código abierto |

**Recomendación:** elegiría **IntelliJ IDEA** como IDE principal para una aplicación Java de backend. Tiene buenas herramientas para Java, sobre todo para refactorizar y depurar, y está disponible en Windows, Linux y macOS. La edición Community es gratuita y puede ser suficiente para el equipo. **VS Code** lo usaría para tareas rápidas o archivos sueltos, ya que es más ligero. En ambos casos utilizaría `.editorconfig` para mantener el mismo formato de código.

---

## Capturas / evidencias

La actividad indica que no hace falta cambiar nada del código ni de la configuración, así que no se piden capturas.
