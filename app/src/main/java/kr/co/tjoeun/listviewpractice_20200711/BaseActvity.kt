package kr.co.tjoeun.listviewpractice_20200711

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActvity : AppCompatActivity()
{
    val mContnxt = this

    abstract fun setupExents()
    abstract fun setValues()
}