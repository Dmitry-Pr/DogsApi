package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.AddFavouriteModel
import org.hse.template.client.rest.model.AddFavouriteResponseModel
import org.hse.template.client.rest.model.DogModel
import org.hse.template.client.rest.model.FavouriteModel

interface FooApi {

    @Tag(name = "Тестовый запрос на получение информации о собаках")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getDogs(
        @Schema(
            description = "Количество изображений",
            defaultValue = "10"
        )
        limit: Int,
        @Schema(
            description = "Ключ",
            defaultValue = "live_jpJNHS1SODAQeKXBll7xb0xlQlerubvqm3xf3QS3sCwD95Jy8YgxRIRYOoX308LE"
        )
        apiKey: String,

        ): List<DogModel>

    @Tag(name = "Тестовый запрос на получение информации о собаке")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getDogById(
        @Schema(
            description = "Уникальный идентификатор собаки",
            defaultValue = "hweK6aOl9"
        )
        id: String,
    ): DogModel

    @Tag(name = "Тестовый запрос на получение понравившихся собак")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getFavouritesByUser(
        @Schema(
            description = "Уникальное имя пользователя",
            defaultValue = "user"
        )
        sub_id: String,
        @Schema(
            description = "Ключ",
            defaultValue = "live_jpJNHS1SODAQeKXBll7xb0xlQlerubvqm3xf3QS3sCwD95Jy8YgxRIRYOoX308LE"
        )
        apiKey: String,
    ): List<FavouriteModel>

    fun addFavourite(
        @Schema(
            description = "Ключ",
            defaultValue = "live_jpJNHS1SODAQeKXBll7xb0xlQlerubvqm3xf3QS3sCwD95Jy8YgxRIRYOoX308LE"
        )
        apiKey: String,
        @Schema(
            description = "Модель добавления понравившейся собаки",
            implementation = AddFavouriteModel::class,
            example = """
        {
            "image_id": "hweK6aOl9",
            "sub_id": "user"
        }
    """
        )
        addFavouriteModel: AddFavouriteModel,
    ): AddFavouriteResponseModel

}