/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.evaluado.sebastian.solarte;

/**
 *
 * @author ssola
 */
public class Hotel {
// Matriz donde se guardan las habitaciones

    private Habitacion[][] habitaciones;

//cantidad de pisos del hotel 
    private int pisos;

    //cantidad de habitaciones en cada piso 
    private int habPorPiso;

    public Hotel(int pisos, int habPorPiso) {
        this.pisos = pisos;
        this.habPorPiso = habPorPiso;
        habitaciones = new Habitacion[pisos][habPorPiso];

        // Se llena la matriz con los datos iniciales del hotel
        precargarHabitaciones();
    }
// este metodo lo que hace es llenar la matriz con las habitaciones del hotel

    private void precargarHabitaciones() {

// estados de cada habitacion
        String[][] estados = {
            {"Libre", "Libre", "Libre", "Libre", "Sucia"},
            {"Libre", "Libre", "Libre", "Libre", "Sucia"},
            {"Sucia", "Libre", "Libre", "Libre", "Sucia"},
            {"Ocupada", "Libre", "Libre", "Libre", "Sucia"},
            {"Libre", "Libre", "Libre", "Libre", "Sucia"}
        };

// tipos de habitacion ya sea simple o doble
        String[][] tipos = {
            {"Simple", "Doble", "Simple", "Doble", "Simple"},
            {"Doble", "Doble", "Simple", "Doble", "Simple"},
            {"Doble", "Doble", "Doble", "Doble", "Simple"},
            {"Simple", "Doble", "Simple", "Simple", "Simple"},
            {"Doble", "Doble", "Simple", "Doble", "Simpel"}
        };

// precio por noche en cada habitacion
        double[][] precios = {
            {100, 300, 300, 300, 500},
            {100, 400, 400, 400, 500},
            {100, 600, 400, 300, 500},
            {100, 600, 400, 400, 500},
            {10, 600, 400, 400, 500}
        };

//  se recorre todo, pisos y habitaciones para crear todo
        for (int piso = 0; piso < pisos; piso++) {
            for (int col = 0; col < habPorPiso; col++) {
                int numero = (piso + 1) * 100 + (col + 1);
                habitaciones[piso][col] = new Habitacion(
                        numero,
                        tipos[piso][col],
                        precios[piso][col],
                        estados[piso][col]
                );
            }
        }
    }
// refleja un texto con la informacion de todas las habitaciones, piso por piso

    public String visualizarHabitaciones() {
        String texto = "========== ESTADO DEL HOTEL ==========\n";
        for (int piso = pisos - 1; piso >= 0; piso--) {
            texto += "\n--- Piso " + (piso + 1) + " ---\n";
            texto += String.format("%-10s %-10s %-10s %-10s%n", "Numero", "Tipo", "Precio", "Estado");
            texto += "-------------------------------------------\n";
            // se agrega cada habitacion del piso al texto
            for (int col = 0; col < habPorPiso; col++) {
                Habitacion h = habitaciones[piso][col];
                texto += String.format("%-10d %-10s $%-9.0f %-10s%n",
                        h.getNumero(), h.getTipo(), h.getPrecio(), h.getEstado());
            }
        }
        texto += "\n==========================================";
        return texto;
    }

// se busca una habitacion por el numero donde se revisa toda la matriz
    public Habitacion buscarHabitacion(int numero) {
        for (int piso = 0; piso < pisos; piso++) {
            for (int col = 0; col < habPorPiso; col++) {
                if (habitaciones[piso][col].getNumero() == numero) {
                    return habitaciones[piso][col];
                }
            }
        }
        return null;
    }

// modifica el estado, el tipo y el precio de una habitacion 
    public boolean modificarHabitacion(int numero, String nuevoEstado, String nuevoTipo, double nuevoPrecio) {
        Habitacion h = buscarHabitacion(numero);
        if (h != null) {
            h.setEstado(nuevoEstado);
            h.setTipo(nuevoTipo);
            h.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

// aqui se genera un resumen con toda la informacion como cantidad de habitacione, el estado y la ganancia del hotel
    public String resumenEstado() {
        int libres = 0, ocupadas = 0, sucias = 0, total = 0;
        double ganancia = 0;

        for (int piso = 0; piso < pisos; piso++) {
            for (int col = 0; col < habPorPiso; col++) {
                Habitacion h = habitaciones[piso][col];
                total++;
                if (h.getEstado().equalsIgnoreCase("Libre")) {
                    libres++;
                } else if (h.getEstado().equalsIgnoreCase("Ocupada")) {
                    ocupadas++;
                    ganancia += h.getPrecio();
                } else if (h.getEstado().equalsIgnoreCase("Sucia")) {
                    sucias++;
                }
            }
        }

        String resumen = "========== RESUMEN DEL HOTEL SOLARTE==========\n";
        resumen += "Total de habitaciones : " + total + "\n";
        resumen += String.format("Libres   : %d (%.1f%%)%n", libres, (libres * 100.0 / total));
        resumen += String.format("Ocupadas : %d (%.1f%%)%n", ocupadas, (ocupadas * 100.0 / total));
        resumen += String.format("Sucias   : %d (%.1f%%)%n", sucias, (sucias * 100.0 / total));
        resumen += String.format("Ganancia actual: $%.2f", ganancia);
        return resumen;
    }
}
