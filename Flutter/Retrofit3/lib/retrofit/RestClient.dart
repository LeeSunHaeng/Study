import 'package:json_annotation/json_annotation.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart';

part 'RestClient.g.dart';

@RestApi(baseUrl: "http://apis.data.go.kr")
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  @GET('/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty')
  Future<List<Map<String,String?>>> getTopNews();
}


@JsonSerializable()
class News{
  String? serviceKey;
  String? returnType;
  String? numOfRows;
  String? pageNo;
  String? sidoName;
  String? ver;

  News({this.serviceKey, this.returnType, this.numOfRows, this.pageNo, this.sidoName, this.ver});

  factory News.fromJson(Map<String, dynamic> json) => _$NewsFromJson(json);

  Map<String, dynamic> toJson() => _$NewsToJson(this);
}