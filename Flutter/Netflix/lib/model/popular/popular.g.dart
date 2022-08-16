// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'popular.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Popular _$PopularFromJson(Map<String, dynamic> json) => Popular(
      results: (json['results'] as List<dynamic>?)
          ?.map((e) => PopResults.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$PopularToJson(Popular instance) => <String, dynamic>{
      'results': instance.results?.map((e) => e.toJson()).toList(),
    };

PopResults _$PopResultsFromJson(Map<String, dynamic> json) => PopResults(
      id: json['id'] as int?,
      overview: json['overview'] as String?,
      poster_path: json['poster_path'] as String?,
      release_date: json['release_date'] as String?,
      title: json['title'] as String?,
      vote_average: (json['vote_average'] as num?)?.toDouble(),
    );

Map<String, dynamic> _$PopResultsToJson(PopResults instance) =>
    <String, dynamic>{
      'id': instance.id,
      'overview': instance.overview,
      'poster_path': instance.poster_path,
      'release_date': instance.release_date,
      'title': instance.title,
      'vote_average': instance.vote_average,
    };
