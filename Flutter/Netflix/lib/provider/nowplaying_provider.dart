import 'package:flutter/material.dart';
import 'package:netflix/model/nplaying/nowplaying.dart';

import '../retrofit/RestClient.dart';

class NowPlayingProvider extends ChangeNotifier{
  List<NowPlayingResults> _NowPlayingMovies = [];
  List<NowPlayingResults> get NowPlayingMovies => _NowPlayingMovies;


    getNowPlaying() async{
      List<NowPlayingResults> listMovies = await RestClient.create().getNowPlaying(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR').then((value) => value.results!);
      _NowPlayingMovies = listMovies;
      notifyListeners();
  }

}