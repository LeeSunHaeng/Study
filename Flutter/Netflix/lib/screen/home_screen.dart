
import 'package:flutter/material.dart';

import 'package:netflix/widget/box_slider.dart';
import 'package:netflix/widget/carousel_silder.dart';
import 'package:netflix/widget/circle_slider.dart';
import 'package:netflix/widget/pop_box_slider.dart';
import 'package:netflix/widget/testcarousel_slider.dart';

import '../model/model_movie.dart';
import '../model/nplaying/nowplaying.dart';
import '../retrofit/RestClient.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late RestClient client;
  late Future<NowPlaying> FNPMovies;
  final List<Movie> movies = [
    Movie.fromMap(
        {
          'title' : '사랑의 불시착',
          'keyword' : '사랑/로맨스/판타지',
          'poster' : 'test_movie_1.png',
          'like' : false
        }
    ),
    Movie.fromMap(
        {
          'title' : '사랑의 불시착',
          'keyword' : '사랑/로맨스/판타지',
          'poster' : 'test_movie_1.png',
          'like' : false
        }
    ),Movie.fromMap(
        {
          'title' : '바보의 불시착',
          'keyword' : '사랑/로맨스/판타지',
          'poster' : 'test_movie_1.png',
          'like' : false
        }
    ),
    Movie.fromMap(
        {
          'title' : '사랑의 불시착',
          'keyword' : '사랑/로맨스/판타지',
          'poster' : 'test_movie_1.png',
          'like' : false
        }
    ),

  ];

  @override
  void initState() {
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: [
        Stack(
          children: [
           //TestCarouselImage(),
            CarouselImage(),
            TopBar(),
          ],
        ),
        CircleSlider(),
        BoxSlider(),
        PopBoxSlider(),
      ],
    );
  }
}

class TopBar extends StatelessWidget {

  const TopBar({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {

    return Container(
      padding: EdgeInsets.fromLTRB(20, 7, 20, 7),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Image.asset(
            'images/bbongflix_logo.png',
            fit: BoxFit.contain,
            height: 25,
          ),
          Container(
            padding: EdgeInsets.only(right: 1),
            child: const Text(
              'TV 프로그램',
              style: TextStyle(fontSize: 14),
            ),
          ),
          Container(
            padding: EdgeInsets.only(right: 1),
            child: const Text(
              '영화',
              style: TextStyle(fontSize: 14),
            ),
          ),
          Container(
            padding: EdgeInsets.only(right: 1),
            child: const Text(
              '내가 찜한 콘텐츠',
              style: TextStyle(fontSize: 14),
            ),

          ),
        ],
      ),
    );
  }
}
