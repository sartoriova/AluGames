package org.example

data class GameInfo(val info: ApiSharkInfo) {
    override fun toString(): String {
        return info.toString()
    }
}