import 'dart:convert';
import 'dart:ui';

import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:retrofit5/Retrofit/RestClient.dart';
import 'package:retrofit5/const/data.dart';

class RestScreen extends StatefulWidget {
  const RestScreen({Key? key}) : super(key: key);

  @override
  State<RestScreen> createState() => _RestScreenState();
}

class _RestScreenState extends State<RestScreen> {

  late RestClient client;
  late List<Items> data;
  late Autogenerated resp;


  @override
  void initState() {
    super.initState();
    test();
    stm();
    print('히히히히');
  }

  Future<void> test() async {

    Dio dio = Dio();
    client = RestClient(dio);
    resp = await client.getJson(serviceKey, '서울', 'json','','');
    var data2 = resp.response!.body!.items![0];
    //var data3 = resp.response!.body!.items!.map((e) => 'item : ${e.toJson()}');

    //print('map : ${data3}');
    print('length : ${resp.response!.body!.items!.length}');
    print('data : ${data2.dataTime}');

    setState(() {
    });
}

  Stream<String> stm() async* {
    Dio dio = Dio();

    client = RestClient(dio);
    resp = await client.getJson(serviceKey, '서울', 'json','','');
    data = resp.response!.body!.items!;

    for(int i = 0; i<data.length; i++){
      await Future.delayed(Duration(seconds: 1));
      yield data[i].stationName.toString();
    }
  }




  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: StreamBuilder(
        stream: stm(),
        builder: (BuildContext context, snapshot){
          return Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text('${snapshot.data}')
            ],
          );
        },
      ),
    );
  }
}
