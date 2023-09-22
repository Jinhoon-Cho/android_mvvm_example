package com.example.myapplication

class GoogleLoginHelper {
    private val googleAuthApi= "https://accounts.google.com/o/oauth2/v2/auth"
    private val googleTokenApi= "https://oauth2.googleapis.com/token"
    private val revokeTokenUrl = "https://oauth2.googleapis.com/revoke"

    fun login() : Boolean {




        try {

            return true
        } catch (e:Exception) {

        }

        return false
    }
}