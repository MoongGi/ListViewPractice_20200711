package kr.co.tjoeun.listviewpractice_20200711.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listviewpractice_20200711.R
import kr.co.tjoeun.listviewpractice_20200711.datas.BangDatas

class BangAdapters (val mContext: Context, val resId: Int, val mList: List<BangDatas>) :
    ArrayAdapter<BangDatas>(mContext, resId, mList)
{
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {

        var tempRow = convertView

        if (tempRow == null)
        {
            tempRow = inf.inflate(R.layout.bang_item_list, null)

        }

        //이코드가 실행되는 시점 => tempRow 가 null 일 가능성이 없다
        val row = tempRow!!
        //!! : 절때 널이 아닐경우

        // row의 내용을 가공해서 사용
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)
        val txtDescription = row.findViewById<TextView>(R.id.txtDescription)

        // 뿌려줄 근거 데이터 가져오기
        val data = mList[position]

        if (data.price >= 10000)
        {
            var amt = data.price.toString()
            var amt2 = amt.substring(0,1)
            var amt3 = amt.substring(1,5)
            txtPrice.text = "${amt2}억${amt3}"
        }
        else
        {
            txtPrice.text = data.price.toString()
        }
        txtAddress.text = "${data.address} ${data.floor} 층"
        txtDescription.text = data.description

//        => 4가지 항목만 화면에 표시 (가격 / 동네/ 층수 / 설명)
//
//        2. 데이터 클래스 예시
//        - 가격 예시
//                - 8천만원 => price = 8000
//        - 2억7천이면  => price = 27000
//        - 주소 :  마포구 서교동 => address = "마포구 서교동"
//        - 층수 예시
//                - 지상층(ex 5층) => floor = 5
//        - 반지하 => floor = 0
//        - 지하층 => floor = -1

        return row
    }
}