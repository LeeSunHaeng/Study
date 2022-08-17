import 'package:flutter/material.dart';
import 'package:netflix/model/nplaying/nowplaying.dart';
import 'package:netflix/model/popular/popular.dart';
import 'package:netflix/model/upcomming/upcomming.dart';

import '../model/toprated/toprated.dart';
import '../retrofit/RestClient.dart';

class MovieProvider with ChangeNotifier {
  List<NowPlayingResults> _NowPlayingMovies = [];
  List<NowPlayingResults> get NowPlayingMovies => _NowPlayingMovies;

  List<TopRatedResults> _TopRatedMovies = [];
  List<TopRatedResults> get TopRatedMovies => _TopRatedMovies;

  List<PopResults> _PopularMovies = [];
  List<PopResults> get PopularMovies => _PopularMovies;

  List<UpResults> _UpResultsMovies = [];
  List<UpResults> get UpResultsMovies => _UpResultsMovies;

  Future<void> getMovie() async {
    await RestClient.create()
        .getNowPlaying('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<NowPlayingResults> listMovies = value.results!;
      _NowPlayingMovies = listMovies;
      return listMovies;
    });

    notifyListeners();
    await RestClient.create()
        .getPopular('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<PopResults> listMovies = value.results!;
      _PopularMovies = listMovies;
      return listMovies;
    });

    notifyListeners();
    await RestClient.create()
        .getUpcoming('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<UpResults> listMovies = value.results!;
      _UpResultsMovies = listMovies;
      return listMovies;
    });

    notifyListeners();
    await RestClient.create()
        .getTopRated('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<TopRatedResults> listMovies = value.results!;
      _TopRatedMovies = listMovies;
      return listMovies;
    });
    notifyListeners();
  }
}

//
//   Future<void> getTopRated() async {
//     notifyListeners();
//   }
//
//   Future<void> getPopular() async {
//     List<PopResults> listMovies = await RestClient.create()
//         .getPopular('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
//         .then((value) => value.results!);
//     _PopularMovies = listMovies;
//     notifyListeners();
//   }
//
//   Future<void> getUpcoming() async {
//     List<UpResults> listMovies = await RestClient.create()
//         .getUpcoming('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
//         .then((value) => value.results!);
//     _UpResultsMovies = listMovies;
//     notifyListeners();
//   }
// }
