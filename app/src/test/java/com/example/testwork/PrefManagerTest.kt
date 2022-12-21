package com.example.testwork

import android.content.Context
import android.content.SharedPreferences
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito


//@RunWith(MockitoJUnitRunner.class)
class PrefManagerTest {

    @Mock
    var sharedPrefs : SharedPreferences? = Mockito.mock(SharedPreferences::class.java)
    var context:Context = Mockito.mock(Context::class.java)


    @Before
    fun setup(){
        //MockitoAnnotations.initMocks(this)
        this.sharedPrefs = Mockito.mock(SharedPreferences::class.java)
        this.context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs)
    }


    @Test
    fun getUsernameHere() {
        Mockito.`when`(sharedPrefs!!.getString(anyString(), anyString())).thenReturn("foobar")

        Assert.assertEquals("foobar", PrefManager(context).getUsername())
    }
}
