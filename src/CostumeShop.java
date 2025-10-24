import java.util.ArrayList;
import java.util.Scanner;

public class CostumeShop {
  private static final Scanner SC = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayList<String> productosDE = generarProductosIniciales();

    System.out.println("🎃 Te damos la bienvenida a la app de SpookyShop!\n");
    boolean salir = false;

    while (!salir){
      System.out.println(""" 
          Ingrese el número equivalente a la opción:
          0-Finaliza el programa
          1-Crea un Producto
          2-Listar productos
          3-Búsqueda por nombre
          4-Editar nombre producto
          5-Borrar producto
          """);

      int opcionUsuario = leerEntero("👉 Opción (0-5): ");

      switch (opcionUsuario) {
        case 0 -> { System.out.println("👋 Gracias por usar la App!"); salir = true; }
        case 1 -> crearProducto(productosDE);
        case 2 -> listarProductos(productosDE);
        case 3 -> buscarProducto(productosDE);
        case 4 -> editarProducto(productosDE);
        case 5 -> borrarProducto(productosDE);
        default -> System.out.println("❌ Opción inválida.\n");
      }
    }
    // SC.close(); // opcional
  }
  //----------------CRUD------------
  public static void crearProducto (ArrayList<String> productos){
    //Scanner entrada = new Scanner(System.in);
    System.out.println("➕Creando Nuevo Producto");
    System.out.print("Ingrese el nombre del nuevo producto: ");
    String nombre = SC.nextLine().trim();
    if (nombre.isEmpty()) {
      System.out.println("⚠ El nombre no puede estar vacío.\n");
      return;
    }
    productos.add(nombre);
    System.out.println("✔ Producto agregado: " + nombre + "\n");
    pausa();
  }

  /** 📜 Muestra la lista de productos con encabezado y cierre. */
  public static void listarProductos(ArrayList<String> productos) {
    System.out.println();
    System.out.println("══════════════════════════════════════════════════");
    System.out.println("              📜  LISTA DE PRODUCTOS");
    System.out.println("══════════════════════════════════════════════════");

    if (productos == null || productos.isEmpty()) {
      System.out.println("🕸  No hay productos para mostrar.");
      System.out.println("✨  ¡Agregá tu primer producto con la opción 1 del menú!");
    } else {
      int contador = 1;
      for (String producto : productos) {
        System.out.printf("%2d. %s%n", contador++, producto);
      }
    }

    System.out.println("══════════════════════════════════════════════════");
    System.out.println("🎯 Fin de la lista de productos 🎃");
    System.out.println("══════════════════════════════════════════════════");
    pausa();
  }

  public static void buscarProducto(ArrayList<String> productos){
    System.out.println("\n🔎 Búsqueda por nombre");
    System.out.print("Texto a buscar: ");
    String q = SC.nextLine().toLowerCase();
    boolean found = false;
    for (int i = 0; i < productos.size(); i++) {
      if (productos.get(i).toLowerCase().contains(q)) {
        System.out.printf("✔ #%02d  %s%n", i, productos.get(i));
        found = true;
      }
    }
    if (!found) System.out.println("✖ Sin coincidencias.");
    System.out.println();
    pausa();
  }
  public static void editarProducto(ArrayList<String> productos){
    if (productos.isEmpty()) { System.out.println("\n🕸 No hay productos para editar.\n"); return; }
    listarProductos(productos);
    int idx = leerEntero("✏️  Número (#) a editar: ");
    if (idx < 0 || idx >= productos.size()) { System.out.println("⚠ Fuera de rango.\n"); return; }
    System.out.print("Nuevo nombre: ");
    String nuevo = SC.nextLine().trim();
    if (nuevo.isEmpty()) { System.out.println("⚠ No puede ser vacío.\n"); return; }
    productos.set(idx, nuevo);
    System.out.println("✔ Actualizado #" + idx + ": " + nuevo + "\n");
  }

  public static void borrarProducto(ArrayList<String> productos){
    if (productos.isEmpty()) { System.out.println("\n🕸 No hay productos para borrar.\n"); return; }
    listarProductos(productos);
    int idx = leerEntero("🗑️  Número (#) a borrar: ");
    if (idx < 0 || idx >= productos.size()) { System.out.println("⚠ Fuera de rango.\n"); return; }
    System.out.print("¿Confirmar eliminación de \"" + productos.get(idx) + "\"? (s/N): ");
    String c = SC.nextLine().trim().toLowerCase();
    if (c.equals("s") || c.equals("si") || c.equals("sí")) {
      System.out.println("✔ Eliminado: " + productos.remove(idx) + "\n");
    } else {
      System.out.println("Operación cancelada.\n");
    }
  }
  // ---------- Utils ----------
  private static int leerEntero(String prompt){
    while (true) {
      System.out.print(prompt);
      String s = SC.nextLine().trim();
      try { return Integer.parseInt(s); }
      catch (NumberFormatException e) { System.out.println("⚠ Ingrese un número válido."); }
    }
  }

  public static void pausa(){
    System.out.print("Presione ENTER para continuar... ");
    SC.nextLine();
    System.out.println();
  }
  public static ArrayList<String> generarProductosIniciales() {
    ArrayList<String> productos = new ArrayList<>();

    productos.add("🧛‍♂️ Disfraz de Vampiro Clásico");
    productos.add("🧙‍♀️ Sombrero de Bruja con Estrellas");
    productos.add("🧟‍♂️ Maquillaje Zombi Efecto Real");
    productos.add("🎭 Máscara de Payaso Terrorífico");
    productos.add("🧞‍♂️ Disfraz de Genio Azul Mágico");
    productos.add("🕸️ Capa Negra con Capucha Misteriosa");
    productos.add("👻 Sábana Fantasma con Ojos Recortados");
    productos.add("🐺 Orejas y Cola de Hombre Lobo");
    productos.add("🎩 Sombrero de Mago con Lentejuela");
    productos.add("💀 Guantes con Huesos Fosforescentes");

    return productos;
  }
}
