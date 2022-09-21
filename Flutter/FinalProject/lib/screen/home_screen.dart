import 'package:dio/dio.dart';
import 'package:finalproject/component/card_title.dart';
import 'package:finalproject/component/category_card.dart';
import 'package:finalproject/component/hourly_card.dart';
import 'package:finalproject/component/main_app_bar.dart';
import 'package:finalproject/component/main_card.dart';
import 'package:finalproject/component/main_drawer.dart';
import 'package:finalproject/component/main_stat.dart';
import 'package:finalproject/const/api_data.dart';
import 'package:finalproject/const/colors.dart';
import 'package:finalproject/retrofit/rest_client.dart';
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
    //fetchData();
    RetroData();
  }
  
  fetchData() async{
    final response = await Dio().get(
        'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty',
      queryParameters:
      {
          'serviceKey': 'ALkKvr2F8p3XhgFXvzBa3gN5t5dHmbdJwMCnb019Dt/HnF9USCZ6La1AU5Cs+19xDgEDIfJPHLZJOAp6kuj4gw==',
          'sidoName' : '경기도',
          'returnType' : 'json',
        }
        );
    print(response.data);
  }

  RetroData() async{
    final response = await RestClient.create().getFineDust('ALkKvr2F8p3XhgFXvzBa3gN5t5dHmbdJwMCnb019Dt/HnF9USCZ6La1AU5Cs+19xDgEDIfJPHLZJOAp6kuj4gw==', '부산', 'json');
    print(response.response!.body!.items![2].coValue);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: primaryColor,
        drawer: MainDrawer(),
        body: CustomScrollView(
          slivers: [
            MainAppBar(),
            SliverToBoxAdapter(
              child: Column(
                children: [
                  CategoryCard(),
                  SizedBox(
                    height: 16.0,
                  ),
                  HourlyCard(),

                ],
              ),
            )
          ],
        ));
  }
}
