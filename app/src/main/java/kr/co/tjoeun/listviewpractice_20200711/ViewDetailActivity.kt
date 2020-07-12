package kr.co.tjoeun.listviewpractice_20200711

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_detail.*
import kr.co.tjoeun.listviewpractice_20200711.datas.BangDatas

class ViewDetailActivity : BaseActvity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_detail)
        setupExents()
        setValues()
    }

    override fun setupExents() {
        val myUrl = Uri.parse("tel:010-2222-2222")
        val myIntent = Intent(Intent.ACTION_DIAL, myUrl)
        startActivity(myIntent)
    }

    override fun setValues() {

        val bangData = intent.getSerializableExtra("bang") as BangDatas

        priceTxt.text = bangData.getFormattedPrice()
        descriptionTxt.text = bangData.description
        addressTxt.text = bangData.address
        floorTxt.text = bangData.getFormattedFloor()
    }
}
