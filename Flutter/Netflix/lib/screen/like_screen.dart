import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/model/movieModel/movie.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:provider/provider.dart';

import 'detail_screen.dart';



class LikeScreen extends StatelessWidget {
  const LikeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return
      ListView(
        padding: EdgeInsets.fromLTRB(5, 0, 5, 0),
        children: [
          Container(
            padding: EdgeInsets.all(20),
          ),
          Consumer<HiveHelper>(
            builder: (context, provider, widget){
              return Container(
                //padding: EdgeInsets.all(5),
                height: MediaQuery.of(context).size.height-25,
                child: GridView.count(
                  crossAxisCount: 3,
                  childAspectRatio: 1/1.618,
                  mainAxisSpacing: 0,
                  crossAxisSpacing: 0,
                  children: makeBoxImages(context, provider.likeIdBox!.values.toList()),

                ),
              );
            },
          ),
        ],
      );
  }
}

List<Widget> makeBoxImages(
    BuildContext context, List<Movie>? movies) {

  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                return DetailScreen(movie: movies[i]);
                //return Text('히히');
              }),
        );
      },
      child: Container(
            //alignment: Alignment.center,
        padding: EdgeInsets.all(2),
            child: CachedNetworkImage(
              //width: 100,
              //height: 168.1,
              //placeholder: (context, url) => CircularProgressIndicator(),
              imageUrl: 'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
              fit: BoxFit.cover,
            )

      ),
    ));
  }
  return result;
}
