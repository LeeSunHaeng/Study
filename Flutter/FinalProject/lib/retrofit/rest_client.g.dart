// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rest_client.dart';

// **************************************************************************
// RetrofitGenerator
// **************************************************************************

// ignore_for_file: unnecessary_brace_in_string_interps,no_leading_underscores_for_local_identifiers

class _RestClient implements RestClient {
  _RestClient(this._dio, {this.baseUrl}) {
    baseUrl ??= 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc';
  }

  final Dio _dio;

  String? baseUrl;

  @override
  Future<FineDustModel> getFineDust(serviceKey, sidoNmae, returnType) async {
    const _extra = <String, dynamic>{};
    final queryParameters = <String, dynamic>{
      r'serviceKey': serviceKey,
      r'sidoName': sidoNmae,
      r'returnType': returnType
    };
    final _headers = <String, dynamic>{
      r'Accept': 'application/json',
      r'content-type': 'application/json'
    };
    _headers.removeWhere((k, v) => v == null);
    final _data = <String, dynamic>{};
    final _result = await _dio.fetch<Map<String, dynamic>>(
        _setStreamType<FineDustModel>(Options(
                method: 'GET',
                headers: _headers,
                extra: _extra,
                contentType: 'application/json')
            .compose(_dio.options, '/getCtprvnRltmMesureDnsty',
                queryParameters: queryParameters, data: _data)
            .copyWith(baseUrl: baseUrl ?? _dio.options.baseUrl)));
    final value = FineDustModel.fromJson(_result.data!);
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
