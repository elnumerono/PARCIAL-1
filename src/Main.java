import model.Hotel;
import javax.swing.JOptionPane;
import model.Huesped;
import model.Habitacion;
import model.Reserva;
import model.Servicio;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("StayPlus", "900.123.456-7",
                "Cr 14 #14-50", "StayPlus.com", 355421456);

        int opcion = 0;
        while (opcion != 9) {
            String lecturaOpcion = JOptionPane.showInputDialog(null, """
                    ================ HOTEL STAYPLUS ================
                    1. Registrar Huésped
                    2. Registrar Habitación
                    3. Registrar Servicio Adicional
                    4. Crear Reserva
                    5. Agregar Servicio a una Reserva
                    6. Verificar Teléfono Perfecto de un Huésped
                    7. Consultar Ingresos por Fecha
                    8. Buscar Huésped
                    9. Salir
                    Seleccione una opción:
                    """);

            if (lecturaOpcion != null && !lecturaOpcion.equals("")) {
                opcion = Integer.parseInt(lecturaOpcion);
            } else {
                opcion = 9; // Si cierra la ventana, sale del ciclo
            }

            if (opcion == 1) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del huésped:");
                String doc = JOptionPane.showInputDialog("Ingrese el documento de identidad:");

                String telTexto = JOptionPane.showInputDialog("Ingrese el teléfono:");
                int tel = Integer.parseInt(telTexto);

                String email = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
                String pais = JOptionPane.showInputDialog("Ingrese el país de procedencia:");

                boolean exito = hotel.registrarHuesped(nombre, doc, tel, email, pais);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Huésped registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "El huésped ya se encuentra registrado.");
                }

            } else if (opcion == 2) {
                String numTexto = JOptionPane.showInputDialog("Ingrese el número de la habitación:");
                int num = Integer.parseInt(numTexto);

                String pisoTexto = JOptionPane.showInputDialog("Ingrese el piso:");
                int piso = Integer.parseInt(pisoTexto);

                String tipo = JOptionPane.showInputDialog("Ingrese el tipo (Individual / Doble / Suite):");

                String capTexto = JOptionPane.showInputDialog("Ingrese la capacidad máxima:");
                int cap = Integer.parseInt(capTexto);

                String precioTexto = JOptionPane.showInputDialog("Ingrese el precio por noche:");
                double precio = Double.parseDouble(precioTexto);

                String estado = "Disponible";

                boolean exito = hotel.registrarHabitacion(num, piso, tipo, cap, precio, estado);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Habitación registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La habitación ya existe.");
                }

            } else if (opcion == 3) {
                String cod = JOptionPane.showInputDialog("Ingrese el código del servicio:");
                String nom = JOptionPane.showInputDialog("Ingrese el nombre del servicio:");
                String desc = JOptionPane.showInputDialog("Ingrese la descripción:");

                String precioTexto = JOptionPane.showInputDialog("Ingrese el precio:");
                double precio = Double.parseDouble(precioTexto);

                String disp = "Disponible";

                boolean exito = hotel.registrarServicio(cod, nom, desc, precio, disp);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Servicio registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "El código del servicio ya existe.");
                }

            } else if (opcion == 4) {
                String docHuesped = JOptionPane.showInputDialog("Ingrese el documento del huésped:");
                Huesped huesped = hotel.buscarHuesped(docHuesped);

                if (huesped != null) {
                    String codReserva = JOptionPane.showInputDialog("Ingrese el código para la reserva:");

                    if (hotel.buscarReserva(codReserva) == null) {
                        String fRealizacion = JOptionPane.showInputDialog("Ingrese la fecha de realización (AAAA-MM-DD):");
                        String fEntrada = JOptionPane.showInputDialog("Ingrese la fecha de entrada (AAAA-MM-DD):");
                        String fSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida (AAAA-MM-DD):");

                        int noches = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches:"));
                        String metodoPago = JOptionPane.showInputDialog("Ingrese el método de pago:");

                        // Crear reserva base
                        boolean creada = hotel.crearReserva(codReserva, fRealizacion, fEntrada, fSalida, "Pendiente", metodoPago, 0.0, huesped);
                        Reserva res = hotel.buscarReserva(codReserva);

                        // Permite agregar una o más habitaciones
                        boolean agregarMas = true;
                        while (agregarMas) {
                            int numHab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la habitación a reservar:"));

                            if (hotel.validarDisponibilidadHabitacion(numHab, fEntrada, fSalida)) {
                                Habitacion hab = hotel.buscarHabitacion(numHab);
                                res.agregarHabitacion(hab);
                                JOptionPane.showMessageDialog(null, "Habitación " + numHab + " agregada a la reserva.");
                            } else {
                                JOptionPane.showMessageDialog(null, "La habitación no está disponible o no existe.");
                            }

                            int resp = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra habitación a esta reserva?", "Confirmar", JOptionPane.YES_NO_OPTION);
                            if (resp != JOptionPane.YES_OPTION) {
                                agregarMas = false;
                            }
                        }

                        // Calcular total acumulado aplicando reglas y descuento
                        res.calcularValorTotal(noches);
                        hotel.confirmarReserva(codReserva);

                        String mensajeFinal = "Reserva creada y confirmada con éxito.\nValor total: $" + res.getValorTotal();
                        if (huesped.getListHuespedReservas().size() > 1) {
                            mensajeFinal += "\n¡Se ha aplicado un 10% de descuento por ser Huésped Frecuente!";
                        }

                        JOptionPane.showMessageDialog(null, mensajeFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe una reserva con ese código.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El huésped no existe. Debe registrarlo primero.");
                }

            } else if (opcion == 5) {
                String codRes = JOptionPane.showInputDialog("Ingrese el código de la reserva:");
                Reserva res = hotel.buscarReserva(codRes);

                if (res != null) {
                    String codServ = JOptionPane.showInputDialog("Ingrese el código del servicio:");
                    Servicio serv = hotel.buscarServicio(codServ);

                    if (serv != null) {
                        res.agregarServicio(serv);
                        JOptionPane.showMessageDialog(null, "Servicio agregado a la reserva.\nNuevo total: $" + res.getValorTotal());
                    } else {
                        JOptionPane.showMessageDialog(null, "El servicio no existe.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La reserva no existe.");
                }

            } else if (opcion == 6) {
                String telTexto = JOptionPane.showInputDialog("Ingrese el teléfono del huésped a consultar:");
                int tel = Integer.parseInt(telTexto);

                String resultado = hotel.verificarTelefonoPerfecto(tel);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 7) {
                String fecha = JOptionPane.showInputDialog("Ingrese la fecha de realización a consultar:");
                double total = hotel.calcularIngresosPorFecha(fecha);
                JOptionPane.showMessageDialog(null, "Los ingresos acumulados para la fecha " + fecha + " son: $" + total);

            } else if (opcion == 8) {
                String doc = JOptionPane.showInputDialog("Ingrese el documento del huésped:");
                Huesped h = hotel.buscarHuesped(doc);

                if (h != null) {
                    JOptionPane.showMessageDialog(null, "Huésped encontrado:\n" + h.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "El huésped no existe.");
                }

            } else if (opcion == 9) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
            }
        }
    }
}
