import 'package:agoraapiproject/const/colors.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class _SliverFixedHeaderDelegate extends SliverPersistentHeaderDelegate{
  final Widget child;
  final double maxHeight;
  final double minHeight;
   _SliverFixedHeaderDelegate({required this.child, required this.maxHeight, required this.minHeight});

  @override
  Widget build(BuildContext context, double shrinkOffset, bool overlapsContent) {
    return SizedBox.expand(
      child: child,
    );
  }

  @override
  //최대 높이
  double get maxExtent => maxHeight;

  @override
  //최소 높이
  double get minExtent => minHeight;

  @override
  // covariant ->  상속된 클래스도 사용 가능\
  // oldDelegate - build가 실행이 됐을때 이전 Delegate
  // this - 새로운 delegate
  // shouldRebuild - 새로 build를 해야 할지 말지 결정
  // false - 빌드안함, true - 빌드함
  bool shouldRebuild(covariant _SliverFixedHeaderDelegate oldDelegate) {
    return oldDelegate.minHeight != this.minHeight ||
    oldDelegate.maxHeight != this.maxHeight ||
    oldDelegate.child !=child;


  }

}

class CustomScrollViewScreen extends StatelessWidget {
  final List<int> numbers = List.generate(100, (index) => index);
  CustomScrollViewScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: CustomScrollView(
          //slivers 안에는 무조건 Sliver 위젯만 넣어야함 ex) 일반 ListView를 넣으면 에러가 남 -> SliverList를 넣어야함
          slivers: [
            //스크롤하면 앱바가 사라짐
            renderSliverAppBar(),
            renderHeader(),
            renderSliverGridBuilder(),
            renderHeader(),
            renderSliverChildBuilder(),
            renderHeader(),
      ],
    )
    );
  }

  SliverPersistentHeader renderHeader(){
    return SliverPersistentHeader(
        delegate: _SliverFixedHeaderDelegate(
          child: Container(
            color: Colors.black,
            child: Center(child: Text('신기하지',style: TextStyle(color: Colors.white),),),
          ),
          minHeight: 50,
          maxHeight: 250,
        ),
      pinned: true,
      );
  }
  //AppBar
  SliverAppBar renderSliverAppBar() {
    return SliverAppBar(
      title: Text('히히'),
      //스크롤 내렸다가 올리면 바로 AppBar가 보이게 함
      floating: true,

      //AppBar 상단 고정
      pinned: false,

      //AppBar 스크롤 방향으로 애니메이션 처리 == 자석효과, floating이 true인 경우에만 사용 가능
      snap: true,

      //맨 위에서 한계 이상으로 스크롤 했을때 남는 공간을 AppBar가 차지함
      stretch: true,

      expandedHeight: 300,
      collapsedHeight: 200,
      flexibleSpace: FlexibleSpaceBar(
        title: Text('FlexibleSpace'),
      ),
    );
  }

  SliverGrid renderSliverGridBuilder() {
    return SliverGrid(
      delegate: SliverChildBuilderDelegate((context, index) {
        return renderContainer(
            color: rainbowColors[index % rainbowColors.length], index: index);
      }, childCount: 100, addAutomaticKeepAlives: true),
      gridDelegate:
          SliverGridDelegateWithMaxCrossAxisExtent(maxCrossAxisExtent: 150),
    );
  }

  //GridView.count와 유사함
  SliverGrid renderChildSliverGrid() {
    return SliverGrid(
      delegate: SliverChildListDelegate(
        numbers
            .map((e) => renderContainer(
                color: rainbowColors[e % rainbowColors.length], index: e))
            .toList(),
      ),
      gridDelegate:
          SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2),
    );
  }

  SliverList renderSliverChildBuilder() {
    return SliverList(
      delegate: SliverChildBuilderDelegate((context, index) {
        return renderContainer(
            color: rainbowColors[index % rainbowColors.length], index: index);
      }, childCount: 10),
    );
  }

  SliverList renderChildSliverList() {
    return SliverList(
      delegate: SliverChildListDelegate(
        numbers
            .map((e) => renderContainer(
                color: rainbowColors[e % rainbowColors.length], index: e))
            .toList(),
      ),
    );
  }

  Widget renderColumn() {
    return Column(
      children: [
        //Coulmn안에 ListView를 사용하면 ListView의 높이는 사실상 무한이기 때문에 Expanded를 사용해 길이 지정을 해줘야 한다!
        Expanded(
          child: ListView(
            children: rainbowColors
                .map((e) => renderContainer(color: e, index: 1))
                .toList(),
          ),
        ),
        Expanded(
          child: GridView.count(
            crossAxisCount: 2,
            children: rainbowColors
                .map((e) => renderContainer(color: e, index: 1))
                .toList(),
          ),
        )
      ],
    );
  }

  Widget renderContainer({
    required Color color,
    required int index,
    double? height,
  }) {
    print(index);

    return Container(
      //height: height == null ? 300 : height,
      //key: Key(index.toString()),
      height: height ?? 300,
      color: color,
      child: Center(
        child: Text(
          index.toString(),
          style: TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.w700,
            fontSize: 30.0,
          ),
        ),
      ),
    );
  }
}
