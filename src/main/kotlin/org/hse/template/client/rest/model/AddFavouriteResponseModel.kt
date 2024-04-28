package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Ответ на добавление в избранное")
data class AddFavouriteResponseModel(
    var message: String,
    var id: Int,
)