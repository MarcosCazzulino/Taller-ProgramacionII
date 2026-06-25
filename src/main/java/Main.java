import javax.swing.*;
import javax.xml.transform.Source;
import java.sql.Time;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionMundial gestion = new GestionMundial();
        gestion.configurarFasesEliminacion();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("----- Copa del Mundo 2026 | MEX CAN USA -----");
            System.out.println("1. Ver informes y estadísticas");
            System.out.println("2. Panel de Administración");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.println("Elige una opción:");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        menuInformes(sc, gestion);
                        break;
                    case 2:
                        menuAdministracion(sc, gestion);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa... ¡Disfruta la Copa del Mundo!");
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentar");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número, por favor");
            }
            sc.close();
        }

        // Estados Unidos
        Pais estadosUnidos = new Pais("Estados Unidos", "Azul, Blanco y Rojo");
        // --- New York
        Sede newYork = new Sede(estadosUnidos, "New York", 10, "Continental húmedo", "UTC-4");
        Estadio metLife = new Estadio("MetLife Stadium", 82566, newYork);
        newYork.agregarEstadio(metLife);

        // --- Atlanta
        Sede atlanta = new Sede(estadosUnidos, "Atlanta", 320, "Subtropical húmedo", "UTC-5");
        Estadio mercedes = new Estadio("Mercedes-Benz Stadium", 71000, atlanta);
        atlanta.agregarEstadio(mercedes);

        // --- Boston
        Sede boston = new Sede(estadosUnidos, "Boston", 146, "Continental húmedo", "UTC-4");
        Estadio gillette = new Estadio("Gillette Stadium", 68756, boston);
        boston.agregarEstadio(gillette);

        // Canadá
        Pais canada = new Pais("Canadá", "Blanco y Rojo");
        // --- Vancouver
        Sede vancouver = new Sede(canada, "Vancouver", 152, "Oceánico moderado", "UTC-8");
        Estadio bcPlace = new Estadio("BC Place", 54500, vancouver);
        vancouver.agregarEstadio(bcPlace);

        // --- Toronto
        Sede toronto = new Sede(canada, "Toronto", 76, "Continental húmedo", "EST (Hora del este)");
        Estadio bmoField = new Estadio("BMO Field", 45736, toronto);
        toronto.agregarEstadio(bmoField);

        // Mexico
        Pais mexico = new Pais("México", "Rojo, Blanco y Verde");
        // --- CDMX
        Sede cdmx = new Sede(mexico, "Ciudad de México", 2240, "Templado subhúmedo", "UTC-6");
        Estadio azteca = new Estadio("Estadio Azteca", 87000, cdmx);
        cdmx.agregarEstadio(azteca);

        // --- Guadalajara
        Sede guadalajara = new Sede(mexico, "Guadalajara", 1536, "Subtropical subhúmedo", "UTC-6");
        Estadio akron = new Estadio("Estadio Akron", 49850, guadalajara);
        guadalajara.agregarEstadio(akron);

        // --- Monterrey
        Sede monterrey = new Sede(mexico, "Monterrey", 540, "Semiárido cálido", "UTC-6");
        Estadio bbva = new Estadio("Estadio BBVA", 53500, monterrey);
        monterrey.agregarEstadio(bbva);

        Fase faseGrupos = new Fase(NombreFase.GRUPOS);
        Grupo grupoA = new Grupo("A", "Primer grupo de la fase de grupos", faseGrupos);
        faseGrupos.agregarGrupo(grupoA);
        gestion.agregarGrupo(grupoA);

        // Selección estadounidense
        Seleccion sUSA = new Seleccion("USA", "Blanca y Roja", "Azul", true, 14, grupoA, estadosUnidos);
        gestion.registrarSeleccion(sUSA);

        Jugador pulisic = new Jugador("Christian Pulisic", 1998, 10, Posicion.DELANTERO, 73, 178);
        gestion.agregarJugadorASeleccion(sUSA, pulisic);

        DirectorTecnico pochettino = new DirectorTecnico("Mauricio Pochettino", 1972, 2024);
        gestion.agregarDTASeleccion(sUSA, pochettino);

        grupoA.agregarSeleccion(sUSA);

        // Selección paraguaya
        Pais paraguay = new Pais("Paraguay", "Blanco, Rojo y Azul");
        Seleccion sParaguay = new Seleccion("PAR", "Blanca y Roja", "Negra", false, 37, grupoA, paraguay);
        gestion.registrarSeleccion(sParaguay);

        Jugador almiron = new Jugador("Miguel Almirón", 1994, 10, Posicion.MEDIOCAMPISTA, 63, 174);
        gestion.agregarJugadorASeleccion(sParaguay, almiron);

        DirectorTecnico alfaro = new DirectorTecnico("Gustavo Alfaro", 1962, 2024);
        gestion.agregarDTASeleccion(sParaguay, alfaro);

        grupoA.agregarSeleccion(sParaguay);

        Partido primerPartido = new Partido(new Date(), Time.valueOf("16:00:00"), 90, 5, faseGrupos, metLife);

        Participacion partUSA = new Participacion(true, primerPartido, sUSA);
        Participacion partPar = new Participacion(false, primerPartido, sParaguay);
        primerPartido.agregarParticipacion(partUSA);
        primerPartido.agregarParticipacion(partPar);

        Pais paisesBajos = new Pais("Países Bajos", "Rojo, Blanco y Azul");
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.PRINCIPAL, primerPartido, new Arbitro("Danny Makkelie", 1983, 15, paisesBajos)));
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.ASISTENTE1, primerPartido, new Arbitro("Árbitro 2", 1988, 10, paisesBajos)));
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.ASISTENTE2, primerPartido, new Arbitro("Árbitro 3", 1985, 9, paisesBajos)));
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.CUARTOARBITRO, primerPartido, new Arbitro("Árbitro 4", 1981, 11, paisesBajos)));
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.VARPRINCIPAL, primerPartido, new Arbitro("Árbitro 5", 1979, 17, paisesBajos)));
        primerPartido.agregarArbitraje(new Arbitraje(CategoriaArbitro.VARASISTENTE, primerPartido, new Arbitro("Árbitro 6", 1989, 8, paisesBajos)));

        try {
            gestion.planificarPartido(faseGrupos, primerPartido);
            System.out.println("Partido planifica con éxito");
        } catch (IllegalStateException e) {
            System.out.println("No se pudo planificar el partido: " + e.getMessage());
        }

        // Simulación de eventos
        System.out.println("---------- Eventos en el Partido ----------");
        gestion.registrarEvento(primerPartido, TipoEvento.GOL, 11, pulisic);
        gestion.registrarEvento(primerPartido, TipoEvento.TARJETA_AMARILLA, 24, almiron);
        gestion.registrarEvento(primerPartido, TipoEvento.GOL, 32, almiron);
        gestion.registrarEvento(primerPartido, TipoEvento.TARJETA_ROJA, 59, pulisic);
        gestion.registrarEvento(primerPartido, TipoEvento.DOBLE_AMARILLA, 88,almiron);
    }

    private static void menuInformes(Scanner sc, GestionMundial gestion) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("----- Informes y Estadísticas -----");
            System.out.println("1. Tabla de posiciones por Grupo");
            System.out.println("2. Tabla de resultados por Selección");
            System.out.println("3. Ranking de Goleadores");
            System.out.println("4. Informe disciplinario de Selección");
            System.out.println("5. Ficha técnica de Partido");
            System.out.println("6. Volver al Menú Principal");
            System.out.println("");
            System.out.println("Seleccione una opción:");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        if (gestion.getGrupos().isEmpty()) {
                            System.out.println("No hay grupos registrados.");
                            break;
                        }
                        System.out.println("Grupos disponibles:");
                        for (Grupo g : gestion.getGrupos()) {
                            System.out.println("- Grupo " + g.getIdentificacion());
                        }

                        System.out.println("Ingresa el grupo que quieres ver: ");
                        String letra = sc.nextLine().toLowerCase();
                        boolean grupoEncontrado = false;
                        for (Grupo g : gestion.getGrupos()) {
                            if (g.getIdentificacion().equals(letra)) {
                                g.mostrarTablaPosiciones();
                                grupoEncontrado = true;
                                break;
                            }
                        }

                        if (!grupoEncontrado) System.out.println("Este grupo no está disponible o no existe");
                        break;

                    case 2:
                        Seleccion selResultados = seleccionarSeleccion(sc, gestion);
                        if (selResultados != null) {
                            gestion.resultadosSeleccion(selResultados);
                        }
                        break;

                    case 3:
                        gestion.rankingGoleadores();
                        break;

                    case 4:
                        Seleccion selDisc = seleccionarSeleccion(sc, gestion);
                        if (selDisc != null) {
                            gestion.informeDiscSelec(selDisc);
                        }

                        break;

                    case 5:
                        if (gestion.getPartidos().isEmpty()) {
                            System.out.println("No hay partidos planificados en el sistema.");
                            break;
                        }

                        System.out.println("Partidos planificados:");
                        for (int i = 0; i < gestion.getPartidos().size(); i++) {
                            Partido p = gestion.getPartidos().get(i);
                            String local = p.getParticipaciones().get(0).getSeleccion().getNombreFederacion();
                            String visitante = p.getParticipaciones().get(1).getSeleccion().getNombreFederacion();
                            System.out.println((i + 1) + ") " + local + " vs " + visitante + " - Estadio: " + p.getEstadio().getNombre());
                        }

                        System.out.println("Seleccione el partido que quiere ver: ");
                        int numeroPartido = sc.nextInt() - 1;
                        if (numeroPartido >= 0 && numeroPartido < gestion.getPartidos().size()) {
                            gestion.getPartidos().get(numeroPartido).fichaTecnica();
                        } else {
                            System.out.println("Ese partido no está disponible");
                        }
                        break;

                    case 6:
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentar");

                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    private static void menuAdministracion(Scanner sc, GestionMundial gestion){
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("----- Panel de Administración -----");
            System.out.println("1. Registrar nueva Selección");
            System.out.println("2. Incorporar un nuevo Jugador");
            System.out.println("3. Registrar Evento en vivo");
            System.out.println("4. Volver al Menú Principal");
            System.out.println("");
            System.out.println("Seleccione una opción:");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre de la Federación (Ej: AFA): ");
                        String nombreFed = sc.nextLine().toUpperCase();
                        System.out.println("Color Camiseta Principal: ");
                        String camPrinc = sc.nextLine();
                        System.out.println("Color Camiseta Secundaria: ");
                        String camSec = sc.nextLine();
                        System.out.println("¿Es cabeza de Grupo? (Sí/No):");
                        String cabezaScan = sc.nextLine();
                        boolean cabezaBool = cabezaScan.toLowerCase().trim().equals("si") || cabezaScan.toLowerCase().trim().equals("sí") ? true : false;
                        System.out.println("Ranking FIFA (Número):");
                        int rank = sc.nextInt();
                        sc.nextLine();

                        if (gestion.getGrupos().isEmpty()) {
                            System.out.println("Para agregar una selección debe haber un grupo creado");
                            break;
                        }
                        Grupo gDestino = gestion.getGrupos().get(0);
                        System.out.println("Nombre del País de origen: ");
                        String nomPais = sc.nextLine();
                        System.out.println("Colores de la Bandera (Ej.: Azul y Blanco):");
                        String nuevaBandera = sc.nextLine();
                        Pais nuevoPais = new Pais(nomPais, nuevaBandera);

                        Seleccion nuevaSel = new Seleccion(nombreFed, camPrinc, camSec, cabezaBool, rank, gDestino, nuevoPais);
                        gestion.registrarSeleccion(nuevaSel);
                        gDestino.agregarSeleccion(nuevaSel);
                        break;

                    case 2:
                        Seleccion selDestino = seleccionarSeleccion(sc, gestion);
                        if (selDestino == null) break;

                        System.out.println("Nombre completo del Jugador: ");
                        String nomJug = sc.nextLine();
                        System.out.println("Año de nacimiento: ");
                        int anioNac = sc.nextInt();
                        System.out.println("Número de Dorsal: ");
                        int dorsal = sc.nextInt();
                        System.out.println("POSICIONES: 1. Arquero | 2. Defensor | 3. Mediocampista | 4. Delantero");
                        System.out.println("Seleccione una opción: ");
                        int posOpcion = sc.nextInt();

                        Posicion pos = Posicion.DELANTERO;
                        if (posOpcion == 1) pos = Posicion.ARQUERO;
                        if (posOpcion == 2) pos = Posicion.DEFENSOR;
                        if (posOpcion == 3) pos = Posicion.MEDIOCAMPISTA;

                        System.out.println("Peso (kg):");
                        float peso = sc.nextFloat();
                        System.out.println("Altura (cm):");
                        float altura = sc.nextFloat();
                        sc.nextLine();

                        Jugador nuevoJugador = new Jugador(nomJug, anioNac, dorsal, pos, peso, altura);
                        gestion.agregarJugadorASeleccion(selDestino, nuevoJugador);
                        break;

                    case 3:
                        if (gestion.getPartidos().isEmpty()) {
                            System.out.println("No hay partidos cargados");
                            break;
                        }

                        Partido pActual = gestion.getPartidos().get(0);
                        System.out.println("Registrando evento en el partido: " +
                                pActual.getParticipaciones().get(0).getSeleccion().getNombreFederacion() + " vs " +
                                pActual.getParticipaciones().get(1).getSeleccion().getNombreFederacion());

                        System.out.println("Eventos: 1.Gol | 2.Tarjeta Amarilla | 3.Tarjeta Roja | 4.Doble Amarilla | 5.Penal Cometido | 6.Penal Convertido | 7.Penal Errado | 8.Sustitución | 9.Lesión");
                        System.out.print("Seleccione el evento: ");
                        int tipoOpt = sc.nextInt();
                        TipoEvento tipo = TipoEvento.GOL;
                        if (tipoOpt == 2) tipo = TipoEvento.TARJETA_AMARILLA;
                        if (tipoOpt == 3) tipo = TipoEvento.TARJETA_ROJA;
                        if (tipoOpt == 4) tipo = TipoEvento.DOBLE_AMARILLA;
                        if (tipoOpt == 5) tipo = TipoEvento.PENAL_COMETIDO;
                        if (tipoOpt == 6) tipo = TipoEvento.PENAL_CONVERTIDO;
                        if (tipoOpt == 7) tipo = TipoEvento.PENAL_ERRADO;
                        if (tipoOpt == 8) tipo = TipoEvento.SUSTITUCION;
                        if (tipoOpt == 9) tipo = TipoEvento.LESION;

                        System.out.print("Minuto del evento: ");
                        int min = sc.nextInt();

                        System.out.println("Jugadores en el partido:");
//                        int idx = 1;
//                        ArrayList<Jugador> jugadoresPartido = new ArrayList<>();
//                        for (Participacion part : pActual.getParticipaciones()) {
//                            for (Jugador j : part.getSeleccion().getNominaJugadoresO_MetodoEquivalente()) {
//                                jugadoresPartido.add(j);
//                                System.out.println(idx + ". " + j.getNombre() + " (" + part.getSeleccion().getNombreFederacion() + ")");
//                                idx++;
//                            }
//                        }
//
//                        jugadoresPartido.clear();
                        int idx = 1;
                        ArrayList<Jugador> jugadoresPartido = new ArrayList<>();
                        for (Participacion part : pActual.getParticipaciones()) {
                            for (Jugador j : part.getSeleccion().getJugadores()) {
                                jugadoresPartido.add(j);
                                System.out.println(idx + ". " + j.getNombre() + " (" + part.getSeleccion().getNombreFederacion() + ")");
                                idx++;
                            }
                        }

                        System.out.print("Seleccione el número de jugador: ");
                        int jugSel = sc.nextInt() - 1;

                        if (jugSel >= 0 && jugSel < jugadoresPartido.size()) {
                            gestion.registrarEvento(pActual, tipo, min, jugadoresPartido.get(jugSel));
                        } else {
                            System.out.println("Ese jugador no existe o no está en este partido.");
                        }
                        break;

                    case 4:
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentarlo");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    private static Seleccion seleccionarSeleccion(Scanner sc, GestionMundial gestion) {
        if (gestion.getSelecciones().isEmpty()) {
            System.out.println("No hay selecciones registradas.");
            return null;
        }
        System.out.println("Selecciones registradas:");
        for (int i = 0; i < gestion.getSelecciones().size(); i++) {
            System.out.println((i + 1) + ". " + gestion.getSelecciones().get(i).getNombreFederacion());
        }
        System.out.print("Elija el número de la selección: ");
        int opcion = sc.nextInt() - 1;
        if (opcion >= 0 && opcion < gestion.getSelecciones().size()) {
            return gestion.getSelecciones().get(opcion);
        }
        System.out.println("Esa selección no existe o no está registrada.");
        return null;
    }
}
