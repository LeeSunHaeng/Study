import 'package:json_annotation/json_annotation.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;
import 'package:retrofit5/const/data.dart';

part 'RestClient.g.dart';

@RestApi(baseUrl: 'http://apis.data.go.kr')
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  // @Headers(<String,dynamic>{
  //   'Content-Language' : 'ko-KR',
  //   'Access-Control-Allow-Origin' : '*',
  //   'Content-Encoding' : 'gzip',
  //   'Content-Type' : 'application/json;charset=UTF-8',
  //   'Content-Length' : '610',
  //   'Date' : 'Thu, 04 Aug 2022 07:08:42 GMT',
  //   'Server' : 'NIA API Server'
  // })
  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json"
  })
  @GET('/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty')
  //Future<List<pmData>> getData(@Body() PracticeRequest praticeRequest);
  Future<List<pmData>> getData(
      @Query("serviceKey") String serviceKey,
      @Query("sidoName") String sidoName,
      @Query('returnType') String returnType,
      );
}

@JsonSerializable()
class PracticeRequest{
  String? serviceKey;
  String? sidoName;

  PracticeRequest({this.serviceKey,this.sidoName});

  factory PracticeRequest.fromJson(Map<String,dynamic> json) => _$PracticeRequestFromJson(json);
  Map<String,dynamic> toJson() => _$PracticeRequestToJson(this);
}

@JsonSerializable()
class pmData{
  String? stationName;
  String? sidoName;
  String? dataTime;
  String? o3Value;
  String? pm10Value;


  pmData({this.stationName, this.sidoName, this.dataTime, this.o3Value, this.pm10Value});

  factory pmData.fromJson(Map<String, dynamic> json) => _$pmDataFromJson(json);

  Map<String, dynamic> toJson() => _$pmDataToJson(this);
}





