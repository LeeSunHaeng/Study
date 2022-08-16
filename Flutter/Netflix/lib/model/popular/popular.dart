import 'package:json_annotation/json_annotation.dart';

part 'popular.g.dart';

@JsonSerializable(explicitToJson: true)
class Popular {

  List<PopResults>? results;

  Popular({ this.results});

  factory Popular.fromJson(Map<String, dynamic> json) => _$PopularFromJson(json);

  Map<String, dynamic> toJson() => _$PopularToJson(this);

}

@JsonSerializable()
class PopResults {
  int? id;
  String? overview;
  String? poster_path;
  String? release_date;
  String? title;
  double? vote_average;

  PopResults(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
      });

  factory PopResults.fromJson(Map<String, dynamic> json) => _$PopResultsFromJson(json);

  Map<String, dynamic> toJson() => _$PopResultsToJson(this);

}