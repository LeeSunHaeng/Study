import 'package:hive/hive.dart';
import 'package:json_annotation/json_annotation.dart';

part 'movie.g.dart';

@JsonSerializable(explicitToJson: true)
class Movies {
  List<Movie>? results;
  Movies(
      {
        this.results,
      });

  factory Movies.fromJson(Map<String, dynamic> json) => _$MoviesFromJson(json);

  Map<String, dynamic> toJson() => _$MoviesToJson(this);


}
@HiveType(typeId: 10)
@JsonSerializable()
class Movie extends HiveObject{

  @HiveField(11)
  int? id;

  @HiveField(12)
  String? overview;

  @HiveField(13)
  String? poster_path;

  @HiveField(14)
  String? release_date;

  @HiveField(15)
  String? title;

  @HiveField(16)
  double? vote_average;


  Movie(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
      });

  factory Movie.fromJson(Map<String, dynamic> json) => _$MovieFromJson(json);

  Map<String, dynamic> toJson() => _$MovieToJson(this);

}