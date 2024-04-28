package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Порода")
data class Breed(
    var weight: Weight,
    var height: Height,
    var id: Int,
    var name: String,
    var bred_for: String?,
    var breed_group: String?,
    var life_span: String?,
    var temperament: String?,
    var reference_image_id: String?,
)