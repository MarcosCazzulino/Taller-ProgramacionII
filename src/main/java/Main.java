import javax.swing.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Donde se ejecuta el programa, con datos hardcodeados para pruebas
 */
public class Main {
    public static void main(String[] args) {
        GestionMundial gestion = new GestionMundial();
        gestion.configurarFasesEliminacion();

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

        Partido partido = new Partido(new Date(), Time.valueOf("20:00:00"), 90, 4, faseGrupos, mercedes);

        Participacion partPar = new Participacion(true, partido, sParaguay);
        Participacion partUSA = new Participacion(false, partido, sUSA);
        partido.agregarParticipacion(partPar);
        partido.agregarParticipacion(partUSA);

        sParaguay.agregarParticipacion(partPar);
        sUSA.agregarParticipacion(partUSA);

        Pais paisArbitro = new Pais("Brasil", "Verde y Amarillo");
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.PRINCIPAL, partido, new Arbitro("Wilton Sampaio", 1981, 12, paisArbitro)));
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.ASISTENTE1, partido, new Arbitro("Arb Asist 1", 1985, 8, paisArbitro)));
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.ASISTENTE2, partido, new Arbitro("Arb Asist 2", 1987, 7, paisArbitro)));
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.CUARTOARBITRO, partido, new Arbitro("Arb Cuarto", 1989, 5, paisArbitro)));
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.VARPRINCIPAL, partido, new Arbitro("Arb VAR 1", 1980, 10, paisArbitro)));
        partido.agregarArbitraje(new Arbitraje(CategoriaArbitro.VARASISTENTE, partido, new Arbitro("Arb VAR 2", 1984, 6, paisArbitro)));

        try {
            gestion.planificarPartido(faseGrupos, partido);
            System.out.println("Partido planificado con éxito en Atlanta.");
        } catch (IllegalStateException e) {
            System.out.println("No se pudo planificar el partido: " + e.getMessage());
        }

        System.out.println("---------- Eventos en el Partido ----------");
        gestion.registrarEvento(partido, TipoEvento.TARJETA_AMARILLA, 15, pulisic);
        gestion.registrarEvento(partido, TipoEvento.GOL, 28, almiron);
        gestion.registrarEvento(partido, TipoEvento.TARJETA_AMARILLA, 42, almiron);
        gestion.registrarEvento(partido, TipoEvento.GOL, 60, pulisic);
        gestion.registrarEvento(partido, TipoEvento.TARJETA_ROJA, 73, almiron);

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n----- Copa del Mundo 2026 | MEX CAN USA -----");
            System.out.println("1. Ver informes y estadísticas");
            System.out.println("2. Panel de Administración");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.println("Elige una opción:");

            try {
                opcion = Integer.parseInt(sc.nextLine());
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
        }
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
                opcion = Integer.parseInt(sc.nextLine());
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
                        String letra = sc.nextLine().trim();
                        boolean grupoEncontrado = false;
                        for (Grupo g : gestion.getGrupos()) {
                            if (g.getIdentificacion().equalsIgnoreCase(letra)) {
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
                        int numeroPartido = Integer.parseInt(sc.nextLine()) - 1;
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

    private static void menuAdministracion(Scanner sc, GestionMundial gestion) {
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("----- Panel de Administración -----");
            System.out.println("1. Registrar País");
            System.out.println("2. Registrar Sede");
            System.out.println("3. Registrar Estadio");
            System.out.println("4. Registrar Selección");
            System.out.println("5. Incorporar Jugador a una Selección");
            System.out.println("6. Asignar Director Técnico a una Selección");
            System.out.println("7. Asignar Arbitraje a un Partido");
            System.out.println("8. Registrar Evento en vivo para un Partido");
            System.out.println("9. Volver al Menú Principal");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        registrarPais(sc, gestion);
                        break;
                    case 2:
                        registrarSede(sc, gestion);
                        break;
                    case 3:
                        registrarEstadio(sc, gestion);
                        break;
                    case 4:
                        registrarSeleccion(sc, gestion);
                        break;
                    case 5:
                        registrarJugador(sc, gestion);
                        break;
                    case 6:
                        registrarDirectorTecnico(sc, gestion);
                        break;
                    case 7:
                        registrarArbitraje(sc, gestion);
                        break;
                    case 8:
                        registrarEvento(sc, gestion);
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentarlo");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    private static void registrarPais(Scanner sc, GestionMundial gestion) {
        System.out.print("Nombre del País: ");
        String nombre = sc.nextLine();
        System.out.print("Colores de la Bandera (Ej.: Blanco y Azul): ");
        String bandera = sc.nextLine();

        Pais nuevoPais = new Pais(nombre, bandera);
        System.out.println("¡País creado con éxito!");
    }

    private static void registrarSede(Scanner sc, GestionMundial gestion) {
        System.out.print("Nombre de la Ciudad (Sede): ");
        String ciudad = sc.nextLine();
        System.out.print("Altura sobre el nivel del mar (metros): ");
        float altura = sc.nextFloat();
        sc.nextLine();
        System.out.print("Clima: ");
        String clima = sc.nextLine();
        System.out.print("Zona Horaria (Ej: UTC-3): ");
        String zona = sc.nextLine();

        System.out.print("Nombre del País al que pertenece esta sede: ");
        String nombrePais = sc.nextLine();
        Pais paisAsociado = new Pais(nombrePais, "Bandera de " + nombrePais);

        Sede nuevaSede = new Sede(paisAsociado, ciudad, altura, clima, zona);
        paisAsociado.agregarSede(nuevaSede);
        System.out.println("¡Sede registrada exitosamente!");
    }

    private static void registrarEstadio(Scanner sc, GestionMundial gestion) {
        System.out.print("Nombre del Estadio: ");
        String nombreEstadio = sc.nextLine();
        System.out.print("Capacidad de espectadores: ");
        int capacidad = Integer.parseInt(sc.nextLine());

        System.out.print("¿En qué ciudad/sede se encuentra el estadio?: ");
        String nombreCiudad = sc.nextLine();

        Sede sedeAsociada = new Sede(null, nombreCiudad, 0, "Desconocido", "UTC");

        Estadio nuevoEstadio = new Estadio(nombreEstadio, capacidad, sedeAsociada);
        sedeAsociada.agregarEstadio(nuevoEstadio);
        System.out.println("¡Estadio creado exitosamente!");
    }

    private static void registrarSeleccion(Scanner sc, GestionMundial gestion) {
        System.out.print("Nombre de la Federación (Ej: AFA, FFF): ");
        String nombreFed = sc.nextLine().toUpperCase();
        System.out.print("Camiseta Principal: ");
        String principal = sc.nextLine();
        System.out.print("Camiseta Secundaria: ");
        String secundaria = sc.nextLine();
        System.out.print("¿Es cabeza de grupo? (Sí/No): ");
        String cabezaScan = sc.nextLine().toLowerCase().trim();
        boolean cabezaBool = cabezaScan.equals("si") || cabezaScan.equals("sí");
        System.out.print("Ranking FIFA: ");
        int ranking = Integer.parseInt(sc.nextLine());

        if (gestion.getGrupos().isEmpty()) {
            System.out.println("No hay grupos creados");
            return;
        }

        Grupo grupoDestino = gestion.getGrupos().get(0);

        System.out.print("País de la Selección: ");
        String nombrePais = sc.nextLine();
        System.out.println("Colores de la bandera: ");
        String bandera = sc.nextLine();
        Pais pais = new Pais(nombrePais, bandera);

        Seleccion nuevaSel = new Seleccion(nombreFed, principal, secundaria, cabezaBool, ranking, grupoDestino, pais);
        gestion.registrarSeleccion(nuevaSel);
        grupoDestino.agregarSeleccion(nuevaSel);
    }

    private static void registrarJugador(Scanner sc, GestionMundial gestion) {
        Seleccion sel = seleccionarSeleccion(sc, gestion);
        if (sel == null) return;

        System.out.print("Nombre del Jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Año de Nacimiento: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Número de Dorsal: ");
        int dorsal = Integer.parseInt(sc.nextLine());

        System.out.println("Posición: 1.ARQUERO | 2.DEFENSOR | 3.MEDIOCAMPISTA | 4.DELANTERO");
        System.out.println("Elija una opción: ");
        int posOpt = Integer.parseInt(sc.nextLine());
        Posicion pos = Posicion.DELANTERO;
        if (posOpt == 1) pos = Posicion.ARQUERO;
        if (posOpt == 2) pos = Posicion.DEFENSOR;
        if (posOpt == 3) pos = Posicion.MEDIOCAMPISTA;

        System.out.print("Peso (kg): ");
        float peso = sc.nextFloat();
        System.out.print("Altura (cm): ");
        float altura = sc.nextFloat();

        Jugador nuevoJugador = new Jugador(nombre, anio, dorsal, pos, peso, altura);
        gestion.agregarJugadorASeleccion(sel, nuevoJugador);
    }

    private static void registrarDirectorTecnico(Scanner sc, GestionMundial gestion) {
        Seleccion sel = seleccionarSeleccion(sc, gestion);
        if (sel == null) return;

        System.out.print("Nombre del DT: ");
        String nombreDT = sc.nextLine();
        System.out.print("Año de Nacimiento: ");
        int nacDT = Integer.parseInt(sc.nextLine());
        System.out.print("Año de Nombramiento en el cargo: ");
        int nombramiento = Integer.parseInt(sc.nextLine());

        DirectorTecnico nuevoDT = new DirectorTecnico(nombreDT, nacDT, nombramiento);
        gestion.agregarDTASeleccion(sel, nuevoDT);
    }

    private static void registrarArbitraje(Scanner sc, GestionMundial gestion) {
        if (gestion.getPartidos().isEmpty()) {
            System.out.println("No hay partidos en el fixture para asignar árbitros.");
            return;
        }
        Partido partido = gestion.getPartidos().get(0);

        System.out.print("Nombre del Árbitro: ");
        String nombreArb = sc.nextLine();
        System.out.println("Año de nacimiento: ");
        int anioNac = Integer.parseInt(sc.nextLine());
        System.out.print("Años de Experiencia: ");
        int exp = Integer.parseInt(sc.nextLine());
        System.out.print("País de origen del Árbitro: ");
        Pais paisArb = new Pais(sc.nextLine(), "Bandera");

        Arbitro arbitro = new Arbitro(nombreArb, anioNac, exp, paisArb);

        System.out.println("Roles: 1.PRINCIPAL | 2.ASISTENTE1 | 3.ASISTENTE2 | 4.CUARTOARBITRO | 5.VARPRINCIPAL | 6.VARASISTENTE");
        System.out.println("Seleccione una opción:");
        int rolOpt = Integer.parseInt(sc.nextLine());

        CategoriaArbitro rol = CategoriaArbitro.PRINCIPAL;
        if (rolOpt == 2) rol = CategoriaArbitro.ASISTENTE1;
        if (rolOpt == 3) rol = CategoriaArbitro.ASISTENTE2;
        if (rolOpt == 4) rol = CategoriaArbitro.CUARTOARBITRO;
        if (rolOpt == 5) rol = CategoriaArbitro.VARPRINCIPAL;
        if (rolOpt == 6) rol = CategoriaArbitro.VARASISTENTE;

        Arbitraje nuevoArbitraje = new Arbitraje(rol, partido, arbitro);
        partido.agregarArbitraje(nuevoArbitraje);
        arbitro.getArbitrajes().add(nuevoArbitraje);

        System.out.println("Árbitro asignado como " + rol + " para el encuentro");
    }

    private static void registrarEvento(Scanner sc, GestionMundial gestion) {
        if (gestion.getPartidos().isEmpty()) {
            System.out.println("No hay partidos en juego.");
            return;
        }
        Partido pActual = gestion.getPartidos().get(0);

        System.out.println("Eventos: 1.Gol | 2.Tarjeta Amarilla | 3.Tarjeta Roja | 4.Doble Amarilla | 5.Penal Cometido | 6.Penal Convertido | 7.Penal Errado | 8.Sustitución | 9.Lesión");
        int tipoOpt = Integer.parseInt(sc.nextLine());
        TipoEvento tipo = TipoEvento.GOL;
        if (tipoOpt == 2) tipo = TipoEvento.TARJETA_AMARILLA;
        if (tipoOpt == 3) tipo = TipoEvento.TARJETA_ROJA;
        if (tipoOpt == 4) tipo = TipoEvento.DOBLE_AMARILLA;
        if (tipoOpt == 5) tipo = TipoEvento.PENAL_COMETIDO;
        if (tipoOpt == 6) tipo = TipoEvento.PENAL_CONVERTIDO;
        if (tipoOpt == 7) tipo = TipoEvento.PENAL_ERRADO;
        if (tipoOpt == 8) tipo = TipoEvento.SUSTITUCION;
        if (tipoOpt == 9) tipo = TipoEvento.LESION;

        System.out.print("Minuto: ");
        int min = Integer.parseInt(sc.nextLine());

        System.out.println("Jugadores convocados:");
        ArrayList<Jugador> jugadoresPartido = new ArrayList<>();
        int index = 1;
        for (Participacion part : pActual.getParticipaciones()) {
            for (Jugador j : part.getSeleccion().getJugadores()) {
                jugadoresPartido.add(j);
                System.out.println(index + ". " + j.getNombre() + " (" + part.getSeleccion().getNombreFederacion() + ")");
                index++;
            }
        }

        System.out.print("Seleccione el número de jugador: ");
        int jugSel = Integer.parseInt(sc.nextLine());

        if (jugSel >= 0 && jugSel < jugadoresPartido.size()) {
            gestion.registrarEvento(pActual, tipo, min, jugadoresPartido.get(jugSel));
        } else {
            System.out.println("Selección inválida.");
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
        int opcion = Integer.parseInt(sc.nextLine()) - 1;
        if (opcion >= 0 && opcion < gestion.getSelecciones().size()) {
            return gestion.getSelecciones().get(opcion);
        }
        System.out.println("Esa selección no existe o no está registrada.");
        return null;
    }
}
