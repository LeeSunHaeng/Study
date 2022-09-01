import 'package:flutter/material.dart';

import '../model/movieModel/movie.dart';
import '../retrofit/RestClient.dart';

class MovieSimilarProvider extends ChangeNotifier{
  Movies _SimilarMovies = Movies();
  Movies get SimilarMovies => _SimilarMovies;


  Future<void> getSimilarMovies(int movieId) async {
    _SimilarMovies =  await RestClient.create()
        .getSimilar(movieId,'ce16f7da30a47ba16d9f038d895318bd','ko-KR');
    notifyListeners();
  }
}