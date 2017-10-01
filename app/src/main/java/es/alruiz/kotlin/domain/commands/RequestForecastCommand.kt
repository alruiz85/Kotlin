package es.alruiz.kotlin.domain.commands

import es.alruiz.kotlin.domain.mappers.ForecastDataMapper
import es.alruiz.kotlin.domain.model.ForecastList
import es.alruiz.kotlin.data.ForecastRequest

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}