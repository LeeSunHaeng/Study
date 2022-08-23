import 'package:netflix/model/movieModel/movie.dart';

import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;



part 'RestClient.g.dart';

@RestApi(baseUrl : 'https://api.themoviedb.org/3/movie')
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
  @POST('/now_playing')
  Future<Movie> getNowPlaying(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/top_rated')
  Future<Movie> getTopRated(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/popular')
  Future<Movie> getPopular(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",

  })
  @POST('/upcoming')
  Future<Movie> getUpcoming(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

}

