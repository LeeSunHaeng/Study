// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'toprated.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TopRated _$TopRatedFromJson(Map<String, dynamic> json) => TopRated(
      results: (json['results'] as List<dynamic>?)
          ?.map((e) => TopRatedResults.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$TopRatedToJson(TopRated instance) => <String, dynamic>{
      'results': instance.results?.map((e) => e.toJson()).toList(),
    };

TopRatedResults _$TopRatedResultsFromJson(Map<String, dynamic> json) =>
    TopRatedResults(
      id: json['id'] as int?,
      overview: json['overview'] as String?,
      poster_path: json['poster_path'] as String?,
      release_date: json['release_date'] as String?,
      title: json['title'] as String?,
      vote_average: (json['vote_average'] as num?)?.toDouble(),
    );

Map<String, dynamic> _$TopRatedResultsToJson(TopRatedResults instance) =>
    <String, dynamic>{
      'id': instance.id,
      'overview': instance.overview,
      'poster_path': instance.poster_path,
      'release_date': instance.release_date,
      'title': instance.title,
      'vote_average': instance.vote_average,
    };
