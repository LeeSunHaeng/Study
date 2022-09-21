import 'package:dio/dio.dart' hide Headers;

import 'package:retrofit/http.dart';

import '../model/finedust_model.dart' hide Body;


part 'rest_client.g.dart';

@RestApi(baseUrl: 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc')
abstract class RestClient{
  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  static RestClient create(){
    final dio = Dio();
    dio.options = BaseOptions(receiveTimeout: 30000, connectTimeout: 30000);
    return RestClient(dio);
  }

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json",
  })
  @GET('/getCtprvnRltmMesureDnsty')
  Future<FineDustModel> getFineDust(
      @Query('serviceKey') String serviceKey,
      @Query('sidoName') String sidoNmae,
      @Query('returnType') String returnType,
      //@Body() Map<String,dynamic> map
      );
}