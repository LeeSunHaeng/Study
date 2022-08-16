import 'dart:convert';

import 'package:carousel_slider/carousel_slider.dart';
import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/model/upcomming/upcomming.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:netflix/screen/detail_screen.dart';
import 'package:netflix/screen/upcoming_detail_screen.dart';

import '../model/model_movie.dart';

class CarouselImage extends StatefulWidget {
  const CarouselImage({Key? key}) : super(key: key);

  @override
  State<CarouselImage> createState() => _CarouselImageState();
}

class _CarouselImageState extends State<CarouselImage> {
  late Future<Upcoming> up;


  late List<UpResults> movies;
  late List<Widget> images;
  late List<String> keywords;
  late List<bool> likes;
  late int _currentPage;
  late String _currentKeyword;



  @override
  void initState() {
    super.initState();
    up = getUpcomming();
  }

  Future<Upcoming> getUpcomming() async {
    // Dio dio = Dio();
    // client = RestClient(dio);
    Upcoming resp = await RestClient.create().getUpcoming(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
  //NetworkImage('https://image.tmdb.org/t/p/original${movies![i].poster_path}')
    movies = await resp.results!;
    images = await movies.map((m) => Image.network('https://image.tmdb.org/t/p/original' + m.poster_path!)).toList();
    //likes = List<bool>.filled(movies.length, false);
    keywords = movies.map((m) => m.title!.toString()).toList();
    _currentPage = 0;

    return resp;
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
          FutureBuilder<Upcoming>(
            future: up,
            builder: (context, snapshot){

              if (snapshot.connectionState == ConnectionState.none ||
                  snapshot.connectionState == ConnectionState.waiting){
                return Container(
                    height: 120,
                    padding: EdgeInsets.only(right: 10),
                    child: CircularProgressIndicator());
              }else{
                return Column(
                  children: [
                    CarouselSlider(
                      items: images,
                      options: CarouselOptions(onPageChanged: (index, reason) {
                        setState(() {
                          _currentPage = index;
                          _currentKeyword = keywords[_currentPage];
                        });
                      }),
                    ),
                    Container(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 3),
                      child: Text(
                        snapshot.data!.results![_currentPage].title!,
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
                                // likes[_currentPage]
                                //     ? IconButton(
                                //   icon: Icon(Icons.check),
                                //   onPressed: () {},
                                // )
                                //     : IconButton(
                                //   onPressed: () {},
                                //   icon: Icon(Icons.add),
                                // ),
                                IconButton(
                                  icon: Icon(Icons.check),
                                  onPressed: () {},
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
                                              return UpcomingDetailScreen(
                                                  movie: snapshot.data!.results![_currentPage]);
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
                        children: makeIndicator(snapshot.data!.results!, _currentPage),
                      ),
                    )
                  ],
                );
              }
          }
          ),



        ],
      ),
    );
  }
}

List<Widget> makeIndicator(List list, int _currentPage) {
  List<Widget> result = [];
  for (int i = 0; i < list.length; i++) {
    result.add(Container(
      width: 8,
      height: 8,
      margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 2.0),
      decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: _currentPage == i
              ? Color.fromRGBO(255, 255, 255, 0.9)
              : Color.fromRGBO(255, 255, 255, 0.4)),
    ));
  }
  return result;
}
