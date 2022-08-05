import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:logger/logger.dart';
import 'package:retrofit/retrofit.dart';
import 'package:retrofit3/retrofit/RestClient.dart';
import 'package:retrofit3/screen/HomeScreen.dart';
import 'package:retrofit3/screen/RetrofitScreen.dart';

  final logger = Logger();

void main() {

  runApp(MaterialApp(
    home: RetrofitScreen()
  ));
}
