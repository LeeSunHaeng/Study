import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/movie_search_provider.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:provider/provider.dart';

import '../model/movieModel/movie.dart';
import 'detail_screen.dart';

class _SliverFixedHeaderDelegate extends SliverPersistentHeaderDelegate {
  final Widget child;
  final double maxHeight;
  final double minHeight;
  _SliverFixedHeaderDelegate(
      {required this.child, required this.maxHeight, required this.minHeight});

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return SizedBox.expand(
      child: child,
    );
  }

  @override
  //최대 높이
  double get maxExtent => maxHeight;

  @override
  //최소 높이
  double get minExtent => minHeight;

  @override
  // covariant ->  상속된 클래스도 사용 가능\
  // oldDelegate - build가 실행이 됐을때 이전 Delegate
  // this - 새로운 delegate
  // shouldRebuild - 새로 build를 해야 할지 말지 결정
  // false - 빌드안함, true - 빌드함
  bool shouldRebuild(covariant _SliverFixedHeaderDelegate oldDelegate) {
    return oldDelegate.minHeight != minHeight ||
        oldDelegate.maxHeight != maxHeight ||
        oldDelegate.child != child;
  }
}

class CustomSearchScreen extends StatelessWidget {
  const CustomSearchScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
        margin: const EdgeInsets.fromLTRB(10, 40, 10, 0),
        child:
            Consumer<MovieSearchProvider>(builder: (context, provider, widget) {
          return CustomScrollView(
            slivers: [
              SliverPersistentHeader(
                delegate: _SliverFixedHeaderDelegate(
                  child: Container(
                    padding: const EdgeInsets.all(10),
                    child: TextField(
                      onChanged: (text) {
                        provider.SearchMovie(text);
                      },
                      decoration: const InputDecoration(
                        labelText: 'Search',
                        hintText: 'Enter Search Movie',
                        labelStyle: TextStyle(color: Colors.redAccent),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide:
                              BorderSide(width: 1, color: Colors.redAccent),
                        ),
                        enabledBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                          borderSide:
                              BorderSide(width: 1, color: Colors.redAccent),
                        ),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(10.0)),
                        ),
                        suffixIcon: Icon(Icons.search), //검색 아이콘 추가
                        contentPadding: EdgeInsets.only(
                            left: 5, bottom: 5, top: 5, right: 5),
                      ),
                      keyboardType: TextInputType.emailAddress,
                    ),
                  ),
                  minHeight: 0,
                  maxHeight: 70,
                ),
                pinned: true,
              ),

              //하나하나 직접 컨테이너 그려줘야함!
              SliverGrid(
                delegate: SliverChildBuilderDelegate((context, index) {
                  if (provider.ResultMovies.results == null) {
                    return const Center(
                      child: Text(
                        '검색 결과가 없습니다.',
                        style: TextStyle(fontSize: 10),
                      ),
                    );
                  }
                  if(provider.ResultMovies.results![index].poster_path != null) {
                    return InkWell(
                      onTap: () {
                        Navigator.of(context).push(
                          MaterialPageRoute(
                              fullscreenDialog: true,
                              builder: (BuildContext context) {
                                return DetailScreen(
                                    movie:
                                    provider.ResultMovies.results![index]);
                                //return Text('히히');
                              }),
                        );
                      },
                      child: Container(
                        height: 200,
                        //alignment: Alignment.center,
                        padding: const EdgeInsets.all(2),
                        child: CachedNetworkImage(
                          width: 100,
                          height: 168.1,
                          //placeholder: (context, url) => CircularProgressIndicator(),
                          imageUrl:
                          'https://image.tmdb.org/t/p/original${provider
                              .ResultMovies.results![index].poster_path}',
                          fit: BoxFit.cover,
                        ),
                      ),

                    );
                  }
                },
                    childCount: provider.ResultMovies.results == null
                        ? 1
                        : provider.ResultMovies.results!.length
                    //childCount: 1
                    ),
                //gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(maxCrossAxisExtent: 150),
                gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 3,
                  mainAxisExtent: 180
                ),
              )
            ],
          );
        }));
  }

  SliverPersistentHeader renderSearch() {
    return SliverPersistentHeader(
      delegate: _SliverFixedHeaderDelegate(
        child: Consumer<MovieSearchProvider>(
          builder: (context, provider, widget) {
            return Container(
              padding: EdgeInsets.all(10),
              child: TextField(
                onChanged: (text) {
                  provider.SearchMovie(text);
                },
                decoration: const InputDecoration(
                  labelText: 'Search',
                  hintText: 'Enter Search Movie',
                  labelStyle: TextStyle(color: Colors.redAccent),
                  focusedBorder: OutlineInputBorder(
                    borderRadius: BorderRadius.all(Radius.circular(10.0)),
                    borderSide: BorderSide(width: 1, color: Colors.redAccent),
                  ),
                  enabledBorder: OutlineInputBorder(
                    borderRadius: BorderRadius.all(Radius.circular(10.0)),
                    borderSide: BorderSide(width: 1, color: Colors.redAccent),
                  ),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.all(Radius.circular(10.0)),
                  ),
                  suffixIcon: Icon(Icons.search), //검색 아이콘 추가
                  contentPadding:
                      EdgeInsets.only(left: 5, bottom: 5, top: 5, right: 5),
                ),
                keyboardType: TextInputType.emailAddress,
              ),
            );
          },
        ),
        minHeight: 50,
        maxHeight: 250,
      ),
      pinned: false,
    );
  }
}

List<Widget> makeBoxImages(BuildContext context, List<Movie>? movies) {
  if (movies == null) {
    return [
      Text(
        '검색 결과가 없습니다.',
        style: TextStyle(fontSize: 10),
      )
    ];
  }

  List<Widget> result = [];
  for (int i = 0; i < movies.length; i++) {
    result.add(InkWell(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
              fullscreenDialog: true,
              builder: (BuildContext context) {
                return DetailScreen(movie: movies[i]);
                //return Text('히히');
              }),
        );
      },
      child: Container(
          //alignment: Alignment.center,
          padding: EdgeInsets.all(2),
          child: CachedNetworkImage(
            //width: 100,
            //height: 168.1,
            //placeholder: (context, url) => CircularProgressIndicator(),
            imageUrl:
                'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
            fit: BoxFit.cover,
          )),
    ));
  }
  return result;
}
