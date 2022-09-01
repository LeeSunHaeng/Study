// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'movie.dart';

// **************************************************************************
// TypeAdapterGenerator
// **************************************************************************

class MovieAdapter extends TypeAdapter<Movie> {
  @override
  final int typeId = 10;

  @override
  Movie read(BinaryReader reader) {
    final numOfFields = reader.readByte();
    final fields = <int, dynamic>{
      for (int i = 0; i < numOfFields; i++) reader.readByte(): reader.read(),
    };
    return Movie(
      id: fields[11] as int?,
      overview: fields[12] as String?,
      poster_path: fields[13] as String?,
      release_date: fields[14] as String?,
      title: fields[15] as String?,
      vote_average: fields[16] as double?,
    );
  }

  @override
  void write(BinaryWriter writer, Movie obj) {
    writer
      ..writeByte(6)
      ..writeByte(11)
      ..write(obj.id)
      ..writeByte(12)
      ..write(obj.overview)
      ..writeByte(13)
      ..write(obj.poster_path)
      ..writeByte(14)
      ..write(obj.release_date)
      ..writeByte(15)
      ..write(obj.title)
      ..writeByte(16)
      ..write(obj.vote_average);
  }

  @override
  int get hashCode => typeId.hashCode;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is MovieAdapter &&
          runtimeType == other.runtimeType &&
          typeId == other.typeId;
}

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Movies _$MoviesFromJson(Map<String, dynamic> json) => Movies(
      results: (json['results'] as List<dynamic>?)
          ?.map((e) => Movie.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$MoviesToJson(Movies instance) => <String, dynamic>{
      'results': instance.results?.map((e) => e.toJson()).toList(),
    };

Movie _$MovieFromJson(Map<String, dynamic> json) => Movie(
      id: json['id'] as int?,
      overview: json['overview'] as String?,
      poster_path: json['poster_path'] as String?,
      release_date: json['release_date'] as String?,
      title: json['title'] as String?,
      vote_average: (json['vote_average'] as num?)?.toDouble(),
    );

Map<String, dynamic> _$MovieToJson(Movie instance) => <String, dynamic>{
      'id': instance.id,
      'overview': instance.overview,
      'poster_path': instance.poster_path,
      'release_date': instance.release_date,
      'title': instance.title,
      'vote_average': instance.vote_average,
    };
