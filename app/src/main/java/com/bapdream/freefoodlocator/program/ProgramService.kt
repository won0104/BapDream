package com.bapdream.freefoodlocator.program

import com.bapdream.freefoodlocator.model.FacilityResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProgramService {
    @GET("openapi/tn_pubr_public_free_mlsv_api")
    fun getFacilityData(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("type") type: String
    ): Call<FacilityResponse>
}