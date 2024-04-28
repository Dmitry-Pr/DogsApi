package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Собака")
data class DogModel(
    var breeds: List<Breed>,
    var id: String,
    var url: String,
    var width: Int,
    var height: Int,
)
