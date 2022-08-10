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
  @override
  void initState() {
    super.initState();
  fetch();
  }

  Future<void> fetch() async{
    Dio dio = Dio();
    client = RestClient(dio);
    dynamic resp = await client.getData(serviceKey, '시도');
    print(resp.response);

    setState(() {

    });
}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
          child: Text('안녕하세요')
      ),
    );
  }
}
