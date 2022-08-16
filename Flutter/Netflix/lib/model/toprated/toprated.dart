import 'package:json_annotation/json_annotation.dart';

part 'toprated.g.dart';

@JsonSerializable(explicitToJson: true)
class TopRated {

  List<TopRatedResults>? results;

  TopRated({ this.results});

  factory TopRated.fromJson(Map<String, dynamic> json) => _$TopRatedFromJson(json);

  Map<String, dynamic> toJson() => _$TopRatedToJson(this);

}
@JsonSerializable()
class TopRatedResults {

  int? id;
  String? overview;
  String? poster_path;
  String? release_date;
  String? title;
  double? vote_average;

  TopRatedResults(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
        });

  factory TopRatedResults.fromJson(Map<String, dynamic> json) => _$TopRatedResultsFromJson(json);

  Map<String, dynamic> toJson() => _$TopRatedResultsToJson(this);
}