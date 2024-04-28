package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Любимая собака")
data class FavouriteModel(
    var id: String,
    var user_id: String,
    var image_id: String,
    var sub_id: String,
    var created_at: String,
    var image: ImageModel
)
