import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:provider/provider.dart';
import 'package:netflix/hive/movie_like_id.dart';
import 'package:netflix/model/movieModel/movie.dart';


class DetailScreen extends StatefulWidget {
  final Movies movie;
  final BuildContext TakeContext;
  const DetailScreen({required this.movie, required this.TakeContext, Key? key}) : super(key: key);


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
     var provider1 = context.watch<HiveHelper>();
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
                      image: NetworkImage(
                          "https://image.tmdb.org/t/p/original${widget.movie.poster_path}"),
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
                                // Container(
                                //   padding: EdgeInsets.all(5),
                                //   alignment: Alignment.centerLeft,
                                //   child: Text(
                                //     '출연: 현빈, 손예진, 서지혜\n제작자: 이정훈, 박지은',
                                //     style: TextStyle(
                                //         color: Colors.white60, fontSize: 12),
                                //   ),
                                // ),
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
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        Container(
                          padding: EdgeInsets.fromLTRB(20, 10, 20, 10),
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
                                        LikeMovies(
                                          id: widget.movie.id,
                                          overview: widget.movie.overview,
                                          poster_path:widget.movie.poster_path,
                                          release_date: widget.movie.release_date,
                                          title: widget.movie.title,
                                          vote_average: widget.movie.vote_average,
                                        ));
                                    print('들어가냐? : ${provider1.likeIdBox!.containsKey(widget.movie.id.toString())}');

                                    //provider2.create(movies[provider.index].id.toString(),LikeMovies(id: movies[provider.index].id.toString()));
                                  },
                                    icon: Icon(Icons.favorite_border),
                            ),
                                Text(
                                  '내가 찜한 콘텐츠',
                                  style: TextStyle(
                                      fontSize: 11, color: Colors.white60),
                                )
                              ],
                            ),
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.fromLTRB(20, 10, 20, 10),
                          child: Container(
                            child: Column(
                              children: [
                                Icon(Icons.thumb_up),
                                Padding(
                                  padding: EdgeInsets.all(5),
                                ),
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
                          padding: EdgeInsets.fromLTRB(20, 10, 20, 10),
                          child: Container(
                            child: Column(
                              children: [
                                Icon(Icons.share),
                                Padding(
                                  padding: EdgeInsets.all(5),
                                ),
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
                      child: Text(
                        '줄거리',
                        textAlign: TextAlign.start,
                        style: TextStyle(fontSize: 20,fontWeight: FontWeight.w600, color: Colors.grey.shade400),
                      ),
                      padding: EdgeInsets.fromLTRB(0, 5, 0, 10),
                    ),
                    Text('${widget.movie.overview}'),
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
