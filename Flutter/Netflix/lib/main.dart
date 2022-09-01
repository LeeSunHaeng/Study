import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/provider/movie_search_provider.dart';
import 'package:netflix/provider/movie_similar_provider.dart';
import 'package:netflix/screen/home_screen.dart';
import 'package:netflix/screen/like_screen.dart';
import 'package:netflix/screen/search_screen.dart';
import 'package:netflix/widget/bottom_bar.dart';
import 'package:provider/provider.dart';

import 'model/movieModel/movie.dart';

void main() async {
  await Hive.initFlutter();
  Hive.registerAdapter(MovieAdapter());
  await HiveHelper().openBox();

  runApp(MultiProvider(
    providers: [
      ChangeNotifierProvider(
        create: (BuildContext context) => MovieProvider(),
      ),
      ChangeNotifierProvider(
        create: (BuildContext context) => HiveHelper(),
      ),
      ChangeNotifierProvider(
          create: (BuildContext context) => MovieSearchProvider()
      ),
      ChangeNotifierProvider(
          create: (BuildContext context) => MovieSimilarProvider()
      ),
    ],
    child: const MyApp(),
  ));
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  late TabController controller;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'NetFlix',
      theme: ThemeData(
        brightness: Brightness.dark,
        primaryColor: Colors.black,
        accentColor: Colors.black,
      ),
      home: DefaultTabController(
        length: 4,
        child: SafeArea(
          top: true,
          child: Scaffold(
            body: Stack(
              children: [
                TopBar(),
                TabBarView(
                  physics: NeverScrollableScrollPhysics(),
                  children: <Widget>[
                    HomeScreen(),
                    SearchScreen(),
                    LikeScreen(),
                    Container(
                      child: Center(
                        child: Text('More'),
                      ),
                    ),
                  ],
                ),
              ],
            ),
            bottomNavigationBar: Bottom(),
          ),
        ),
      ),
    );
  }
}
