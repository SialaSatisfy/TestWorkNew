package com.example.testwork

import android.content.Context
import android.content.SharedPreferences

 class PrefManager(context: Context?) {
    //Shared Pref Mode
    val PRIVATE_MODE: Int = 0


    //SharedPref FileName
    private  val PREF_NAME: String? = "SharedPreferences"
    private val IS_LOGIN: String? = "is_login"


    val pref: SharedPreferences? = context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    val editor: SharedPreferences.Editor? = pref?.edit()

    fun setLogin(isLogin: Boolean){
        editor?.putBoolean(IS_LOGIN, isLogin)
        editor?.commit()
    }

    open fun setUsername(username: String?){
        editor?.putString("username", username)
        editor?.commit()
    }

    open fun getUsername(): String?{
        return pref?.getString("username", "")
    }

    fun isLogin(): Boolean?{
        return pref?.getBoolean(IS_LOGIN, false)
    }

    fun removeData(){
        editor?.clear()
        editor?.commit()
    }
}