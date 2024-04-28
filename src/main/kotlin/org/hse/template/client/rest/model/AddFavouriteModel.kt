package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Добавить в избранное")
data class AddFavouriteModel (
    var image_id: String,
    var sub_id: String,
)