package com.bapdream.freefoodlocator.program

import com.bapdream.freefoodlocator.model.FacilityResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProgramRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://api.data.go.kr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiService::class.java)
    val call = service.getFacilityData("인코딩된 서비스 키", 1, 100, "json")

    call.enqueue(object : Callback<FacilityResponse> {
        override fun onResponse(call: Call<FacilityResponse>, response: Response<FacilityResponse>) {
            if (response.isSuccessful) {
                // 성공적으로 데이터를 받아왔을 때 처리
                val facilities = response.body()?.response?.body?.items
                // 데이터 사용
            }
        }

        override fun onFailure(call: Call<FacilityResponse>, t: Throwable) {
            // 에러 처리
        }
    })
}