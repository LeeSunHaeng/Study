import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:retrofit2/Retrofit/RestClient.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  var dio = Dio();
  late RestClient client;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();


    client = RestClient();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
       crossAxisAlignment: CrossAxisAlignment.stretch,
       children: [
         Text('Retrofit Test',textAlign: TextAlign.center,),
       ],
      ),
    );
  }
}
