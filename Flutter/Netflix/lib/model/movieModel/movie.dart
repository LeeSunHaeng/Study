import 'package:hive/hive.dart';
import 'package:json_annotation/json_annotation.dart';

part 'movie.g.dart';
@JsonSerializable(explicitToJson: true)
class Movie {
  List<Movies>? results;
  Movie(
      {
        this.results,
      });

  factory Movie.fromJson(Map<String, dynamic> json) => _$MovieFromJson(json);

  Map<String, dynamic> toJson() => _$MovieToJson(this);


}

@JsonSerializable()
class Movies {

  int? id;
  String? overview;
  String? poster_path;
  String? release_date;
  String? title;
  double? vote_average;


  Movies(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
      });

  factory Movies.fromJson(Map<String, dynamic> json) => _$MoviesFromJson(json);

  Map<String, dynamic> toJson() => _$MoviesToJson(this);

}