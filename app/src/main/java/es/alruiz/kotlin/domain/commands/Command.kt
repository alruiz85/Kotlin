package es.alruiz.kotlin.domain.commands


public interface Command<out T> {
    fun execute(): T
}