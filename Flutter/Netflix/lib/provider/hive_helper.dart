import 'package:flutter/cupertino.dart';
import 'package:hive/hive.dart';
import 'package:netflix/model/movieModel/movie.dart';


const String movie = 'LIKE_MOVIE';

class HiveHelper extends ChangeNotifier{

  static final HiveHelper _singleton = HiveHelper._internal();

  factory HiveHelper(){
    return _singleton;
  }
  HiveHelper._internal();

  Box<Movie>? likeIdBox;

  Future openBox() async{
    likeIdBox = await Hive.openBox(movie);
  }

  void clear(){
    notifyListeners();
  }

  Future create(String id,Movie movieId)async{
    var result = likeIdBox!.put(id, movieId);
    notifyListeners();
    return result;
  }

  Future<List<Movie>> read() async {
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