import 'package:netflix/model/popular/popular.dart';
import 'package:netflix/model/toprated/toprated.dart';
import 'package:netflix/model/upcomming/upcomming.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;

import '../model/nplaying/nowplaying.dart';


part 'RestClient.g.dart';

@RestApi(baseUrl : 'https://api.themoviedb.org/3/movie')
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  static RestClient create() {
    final dio = Dio();
    // dio.interceptors.add(PrettyDioLogger());
//     dio.transformer = FlutterTransformer();
    dio.options = BaseOptions(receiveTimeout: 30000, connectTimeout: 30000);
    return RestClient(dio);
  }

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json"
  })
  @GET('/now_playing')
  Future<NowPlaying> getNowPlaying(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json"
  })
  @GET('/top_rated')
  Future<TopRated> getTopRated(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );


  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json"
  })
  @GET('/popular')
  Future<Popular> getPopular(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",
  })
  @GET('/upcoming')
  Future<Upcoming> getUpcoming(
      @Query('api_key') String apiKey,
      @Query('language') String language,
      @Query('page') int page,
      @Query('region') String region,
      );

}

