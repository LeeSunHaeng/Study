import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:retrofit3/retrofit/RestClient.dart';

class RetrofitScreen extends StatefulWidget {
  const RetrofitScreen({Key? key}) : super(key: key);

  @override
  State<RetrofitScreen> createState() => _RetrofitScreenState();
}

class _RetrofitScreenState extends State<RetrofitScreen> {

  late RestClient client;

  @override
  void initState(){
    Dio dio = Dio();
    client = RestClient(dio);
    super.initState();

    Future.microtask(() async{
      final resp = await client.getTopNews();
      print(resp);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('ㅎㅎㅎ'),
    );
  }
}
