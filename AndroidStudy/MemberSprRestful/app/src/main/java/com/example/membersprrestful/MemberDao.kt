package com.example.membersprrestful

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MemberService{

    @GET("/allMember")
    fun allMember(): Call<List<MemberDto>>

    @POST("/login")
    fun login(@Body dto:MemberDto) : Call<MemberDto>
}

class MemberDao {

    companion object{
        var memberDao:MemberDao? = null

        fun getInstance():MemberDao{

            if(memberDao == null){
                memberDao = MemberDao()
            }
            return memberDao!!
        }
    }

    fun allMember(): ArrayList<MemberDto> {
        val retrofit = RetrofitClient.getInstance()

        val service = retrofit?.create(MemberService::class.java)
        val call = service?.allMember()
        val response = call?.execute()

        return response?.body() as ArrayList<MemberDto>
    }

    fun login(dto:MemberDto) : MemberDto?{
        val retrofit = RetrofitClient.getInstance()
        val service = retrofit?.create(MemberService::class.java)
        val call = service?.login(dto)
        val response = call?.execute()

        return response?.body()

    }
}






