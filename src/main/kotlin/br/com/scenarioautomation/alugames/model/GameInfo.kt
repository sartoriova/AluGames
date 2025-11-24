package br.com.scenarioautomation.alugames.model

data class GameInfo(val info: ApiSharkInfo) {
    override fun toString(): String {
        return info.toString()
    }
}