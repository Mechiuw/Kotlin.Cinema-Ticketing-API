package com.mcsoftware.ticketo.json

import org.springframework.http.HttpStatus

data class ResponseJSON<T>(
    var statusCode : Int,
    var success : Boolean,
    var message : String,
    var data : T,
) {
    fun useResponse(anyData :T) :ResponseJSON<T> {
        return when(this.statusCode){
                //success
            HttpStatus.OK.value() -> ResponseJSON(HttpStatus.OK.value(),true,HttpStatus.OK.reasonPhrase,anyData)
            HttpStatus.CREATED.value() -> ResponseJSON(HttpStatus.CREATED.value(),true,HttpStatus.CREATED.reasonPhrase,anyData)
            HttpStatus.ACCEPTED.value() -> ResponseJSON(HttpStatus.ACCEPTED.value(),true,HttpStatus.ACCEPTED.reasonPhrase,anyData)
                // errors
            HttpStatus.SERVICE_UNAVAILABLE.value() -> ResponseJSON(HttpStatus.SERVICE_UNAVAILABLE.value(),false,HttpStatus.SERVICE_UNAVAILABLE.reasonPhrase,anyData)
            HttpStatus.NOT_FOUND.value() -> ResponseJSON(HttpStatus.NOT_FOUND.value(),false,HttpStatus.NOT_FOUND.reasonPhrase,anyData)
            HttpStatus.UNAUTHORIZED.value() -> ResponseJSON(HttpStatus.UNAUTHORIZED.value(),false,HttpStatus.UNAUTHORIZED.reasonPhrase,anyData)
            HttpStatus.FORBIDDEN.value() -> ResponseJSON(HttpStatus.FORBIDDEN.value(),false,HttpStatus.FORBIDDEN.reasonPhrase,anyData)
            HttpStatus.INTERNAL_SERVER_ERROR.value() -> ResponseJSON(HttpStatus.INTERNAL_SERVER_ERROR.value(),false,HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,anyData)
            HttpStatus.METHOD_NOT_ALLOWED.value() -> ResponseJSON(HttpStatus.METHOD_NOT_ALLOWED.value(),false,HttpStatus.METHOD_NOT_ALLOWED.reasonPhrase,anyData)
            HttpStatus.BAD_GATEWAY.value() -> ResponseJSON(HttpStatus.BAD_GATEWAY.value(),false,HttpStatus.BAD_GATEWAY.reasonPhrase,anyData)
            HttpStatus.BAD_REQUEST.value() -> ResponseJSON(HttpStatus.BAD_REQUEST.value(),false,HttpStatus.BAD_REQUEST.reasonPhrase,anyData)
            HttpStatus.NOT_IMPLEMENTED.value() -> ResponseJSON(HttpStatus.NOT_IMPLEMENTED.value(),false,HttpStatus.NOT_IMPLEMENTED.reasonPhrase,anyData)
            else -> {
                throw IllegalAccessException("Unexpected status code")
            }
        }
    }
}

