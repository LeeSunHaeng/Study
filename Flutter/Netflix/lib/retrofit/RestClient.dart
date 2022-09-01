import 'dart:ffi';

import 'package:netflix/model/movieModel/movie.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;

part 'RestClient.g.dart';

@RestApi(baseUrl : 'https://api.themoviedb.org/3')
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  static RestClient create() {
    final dio = Dio();
    // dio.interceptors.add(PrettyDioLogger());
    // dio.transformer = FlutterTransformer();
    dio.options = BaseOptions(receiveTimeout: 30000, connectTimeout: 30000);
    return RestClient(dio);
  }

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/movie/now_playing')
  Future<Movies> getNowPlaying(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/movie/top_rated')
  Future<Movies> getTopRated(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/movie/popular')
  Future<Movies> getPopular(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",
  })
  @POST('/movie/upcoming')
  Future<Movies> getUpcoming(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",
  })
  @GET('/search/movie')
  Future<Movies> getSearch(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('query') String query,
      @Query('include_adult') bool includeAdult,
      );

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",
  })
  @GET('/movie/{movie_id}/similar')
  Future<Movies> getSimilar(
      @Path() int movie_id,
      @Query('api_key') String apiKey,
      @Query('language') String language,
      );

}

