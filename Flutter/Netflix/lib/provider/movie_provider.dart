import 'package:flutter/material.dart';
import 'package:netflix/model/movieModel/movie.dart';
import '../retrofit/RestClient.dart';

class MovieProvider with ChangeNotifier {
  int _index = 0;
  int get index => _index;

  Movies _NowPlayingMovies = Movies();
  Movies get NowPlayingMovies => _NowPlayingMovies;

  Movies _TopRatedMovies = Movies();
  Movies get TopRatedMovies => _TopRatedMovies;

  Movies _PopularMovies = Movies();
  Movies get PopularMovies => _PopularMovies;

  Movies _UpResultsMovies = Movies();
  Movies get UpResultsMovies => _UpResultsMovies;

  Movies _SimilarMovies = Movies();
  Movies get SimilarMovies => _SimilarMovies;

  void changeIdx(int idx){
    _index = idx;
    notifyListeners();
  }
  MovieProvider(){
    getNowPlayingMovie().then((nowMovies) {
      _NowPlayingMovies = nowMovies;
      notifyListeners();
    });

    getPopularMovie().then((popMovies) {
      _PopularMovies = popMovies;
      notifyListeners();
    });

    getUpcomingMovie().then((upMovies) {
      _UpResultsMovies = upMovies;
      notifyListeners();
    });

    getTopRatedMovie().then((topMovies) {
      _TopRatedMovies = topMovies;
      notifyListeners();
    });
  }

  Future<Movies> getNowPlayingMovie() async {
    return await RestClient.create()
        .getNowPlaying('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
  }

  Future<Movies> getPopularMovie() async {
    return await RestClient.create()
        .getPopular('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');

  }

  Future<Movies> getUpcomingMovie() async {
    return await RestClient.create()
        .getUpcoming('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
  }

  Future<Movies> getTopRatedMovie() async {
    return await RestClient.create()
        .getTopRated('ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
  }

  Future<void> getSimilarMovies(int movieId) async {
    _SimilarMovies = await RestClient.create()
        .getSimilar(movieId,'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR');
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
