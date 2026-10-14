import java.util.Scanner;
 
public class Tienda {
 
    // Matriz tridimensional: [Sucursal][Producto][Atributos]
    static String[][][] tienda = {
        {
            {"Codigo", "Producto", "Marca", "Categoria", "Precio", "Cantidad", "Disponible"},
            {"P001", "Arroz", "Diana", "Alimentos", "3500", "20", "Si"},
            {"P002", "Leche", "Alqueria", "Lacteos", "4200", "15", "Si"},
            {"P003", "Pan", "Bimbo", "Panaderia", "5000", "10", "Si"},
            {"P004", "Gaseosa", "Coca-Cola", "Bebidas", "3000", "25", "Si"},
            {"P005", "Jabon", "Dove", "Aseo", "6500", "12", "Si"}
        },
        {
            {"Codigo", "Producto", "Marca", "Categoria", "Precio", "Cantidad", "Disponible"},
            {"P006", "Aceite", "Roa", "Alimentos", "8000", "8", "Si"},
            {"P007", "Papas fritas", "Margarita", "Mecatos", "2500", "30", "Si"},
            {"P008", "Cafe", "Sello Rojo", "Bebidas", "12000", "5", "Si"},
            {"P009", "Detergente", "Ariel", "Aseo", "9500", "0", "No"},
            {"P010", "Chocolate", "Jet", "Dulces", "1500", "40", "Si"}
        }
    };
 
    // 1. Mostrar productos de una sucursal
    public static void mostrarSucursal(int sucursal) {
        System.out.println("\nProductos en sucursal " + (sucursal + 1));
 
        for (int i = 1; i < tienda[sucursal].length; i++) {
            System.out.println(
                tienda[sucursal][i][0] + " - "
                + tienda[sucursal][i][1] + " ("
                + tienda[sucursal][i][4] + " COP)"
            );
        }
    }
 
    // 2. Mostrar encabezados
    public static void mostrarEncabezados(int sucursal) {
        for (String encabezado : tienda[sucursal][0]) {
            System.out.print(encabezado + " | ");
        }
        System.out.println();
    }
 
    // 3. Buscar producto por codigo
    public static void buscarProducto(String codigo) {
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                if (tienda[s][i][0].equalsIgnoreCase(codigo)) {
                    System.out.println(
                        "Producto encontrado: " + tienda[s][i][1]
                        + " en sucursal " + (s + 1)
                    );
                    return;
                }
            }
        }
 
        System.out.println("Producto no encontrado.");
    }
 
    // 4. Mostrar productos disponibles
    public static void mostrarDisponibles() {
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                if (tienda[s][i][6].equals("Si")) {
                    System.out.println(
                        tienda[s][i][1] + " esta disponible."
                    );
                }
            }
        }
    }
 
    // 5. Calcular stock total
    public static void calcularStockTotal() {
        int total = 0;
 
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                total += Integer.parseInt(tienda[s][i][5]);
            }
        }
 
        System.out.println("Stock total: " + total + " unidades.");
    }
 
    // 6. Mostrar productos por categoria
    public static void mostrarPorCategoria(String categoria) {
        boolean encontrado = false;
 
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                if (tienda[s][i][3].equalsIgnoreCase(categoria)) {
                    System.out.println(
                        tienda[s][i][1] + " - "
                        + tienda[s][i][4] + " COP"
                    );
                    encontrado = true;
                }
            }
        }
 
        if (!encontrado) {
            System.out.println("No se encontraron productos en esa categoria.");
        }
    }
 
    // 7. Actualizar cantidad de un producto
    public static void actualizarCantidad(String codigo, int nuevaCantidad) {
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                if (tienda[s][i][0].equalsIgnoreCase(codigo)) {
                    tienda[s][i][5] = String.valueOf(nuevaCantidad);
 
                    if (nuevaCantidad > 0) {
                        tienda[s][i][6] = "Si";
                    } else {
                        tienda[s][i][6] = "No";
                    }
 
                    System.out.println(
                        "Cantidad actualizada para "
                        + tienda[s][i][1]
                    );
                    return;
                }
            }
        }
 
        System.out.println("Producto no encontrado.");
    }
 
    // 8. Calcular valor total del inventario
    public static void calcularValorInventario() {
        int valor = 0;
 
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                int precio = Integer.parseInt(tienda[s][i][4]);
                int cantidad = Integer.parseInt(tienda[s][i][5]);
 
                valor += precio * cantidad;
            }
        }
 
        System.out.println("Valor total del inventario: " + valor + " COP");
    }
 
    // 9. Mostrar productos agotados
    public static void mostrarAgotados() {
        boolean encontrado = false;
 
        for (int s = 0; s < tienda.length; s++) {
            for (int i = 1; i < tienda[s].length; i++) {
                if (tienda[s][i][6].equals("No")) {
                    System.out.println(
                        "Producto agotado: " + tienda[s][i][1]
                    );
                    encontrado = true;
                }
            }
        }
 
        if (!encontrado) {
            System.out.println("No hay productos agotados.");
        }
    }
 
    // 10. Mostrar todos los productos de todas las sucursales
    public static void mostrarTodos() {
        for (int s = 0; s < tienda.length; s++) {
            mostrarSucursal(s);
        }
    }
 
    // Menu principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
 
        do {
            System.out.println("--- MENU DE TIENDA ---");
            System.out.println("1. Mostrar productos de una sucursal");
            System.out.println("2. Mostrar encabezados");
            System.out.println("3. Buscar producto por codigo");
            System.out.println("4. Mostrar productos disponibles");
            System.out.println("5. Calcular stock total");
            System.out.println("6. Mostrar productos por categoria");
            System.out.println("7. Actualizar cantidad de un producto");
            System.out.println("8. Calcular valor del inventario");
            System.out.println("9. Mostrar productos agotados");
            System.out.println("10. Mostrar todos los productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
 
            opcion = sc.nextInt();
            sc.nextLine();
 
            switch (opcion) {
 
                case 1:
                    System.out.print("Ingrese sucursal (1 o 2): ");
                    int sucursal = sc.nextInt();
                    sc.nextLine();
 
                    if (sucursal >= 1 && sucursal <= tienda.length) {
                        mostrarSucursal(sucursal - 1);
                    } else {
                        System.out.println("Sucursal no valida.");
                    }
                    break;
 
                case 2:
                    System.out.print("Ingrese sucursal (1 o 2): ");
                    sucursal = sc.nextInt();
                    sc.nextLine();
 
                    if (sucursal >= 1 && sucursal <= tienda.length) {
                        mostrarEncabezados(sucursal - 1);
                    } else {
                        System.out.println("Sucursal no valida.");
                    }
                    break;
 
                case 3:
                    System.out.print("Ingrese codigo del producto: ");
                    String codigo = sc.nextLine();
                    buscarProducto(codigo);
                    break;
 
                case 4:
                    mostrarDisponibles();
                    break;
 
                case 5:
                    calcularStockTotal();
                    break;
 
                case 6:
                    System.out.print("Ingrese la categoria: ");
                    String categoria = sc.nextLine();
                    mostrarPorCategoria(categoria);
                    break;
 
                case 7:
                    System.out.print("Ingrese codigo del producto: ");
                    codigo = sc.nextLine();
 
                    System.out.print("Ingrese la nueva cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
 
                    if (cantidad >= 0) {
                        actualizarCantidad(codigo, cantidad);
                    } else {
                        System.out.println(
                            "La cantidad no puede ser negativa."
                        );
                    }
                    break;
 
                case 8:
                    calcularValorInventario();
                    break;
 
                case 9:
                    mostrarAgotados();
                    break;
 
                case 10:
                    mostrarTodos();
                    break;
 
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
 
                default:
                    System.out.println(
                        "Opcion no valida. Intente de nuevo."
                    );
            }
 
        } while (opcion != 0);
 
   
    }
}