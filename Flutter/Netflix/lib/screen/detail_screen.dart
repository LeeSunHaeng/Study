import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/provider/movie_similar_provider.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:provider/provider.dart';
import 'package:netflix/model/movieModel/movie.dart';



class DetailScreen extends StatefulWidget {
  final Movie movie;
  const DetailScreen({required this.movie, Key? key}) : super(key: key);
  
  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  bool like = false;
  @override
  void initState() {
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    final _provider = Provider.of<MovieSimilarProvider>(context,listen:false);
    _provider.getSimilarMovies(widget.movie.id!);

    return Scaffold(
      body: Container(
        child: SafeArea(
          child: ListView(
            children: [
              Stack(
                children: [
                  Container(
                    //뒤에 불투명한 부분 데코레이션
                    width: double.maxFinite,
                    decoration: BoxDecoration(
                        image: DecorationImage(
                      image: CachedNetworkImageProvider( "https://image.tmdb.org/t/p/original${widget.movie.poster_path}"),
                      fit: BoxFit.cover,
                    )),
                    //실제 이미지
                    child: ClipRect(
                      child: BackdropFilter(
                        filter: ImageFilter.blur(sigmaX: 10, sigmaY: 10),
                        child: Container(
                          alignment: Alignment.center,
                          color: Colors.black.withOpacity(0.1),
                          child: Container(
                            child: Column(
                              children: [
                                Container(
                                  padding: EdgeInsets.fromLTRB(0, 45, 0, 10),
                                  height: 300,
                                  child: CachedNetworkImage(
                                      placeholder: (context, url) => Container(
                                          height: 60,
                                          child: CircularProgressIndicator()),
                                      imageUrl: 'https://image.tmdb.org/t/p/original${widget.movie.poster_path}',
                                      errorWidget: (context, url, error) => Icon(Icons.error)
                                      ),
                                ),
                                Container(
                                  padding: EdgeInsets.all(7),
                                  child: Text(
                                    '${widget.movie.release_date}일 개봉',
                                    style: TextStyle(fontSize: 13),
                                  ),
                                ),
                                Container(
                                  padding: EdgeInsets.all(7),
                                  child: Text(
                                    widget.movie.title!,
                                    textAlign: TextAlign.center,
                                    style: const TextStyle(
                                        fontWeight: FontWeight.bold,
                                        fontSize: 16),
                                  ),
                                ),
                                //재생버튼
                                Container(
                                    padding: EdgeInsets.all(3),
                                    child: TextButton(
                                      onPressed: () {},
                                      style: ButtonStyle(
                                          backgroundColor:
                                              MaterialStateProperty.all(
                                                  Colors.red)),
                                      child: Row(
                                        mainAxisAlignment:
                                            MainAxisAlignment.center,
                                        children: const [
                                          Icon(
                                            Icons.play_arrow,
                                            color: Colors.white,
                                          ),
                                          Text(
                                            '재생',
                                            style:
                                                TextStyle(color: Colors.white),
                                          ),
                                        ],
                                      ),
                                    )),
                                Container(
                                  padding: EdgeInsets.all(5),
                                  child:
                                      Text('평점 : ${widget.movie.vote_average}'),
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  Positioned(
                      child: AppBar(
                    backgroundColor: Colors.transparent,
                    elevation: 0,
                  ))
                ],
              ),
              Container(
                    color: Colors.black26,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        Consumer<HiveHelper>(
                          builder: (context, provider1, widget2){
                            return Container(
                              padding: EdgeInsets.fromLTRB(20, 0, 20, 10),
                              child: InkWell(
                                onTap: () {},
                                child: Column(
                                  children: [
                                    provider1.likeIdBox!.containsKey(widget.movie.id.toString())
                                        ? IconButton(
                                      icon: Icon(Icons.favorite),
                                      onPressed: () {
                                        provider1.delete(widget.movie.id.toString());
                                      },
                                    )
                                        : IconButton(
                                            onPressed: () {
                                              provider1.create(
                                                  widget.movie.id.toString(),
                                                  Movie(
                                                    id: widget.movie.id,
                                                    overview: widget.movie.overview,
                                                    poster_path:widget.movie.poster_path,
                                                    release_date: widget.movie.release_date,
                                                    title: widget.movie.title,
                                                    vote_average: widget.movie.vote_average,
                                                  ));

                                            },
                                          icon: Icon(Icons.favorite_border),
                                    ),
                                    const Text(
                                      '내가 찜한 콘텐츠',
                                      style: TextStyle(
                                          fontSize: 11, color: Colors.white60),
                                    )
                                  ],
                                ),
                              ),
                            );
                          },

                        ),
                        Container(
                          padding: EdgeInsets.fromLTRB(20, 0, 20, 10),
                          child: Container(
                            child: Column(
                              children:  [
                                IconButton(
                                  onPressed: (){},
                                    icon : Icon(Icons.thumb_up)),

                                Text(
                                  '평가',
                                  style: TextStyle(
                                      fontSize: 11, color: Colors.white60),
                                )
                              ],
                            ),
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.fromLTRB(20, 0, 20, 10),
                          child: Container(
                            child: Column(
                              children:  [
                                IconButton(onPressed: (){
                                }, icon: Icon(Icons.share)),

                                Text(
                                  '공유',
                                  style: TextStyle(
                                      fontSize: 11, color: Colors.white60),
                                )
                              ],
                            ),
                          ),
                        )
                      ],
                    ),
                  ),

              Container(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    Container(
                      padding: EdgeInsets.fromLTRB(5, 10, 5, 10),
                      child: Text('${widget.movie.overview}',style: TextStyle(color : Colors.grey.shade400),),
                    ),

                  ],
                ),
              ),
              Container(
                padding: EdgeInsets.fromLTRB(5, 10, 5, 10),
                child: Text(
                  '다른 비슷한 컨텐츠',
                  textAlign: TextAlign.start,
                  style: TextStyle(fontSize: 20,fontWeight: FontWeight.w600,),
                ),
              ),
              // FutureBuilder<Movies>(
              //   future: RestClient.create().getSimilar(widget.movie.id!,'ce16f7da30a47ba16d9f038d895318bd','ko-KR'),
              //     builder: (BuildContext context, snapshot){
              //     if(snapshot.hasData){
              //       return Container(
              //         //padding: EdgeInsets.all(5),
              //         //height: MediaQuery.of(context).size.height-25,
              //         height: 500,
              //         child: GridView.count(
              //           crossAxisCount: 3,
              //           childAspectRatio: 1/1.618,
              //           mainAxisSpacing: 0,
              //           crossAxisSpacing: 0,
              //           children: makeSimilarImages(context, snapshot.data!.results),
              //         ),
              //       );
              //     }
              //     else{
              //     return Container(
              //         height: 80,
              //         width: 80,
              //         padding: EdgeInsets.only(right: 10),
              //         child: CircularProgressIndicator());
              //   }
              // })



              Consumer<MovieSimilarProvider>(
                  builder: (context, provider, widget2){

                if(provider.SimilarMovies.results != null){
                  return Container(
                              //padding: EdgeInsets.all(5),
                              //height: MediaQuery.of(context).size.height-25,
                              height: 500,
                              child: GridView.count(
                                crossAxisCount: 3,
                                childAspectRatio: 1/1.618,
                                // mainAxisSpacing: 0,
                                // crossAxisSpacing: 0,
                                children: makeSimilarImages(context, provider.SimilarMovies.results),
                              ),
                            );
                }else{
                      return Container(
                              height: 80,
                              width: 80,
                              padding: EdgeInsets.only(right: 10),
                              child: CircularProgressIndicator());
                      }
              })


            ],
          ),
        ),
      ),
    );
  }
}

List<Widget> makeSimilarImages(
    BuildContext context, List<Movie>? movies) {

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
          padding: EdgeInsets.all(5),
              child:ClipRRect(
                borderRadius: BorderRadius.circular(10.0),
                child: CachedNetworkImage(
                  //placeholder: (context, url) => CircularProgressIndicator(),
                  imageUrl: 'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
                  fit: BoxFit.cover,
                ),
              )
        )
    )
    );
  }
  return result;
}
