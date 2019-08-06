package com.sonahjin.savemysearch.utils

class NetworkConstants {

    companion object {

        //network code

        val OK = 200

        val CD_AUTHORIZE_EMPTY = 4000
        val CD_AUTHORIZE_MISSMATCH = 4001
        val CD_AUTHORIZE_EXPIRE = 4002
        val CD_AUTHORIZE_ERR = 4003
        val CD_AUTHORIZE_ERR_PERMISSION = 3004
        val CD_AUTHORIZE_ERR_TOKEN = 4005
        val CD_MIS_PERSON_AUTHORIZE = 4008
        val CD_CHANGED_TOKEN = 4010
        val CD_ALREADY_BEEN_PAID = 8013
        val CD_EXCEPTION = 9000
        val CD_NET_ERR = 10000
        val CD_BAD_GATEWAY = 502
        val CD_NOT_FOUND = 404
        val CD_TIME_OUT = 408


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