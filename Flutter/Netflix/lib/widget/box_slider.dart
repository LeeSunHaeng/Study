
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:provider/provider.dart';
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
  // late MovieProvider _nowPlayingProvider;


  @override
  void initState() {
    super.initState();
    // _nowPlayingProvider = Provider.of<MovieProvider>(context, listen: false);
    // _nowPlayingProvider.getNowPlaying();
  }

  @override
  Widget build(BuildContext context) {


    return Container(
      padding: EdgeInsets.all(7),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: EdgeInsets.only(bottom: 5.0),
              child: Text('현재 상영중인 영화')),
          Consumer<MovieProvider>(
              builder: (context, provider ,widget) {
                if(provider.NowPlayingMovies != null && provider.NowPlayingMovies.length > 0){
                  return Container(
                    height: 120,
                    child: ListView(
                      scrollDirection: Axis.horizontal,
                      children: makeBoxImages(context,provider.NowPlayingMovies),
                    ),
                  );
                }
                else{
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
