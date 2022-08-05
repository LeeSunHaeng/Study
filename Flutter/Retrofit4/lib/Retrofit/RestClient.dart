import 'package:json_annotation/json_annotation.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;

part 'RestClient.g.dart';

@RestApi(baseUrl: 'https://hacker-news.firebaseio.com/v0')
abstract class RestClient{

  factory RestClient(Dio dio, {String baseUrl}) = _RestClient;

  @Headers(<String,String>{"accept":"image/jpeg"})
  @GET('/topstories.json')
  Future<List<int>> getTopNews();
}

@JsonSerializable()
class News{
  int? userId;
  int? id;
  String? title;
  bool? completed;

  News({this.userId, this.id, this.title, this.completed});

  factory News.fromJson(Map<String, dynamic> json) => _$NewsFromJson(json);

  Map<String, dynamic> toJson() => _$NewsToJson(this);
}