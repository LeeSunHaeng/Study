import 'package:hive/hive.dart';

part 'movie_like_id.g.dart';

@HiveType(typeId: 0)

class LikeMovies extends HiveObject {

  @HiveField(1)
  int? id;

  @HiveField(2)
  String? overview;

  @HiveField(3)
  String? poster_path;

  @HiveField(4)
  String? release_date;

  @HiveField(5)
  String? title;

  @HiveField(6)
  double? vote_average;

  LikeMovies(
      {this.id,
      this.overview,
      this.poster_path,
      this.release_date,
      this.title,
      this.vote_average});
}
