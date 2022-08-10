import 'package:json_annotation/json_annotation.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;
import 'package:retrofit5/const/data.dart';

part 'RestClient.g.dart';

@RestApi(baseUrl: 'http://apis.data.go.kr')
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  @Headers(<String, dynamic>{
    "Accept": "application/json",
    "content-type": "application/json"
  })
  @GET('/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty')
  Future<PmData> getData(
      @Query("serviceKey") String serviceKey,
      @Query("sidoName") String sidoName,
      );
}

@JsonSerializable()
class PmData{
  dynamic data;

  PmData({this.data});

  factory PmData.fromJson(Map<String, dynamic> json) => _$PmDataFromJson(json);

  Map<String, dynamic> toJson() => _$PmDataToJson(this);


}