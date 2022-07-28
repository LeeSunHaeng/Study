import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class homeScreen extends StatelessWidget {
  WebViewController? controller;
  homeScreen({Key? key}) : super(key: key);
  final homeUrl = 'https://blog.codefactory.ai';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.orange,
        title: Text('CodeFactory'),
        centerTitle: true,
        actions: [
          IconButton(onPressed: () {

          if(controller == null){
            return;
          }else{
            controller!.loadUrl(homeUrl);
          }

        },
            icon: Icon(
              Icons.home,
            ))],
      ),
      body: WebView(
        onWebViewCreated: (WebViewController controller) {
          this.controller = controller;
        },
        initialUrl: homeUrl,
        javascriptMode: JavascriptMode
            .unrestricted, //WebView는 자바스크립트가 기본으로 사용안하게 되어있어서 사용한다고 설정해줘야함
      ),
    );
  }
}
