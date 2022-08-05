import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:retrofit4/Retrofit/RestClient.dart';

class RetrofitScreen extends StatefulWidget {
  const RetrofitScreen({Key? key}) : super(key: key);

  @override
  State<RetrofitScreen> createState() => _RetrofitScreenState();
}

class _RetrofitScreenState extends State<RetrofitScreen> {
  late RestClient client;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    Dio dio = Dio();
    client = RestClient(dio);
    var resp = client.getTopNews().toString();
    print(resp);

  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('안녕안녕'),
    );
  }
}
