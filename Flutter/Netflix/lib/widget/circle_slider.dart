import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/model/toprated/toprated.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:netflix/screen/top_detail_screnn.dart';

class CircleSlider extends StatefulWidget {
  const CircleSlider({Key? key}) : super(key: key);

  @override
  State<CircleSlider> createState() => _CircleSliderState();
}

class _CircleSliderState extends State<CircleSlider> {
  late RestClient client;
  late Future<TopRated> TRated;

  Future<TopRated> getTopRated() async {
    // Dio dio = Dio();
    // client = RestClient(dio);
    var resp = await RestClient.create().getTopRated(
        'ce16f7da30a47ba16d9f038d895318bd', 'ko-KR', 1, 'KR');
    return resp;
  }

  @override
  void initState() {
    super.initState();
    TRated = getTopRated();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('영화 순위'),
          FutureBuilder<TopRated>(
            future: TRated,
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
                      children:
                          makeCircleImages(context, snapshot.data!.results),
                    ));
              }
            },
          )
        ],
      ),
    );
  }
}

List<Widget> makeCircleImages(
    BuildContext context, List<TopRatedResults>? movies) {
  List<Widget> result = [];
  for (int i = 0; i < movies!.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                return TopDetailScreen(movie: movies[i]);
              }),
        );
      },
      child: Container(
        padding: EdgeInsets.only(right: 10),
        child: Align(
          alignment: Alignment.centerLeft,
          child: CircleAvatar(
            backgroundImage: NetworkImage(
                'https://image.tmdb.org/t/p/original${movies[i].poster_path}'),
            radius: 48,
          ),
        ),
      ),
    ));
  }
  return result;
}
