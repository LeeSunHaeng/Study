// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'RestClient.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

News _$NewsFromJson(Map<String, dynamic> json) => News(
      serviceKey: json['serviceKey'] as String?,
      returnType: json['returnType'] as String?,
      numOfRows: json['numOfRows'] as String?,
      pageNo: json['pageNo'] as String?,
      sidoName: json['sidoName'] as String?,
      ver: json['ver'] as String?,
    );

Map<String, dynamic> _$NewsToJson(News instance) => <String, dynamic>{
      'serviceKey': instance.serviceKey,
      'returnType': instance.returnType,
      'numOfRows': instance.numOfRows,
      'pageNo': instance.pageNo,
      'sidoName': instance.sidoName,
      'ver': instance.ver,
    };

// **************************************************************************
// RetrofitGenerator
// **************************************************************************

class _RestClient implements RestClient {
  _RestClient(this._dio, {this.baseUrl}) {
    baseUrl ??= 'http://apis.data.go.kr';
  }

  final Dio _dio;

  String? baseUrl;

  @override
  Future<List<Map<String, dynamic>>> getData() async {
    const _extra = <String, dynamic>{};
    final queryParameters = <String, dynamic>{};
    final _headers = <String, dynamic>{
      r'Content-Language': 'ko-KR',
      r'Access-Control-Allow-Origin': '*',
      r'Content-Encoding': 'gzip',
      r'Content-Type': 'application/json;charset=UTF-8',
      r'Content-Length': '610',
      r'Date': 'Thu, 04 Aug 2022 07:08:42 GMT',
      r'Server': 'NIA API Server'
    };
    _headers.removeWhere((k, v) => v == null);
    final _data = <String, dynamic>{};
    final _result = await _dio.fetch<List<dynamic>>(
        _setStreamType<List<Map<String, dynamic>>>(Options(
                method: 'GET',
                headers: _headers,
                extra: _extra,
                contentType: 'application/json;charset=UTF-8')
            .compose(_dio.options,
                '/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty',
                queryParameters: queryParameters, data: _data)
            .copyWith(baseUrl: baseUrl ?? _dio.options.baseUrl)));
    var value = _result.data!
        .map((dynamic i) =>
            Map<String, dynamic>.fromJson(i as Map<String, dynamic>))
        .toList();
    return value;
  }

  RequestOptions _setStreamType<T>(RequestOptions requestOptions) {
    if (T != dynamic &&
        !(requestOptions.responseType == ResponseType.bytes ||
            requestOptions.responseType == ResponseType.stream)) {
      if (T == String) {
        requestOptions.responseType = ResponseType.plain;
      } else {
        requestOptions.responseType = ResponseType.json;
      }
    }
    return requestOptions;
  }
}
