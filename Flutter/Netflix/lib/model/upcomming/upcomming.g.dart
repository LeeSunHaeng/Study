// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'upcomming.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Upcoming _$UpcomingFromJson(Map<String, dynamic> json) => Upcoming(
      results: (json['results'] as List<dynamic>?)
          ?.map((e) => UpResults.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$UpcomingToJson(Upcoming instance) => <String, dynamic>{
      'results': instance.results?.map((e) => e.toJson()).toList(),
    };

UpResults _$UpResultsFromJson(Map<String, dynamic> json) => UpResults(
      id: json['id'] as int?,
      overview: json['overview'] as String?,
      poster_path: json['poster_path'] as String?,
      release_date: json['release_date'] as String?,
      title: json['title'] as String?,
      vote_average: (json['vote_average'] as num?)?.toDouble(),
    );

Map<String, dynamic> _$UpResultsToJson(UpResults instance) => <String, dynamic>{
      'id': instance.id,
      'overview': instance.overview,
      'poster_path': instance.poster_path,
      'release_date': instance.release_date,
      'title': instance.title,
      'vote_average': instance.vote_average,
    };
