import 'package:flutter/material.dart';
import 'package:netflix/model/movieModel/movie.dart';
import '../retrofit/RestClient.dart';

class MovieProvider with ChangeNotifier {
  int index = 0;
  List<Movies> _NowPlayingMovies = [];
  List<Movies> get NowPlayingMovies => _NowPlayingMovies;

  List<Movies> _TopRatedMovies = [];
  List<Movies> get TopRatedMovies => _TopRatedMovies;

  List<Movies> _PopularMovies = [];
  List<Movies> get PopularMovies => _PopularMovies;

  List<Movies> _UpResultsMovies = [];
  List<Movies> get UpResultsMovies => _UpResultsMovies;

  void changeIdx(int idx){
    index = idx;
    notifyListeners();
  }

  Future<void> getMovie() async {
    await RestClient.create()
        .getNowPlaying('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
          print('value : ${value.results}');
          print(value.results![0].id);
      List<Movies> listMovies = value.results!;
      _NowPlayingMovies = listMovies;
          notifyListeners();
          return listMovies;
    });

    await RestClient.create()
        .getPopular('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<Movies> listMovies = value.results!;
      _PopularMovies = listMovies;
      notifyListeners();
      return listMovies;
    });

    await RestClient.create()
        .getUpcoming('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<Movies> listMovies = value.results!;
      _UpResultsMovies = listMovies;
      notifyListeners();
      return listMovies;
    });

    await RestClient.create()
        .getTopRated('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR')
        .then((value) {
      List<Movies> listMovies = value.results!;
      _TopRatedMovies = listMovies;
      notifyListeners();
      return listMovies;
    });
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
