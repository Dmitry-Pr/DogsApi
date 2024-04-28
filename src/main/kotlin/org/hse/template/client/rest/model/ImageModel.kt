package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Изображение")
data class ImageModel (
    var id: String,
    var url: String,
)