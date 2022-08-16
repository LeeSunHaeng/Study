import 'package:carousel_slider/carousel_slider.dart';
import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../model/upcomming/upcomming.dart';
import '../retrofit/RestClient.dart';

class TestCarouselImage extends StatefulWidget {
  const TestCarouselImage({Key? key}) : super(key: key);

  @override
  State<TestCarouselImage> createState() => _TestCarouselImageState();
}

class _TestCarouselImageState extends State<TestCarouselImage> {

  late RestClient client;
  late Future<Upcoming> up;

  Future<Upcoming> getUpcomming2() async {
    Dio dio = Dio();
    client = RestClient(dio);
    Upcoming resp = await client.getUpcoming(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
    return resp;
  }

  @override
  void initState() {
    super.initState();
    up = getUpcomming2();
  }



  @override
  Widget build(BuildContext context) {
    return Container(
        child: Column(children: [
      Container(
        padding: EdgeInsets.all(20),
      ),
      FutureBuilder<Upcoming>(
          future: up,
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return Container(
                  height: 120,
                  padding: EdgeInsets.only(right: 10),
                  child: CircularProgressIndicator());
            }
            else {
              if(snapshot.hasError){
                print('snapshot.error : ${snapshot.error}');
                //print('url : https://image.tmdb.org/t/p/original${snapshot.data!.results![0].poster_path}');
                return Text('fetch error');
              }
              else{
                return CarouselSlider(
                  items: snapshot.data!.results!
                      .map((m) => Image.network('https://image.tmdb.org/t/p/original${m.poster_path!}'))
                      .toList(),
                  options: CarouselOptions(onPageChanged: (index, reason) {
                    setState(() {
                      print('url : https://image.tmdb.org/t/p/original${snapshot.data!.results![0].poster_path}');
                    });
                  }),
                );
              }

            }
          })
    ]));
  }
}
