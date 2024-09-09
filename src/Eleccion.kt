class Eleccion(){
    private val listaCandidatos = mutableListOf<Candidato>()
    fun agregarCandidato(candidato: Candidato){
        listaCandidatos.add(candidato)
    }
    fun votar(candidato: Candidato,medio:String){
        when(medio){
            "internet"->{
                candidato.votosInternet++
            }"radio"->{
                candidato.votosRadio++
            }"television"->{
                candidato.votosTelevision++
            }
        }
    }

    fun vaciarUrnas(){
        for (candidato in listaCandidatos){
            candidato.votosInternet =0
            candidato.votosRadio =0
            candidato.votosTelevision=0
        }
    }

    fun calcularTotalVotos():Int{
        return listaCandidatos.sumOf { it.obtenerTotalVotos() }
    }

    fun calcularCostoPromedioCampaña():Double{
        var totalCosto = listaCandidatos.sumOf { it.calcularCostoCampaña() }
        val totalVotos = calcularTotalVotos()
        return if (totalVotos>0) {totalCosto/totalVotos} else 0.0
    }
    fun Ganador(){
        val maxVotos = listaCandidatos.maxOf { it.obtenerTotalVotos() }
        val candidatoMaxVotos = listaCandidatos.filter { it.obtenerTotalVotos() == maxVotos }

        if (candidatoMaxVotos.size == 1){
            println("El ganador es el candidato = ${candidatoMaxVotos[0].nombre}")
        }else{
            val nombres = candidatoMaxVotos.joinToString(",") { it.nombre }
            println("Hay un empate entre ${nombres}")
        }
    }
}