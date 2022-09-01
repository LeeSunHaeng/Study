import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:netflix/screen/detail_screen.dart';
import 'package:provider/provider.dart';
import '../model/movieModel/movie.dart';

class PopBoxSlider extends StatefulWidget {
  const PopBoxSlider({Key? key}) : super(key: key);

  @override
  State<PopBoxSlider> createState() => _PopBoxSliderState();
}

class _PopBoxSliderState extends State<PopBoxSlider> {
  late RestClient client;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
              padding: EdgeInsets.only(bottom: 5.0),
              child: Text('인기영화')),
          Consumer<MovieProvider>(builder: (context, provider, widget) {
            var movies = provider.PopularMovies;
            if (movies.results != null && movies.results!.length > 0) {

              return Container(
                height: 160,
                child: ListView.builder(
                    itemCount: provider.PopularMovies.results!.length,
                    scrollDirection: Axis.horizontal,
                    itemBuilder: (context,i){

                  return InkWell(
                    onTap: () {
                      Navigator.of(context).push(
                        MaterialPageRoute(
                            fullscreenDialog: true,
                            builder: (BuildContext context) {
                              return DetailScreen(movie: movies.results![i]);
                            }),
                      );
                    },
                    child: Container(
                      padding: EdgeInsets.only(right: 10),
                      child: Align(
                          alignment: Alignment.centerLeft,
                          child:ClipRRect(
                            borderRadius: BorderRadius.circular(10.0),
                            child: CachedNetworkImage(
                              //placeholder: (context, url) => CircularProgressIndicator(),
                              imageUrl: 'https://image.tmdb.org/t/p/original${movies.results![i].poster_path}',
                            ),
                          )
                      ),
                    )
                  );
                }),
              );
            }
            else{
              return Container(
                  height: 80,
                  width: 80,
                  padding: EdgeInsets.only(right: 10),
                  child: CircularProgressIndicator());
            }
          }),
        ],
      ),
    );
  }
}

List<Widget> makePopBoxImages(BuildContext context, List<Movie>? movies) {
  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                return DetailScreen(movie: movies[i]);
              }),
        );
      },
        child: Container(
          padding: EdgeInsets.only(right: 10),
          child: Align(
              alignment: Alignment.centerLeft,
              child:ClipRRect(
                borderRadius: BorderRadius.circular(10.0),
                child: CachedNetworkImage(
                  //placeholder: (context, url) => CircularProgressIndicator(),
                  imageUrl: 'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
                ),
              )
          ),
        )
    ));
  }
  return result;
}
