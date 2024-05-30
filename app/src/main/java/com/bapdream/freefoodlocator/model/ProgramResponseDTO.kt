package com.bapdream.freefoodlocator.model

import retrofit2.http.Body

data class Response(
    val header: Header,
    val body: Body
)

data class FacilityResponse(
    val response: Response
)

data class Header(
    val resultCode: String,
    val resultMsg: String,
    val type: String
)
data class Body(
    val items: List<Item>,
    val totalCount: String,
    val numOfRows: String,
    val pageNo: String
)

data class Item(
    val fcltyNm: String,
    val rdnmadr: String,
    val lnmadr: String?,
    val operInstitutionNm: String,
    val phoneNumber: String,
    val mlsvPlace: String,
    val mlsvTrget: String,
    val mlsvTime: String,
    val mlsvDate: String,
    val operOpenDate: String,
    val operCloseDate: String?,
    val latitude: String,
    val longitude: String,
    val referenceDate: String,
    val insttCode: String
)

