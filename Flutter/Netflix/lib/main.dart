import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:netflix/provider/hive_helper.dart';
import 'package:netflix/hive/movie_like_id.dart';
import 'package:netflix/provider/movie_provider.dart';
import 'package:netflix/screen/home_screen.dart';
import 'package:netflix/screen/like_screen.dart';
import 'package:netflix/widget/bottom_bar.dart';
import 'package:provider/provider.dart';


void main() async{
  await Hive.initFlutter();
  Hive.registerAdapter(LikeMoviesAdapter());
  await HiveHelper().openBox();

  runApp(
      MultiProvider(
          providers: [
            ChangeNotifierProvider(
              create: (BuildContext context) => MovieProvider(),
            ),
            ChangeNotifierProvider(
              create: (BuildContext context) => HiveHelper(),
            )
          ],
          child: const MyApp(),
      )
  );
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
      home:
        DefaultTabController(
          length: 4,
          child: Scaffold(
            body: TabBarView(
              physics: NeverScrollableScrollPhysics(),
              children: <Widget>[
                HomeScreen(),
                Container(
                  child: Center(
                    child: Text('Search'),
                  ),
                ),
                LikeScreen(),
                Container(
                  child: Center(
                    child: Text('More'),
                  ),
                ),
              ],
            ),
            bottomNavigationBar: Bottom(),
          ),
      ),
    );
  }
}
