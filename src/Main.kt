fun main() {

    val candidato1 = Candidato("Julian")
    val candidato2 = Candidato("David")
    val candidato3 = Candidato("Alex")

    val eleccion = Eleccion()
    eleccion.agregarCandidato(candidato1)
    eleccion.agregarCandidato(candidato2)
    eleccion.agregarCandidato(candidato3)


    do {


        print(
            """
    |1.	Votar por el candidato de su elección.
    |2.	Calcular el costo de campaña de un candidato dependiendo de la influencia publicitaria de cada voto.
    |3.	Vaciar todas las urnas de la votación.
    |4.	Conocer el número total de votos. RESULTADOS
    |5.	Porcentaje de votos obtenidos por cada candidato. 
    |6.	Costo promedio de campaña en las elecciones.
    |7. Salir
    |
    |Selecciona una opcion (1/6)
    |
""".trimMargin()
        )
        var opcion = readln().toInt()

        try {
            when (opcion) {
                1 -> {
                    print(
                        """
                    ¿Por cual candidato desea Votar? (1-3)
                    1. Candidato #1 (Julian)
                    2. Candidato #2 (David)
                    3. Candidato #3 (Alex)
                    
                """.trimIndent()
                    )
                    var opcion2: Int = readln().toInt()
                    when (opcion2) {
                        1 -> {
                            print(
                                """
                    ¿Por cual Medio se influencio? (1-3)
                    1. Internet 
                    2. Radio 
                    3. Television
                    
                """.trimIndent()
                            )
                            var opcion3: Int = readln().toInt()
                            when (opcion3) {
                                1 -> eleccion.votar(candidato1, "internet")
                                2 -> eleccion.votar(candidato1, "radio")
                                3 -> eleccion.votar(candidato1, "television")
                            }
                        }

                        2 -> {
                            print(
                                """
                    ¿Por cual Medio desea Votar? (1-3)
                    1. Internet 
                    2. Radio 
                    3. Television
                     
                """.trimIndent()
                            )
                            var opcion3: Int = readln().toInt()
                            when (opcion3) {
                                1 -> eleccion.votar(candidato2, "internet")
                                2 -> eleccion.votar(candidato2, "radio")
                                3 -> eleccion.votar(candidato2, "television")
                            }
                        }

                        3 -> {
                            print(
                                """
                    ¿Por cual Medio desea Votar? (1-3)
                    1. Internet 
                    2. Radio 
                    3. Television 
                    
                """.trimIndent()
                            )
                            var opcion3: Int = readln().toInt()
                            when (opcion3) {
                                1 -> eleccion.votar(candidato3, "internet")
                                2 -> eleccion.votar(candidato3, "radio")
                                3 -> eleccion.votar(candidato3, "television")
                            }
                        }
                    }
                }

                2 -> {
                    println("Costo promedio de campaña de ${candidato1.nombre} = ${candidato1.calcularCostoCampaña()}")
                    println("Costo promedio de campaña de ${candidato2.nombre} = ${candidato2.calcularCostoCampaña()}")
                    println("Costo promedio de campaña de ${candidato3.nombre} = ${candidato3.calcularCostoCampaña()}")
                    println("-------------------------------------------------------------------")
                }
                3 -> {
                    eleccion.vaciarUrnas()
                }
                4 -> {
                    println("Total de Votos ${eleccion.calcularTotalVotos()}")
                    println("Candidato ${candidato1.nombre} TotalVotos: ${candidato1.obtenerTotalVotos()}")
                    println("Candidato ${candidato2.nombre} TotalVotos: ${candidato2.obtenerTotalVotos()}")
                    println("Candidato ${candidato3.nombre} TotalVotos: ${candidato3.obtenerTotalVotos()}")
                    eleccion.Ganador()
                    println("-----------------------------------------------------------------------")
                }
                5 -> {
                    print("""
                        |Porcentaje de votos 
                        |Candidato: ${candidato1.nombre} //  ${candidato1.porcentajeVotos(eleccion.calcularTotalVotos())} %
                        |Candidato: ${candidato2.nombre} //  ${candidato2.porcentajeVotos(eleccion.calcularTotalVotos())} %
                        |Candidato: ${candidato3.nombre} //  ${candidato3.porcentajeVotos(eleccion.calcularTotalVotos())} %
                        |--------------------------------------------------------------------
                    """.trimMargin())
                }
                6 -> {
                    println("Costo promedio campaña de elecciones: ${eleccion.calcularCostoPromedioCampaña()}")
                }
                7->{
                    print("")
                }

            }
        } catch (e: NumberFormatException) {
            println("Entrada no válida. Por favor, ingresa un número.")

        } catch (e: Exception) {
            println("Error inesperado ${e.message}")
        } catch (e: NullPointerException) {
            print("El valor no puede ser nulo")
        }


    }while (opcion!=7)
}