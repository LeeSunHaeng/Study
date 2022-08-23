// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'movie_like_id.dart';

// **************************************************************************
// TypeAdapterGenerator
// **************************************************************************

class LikeMoviesAdapter extends TypeAdapter<LikeMovies> {
  @override
  final int typeId = 0;

  @override
  LikeMovies read(BinaryReader reader) {
    final numOfFields = reader.readByte();
    final fields = <int, dynamic>{
      for (int i = 0; i < numOfFields; i++) reader.readByte(): reader.read(),
    };
    return LikeMovies(
      id: fields[1] as int?,
      overview: fields[2] as String?,
      poster_path: fields[3] as String?,
      release_date: fields[4] as String?,
      title: fields[5] as String?,
      vote_average: fields[6] as double?,
    );
  }

  @override
  void write(BinaryWriter writer, LikeMovies obj) {
    writer
      ..writeByte(6)
      ..writeByte(1)
      ..write(obj.id)
      ..writeByte(2)
      ..write(obj.overview)
      ..writeByte(3)
      ..write(obj.poster_path)
      ..writeByte(4)
      ..write(obj.release_date)
      ..writeByte(5)
      ..write(obj.title)
      ..writeByte(6)
      ..write(obj.vote_average);
  }

  @override
  int get hashCode => typeId.hashCode;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is LikeMoviesAdapter &&
          runtimeType == other.runtimeType &&
          typeId == other.typeId;
}
