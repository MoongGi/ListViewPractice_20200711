package kr.co.tjoeun.listviewpractice_20200711.datas


class BangDatas( val price:Int, val address:String, val floor:Int, val description:String)
{

    fun getFormattedPrice() : String
    {
        if (price>= 10000)
        {
            val uk = this.price / 10000
            val rest = this.price % 10000
            if (rest == 0)
            {
                return String.format("%d억", uk)
            }
            else
            {
                return String.format("%d억 %,d", uk, rest)
            }
        }
        else
        {
            return String.format("%,d", price)
        }
    }

    fun getFormattedFloor() : String
    {
        if (floor > 0)
        {
            return "${this.floor}층"
        }
        else if (floor == 0)
        {
            return "반지하"
        }
        else
        {
            return "지하 ${this.floor}층"
        }

    }
}