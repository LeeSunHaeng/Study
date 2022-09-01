import 'package:flutter/material.dart';

import '../model/movieModel/movie.dart';
import '../retrofit/RestClient.dart';

class MovieSearchProvider extends ChangeNotifier {

  Movies _ResultMovies = Movies();
  Movies get ResultMovies => _ResultMovies;


  Future<void> SearchMovie(String content) async {
    _ResultMovies =  await RestClient.create()
        .getSearch('ce16f7da30a47ba16d9f038d895318bd','ko-KR',content,true);
    notifyListeners();
  }
}