import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:netflix/hive/movie_like_id.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/screen/detail_screen.dart';
import 'package:provider/provider.dart';

class CarouselImage extends StatefulWidget {
  const CarouselImage({Key? key}) : super(key: key);

  @override
  State<CarouselImage> createState() => _CarouselImageState();
}

class _CarouselImageState extends State<CarouselImage> {
  late List<bool> likes;
  //

  @override
  void initState() {
    super.initState();
    //provider.index = 0;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: [
          Container(
            padding: EdgeInsets.all(20),
          ),
          Container(
              margin: EdgeInsets.only(bottom: 10.0),
              child: Text('COMING SOON')),
          Consumer2<MovieProvider, HiveHelper>(
              builder: (context, provider, provider2, widget) {
            var movies = provider.UpResultsMovies;
            // List<MovieLikeId> likeMoviesId = [];
            // Future.delayed(Duration(seconds: 0),(){
            //   provider2.read().then((value) => likeMoviesId = value);
            // });

            if (movies != null && movies.length > 0) {
              return Column(
                children: [
                  CarouselSlider(
                    items: movies
                        .map((m) => Image.network(
                            'https://image.tmdb.org/t/p/original' +
                                m.poster_path!))
                        .toList(),
                    options: CarouselOptions(onPageChanged: (index, reason) {
                      provider.changeIdx(index);
                    }),
                  ),
                  Container(
                    padding: EdgeInsets.fromLTRB(0, 10, 0, 3),
                    child: Text(
                      movies[provider.index].title!,
                      style: TextStyle(fontSize: 11),
                    ),
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        Container(
                          child: Column(
                            children: [
                              provider2.likeIdBox!.containsKey(
                                      '${movies[provider.index].id.toString()}')
                                  ? IconButton(
                                      icon: Icon(Icons.favorite),
                                      onPressed: () {
                                        provider2.delete(movies[provider.index]
                                            .id
                                            .toString());
                                      },
                                    )
                                  : IconButton(
                                      onPressed: () {
                                        provider2.create(
                                            movies[provider.index].id.toString(),
                                            LikeMovies(
                                              id: movies[provider.index].id,
                                              overview: movies[provider.index].overview,
                                              poster_path:movies[provider.index].poster_path,
                                              release_date: movies[provider.index].release_date,
                                              title: movies[provider.index].title,
                                              vote_average: movies[provider.index].vote_average
                                            ));

                                        //provider2.create(movies[provider.index].id.toString(),LikeMovies(id: movies[provider.index].id.toString()));
                                      },
                                      icon: Icon(Icons.favorite_border),
                                    ),
                              Text(
                                '내가 찜한 콘텐츠',
                                style: TextStyle(fontSize: 11),
                              ),
                            ],
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.only(right: 10),
                          child: TextButton(
                            style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.white)),
                            onPressed: () {},
                            child: Row(
                              children: const [
                                Icon(
                                  Icons.play_arrow,
                                  color: Colors.black,
                                ),
                                Padding(padding: EdgeInsets.all(3)),
                                Text(
                                  '재생',
                                  style: TextStyle(color: Colors.black),
                                )
                              ],
                            ),
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.only(right: 10),
                          child: Column(
                            children: [
                              IconButton(
                                  onPressed: () {
                                    Navigator.of(context).push(
                                      MaterialPageRoute(
                                          fullscreenDialog: true,
                                          builder: (BuildContext context) {
                                            return DetailScreen(
                                                movie: movies[provider.index],TakeContext: context,);
                                          }),
                                    );
                                  },
                                  icon: Icon(Icons.info)),
                              Text(
                                '정보',
                                style: TextStyle(fontSize: 11),
                              )
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: makeIndicator(movies, provider.index),
                    ),
                  )
                ],
              );
            } else {
              return Container(
                  height: 120,
                  width: 120,
                  padding: EdgeInsets.only(right: 10),
                  child: CircularProgressIndicator());
            }
          }),
        ],
      ),
    );
  }
}

List<Widget> makeIndicator(List list, int idx) {
  List<Widget> result = [];
  for (int i = 0; i < list.length; i++) {
    result.add(Container(
      width: 8,
      height: 8,
      margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 2.0),
      decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: idx == i
              ? Color.fromRGBO(255, 255, 255, 0.9)
              : Color.fromRGBO(255, 255, 255, 0.4)),
    ));
  }
  return result;
}
