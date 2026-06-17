
package boutiquedearomas.logica;

import java.util.ArrayList;

public class Logica {

    // Listas de codigos, nombres, precios y origenes
    ArrayList<String> codigosProductos = new ArrayList<>();
    ArrayList<String> nombresProductos = new ArrayList<>();
    ArrayList<Integer> preciosProductos = new ArrayList<>();
    ArrayList<String> origenesProductos = new ArrayList<>();

    // Agregar Productos
    public boolean agregarProducto(String codigoProducto, String nombreProducto, String precioProducto, String origenProducto) {
        try {
            int precioProductoInt = Integer.parseInt(precioProducto);

            if (precioProductoInt < 0) {
                return false;
            }

            codigosProductos.add(codigoProducto);
            nombresProductos.add(nombreProducto);
            preciosProductos.add(precioProductoInt);
            origenesProductos.add(origenProducto);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Mostrar Productos
    public boolean mostrarProductos(javax.swing.JTextArea mostrarResultados) {
        mostrarResultados.setText("");
        String listaCompleta = "";

        for (int i = 0; i < codigosProductos.size(); i++) {
            listaCompleta = listaCompleta + (i + 1) + ". Código: " + codigosProductos.get(i) + " | " +
                    "Nombre: " + nombresProductos.get(i) + " | Precio: $" + preciosProductos.get(i) +
                    " | Origen: " + origenesProductos.get(i) + "\n";
        }

        mostrarResultados.append("--- Lista de Productos Registrados ---\n" + listaCompleta);

        return true;
    }

    /* Productos*/

    // Buscar Indice Producto
    private int indiceCodigo(String codigoProducto) {
        int indice = 0;

        for (String codigo : codigosProductos) {
            if (codigo.equalsIgnoreCase(codigoProducto.trim())) {
                return indice;
            }
            indice++;
        }

        return -1;
    }

    // Editar Producto
    public boolean editarProducto(String codigoProducto, String nombreProducto, String precioProducto, String origenProducto) {
        try {
            int precioProductoInt = Integer.parseInt(precioProducto);

            if (precioProductoInt < 0) {
                return false;
            }

            boolean encontrados = false;

            for (int i = 0; i < codigosProductos.size(); i++) {
                if (codigosProductos.get(i).equalsIgnoreCase(codigoProducto)) {
                    nombresProductos.set(i, nombreProducto);
                    preciosProductos.set(i, precioProductoInt);
                    origenesProductos.set(i, origenProducto);
                    encontrados = true;
                }
            }
            return encontrados;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* ESTADISTICAS */

    // Calcular Total Precios
    public int calcularTotal() {
        int totalPrecio = 0;

        try {
            for (int precio : preciosProductos) {
                totalPrecio += precio;
            }
            return totalPrecio;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Promedio de Precios
    public double calcularPromedio() {
        try {
            double suma = calcularTotal();

            return suma / preciosProductos.size();
        } catch (Exception e) {
            return 0;
        }
    }

    // Producto mas caro
    public String calcularPrecioMaximo() {
        int precioMaximo = preciosProductos.get(0);
        int indiceMaximo = 0;

        for (int i = 1; i < codigosProductos.size(); i++) {
            if (preciosProductos.get(i) > precioMaximo) {
                precioMaximo = preciosProductos.get(i);
                indiceMaximo = i;
            }
        }
        String nombreMaximo = nombresProductos.get(indiceMaximo);

        return "El producto más caro registrado es " + nombreMaximo + " y su precio es $" + precioMaximo;
    }


    // Producto mas barato
    public String calcularPrecioMinimo() {
        int precioMinimo = preciosProductos.get(0);
        int indiceMinimo = 0;

        for (int i = 1; i < codigosProductos.size(); i++) {
            if (preciosProductos.get(i) < precioMinimo) {
                precioMinimo = preciosProductos.get(i);
                indiceMinimo = i;
            }
        }

        String nombreMinimo = nombresProductos.get(indiceMinimo);

        return "El producto más económico registrado es " + nombreMinimo + " y su precio es $" + precioMinimo;
    }


    // Mostrar Estadisticas
    public boolean mostrarEstadisticas(javax.swing.JTextArea mostrarResultados) {
        int total = calcularTotal();

        if (codigosProductos == null || codigosProductos.isEmpty()) {
            mostrarResultados.append("\n--- Estadísticas ---\n");
            mostrarResultados.append("No existen productos registrados.");
        } else {
            String promedioAproximado = String.format("%.1f", calcularPromedio());

            mostrarResultados.append("\n--- Estadísticas ---\n");
            mostrarResultados.append("Total gastado: $" + total + "\n");
            mostrarResultados.append("Promedio de precios: $" + promedioAproximado + "\n");
            mostrarResultados.append(calcularPrecioMaximo() + "\n");
            mostrarResultados.append(calcularPrecioMinimo() + "\n");

        }

        return true;
    }


    // Borrar Ultimo Registro
    public boolean borrarUltimo() {
        if (listaVacia()) {

            return false;
        } else {
            codigosProductos.remove(codigosProductos.size() - 1);
            nombresProductos.remove(nombresProductos.size() - 1);
            preciosProductos.remove(preciosProductos.size() - 1);
            origenesProductos.remove(origenesProductos.size() - 1);

            return true;
        }
    }

    /* Adicionales*/

    // Validar lista vacia
    public boolean listaVacia() {
        return codigosProductos.isEmpty();
    }

    // Validar si Existe el código
    public boolean existeProducto(String codigo) {
        return indiceCodigo(codigo) != -1;
    }

    // Mensajes para mostrar con el Total
    public String mensajeTotalGastado() {
        int total = calcularTotal();

        if (total > 100000) {
            return "¡Gracias por elegir fragancias conscientes! Has ganado un set exclusivo de velas aromáticas.";
        } else if (total >= 30000) {
            return "Obtienes un cupón del 15% de descuento en tu próxima visita";
        } else {
            return "Gracias por tu compra. ¡Esperamos verte pronto en Boutique de Aromas!";
        }
    }


}
