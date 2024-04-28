package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Вес")
data class Weight(
    var imperial: String,
    var metric: String,
)