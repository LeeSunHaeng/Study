import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:netflix/provider/movie_search_provider.dart';
import 'package:netflix/retrofit/RestClient.dart';
import 'package:provider/provider.dart';

import '../model/movieModel/movie.dart';
import 'detail_screen.dart';

class SearchScreen extends StatelessWidget {
  const SearchScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.fromLTRB(10, 40, 10, 0),
      child: GestureDetector(
        onTap: () => FocusScope.of(context).unfocus(),
        child: SingleChildScrollView(
          child: Consumer<MovieSearchProvider>(
            builder: (context, provider, widget){
              return Column(
                children:  [
                  Container(
                    padding: EdgeInsets.all(10),
                    child: TextField(
                      onChanged: (text){
                        provider.SearchMovie(text);
                      },
                      decoration: InputDecoration(
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
                        contentPadding: EdgeInsets.only(left: 5, bottom: 5, top: 5, right: 5),
                      ),
                      keyboardType: TextInputType.emailAddress,

                    ),
                  ),
                  Container(
                    //padding: EdgeInsets.all(5),
                    height: MediaQuery.of(context).size.height-25,
                    child: GridView.count(
                      crossAxisCount: 3,
                      childAspectRatio: 1/1.618,
                      mainAxisSpacing: 0,
                      crossAxisSpacing: 0,
                      children: makeBoxImages(context, provider.ResultMovies.results),
                    ),
                  ),
                ],
              );
            },
          ),
        ),
      ),
    );

  }
}

List<Widget> makeBoxImages(
    BuildContext context, List<Movie>? movies) {

  if(movies == null){
    return [Text('검색 결과가 없습니다.',style: TextStyle(fontSize: 10),)];
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
            imageUrl: 'https://image.tmdb.org/t/p/original${movies[i].poster_path}',
            fit: BoxFit.cover,
          )

      ),
    ));
  }
  return result;
}

