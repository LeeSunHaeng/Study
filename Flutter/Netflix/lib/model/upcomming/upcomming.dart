import 'package:json_annotation/json_annotation.dart';

part 'upcomming.g.dart';

@JsonSerializable(explicitToJson: true)
class Upcoming {

  List<UpResults>? results;

  Upcoming(
      {
        this.results,
       });

  factory Upcoming.fromJson(Map<String, dynamic> json) => _$UpcomingFromJson(json);

  Map<String, dynamic> toJson() => _$UpcomingToJson(this);


}

@JsonSerializable()
class UpResults {

  int? id;
  String? overview;
  String? poster_path;
  String? release_date;
  String? title;
  double? vote_average;


  UpResults(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
});

  factory UpResults.fromJson(Map<String, dynamic> json) => _$UpResultsFromJson(json);

  Map<String, dynamic> toJson() => _$UpResultsToJson(this);

}