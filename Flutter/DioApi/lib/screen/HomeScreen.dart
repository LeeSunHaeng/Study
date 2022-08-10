import 'package:dio/dio.dart';
import 'package:dioapi/const/data.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    fetchData();

  }

  fetchData() async {
    final response = await Dio().get(
      'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty',
      queryParameters: {
        'serviceKey' : serviceKey,
        'sidoName' : '서울',
        'returnType' : 'json',
        'nomOfRows' : '3',
        'pageNo' : '1'
      }
    );
    print(response.data);
  }



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("ㅎㅎ"),
      ),
    );
  }
}
