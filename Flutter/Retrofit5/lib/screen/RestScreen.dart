import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:retrofit5/Retrofit/RestClient.dart';

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

    Dio dio = Dio();

    client = RestClient(dio);
    var resp = client.getData();
    print(resp);


  }
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('히히'),
    );
  }
}
