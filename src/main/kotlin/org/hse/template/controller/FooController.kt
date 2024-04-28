package org.hse.template.controller

import org.hse.template.api.FooApi
import org.hse.template.client.rest.api.DogsClient
import org.hse.template.client.rest.model.AddFavouriteModel
import org.hse.template.client.rest.model.AddFavouriteResponseModel
import org.hse.template.client.rest.model.DogModel
import org.hse.template.client.rest.model.FavouriteModel
import org.hse.template.service.DogsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController(
    private val dogsService: DogsService
) : FooApi {

    @GetMapping()
    override fun getDogs(
        @RequestParam limit: Int,
        @RequestParam api_key: String
    ) =
        dogsService.getDogs(limit, api_key)

    @GetMapping("find/{id}")
    override fun getDogById(@PathVariable id: String): DogModel =
        dogsService.getDogById(id)

    @GetMapping("favourites")
    override fun getFavouritesByUser(
        @RequestParam sub_id: String,
        @RequestParam api_key: String
    ): List<FavouriteModel> =
        dogsService.getFavouritesByUser(sub_id, api_key)

    @PostMapping("favourites")
    override fun addFavourite(
        @RequestParam api_key: String,
        @RequestBody addFavouriteModel: AddFavouriteModel
    ): AddFavouriteResponseModel =
        dogsService.addFavourite(api_key, addFavouriteModel)

}