package kr.co.tjoeun.listviewpractice_20200711

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listviewpractice_20200711.adapters.BangAdapters
import kr.co.tjoeun.listviewpractice_20200711.datas.BangDatas

class MainActivity : BaseActvity() {

    val mBang =ArrayList<BangDatas>()

    lateinit var mAdapters:BangAdapters

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapters =BangAdapters(mContnxt, R.layout.bang_item_list, mBang)
        bangListView.adapter = mAdapters
        setupExents()
        setValues()
        mAdapters.notifyDataSetChanged()
    }

    override fun setupExents() {
        bangListView.setOnItemClickListener { parent, view, position, id ->
            //어떤방을 선택했는지
            val clickedRoom = mBang[position]

            //상세 화면으로 진입

            val myIntent = Intent(mContnxt, ViewDetailActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        mBang.add(BangDatas(8000,"남양주시퇴계원",1,"1분거리"))
        mBang.add(BangDatas(1200,"남양주시도농",2,"30분거리"))
        mBang.add(BangDatas(33100,"남양주시구리",-1,"21분거리"))
        mBang.add(BangDatas(4000,"남양주시다산",0,"0분거리"))
    }


}
