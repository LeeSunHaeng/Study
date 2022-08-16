import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/model/popular/popular.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:netflix/screen/pop_detail_screnn.dart';
import '../model/nplaying/nowplaying.dart';
import '../screen/detail_screen.dart';

class PopBoxSlider extends StatefulWidget {
  const PopBoxSlider({Key? key}) : super(key: key);

  @override
  State<PopBoxSlider> createState() => _PopBoxSliderState();
}

class _PopBoxSliderState extends State<PopBoxSlider> {
  late RestClient client;
  late Future<Popular> Pop;

  Future<Popular> getPopular() async {

    // client = RestClient(dio);
    var resp = await RestClient.create().getPopular(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
    return resp;
  }

  @override
  void initState() {
    super.initState();
    Pop = getPopular();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('인기영화'),
          FutureBuilder<Popular>(
            future: Pop,
            builder: (context, snapshot) {

              if (snapshot.connectionState == ConnectionState.none ||
                  snapshot.connectionState == ConnectionState.waiting){
                return Container(
                    height: 120,
                    padding: EdgeInsets.only(right: 10),
                    child: CircularProgressIndicator());
              }

              else {
                return Container(
                  height: 120,
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: makePopBoxImages(context, snapshot.data!.results),
                  ),
                );
              }
            },
          )
        ],
      ),
    );
  }
}

List<Widget> makePopBoxImages(BuildContext context, List<PopResults>? movies) {
  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(
        InkWell(
          onTap: () {
            Navigator.of(context).push(
              MaterialPageRoute(
                  fullscreenDialog: true,
                  builder: (BuildContext context) {
                    return PopDetailScreen(movie: movies[i]);
                  }),
            );
          },

      child: Container(
        padding: EdgeInsets.only(right: 10),
        child: Align(
            alignment: Alignment.centerLeft,
            child: Image(
              image: NetworkImage(
                  'https://image.tmdb.org/t/p/original${movies[i].poster_path}'),
            )),
      ),
    )
    );
  }
  print('box : ${result.length}');
  return result;
}
