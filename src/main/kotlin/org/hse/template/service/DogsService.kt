package org.hse.template.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.hse.template.client.rest.api.DogsClient
import org.hse.template.client.rest.model.*
import org.hse.template.repository.CachedResponseRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DogsService(private val dogsClient: DogsClient, private val repository: CachedResponseRepository) {

    fun getDogs(limit: Int, api_key: String): List<DogModel> {
        val requestUrl = "/images/search?limit=$limit&api_key=$api_key"

        val cachedResponse = checkCache(requestUrl)
        if (cachedResponse != null) {
            val listType = object : TypeToken<List<DogModel>>() {}.type
            return Gson().fromJson(cachedResponse.response, listType)
        }

        val response = dogsClient.getDogs(limit, api_key)

        repository.save(CachedResponse(requestUrl, Gson().toJson(response), LocalDateTime.now()))

        return response
    }

    fun getDogById(id: String): DogModel {
        val requestUrl = "/images/$id"

        val cachedResponse = checkCache(requestUrl)
        if (cachedResponse != null) {
            return cachedResponse.getResponseAsObject(DogModel::class.java)
        }

        val response = dogsClient.getDogById(id)

        repository.save(CachedResponse(requestUrl, Gson().toJson(response), LocalDateTime.now()))

        return response
    }

    fun getFavouritesByUser(sub_id: String, api_key: String): List<FavouriteModel> {
        val requestUrl = "/favourites?sub_id=$sub_id&api_key=$api_key"

        val cachedResponse = checkCache(requestUrl)
        if (cachedResponse != null) {
            val listType = object : TypeToken<List<FavouriteModel>>() {}.type
            return Gson().fromJson(cachedResponse.response, listType)
        }

        val response = dogsClient.getFavouritesByUser(sub_id, api_key)

        repository.save(CachedResponse(requestUrl, Gson().toJson(response), LocalDateTime.now()))

        return response
    }

    fun addFavourite(api_key: String, addFavouriteModel: AddFavouriteModel): AddFavouriteResponseModel {
        val requestUrl = "/favourites?api_key=$api_key"

        val cachedResponse = checkCache(requestUrl)
        if (cachedResponse != null) {
            return cachedResponse.getResponseAsObject(AddFavouriteResponseModel::class.java)
        }

        val response = dogsClient.addFavourite(api_key, addFavouriteModel)

        repository.save(CachedResponse(requestUrl, Gson().toJson(response), LocalDateTime.now()))

        return response
    }

    fun checkCache(requestUrl: String): CachedResponse? {
        val cachedResponse = repository.findById(requestUrl)
        if (cachedResponse.isPresent) {
            val response = cachedResponse.get()
            if (response.timestamp.isAfter(LocalDateTime.now().minusMinutes(1))) {
                return response
            }
        }
        return null
    }
}