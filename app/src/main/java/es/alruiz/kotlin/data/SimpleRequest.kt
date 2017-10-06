package es.alruiz.kotlin.data

import java.net.URL

/**
 * Siempre request.
 */
class SimpleRequest(private val url: String) {

    fun run(): String {
        return URL(url).readText()
    }

}