import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/hive/movie_like_id.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:provider/provider.dart';

import 'detail_screen.dart';

class LikeScreen extends StatelessWidget {
  const LikeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return
      Consumer<HiveHelper>(
        builder: (context, provider, widget){
          return Container(
            //padding: EdgeInsets.all(5),
            height: 200,
            child: GridView.count(
              crossAxisCount: 3,
              childAspectRatio: 1/1.618,
              mainAxisSpacing: 0,
              crossAxisSpacing: 5,
              children: makeBoxImages(context, provider.likeIdBox!.values.toList()),

            ),
          );
        },
      );
  }
}

List<Widget> makeBoxImages(
    BuildContext context, List<LikeMovies>? movies) {

  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                //return DetailScreen(movie: movies[i],TakeContext: context,);
                return Text('히히');
              }),
        );
      },
      child: Container(
        //padding: EdgeInsets.only(right: 10),
        child: Align(
            alignment: Alignment.centerLeft,
            child: CachedNetworkImage(
              placeholder: (context, url) => CircularProgressIndicator(),
              imageUrl: 'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
            )),
      ),
    ));
  }
  return result;
}
