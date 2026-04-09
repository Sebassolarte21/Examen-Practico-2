/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso.evaluado.sebastian.solarte;

import javax.swing.JOptionPane;

/**
 *
 * @author ssola
 */
public class CasoEvaluadoSebastianSolarte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos el hotel con 5 pisos y 5 habitaciones por piso
        Hotel hotel = new Hotel(5, 5);

        // Esta variable guarda la opcion que elige el usuario en el menu
        String opcion = "";

        // Mensaje de bienvenida al arrancar el programa
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Sistema de Gestion de Reservas\nHotel Solarte",
                "Hotel Solarte", JOptionPane.INFORMATION_MESSAGE);

        // El menu se sigue mostrando hasta que el usuario elija salir 
        while (!opcion.equals("4")) {

            // Le mostramos el menu al usuario y guardamos lo que escribe
            opcion = JOptionPane.showInputDialog(null,
                    "MENU PRINCIPAL\n\n"
                    + "1. Ver estado de habitaciones\n"
                    + "2. Modificar habitacion\n"
                    + "3. Ver resumen del hotel\n"
                    + "4. Salir\n\n"
                    + "Ingrese una opcion:",
                    "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            // Si el usuario cierra la ventana sin escribir nada, lo mandamos a salir
            if (opcion == null) {
                opcion = "4";
            }

            // Opcion 1: muestra todas las habitaciones con su info
            if (opcion.equals("1")) {
                JOptionPane.showMessageDialog(null,
                        hotel.visualizarHabitaciones(),
                        "Estado de Habitaciones", JOptionPane.INFORMATION_MESSAGE);

                // Opcion 2: modifica la informacion de una habitacion especifica
            } else if (opcion.equals("2")) {

                String input = JOptionPane.showInputDialog(null,
                        "Ingrese el numero de habitacion a modificar:",
                        "Modificar Habitacion", JOptionPane.QUESTION_MESSAGE);

                // Si cierra sin ingresar nada, volvemos al menu
                if (input == null) {
                    continue;
                }
                // Convertimos el texto a numero y buscamos la habitacion en el hotel

                int numero = Integer.parseInt(input);
                Habitacion h = hotel.buscarHabitacion(numero);

                // Si no existe esa habitacion, avisamos y volvemos al menu
                if (h == null) {
                    JOptionPane.showMessageDialog(null,
                            "Habitacion no encontrada.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Mostramos la info actual de la habitacion antes de cambiarla

                    JOptionPane.showMessageDialog(null,
                            "Habitacion encontrada:\n" + h.toString(),
                            "Informacion Actual", JOptionPane.INFORMATION_MESSAGE);

                    // Seleccionar nuevo tipo
                    String[] tipos = {"Simple", "Doble"};
                    String nuevoTipo = (String) JOptionPane.showInputDialog(null,
                            "Seleccione el nuevo tipo:",
                            "Tipo de Habitacion",
                            JOptionPane.QUESTION_MESSAGE,
                            null, tipos, tipos[0]);

                    // Si cierra la ventana del tipo, volvemos al menu
                    if (nuevoTipo == null) {
                        continue;
                    }

                    // Ingresar nuevo precio
                    String precioInput = JOptionPane.showInputDialog(null,
                            "Ingrese el nuevo precio por noche:",
                            "Precio", JOptionPane.QUESTION_MESSAGE);

                    // Si cierra sin poner precio, volvemos al menu
                    if (precioInput == null) {
                        continue;
                    }

                    // Convertimos el precio de texto a numero decimal
                    double nuevoPrecio = Double.parseDouble(precioInput);

                    // Seleccionar nuevo estado
                    String[] estados = {"Libre", "Ocupada", "Sucia"};
                    String nuevoEstado = (String) JOptionPane.showInputDialog(null,
                            "Seleccione el nuevo estado:",
                            "Estado de Habitacion",
                            JOptionPane.QUESTION_MESSAGE,
                            null, estados, estados[0]);

                    // Si cierra sin elegir estado, volvemos al menu
                    if (nuevoEstado == null) {
                        continue;
                    }

                    // Aplicamos todos los cambios a la habitacion
                    hotel.modificarHabitacion(numero, nuevoEstado, nuevoTipo, nuevoPrecio);

                    // Confirmamos que todo se guardo bien
                    JOptionPane.showMessageDialog(null,
                            "Habitacion " + numero + " actualizada correctamente.",
                            "Exito", JOptionPane.INFORMATION_MESSAGE);
                }

                // Opcion 3: muestra el resumen general (libres, ocupadas, sucias y ganancias)
            } else if (opcion.equals("3")) {
                JOptionPane.showMessageDialog(null,
                        hotel.resumenEstado(),
                        "Resumen del Hotel", JOptionPane.INFORMATION_MESSAGE);

                // Opcion 4: mensaje de despedida y el while deja de ejecutarse
            } else if (opcion.equals("4")) {
                JOptionPane.showMessageDialog(null,
                        "Cerrando el sistema. Hasta luego.",
                        "Salir", JOptionPane.INFORMATION_MESSAGE);

                // Si escribe cualquier otra cosa que no sea 1, 2, 3 o 4
            } else {
                JOptionPane.showMessageDialog(null,
                        "Opcion invalida, intente de nuevo.",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
