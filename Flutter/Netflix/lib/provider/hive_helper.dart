
import 'package:flutter/cupertino.dart';
import 'package:hive/hive.dart';

import '../hive/movie_like_id.dart';

const String LikeMovie = 'LIKE_MOVIE';

class HiveHelper extends ChangeNotifier{
  int count = 0;
  static final HiveHelper _singleton = HiveHelper._internal();
  static Future<List<LikeMovies>> likeMovies = HiveHelper().read();
  factory HiveHelper(){
    return _singleton;
  }
  HiveHelper._internal();

  Box<LikeMovies>? likeIdBox;

  Future openBox() async{
    likeIdBox = await Hive.openBox(LikeMovie);
  }

  void plus() {
    count++;
    notifyListeners();
  }
  void minus() {
    count--;
    notifyListeners();
  }


  void clear(){
    notifyListeners();
  }

  Future create(String id,LikeMovies movieId)async{
    var result = likeIdBox!.put(id, movieId);
    print(';');
    notifyListeners();
    return result;
  }

  Future<List<LikeMovies>> read() async {
    var result = likeIdBox!.values.toList();
    notifyListeners();
    return result;
  }

  Future delete(String key)async{
    likeIdBox!.delete(key);
    notifyListeners();
  }
  Future deleteAll() async {
    likeIdBox!.deleteFromDisk();
    notifyListeners();
  }

}