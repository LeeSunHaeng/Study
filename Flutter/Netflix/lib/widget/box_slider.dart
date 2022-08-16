import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/retrofit/RestClient.dart';
import '../model/nplaying/nowplaying.dart';
import '../screen/detail_screen.dart';

class BoxSlider extends StatefulWidget {
  const BoxSlider({Key? key}) : super(key: key);

  @override
  State<BoxSlider> createState() => _BoxSliderState();
}

class _BoxSliderState extends State<BoxSlider> {
  late RestClient client;
  late Future<NowPlaying> GNP;

  Future<NowPlaying> getNowPlaying() async {
    // Dio dio = Dio();
    // client = RestClient(dio);
    var resp = await RestClient.create().getNowPlaying(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
    return resp;
  }

  @override
  void initState() {
    super.initState();
    GNP = getNowPlaying();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('현재 상영중인 영화'),
          FutureBuilder<NowPlaying>(
            future: GNP,
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.none ||
                  snapshot.connectionState == ConnectionState.waiting) {
                return Container(
                    height: 120,
                    padding: EdgeInsets.only(right: 10),
                    child: CircularProgressIndicator());
              } else {
                return Container(
                  height: 120,
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: makeBoxImages(context, snapshot.data!.results),
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

List<Widget> makeBoxImages(
    BuildContext context, List<NowPlayingResults>? movies) {
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
            child: Image(
              image: NetworkImage(
                  'https://image.tmdb.org/t/p/original${movies[i].poster_path}'),
            )),
      ),
    ));
  }
  return result;
}
