package br.com.scenarioautomation.alugames.model

data class ApiSharkInfo(val title:String, val thumb:String)
//criado para nao precisar usar o SerializedName!
//data class ja implementam equals e toString, mas podem ser sobrescritos, se necessario