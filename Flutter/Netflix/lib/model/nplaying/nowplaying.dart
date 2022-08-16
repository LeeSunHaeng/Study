import 'package:json_annotation/json_annotation.dart';

part 'nowplaying.g.dart';


@JsonSerializable(explicitToJson: true)
class NowPlaying {
  List<NowPlayingResults>? results;

  NowPlaying(
      {
        this.results,
        });

  factory NowPlaying.fromJson(Map<String, dynamic> json) => _$NowPlayingFromJson(json);

  Map<String, dynamic> toJson() => _$NowPlayingToJson(this);
}


@JsonSerializable()
class NowPlayingResults {

  int? id;
  String? overview;
  String? poster_path;
  String? release_date;
  String? title;
  double? vote_average;

  NowPlayingResults(
      {
        this.id,
        this.overview,
        this.poster_path,
        this.release_date,
        this.title,
        this.vote_average,
        });

  factory NowPlayingResults.fromJson(Map<String, dynamic> json) => _$NowPlayingResultsFromJson(json);

  Map<String, dynamic> toJson() => _$NowPlayingResultsToJson(this);

}
