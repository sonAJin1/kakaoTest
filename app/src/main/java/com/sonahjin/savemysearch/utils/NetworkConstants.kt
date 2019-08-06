package com.sonahjin.savemysearch.utils

class NetworkConstants {

    companion object {

        //network code

        val OK = 200

        val SUCCESS_PUT = 201
        val CHANGE_URI = 301
        val WRONG_REQUEST = 400
        val NO_AUTHORITY = 401
        val WRONG_RESOURCE = 403
        val NO_PAGE = 404
        val WRONG_METHOD = 405
        val SERVER_ERROR = 500


        /**
         *
         * 200 : 클라이언트의 요청을 정상적으로 수행
        201 : 클라이언트의 생성 요청을 정상적으로 수행
        301 : 클라이언트가 요청한 리소스에 대한 URI가 변경 되었음
        400 : 클라이언트이 부적절한 요청을 함
        401 : 클라이언트가 인증되지 않은 상태에서 요청함
        403 : 적절하지 않은 리소스를 클라이언트가 요청함
        404 : 페이지를 찾을 수 없음
        405 : 클라이언트가 요청한 리소스에서 사용할 수 없는 Method 를 사용함
        500 : 서버에 문제가 발생
         */
    }
}