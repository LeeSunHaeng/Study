import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:logger/logger.dart';
import 'package:retrofit5/Retrofit/RestClient.dart';
import 'package:retrofit5/const/data.dart';

class RestScreen extends StatefulWidget {
  const RestScreen({Key? key}) : super(key: key);

  @override
  State<RestScreen> createState() => _RestScreenState();
}

class _RestScreenState extends State<RestScreen> {

  late RestClient client;
  late Logger logger;


  @override
  void initState() {
    super.initState();

    // Dio dio = Dio();
    // client = RestClient(dio);
    // var resp = client.getData(serviceKey,'서울');
    //final rere = resp.then((value) => jsonEncode(value));
    // Future.microtask(() async{
    //   var rree = jsonDecode(jsonEncode(await client.getData(serviceKey, '서울','json').toString())) ;
    //   print(rree);
    // });
    fetch();

  }
   fetch() async {

    Dio dio = Dio();
    client = RestClient(dio);
    client.getData(serviceKey, '서울','json').then((value) => print(value));
    //List<dynamic> rree = await client.getData(serviceKey, '서울','json');
    // Map<String,dynamic> map = jsonDecode(rree[0].dataTime!);
    // List<dynamic> data = map["dataTime"];
    //print(rree);
     print('sss');
  }
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('안녕하세요'),
    );
  }
}
