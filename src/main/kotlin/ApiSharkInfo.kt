package org.example

data class ApiSharkInfo(val title:String, val thumb:String)
//criado para nao precisar usar o SerializedName!
//elas ja implementam equals e toString, mas podem ser sobrescritos, se necessario