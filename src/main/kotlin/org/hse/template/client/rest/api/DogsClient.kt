package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.AddFavouriteModel
import org.hse.template.client.rest.model.AddFavouriteResponseModel
import org.hse.template.client.rest.model.DogModel
import org.hse.template.client.rest.model.FavouriteModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "dogs")
interface DogsClient {

    @GetMapping("images/search")
    fun getDogs(
        @RequestParam limit: Int,
        @RequestParam api_key: String
    ): List<DogModel>

    @GetMapping("images/{id}")
    fun getDogById(
        @PathVariable id: String
    ): DogModel

    @GetMapping("favourites")
    fun getFavouritesByUser(
        @RequestParam sub_id: String,
        @RequestParam api_key: String
    ): List<FavouriteModel>

    @PostMapping("favourites")
    fun addFavourite(
        @RequestParam api_key: String,
        @RequestBody addFavouriteModel: AddFavouriteModel,
    ): AddFavouriteResponseModel
}
