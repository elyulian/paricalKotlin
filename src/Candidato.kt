open class Candidato(var nombre:String , var votosInternet:Int=0,var votosRadio:Int=0,var votosTelevision:Int=0){

    open fun calcularCostoCampaña():Double{
        val internetTotal = votosInternet*700000
        val radioTotal = votosRadio*200000
        val televisionTotal = votosTelevision*600000
        return (internetTotal+radioTotal+televisionTotal).toDouble()
    }
    fun obtenerTotalVotos():Int{
        return votosInternet+votosRadio+votosTelevision
    }
    fun porcentajeVotos(totalVotos:Int):Double{
        return if (totalVotos>0){
            (obtenerTotalVotos().toDouble()/totalVotos)*100
        }else{
            0.0
        }
    }

}