import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/movie_provider.dart';

import 'package:netflix/retrofit/RestClient.dart';
import 'package:netflix/screen/detail_screen.dart';
import 'package:provider/provider.dart';

import '../model/movieModel/movie.dart';

class CircleSlider extends StatefulWidget {
  const CircleSlider({Key? key}) : super(key: key);

  @override
  State<CircleSlider> createState() => _CircleSliderState();
}

class _CircleSliderState extends State<CircleSlider> {
  late RestClient client;
  late MovieProvider _topRatedProvider;

  @override
  void initState() {
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('영화 순위'),
          Consumer<MovieProvider>(builder: (context, provider, widget) {
            var movies = provider.TopRatedMovies;
            if (movies != null && movies.length > 0) {
              return Container(
                  height: 120,
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: makeCircleImages(context, movies),
                  ));
            } else {
              return Container(
                  height: 80,
                  width: 80,
                  padding: EdgeInsets.only(right: 10),
                  child: CircularProgressIndicator());
            }
          })
        ],
      ),
    );
  }
}

List<Widget> makeCircleImages(
    BuildContext context, List<Movies>? movies) {
  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                return DetailScreen(movie: movies[i],TakeContext: context,);
              }),
        );
      },
      child: Container(
        padding: EdgeInsets.only(right: 10),
        child: Align(
          alignment: Alignment.centerLeft,
          child: CircleAvatar(
            backgroundImage:CachedNetworkImageProvider('https://image.tmdb.org/t/p/original${movies[i].poster_path}'),
            //NetworkImage('https://image.tmdb.org/t/p/original${movies[i].poster_path}'),
            radius: 48,
          ),
        ),
      ),
    ));
  }
  return result;
}
