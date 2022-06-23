package com.example.springrestfulandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

class MemberDto(val id:String, val pwd:String, val name:String, val email:String, val auth:Int)

interface ReadyService{

    // 1. 문자열 받기
    @GET("/base")
    fun base(): Call<String>

    // 2. 문자열 보내고 받기
    @GET("/connectParamGet")
    fun connectParamGet(@Query("title") title:String) :Call<String>

    // 3. object를 보내고 받기
    @POST("/getMember") // post일때는 @Body
    fun getMember(@Body mem:MemberDto) :Call<MemberDto>

    // 4. list로 받기
    @POST("/dbTest")
    fun dbTest(): Call<List<MemberDto>>
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Network 처리에 추가한다  == HttpURLConnection
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        // Gson 은 Java 객체를 JSON 으로 변환할 수 있다
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.219.111:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))     // object, integer
            .addConverterFactory(ScalarsConverterFactory.create())      // 문자열 리턴받는 경우
            .build()

        val service = retrofit.create(ReadyService::class.java)

        // 1. 문자열 받기
        //val call = service.base()

        // 2. 문자열 보내고 받기
        //val call = service.connectParamGet("제목입니다.")

        // 3. object 보내고 받기
        //val call = service.getMember(MemberDto("aaa","111","AAA","asd@naver.com",3))

        // 4. list로 받기
        val call = service.dbTest()

        val response = call.execute()

        if(response.isSuccessful){

            if(response.code() == 200){

                // 1.
                //val base: String? = response.body()
                //println("~~~base:$base")

                // 2.
                //val str:String? = response.body()
                //println("~~~~str: $str")

                // 3.
                val list:List<MemberDto>? = response.body()
                println(list)
                println(list?.get(0)?.name)


            }
        }
    }
}







